package Starter.Profile;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetUserThread {
    protected String url = "https://capstone-go.dikatest.xyz/";
    protected static String token = "";

    public JSONObject setLoginAndAuth7() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ii@gmail.com");
        requestBody.put("password", "123");
        return requestBody;
    }

    @Step
    public void successAuth7() {
        SerenityRest.given().header("Content-Type", "application/json").body(setLoginAndAuth7().toJSONString()).post(url + "auth/login");
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("token");
    }
    @Step
    public String setGetUserThreadEndpoints() {
        return url + "t/user/therad";
    }
    @Step
    public void sendGetUserThreadEndpoints(){
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setGetUserThreadEndpoints());
    }
    @Step
    public void getResponse7Code200 () {
        restAssuredThat(response -> response.statusCode(200));
    }
}
