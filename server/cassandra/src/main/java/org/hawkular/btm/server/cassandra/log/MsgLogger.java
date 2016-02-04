/*
 * Copyright 2015-2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.btm.server.cassandra.log;

import org.jboss.logging.BasicLogger;
import org.jboss.logging.Logger;
import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageLogger;
import org.jboss.logging.annotations.ValidIdRange;

/**
 * Log for INFO, WARN, ERROR and FATAL messages.
 *
 * @author gbrown
 */
@MessageLogger(projectCode = "HAWKBTM")
@ValidIdRange(min = 600300, max = 600399)
public interface MsgLogger extends BasicLogger {
    MsgLogger LOGGER = Logger.getMessageLogger(MsgLogger.class, MsgLogger.class.getPackage().getName());

    @LogMessage(level = Logger.Level.ERROR)
    @Message(id = 600300, value = "Failed to initialise Cassandra client")
    void errorFailedToInitialiseElasticsearchClient(@Cause Throwable t);

    @LogMessage(level = Logger.Level.ERROR)
    @Message(id = 600301, value = "Failed to parse")
    void errorFailedToParse(@Cause Throwable t);

    @LogMessage(level = Logger.Level.WARN)
    @Message(id = 600302, value = "Query timed out")
    void warnQueryTimedOut();

}