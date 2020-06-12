package com.ocbc.accesslogin;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import utils.BaseUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class accessUsers {

    private final BaseUtil base;
    public static int total;
    private Scenario scenario;

    public accessUsers(BaseUtil base) {
        this.base = base;
    }


    private FileInputStream fileInputStream;
    private Map headers;

    @Before
    public void init(Scenario scenario) {
        this.scenario = scenario;
    }


    @Given("The request with all headers")
    public void theRequestWithAllHeaders() throws IOException {
        fileInputStream = new FileInputStream(new File("src/test/java/utils/commonHeaders.json"));
        headers = base.mapper.readValue(IOUtils.toString(fileInputStream, "UTF-8"), Map.class);
        System.out.println("In Before First");
        System.out.println("In Given Method");
        base.builder.setBaseUri(Constants.baseURI);
        base.builder.setContentType(ContentType.JSON);
        scenario.write("test");
    }

    @When("get the service {string}")
    public void getTheService(String arg0) {

        System.out.println("In When Method");
        base.builder.addHeaders(headers);
        base.builder.setBasePath(Constants.path);
        RequestSpecification requestSpecification = base.builder.build();
        base.response = given()
                .spec(requestSpecification)
                .when()
                .request(Method.GET)
                .then()
                .extract()
                .response();

        scenario.write("Test");
        String outout = base.response.getBody().asString();
        System.out.println("output is" + outout);
    }

    @Then("validate the response code as {int}")
    public void validateTheResponseCodeAs(int statuscode) {
        System.out.println("In Then Method");
        System.out.println(base.response.getStatusCode());
        Assert.assertEquals(base.response.getStatusCode(), statuscode);

    }

    @And("retrieve the total value")
    public void retrieveTheTotalValue() {
        total = base.response.jsonPath().get("total");
        System.out.println(total);
    }
}
