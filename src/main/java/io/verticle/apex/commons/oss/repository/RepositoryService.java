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


import io.verticle.apex.commons.oss.repository.model.MetaModel;
import io.verticle.apex.commons.oss.repository.model.instrumentation.InstrumentationModel;

import java.nio.file.Path;
import java.util.List;

/**
 * Repository service, giving access to instrumentation configurations.
 * @author Jens Saade
 */
public abstract class RepositoryService {

    RepositoryReader repositoryReader;
    RepositoryWriter repositoryWriter;

    public RepositoryService(Path localRepositoryPath) {
         repositoryReader = new RepositoryReader(localRepositoryPath);
         repositoryWriter = new RepositoryWriter(localRepositoryPath);
    }

    public List<MetaModel> loadMetaModels() {
        return repositoryReader.loadMetaModels();
    }

    public List<InstrumentationModel> loadInstrumentationModels(MetaModel metaModel) {
        return repositoryReader.loadInstrumentationModels(metaModel);
    }

    public void writeInstrumentationModel(InstrumentationModel instrumentationModel, MetaModel metaModel) {
        repositoryWriter.writeInstrumentationModel(instrumentationModel, metaModel);
    }

    public void writeMetaModel(MetaModel metaModel) {
        repositoryWriter.writeMetaModel(metaModel);
    }
}
