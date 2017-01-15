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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.verticle.apex.commons.oss.repository.model.MetaModel;
import io.verticle.apex.commons.oss.repository.model.instrumentation.HandlerModel;
import io.verticle.apex.commons.oss.repository.model.instrumentation.HandlerOptionModel;
import io.verticle.apex.commons.oss.repository.model.instrumentation.InstrumentationInstructionModel;
import io.verticle.apex.commons.oss.repository.model.instrumentation.InstrumentationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.*;

/**
 * A writer for the {@link Repository}
 * @author Jens Saade
 */
public class RepositoryWriter {

    static final Logger logger = LoggerFactory.getLogger(RepositoryWriter.class);

    Path repositoryPath;

    Repository repo = new Repository();

    public RepositoryWriter(Path repositoryLocation){
        this.repositoryPath = repositoryLocation;
    }

    private void writeFile(Path modulePath, String fileName, byte[] fileContent){

        Path filePath = Paths.get(modulePath.toString(), fileName);
        try {

            if (!Files.exists(modulePath)) {
                File file = modulePath.toFile();
                file.mkdirs();
            }

            if (!Files.exists(filePath, LinkOption.NOFOLLOW_LINKS)){
                Files.createFile(filePath);
            }
            Files.write(filePath, fileContent, StandardOpenOption.WRITE);
        } catch (IOException e) {
            logger.error("Could not write file", e);
        }
    }

    public void writeInstrumentationModel(InstrumentationModel instrumentationModel, MetaModel metaModel){

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter();
        mapper.registerSubtypes(InstrumentationModel.class);
        mapper.registerSubtypes(InstrumentationInstructionModel.class);
        mapper.registerSubtypes(HandlerModel.class);
        mapper.registerSubtypes(HandlerOptionModel.class);

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, instrumentationModel);

            Path modulePath = repo.getModulePathFromMeta(repositoryPath, metaModel);
            String fileName = instrumentationModel.getQualifier() + ".json";

            writeFile(modulePath, fileName, sw.toString().getBytes());

        } catch (IOException e) {
            logger.error("could not write instrumentation model", e);
        }


    }

    public void writeMetaModel(MetaModel metaModel){

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter();
        mapper.registerSubtypes(MetaModel.class);

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, metaModel);

            Path modulePath = repo.getModulePathFromMeta(repositoryPath, metaModel);
            String fileName = "meta.json";

            writeFile(modulePath, fileName, sw.toString().getBytes());

        } catch (IOException e) {
            logger.error("could not write metamodel", e);
        }


    }
}
