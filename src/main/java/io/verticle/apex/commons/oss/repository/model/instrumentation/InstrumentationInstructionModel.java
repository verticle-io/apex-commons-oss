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

package io.verticle.apex.commons.oss.repository.model.instrumentation;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.verticle.apex.commons.oss.api.instrumentation.Handler;
import io.verticle.apex.commons.oss.api.instrumentation.InstrumentationInstruction;

import java.util.List;

/**
 *
 * @author Jens Saade
 */
public class InstrumentationInstructionModel implements InstrumentationInstruction {
    String qualifier;
    boolean isConstructor;
    String methodName;
    List<String> signatureClasses;

    @JsonTypeInfo(defaultImpl = HandlerModel.class, use = JsonTypeInfo.Id.CLASS)
    List<Handler> handlers;

    boolean enabled = true;

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public boolean isConstructor() {
        return isConstructor;
    }

    public void setConstructor(boolean constructor) {
        isConstructor = constructor;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<String> getSignatureClasses() {
        return signatureClasses;
    }

    public void setSignatureClasses(List<String> signatureClasses) {
        this.signatureClasses = signatureClasses;
    }

    public List<Handler> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<Handler> handlers) {
        this.handlers = handlers;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
