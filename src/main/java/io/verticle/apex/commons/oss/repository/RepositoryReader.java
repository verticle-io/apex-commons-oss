/*
 *    Copyright 2016 Jens Saade <jens@verticle.io>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package io.verticle.apex.commons.oss.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.verticle.apex.commons.oss.repository.model.MetaModel;
import io.verticle.apex.commons.oss.repository.model.instrumentation.HandlerModel;
import io.verticle.apex.commons.oss.repository.model.instrumentation.HandlerOptionModel;
import io.verticle.apex.commons.oss.repository.model.instrumentation.InstrumentationInstructionModel;
import io.verticle.apex.commons.oss.repository.model.instrumentation.InstrumentationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * A reader for the {@link Repository}
 * @author Jens Saade
 */
public class RepositoryReader {

    static final Logger logger = LoggerFactory.getLogger(RepositoryReader.class);

    Path repositoryPath;

    Repository repo = new Repository();

    public RepositoryReader( Path repositoryLocation){
        this.repositoryPath = repositoryLocation;
    }

    private byte[] readFile(Path filePath){
        byte[] fileContent = null;
        try {
            fileContent = Files.readAllBytes(filePath);
        } catch (IOException e) {
            logger.error("Could not read file in repository", e);
        }
        return fileContent;
    }

    public List<MetaModel> loadMetaModels(){

        List<MetaModel> metaModels = new ArrayList<>();

        try {
            List<Path> metaModelPaths = repo.getMetaModels(repositoryPath);

            metaModelPaths.forEach(path ->
                    metaModels.add(readMetaModel(path))
            );

        } catch (IOException e) {
            logger.error("Could not locate metamodel file", e);
        }

        return metaModels;
    }

    private MetaModel readMetaModel(Path metaModelPath){

        MetaModel metaModel = null;

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerSubtypes(MetaModel.class);

        TypeReference<MetaModel> typeRef = new TypeReference<MetaModel>(){};

        try {
            metaModel = mapper.readValue(readFile(metaModelPath), typeRef);
        } catch (IOException e) {
            logger.error("Could not parse metamodel", e);
        }

        return metaModel;
    }


    public List<InstrumentationModel> loadInstrumentationModels(MetaModel metaModel){

        List<InstrumentationModel> instrumentationModels = new ArrayList<>();

        try {

            List<Path> instrumentationModelPaths = repo.getInstrumentationModels(metaModel.getRepositoryModulePath(), metaModel);

            instrumentationModelPaths.forEach(path -> {
                instrumentationModels.add(readInstrumentationModel(path));
            });

        } catch (IOException e) {
            logger.error("could not load instrumentation model", e);
        }

        return instrumentationModels;
    }

    private InstrumentationModel readInstrumentationModel(Path instrumentationModelPath){

        InstrumentationModel instrumentationModel = null;

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerSubtypes(InstrumentationModel.class);
        mapper.registerSubtypes(InstrumentationInstructionModel.class);
        mapper.registerSubtypes(HandlerModel.class);
        mapper.registerSubtypes(HandlerOptionModel.class);


        TypeReference<InstrumentationModel> typeRef = new TypeReference<InstrumentationModel>(){};

        try {
            instrumentationModel = mapper.readValue(readFile(instrumentationModelPath), typeRef);
        } catch (IOException e) {
            logger.error("Could not parse instrumentation model", e);
        }

        return instrumentationModel;
    }
}
