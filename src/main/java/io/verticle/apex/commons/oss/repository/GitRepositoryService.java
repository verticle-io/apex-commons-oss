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

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.TransportCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.jgit.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Git based implementation of the {@link RepositoryService}
 * Will clone from master branch.
 * @author Jens Saade
 */
public class GitRepositoryService extends RepositoryService{

    static final Logger logger = LoggerFactory.getLogger(GitRepositoryService.class);

    private static GitRepositoryService instance;

    private int timeout = 5;
    private boolean cloneByDefault = true;
    private Path localRepositoryPath;
    private String remoteRepositoryUri;
    private String remoteRepositoryUsername;
    private String remoteRepositoryPassword;


    public GitRepositoryService(Path localRepositoryPath, String remoteRepositoryUri, String remoteRepositoryUsername, String remoteRepositoryPassword) {
        super(localRepositoryPath);

        this.localRepositoryPath = localRepositoryPath;
        this.remoteRepositoryUri = remoteRepositoryUri;
        this.remoteRepositoryUsername = remoteRepositoryUsername;
        this.remoteRepositoryPassword = remoteRepositoryPassword;

    }

    public void init() throws Exception {

        if (remoteRepositoryUri != null){
            if(this.cloneByDefault) {
                this.cloneRepository();
            }
        } else {
            logger.error("Failed to initialize: Please configure a git repository url");
        }

    }



    private void cloneRepository() throws GitAPIException, IOException {
        logger.info("cloning repository from " + remoteRepositoryUri);
        if(!remoteRepositoryUri.startsWith("file:")) {
            this.deleteLocalRepoDirIfExists();

            Git git = this.cloneToLocalDir();
            if(git != null) {
                git.close();
            }

            git = this.openGitRepository();
            if (git != null) {
                git.close();
            }
        }

    }


    private Git openGitRepository() throws IOException {
        Git git =  Git.open(localRepositoryPath.toFile());
        return git;
    }


    private Git cloneToLocalDir() throws GitAPIException {
        CloneCommand cloneCommand = Git.cloneRepository().setURI(remoteRepositoryUri).setDirectory(localRepositoryPath.toFile());

        if(remoteRepositoryUsername != null) {
            cloneCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(remoteRepositoryUsername, remoteRepositoryPassword));
        }
        this.setTimeout(cloneCommand);

        return cloneCommand.call();
    }

    private void deleteLocalRepoDirIfExists() {
        if(localRepositoryPath.toFile().exists()) {
            try {
                FileUtils.delete(localRepositoryPath.toFile(), 1);
            } catch (IOException ioe) {
                throw new IllegalStateException("Failed to initialize local repository directory", ioe);
            }
        }

    }

    private void setTimeout(TransportCommand<?, ?> pull) {
        pull.setTimeout(this.timeout);
    }


    public Path getLocalRepositoryPath() {
        return localRepositoryPath;
    }

    public void setLocalRepositoryPath(Path localRepositoryPath) {
        this.localRepositoryPath = localRepositoryPath;
    }

    public String getRemoteRepositoryUri() {
        return remoteRepositoryUri;
    }

    public void setRemoteRepositoryUri(String remoteRepositoryUri) {
        this.remoteRepositoryUri = remoteRepositoryUri;
    }

    public String getRemoteRepositoryUsername() {
        return remoteRepositoryUsername;
    }

    public void setRemoteRepositoryUsername(String remoteRepositoryUsername) {
        this.remoteRepositoryUsername = remoteRepositoryUsername;
    }

    public String getRemoteRepositoryPassword() {
        return remoteRepositoryPassword;
    }

    public void setRemoteRepositoryPassword(String remoteRepositoryPassword) {
        this.remoteRepositoryPassword = remoteRepositoryPassword;
    }
}
