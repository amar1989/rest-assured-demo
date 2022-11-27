package com.crunchbase.orginfo.data;

import org.testng.annotations.DataProvider;

public class CrunchbaseDataProvider {
    public  final String RAPID_API_KEY = "7aadcd51d8msh80a00a7fe15767fp1f1abcjsnc5d60413bc09";
    public  final String RAPID_API_HOST="crunchbase-crunchbase-v1.p.rapidapi.com";
    public final String crunchbaseSchemaValidationFile="/Users/amarsingh/Workspace/restassureddemo/src/main/resources/Crunchbase-schema.json";

    @DataProvider(name = "org_data")
    public Object[][] dpMethod() {
        return new Object [][] {{"Gojek"},{"Grab"}};
    }

}
