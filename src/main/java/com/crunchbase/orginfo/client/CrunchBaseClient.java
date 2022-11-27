package com.crunchbase.orginfo.client;

import com.crunchbase.orginfo.endpoint.CrunchbaseEndpoint;
import com.crunchbase.core.servicereq.Requester;
import io.restassured.response.Response;

public class CrunchBaseClient {

    public Response makeRequest(String apiKey, String apiHost, String paramValue) {
        CrunchbaseEndpoint crunchbaseEndpoint = new CrunchbaseEndpoint(apiKey, apiHost, paramValue);
        return Requester.processRequest(crunchbaseEndpoint);
    }
}
