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

package io.verticle.apex.commons.oss.api.instrumentation;

import java.nio.file.Path;

/**
 *
 * @author Jens Saade
 */
public interface Meta {
    Path getRepositoryModulePath();

    void setRepositoryModulePath(Path repositoryMetaPath);

    String getAssetName();

    void setAssetName(String assetName);

    String getVersion();

    void setVersion(String version);

    String getPackageName();

    void setPackageName(String packageName);

    String getAuthor();

    void setAuthor(String author);

    String getAuthorEmail();

    void setAuthorEmail(String authorEmail);

    String getAuthorHomepage();

    void setAuthorHomepage(String authorHomepage);

    String getFingerprint();

    void setFingerprint(String fingerprint);

    String getCreated();

    void setCreated(String created);

    String getDescription();

    void setDescription(String description);
}
