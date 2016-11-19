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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateDeserializer;
import org.joda.time.DateTime;

/**
 * Representation of a Collector definition.
 * @author Jens Saade
 */
public class CollectorDefinition {

    String collectorIdent;
    String alias;
    String description;
    String ip;
    String macHash;

    @JsonDeserialize(using=LocalDateDeserializer.class)
    DateTime created;

    @JsonDeserialize(using=LocalDateDeserializer.class)
    DateTime firstMessage;

    @JsonDeserialize(using=LocalDateDeserializer.class)
    DateTime lastMessage;


    public String getCollectorIdent() {
        return collectorIdent;
    }

    public void setCollectorIdent(String collectorIdent) {
        this.collectorIdent = collectorIdent;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMacHash() {
        return macHash;
    }

    public void setMacHash(String macHash) {
        this.macHash = macHash;
    }

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public DateTime getFirstMessage() {
        return firstMessage;
    }

    public void setFirstMessage(DateTime firstMessage) {
        this.firstMessage = firstMessage;
    }

    public DateTime getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(DateTime lastMessage) {
        this.lastMessage = lastMessage;
    }
}
