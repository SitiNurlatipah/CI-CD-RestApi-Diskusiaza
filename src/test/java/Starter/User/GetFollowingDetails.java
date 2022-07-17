package Starter.User;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetFollowingDetails {
    protected String url = "https://capstone-go.dikatest.xyz/";
    protected static String token = "";

    public JSONObject setLoginToken03() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ii@gmail.com");
        requestBody.put("password", "123");
        return requestBody;
    }

    @Step
    public void successAuthC() {
        SerenityRest.given().header("Content-Type", "application/json").body(setLoginToken03().toJSONString()).post(url + "auth/login");
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("token");
    }

    @Step
    public String setGetFollowingDetailsEndpoints() {
        return url + "t/user/followed";
    }

    @Step
    public void sendFollowingdetailsEndpoints() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setGetFollowingDetailsEndpoints());
    }
    @Step
    public void get3ResponseCode200 () {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step
    public void receiveDetailsFollowing () {
        restAssuredThat(response -> response.body("message", equalTo("detail your followed")));
    }
}
