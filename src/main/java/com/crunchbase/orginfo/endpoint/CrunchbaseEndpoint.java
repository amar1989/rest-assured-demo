package com.crunchbase.orginfo.endpoint;

import com.crunchbase.core.endpoint.IEndPoint;
import com.crunchbase.core.constants.MethodType;
import com.crunchbase.core.constants.ParamType;

import java.util.HashMap;
import java.util.Map;

public class CrunchbaseEndpoint implements IEndPoint {
    String baseUrl = "https://crunchbase-crunchbase-v1.p.rapidapi.com";
    String rapidApiKey;
    String getRapidApiHost;
    String paramValue;

    public CrunchbaseEndpoint(String rapidApiKey, String rapidApiHost, String paramValue) {
        this.rapidApiKey = rapidApiKey;
        this.getRapidApiHost = rapidApiHost;
        this.paramValue = paramValue;
    }

    @Override
    public MethodType getMethodType() {
        return MethodType.GET;
    }

    @Override
    public String getUrl() {
        return baseUrl + "/autocompletes";
    }

    @Override
    public Map<String, String> getHeaders() {
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put("X-RapidAPI-Key", rapidApiKey);
        headersMap.put("X-RapidAPI-Host", getRapidApiHost);
        headersMap.put("Content-Type", "application/json");
        headersMap.put("Accept", "application/json");
        return headersMap;
    }

    @Override
    public String getRequestBody() {
        return null;
    }

    @Override
    public ParamType getParamType() {
        return ParamType.QUERY_PARAM;
    }

    @Override
    public Map<String, String> getParamValue() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("query", paramValue);
        return paramMap;
    }
}
