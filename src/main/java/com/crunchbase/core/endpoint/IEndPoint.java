package com.crunchbase.core.endpoint;

import com.crunchbase.core.constants.MethodType;
import com.crunchbase.core.constants.ParamType;

import java.util.Map;

public interface IEndPoint {
    MethodType getMethodType();

    String getUrl();

    Map<String,String> getHeaders();

    String getRequestBody();

    ParamType getParamType();

    Map<String,String> getParamValue();
}
