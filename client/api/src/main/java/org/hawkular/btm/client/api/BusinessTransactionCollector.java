/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates
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
package org.hawkular.btm.client.api;

import java.util.Map;

/**
 * This interface represents the collector used to register activity
 * related to a business transaction execution.
 *
 * @author gbrown
 */
public interface BusinessTransactionCollector {

    /**
     * The maximum number of business transactions to batch before sending to the server.
     */
    String BATCH_SIZE = "hawkular-btm.collector.batchsize";

    /**
     * The maximum time (in milliseconds) before sending a batch of business transactions to the server.
     */
    String BATCH_TIME = "hawkular-btm.collector.batchtime";

    /**
     * The thread pool size for reporting a batch of business transactions to the server.
     */
    String BATCH_THREADS = "hawkular-btm.collector.batchthreads";

    /**
     * This method sets the name of the business transaction.
     *
     * @param name The business transaction name
     */
    void setName(String name);

    /**
     * This method returns the name of the business transaction.
     *
     * @return The business transaction name, or empty string if not defined
     */
    String getName();

    /**
     * This method indicates the start of a message being consumed.
     *
     * @param uri The uri
     * @param type The endpoint type
     * @param id The unique interaction id
     * @param headers The header values
     * @param values The request values
     */
    void consumerStart(String uri, String type, String id, Map<String, ?> headers, Object... values);

    /**
     * This method indicates the end of a message being consumed.
     *
     * @param uri The uri
     * @param type The endpoint type
     * @param headers The header values
     * @param values The response values
     */
    void consumerEnd(String uri, String type, Map<String, ?> headers, Object... values);

    /**
     * This method indicates the start of a service invocation.
     *
     * @param uri The service type uri
     * @param operation The operation
     * @param headers The header values
     * @param values The request values
     */
    void serviceStart(String uri, String operation, Map<String, ?> headers, Object... values);

    /**
     * This method indicates the end of a service invocation.
     *
     * @param uri The service type uri
     * @param operation The operation
     * @param headers The header values
     * @param values The response values
     */
    void serviceEnd(String uri, String operation, Map<String, ?> headers, Object... values);

    /**
     * This method indicates the start of a component invocation.
     *
     * @param uri The uri
     * @param type The component type
     * @param operation The operation
     * @param values The request values
     */
    void componentStart(String uri, String type, String operation, Object... values);

    /**
     * This method indicates the end of a component invocation.
     *
     * @param uri The uri
     * @param type The component type
     * @param operation The operation
     * @param values The response values
     */
    void componentEnd(String uri, String type, String operation, Object... values);

    /**
     * This method indicates the start of a message being produced.
     *
     * @param uri The uri
     * @param type The endpoint type
     * @param id The unique interaction id
     * @param headers The header values
     * @param values The request values
     */
    void producerStart(String uri, String type, String id, Map<String, ?> headers, Object... values);

    /**
     * This method indicates the end of a message being produced.
     *
     * @param uri The uri
     * @param type The endpoint type
     * @param headers The header values
     * @param values The response values
     */
    void producerEnd(String uri, String type, Map<String, ?> headers, Object... values);

    /**
     * This method sets a fault on the current node.
     *
     * @param value The fault value
     * @param description The optional fault description
     */
    void setFault(String value, String description);

    /**
     * This method sets a property on the business transaction.
     *
     * @param name The property name
     * @param value The property value
     */
    void setProperty(String name, String value);

    /**
     * This method sets a detail on the current node.
     *
     * @param name The detail name
     * @param value The detail value
     */
    void setDetail(String name, String value);

    /**
     * This method returns the session manager associated with the
     * current thread of execution.
     *
     * @return The session manager
     */
    SessionManager session();

}