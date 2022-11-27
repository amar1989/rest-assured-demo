package com.crunchbase.orginfo.controller;

import com.crunchbase.orginfo.entities.CrunchbaseResponse;
import io.restassured.response.Response;

public class CrunchBaseController {

    public CrunchbaseResponse getCrunchBaseResponse(Response response)
    {
        return response.as(CrunchbaseResponse.class);
    }
}
