package Starter.User;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetFollowersDetails {
    protected String url = "https://capstone-go.dikatest.xyz/";
    protected static String token = "";

    public JSONObject setLoginToken02() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ii@gmail.com");
        requestBody.put("password", "123");
        return requestBody;
    }

    @Step
    public void successAuthB() {
        SerenityRest.given().header("Content-Type", "application/json").body(setLoginToken02().toJSONString()).post(url + "auth/login");
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("token");
    }

    @Step
    public String setGetFollowersDetailsEndpoints() {
        return url + "t/user/followers";
    }

    @Step
    public void sendFollowersdetailsEndpoints() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setGetFollowersDetailsEndpoints());
    }
    @Step
    public void get2ResponseCode200 () {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step
    public void receiveDetailsFollowers () {
        restAssuredThat(response -> response.body("message", equalTo("detail your followers")));
    }
}
