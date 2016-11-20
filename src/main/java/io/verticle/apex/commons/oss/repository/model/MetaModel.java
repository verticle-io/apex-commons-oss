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

package io.verticle.apex.commons.oss.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.verticle.apex.commons.oss.api.instrumentation.Meta;

import java.nio.file.Path;

/**
 * Meta model representation for the configured {@link Meta}
 * @author Jens Saade
 */
public class MetaModel implements Meta {

    String assetName;
    String packageName;
    String version;
    String author;
    String authorEmail;
    String authorHomepage;
    String fingerprint;
    String created;
    String description;

    @JsonIgnore
    Path repositoryModulePath;

    @Override
    public Path getRepositoryModulePath() {
        return repositoryModulePath;
    }

    @Override
    public void setRepositoryModulePath(Path repositoryMetaPath) {
        this.repositoryModulePath = repositoryMetaPath;
    }

    @Override
    public String getAssetName() {
        return assetName;
    }

    @Override
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String getPackageName() {
        return packageName;
    }

    @Override
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getAuthorEmail() {
        return authorEmail;
    }

    @Override
    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    @Override
    public String getAuthorHomepage() {
        return authorHomepage;
    }

    @Override
    public void setAuthorHomepage(String authorHomepage) {
        this.authorHomepage = authorHomepage;
    }

    @Override
    public String getFingerprint() {
        return fingerprint;
    }

    @Override
    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    @Override
    public String getCreated() {
        return created;
    }

    @Override
    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
