package com.ocbc.accesslogin;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;
import utils.BaseUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class accessUsersSubmission {

    private final BaseUtil base;
    public Map headers;
    private FileInputStream fileInputStream1;
    private FileInputStream fileInputStream;
    private String requestBody_Submission;
    private Scenario scenario;


    public accessUsersSubmission(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void init(Scenario scenario) {
        this.scenario = scenario;
    }


    @When("post the request {string}")
    public void postTheRequest(String path) throws IOException {
        fileInputStream = new FileInputStream(new File("src/test/java/utils/commonHeaders.json"));
        headers = base.mapper.readValue(IOUtils.toString(fileInputStream, "UTF-8"), Map.class);
        fileInputStream1 = new FileInputStream(new File("src/test/java/utils/accessUserSubmissionRequest.json"));
        requestBody_Submission = IOUtils.toString(fileInputStream1, "UTF-8");
        System.out.println("In Second When Method");
        System.out.println(accessUsers.total);
        base.builder.addHeaders(headers);
        base.builder.setBody(requestBody_Submission);
        RequestSpecification requestSpecification = base.builder.build();
        System.out.println("In When ");
        base.response = given()
                .spec(requestSpecification)
                .when()
                .request(Method.POST, path)
                .then()
                .extract()
                .response();
        base.response.prettyPrint();
        scenario.write(base.response.prettyPrint());
    }
}
