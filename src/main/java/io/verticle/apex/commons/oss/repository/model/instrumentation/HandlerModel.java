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

import io.verticle.apex.commons.oss.api.instrumentation.AdvisorContext;
import io.verticle.apex.commons.oss.api.instrumentation.Handler;

import java.util.HashMap;
import java.util.Map;

/**
 * Handler model representation for the configured {@link Handler}
 * @author Jens Saade
 */
public class HandlerModel implements Handler {

    Class<? extends Handler> handlerClass;
    Map<HandlerOption, Object> options = new HashMap<>();


    public Class<? extends Handler> getHandlerClass() {
        return handlerClass;
    }

    public void setHandlerClass(Class<? extends Handler> handlerClass) {
        this.handlerClass = handlerClass;
    }

    @Override
    public Map<HandlerOption, Object> getOptions() {
        return options;
    }

    @Override
    public void setOptions(Map<HandlerOption, Object> options) {
        this.options = options;
    }

    @Override
    public void handle(AdvisorContext advisorContext) {
        //NOOP
    }

    @Override
    public void handleBefore(AdvisorContext advisorContext) {
        //NOOP
    }

    @Override
    public void handleAfter(AdvisorContext advisorContext) {
        //NOOP
    }

}
