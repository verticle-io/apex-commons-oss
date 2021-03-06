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



import io.verticle.apex.commons.oss.api.instrumentation.HandlerOption;

import java.util.HashMap;
import java.util.Map;

/**
 * HandlerOption model representation for the configured {@link HandlerOption}
 * @author Jens Saade
 */
public class HandlerOptionModel implements HandlerOption {

    Map<OptionKey, Object> options = new HashMap<>();

    public enum OptionKey {
        script
    }

    public Map<OptionKey, Object> getOptions() {
        return options;
    }

    public void setOptions(Map<OptionKey, Object> options) {
        this.options = options;
    }


}
