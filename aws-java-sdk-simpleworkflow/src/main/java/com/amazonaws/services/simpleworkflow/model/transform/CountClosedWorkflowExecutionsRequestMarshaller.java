/*
 * Copyright 2010-2014 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.simpleworkflow.model.transform;

import static com.amazonaws.util.StringUtils.UTF8;
import static com.amazonaws.util.StringUtils.COMMA_SEPARATOR;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.regex.Pattern;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.simpleworkflow.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.*;

/**
 * Count Closed Workflow Executions Request Marshaller
 */
public class CountClosedWorkflowExecutionsRequestMarshaller implements Marshaller<Request<CountClosedWorkflowExecutionsRequest>, CountClosedWorkflowExecutionsRequest> {

    public Request<CountClosedWorkflowExecutionsRequest> marshall(CountClosedWorkflowExecutionsRequest countClosedWorkflowExecutionsRequest) {
        if (countClosedWorkflowExecutionsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<CountClosedWorkflowExecutionsRequest> request = new DefaultRequest<CountClosedWorkflowExecutionsRequest>(countClosedWorkflowExecutionsRequest, "AmazonSimpleWorkflow");
        String target = "SimpleWorkflowService.CountClosedWorkflowExecutions";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (countClosedWorkflowExecutionsRequest.getDomain() != null) {
                jsonWriter.key("domain").value(countClosedWorkflowExecutionsRequest.getDomain());
            }
            ExecutionTimeFilter startTimeFilter = countClosedWorkflowExecutionsRequest.getStartTimeFilter();
            if (startTimeFilter != null) {

                jsonWriter.key("startTimeFilter");
                jsonWriter.object();

                if (startTimeFilter.getOldestDate() != null) {
                    jsonWriter.key("oldestDate").value(startTimeFilter.getOldestDate());
                }
                if (startTimeFilter.getLatestDate() != null) {
                    jsonWriter.key("latestDate").value(startTimeFilter.getLatestDate());
                }
                jsonWriter.endObject();
            }
            ExecutionTimeFilter closeTimeFilter = countClosedWorkflowExecutionsRequest.getCloseTimeFilter();
            if (closeTimeFilter != null) {

                jsonWriter.key("closeTimeFilter");
                jsonWriter.object();

                if (closeTimeFilter.getOldestDate() != null) {
                    jsonWriter.key("oldestDate").value(closeTimeFilter.getOldestDate());
                }
                if (closeTimeFilter.getLatestDate() != null) {
                    jsonWriter.key("latestDate").value(closeTimeFilter.getLatestDate());
                }
                jsonWriter.endObject();
            }
            WorkflowExecutionFilter executionFilter = countClosedWorkflowExecutionsRequest.getExecutionFilter();
            if (executionFilter != null) {

                jsonWriter.key("executionFilter");
                jsonWriter.object();

                if (executionFilter.getWorkflowId() != null) {
                    jsonWriter.key("workflowId").value(executionFilter.getWorkflowId());
                }
                jsonWriter.endObject();
            }
            WorkflowTypeFilter typeFilter = countClosedWorkflowExecutionsRequest.getTypeFilter();
            if (typeFilter != null) {

                jsonWriter.key("typeFilter");
                jsonWriter.object();

                if (typeFilter.getName() != null) {
                    jsonWriter.key("name").value(typeFilter.getName());
                }
                if (typeFilter.getVersion() != null) {
                    jsonWriter.key("version").value(typeFilter.getVersion());
                }
                jsonWriter.endObject();
            }
            TagFilter tagFilter = countClosedWorkflowExecutionsRequest.getTagFilter();
            if (tagFilter != null) {

                jsonWriter.key("tagFilter");
                jsonWriter.object();

                if (tagFilter.getTag() != null) {
                    jsonWriter.key("tag").value(tagFilter.getTag());
                }
                jsonWriter.endObject();
            }
            CloseStatusFilter closeStatusFilter = countClosedWorkflowExecutionsRequest.getCloseStatusFilter();
            if (closeStatusFilter != null) {

                jsonWriter.key("closeStatusFilter");
                jsonWriter.object();

                if (closeStatusFilter.getStatus() != null) {
                    jsonWriter.key("status").value(closeStatusFilter.getStatus());
                }
                jsonWriter.endObject();
            }

          jsonWriter.endObject();

          String snippet = stringWriter.toString();
          byte[] content = snippet.getBytes(UTF8);
          request.setContent(new StringInputStream(snippet));
          request.addHeader("Content-Length", Integer.toString(content.length));
          request.addHeader("Content-Type", "application/x-amz-json-1.0");
        } catch(Throwable t) {
          throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}
