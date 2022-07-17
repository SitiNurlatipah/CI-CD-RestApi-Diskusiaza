package Starter.Profile;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetProfile {
    protected String url = "https://capstone-go.dikatest.xyz/";
    protected static String token = "";

    public JSONObject setLoginAndAuth() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ii@gmail.com");
        requestBody.put("password", "123");
        return requestBody;
    }

    @Step
    public void successAutho() {
        SerenityRest.given().header("Content-Type", "application/json").body(setLoginAndAuth().toJSONString()).post(url + "auth/login");
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("token");
    }


    @Step
    public String setGetProfileEndpoints() {
        return url + "t/user/profile";
    }

    @Step
    public void sendGetProfileEndpoints() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setGetProfileEndpoints());
    }
    @Step
    public void getResponseCode200 () {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step
    public void receiveValidDataProfile () {
        restAssuredThat(response -> response.body("'data'.lastname", equalTo("Nurlatipah")));
    }
    }
