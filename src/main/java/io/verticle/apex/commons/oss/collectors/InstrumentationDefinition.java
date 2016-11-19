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

package io.verticle.apex.commons.oss.collectors;

import java.util.List;

/**
 * Representation of an Instrumentation definition
 * @author Jens Saade
 */
public class InstrumentationDefinition {

    String qualifier;

    CollectorDefinition collectorDefinition;

    List<String> handlerClasses;
    String fullyQualifiedClassName;
    String methodName;
    boolean enabled = true;

    String handlerScript;

    public String getHandlerScript() {
        return handlerScript;
    }

    public void setHandlerScript(String handlerScript) {
        this.handlerScript = handlerScript;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public CollectorDefinition getCollectorDefinition() {
        return collectorDefinition;
    }

    public void setCollectorDefinition(CollectorDefinition collectorDefinition) {
        this.collectorDefinition = collectorDefinition;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public List<String> getHandlerClasses() {
        return handlerClasses;
    }

    public void setHandlerClasses(List<String> handlerClasses) {
        this.handlerClasses = handlerClasses;
    }

    public String getFullyQualifiedClassName() {
        return fullyQualifiedClassName;
    }

    public void setFullyQualifiedClassName(String fullyQualifiedClassName) {
        this.fullyQualifiedClassName = fullyQualifiedClassName;
    }
}
