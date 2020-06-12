package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

public class BaseUtil {

    public RequestSpecBuilder builder = new RequestSpecBuilder();
    public ObjectMapper mapper = new ObjectMapper();
    public Gson gson = new Gson();
    public Response response;
}
