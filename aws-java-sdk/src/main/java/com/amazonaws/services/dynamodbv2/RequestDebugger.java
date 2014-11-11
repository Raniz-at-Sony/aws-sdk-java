package com.amazonaws.services.dynamodbv2;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpResponseHandler;

/**
 * Interface used for debugging requests to Amazon DynamoDB.
 * @author Raniz
 *
 */
public interface RequestDebugger {

    /**
     * Called when a request was successful.
     *
     * @param request
     * @param responseHandler
     * @param executionContext
     * @param response
     * @return
     */
    public <X, Y extends AmazonWebServiceRequest> void requestCompleted(Request<Y> request,
            HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext, Response<X> response);

    /**
     * Called when a request failed due to an exception
     * @param request
     * @param executionContext
     * @param exception
     * @return
     */
    public <X, Y extends AmazonWebServiceRequest> void requestFailed(Request<Y> request,
            HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext, AmazonClientException exception);
}
