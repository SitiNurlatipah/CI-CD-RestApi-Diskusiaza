package Starter.User;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetAllUsers {
    protected String url = "https://capstone-go.dikatest.xyz/";
    protected static String token = "";

    public JSONObject setLoginToken01() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ii@gmail.com");
        requestBody.put("password", "123");
        return requestBody;
    }

    @Step
    public void successAuthA() {
        SerenityRest.given().header("Content-Type", "application/json").body(setLoginToken01().toJSONString()).post(url + "auth/login");
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("token");
    }

    @Step
    public String setGetAllUser() {
        return url + "t/user";
    }

    @Step
    public void sendGetAllUserEndpoints() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setGetAllUser());
    }
    @Step
    public void get1ResponseCode200 () {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step
    public void receiveMassageLikeSucces2 () {
        restAssuredThat(response -> response.body("'data'.id[0]", equalTo(1)));
    }
}
