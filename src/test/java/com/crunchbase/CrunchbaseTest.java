package com.crunchbase;

import com.crunchbase.orginfo.client.CrunchBaseClient;
import com.crunchbase.orginfo.data.CrunchbaseDataProvider;
import com.crunchbase.orginfo.controller.CrunchBaseController;
import com.crunchbase.orginfo.entities.CrunchbaseResponse;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class CrunchbaseTest extends CrunchbaseDataProvider {
    Logger logger = LogManager.getLogger(CrunchbaseTest.class);
    CrunchBaseClient crunchBaseClient = new CrunchBaseClient();
    CrunchBaseController crunchBaseController = new CrunchBaseController();

    @Test(dataProvider = "org_data")
    public void getOrgInfo(String orgName) {
        try {
            Response response = crunchBaseClient.makeRequest(RAPID_API_KEY, RAPID_API_HOST, orgName);
            logger.info("Response JSON:\n" + response.getBody().prettyPrint());
            Assert.assertEquals(200, response.getStatusCode(), "Status code is not matching for the end point /autofilter");

            //Schema validation
            ValidatableResponse validatableresponse = response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(crunchbaseSchemaValidationFile)));
            validatableresponse.statusCode(200);

            //Response validation
            CrunchbaseResponse crunchbaseResponse = crunchBaseController.getCrunchBaseResponse(response);
            Assert.assertTrue(crunchbaseResponse.getEntities()[0].getFacetsId().length != 0, "Getting empty facet ids");
            Assert.assertTrue(crunchbaseResponse.getEntities()[0].getIdentifier().getValue().equals(orgName), "Org name is not matching");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
