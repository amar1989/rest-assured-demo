package com.crunchbase.core.servicereq;

import com.crunchbase.core.constants.MethodType;
import com.crunchbase.core.constants.ParamType;
import com.crunchbase.core.endpoint.IEndPoint;
import com.github.dzieciou.testing.curl.CurlRestAssuredConfigFactory;
import com.github.dzieciou.testing.curl.Options;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.event.Level;

import java.util.Map;

public class Requester {

    public static Response processRequest(IEndPoint endPoint) {
        Response response = null;

        try {
            Options options = Options.builder().useLogLevel(Level.INFO).build();
            RestAssuredConfig config = CurlRestAssuredConfigFactory.createConfig(options);
            RestAssured.baseURI = endPoint.getUrl();
            RequestSpecification request = RestAssured.given();
            Map<String, String> paramMap = endPoint.getParamValue();
            if (endPoint.getParamType() != null && (!endPoint.getParamType().equals(""))) {
                if (endPoint.getParamType().equals(ParamType.PATH_PARAM)) {
                    for (String paramKey : paramMap.keySet()) {
                        request.pathParam(paramKey, paramMap.get(paramKey));
                    }
                } else if (endPoint.getParamType().equals(ParamType.QUERY_PARAM)) {
                    for (String paramKey : paramMap.keySet()) {
                        request.queryParam(paramKey, paramMap.get(paramKey));
                    }
                }
            }
            request.config(config);
            Map<String, String> headers = endPoint.getHeaders();
            for (String headerKey : headers.keySet()) {
                request.headers(headerKey, headers.get(headerKey));
            }
            if (endPoint.getMethodType().equals(MethodType.GET)) {
                response = request.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
