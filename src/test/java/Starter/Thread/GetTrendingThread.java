package Starter.Thread;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetTrendingThread {
    protected String url = "https://capstone-go.dikatest.xyz/";
    protected static String token = "";

    public JSONObject setLoginToken6() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ii@gmail.com");
        requestBody.put("password", "123");
        return requestBody;
    }

    @Step
    public void successAuth6() {
        SerenityRest.given().header("Content-Type", "application/json").body(setLoginToken6().toJSONString()).post(url + "auth/login");
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("token");
    }

    @Step
    public String setGetThreadTrendingEndpoints() {
        return url + "t/therad/trending";
    }

    @Step
    public void sendGetThreadTrendingEndpoints() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setGetThreadTrendingEndpoints());
    }
    @Step
    public void getResponseCode200 () {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step
    public void receiveThreadTrending () {
        restAssuredThat(response -> response.body("message", equalTo("favorite therad by total_like")));
    }
}
