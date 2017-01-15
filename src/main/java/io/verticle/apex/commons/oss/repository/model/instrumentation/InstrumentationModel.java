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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.verticle.apex.commons.oss.api.instrumentation.Instrumentation;
import io.verticle.apex.commons.oss.api.instrumentation.InstrumentationInstruction;
import io.verticle.apex.commons.oss.api.instrumentation.Meta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jens Saade
 */
public class InstrumentationModel implements Instrumentation {

    Map<MetaKey, Object> meta;

    @JsonIgnore
    Meta metaReference;

    String qualifier;

    String targetClass;


    List<InstrumentationInstruction> instrumentations = new ArrayList<>();

    public Meta getMetaReference() {
        return metaReference;
    }

    public void setMetaReference(Meta metaReference) {
        this.metaReference = metaReference;
    }

    public Map<MetaKey, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<Instrumentation.MetaKey, Object> meta) {
        this.meta = meta;
    }

    public String getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(String targetClass) {
        this.targetClass = targetClass;
    }

    @JsonTypeInfo(defaultImpl = InstrumentationInstructionModel.class, use = JsonTypeInfo.Id.CLASS)
    @JsonSubTypes.Type(InstrumentationInstructionModel.class)
    public List<InstrumentationInstruction> getInstrumentationInstructions() {
        return instrumentations;
    }

    public void setInstrumentations(List<InstrumentationInstruction> instrumentations) {
        this.instrumentations = instrumentations;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }
}
