package Starter.Profile;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteUserThread {
    protected String url = "https://capstone-go.dikatest.xyz/";
    protected static String token = "";

    public JSONObject setLoginAndAuth8() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ii@gmail.com");
        requestBody.put("password", "123");
        return requestBody;
    }

    @Step
    public void successAuth8() {
        SerenityRest.given().header("Content-Type", "application/json").body(setLoginAndAuth8().toJSONString()).post(url + "auth/login");
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("token");
    }
    @Step
    public String setDeleteUserThreadEndpoints() {
        return url + "https://capstone-go.dikatest.xyz/t/user/therad/53";
    }
    @Step
    public void sendDeleteUserThreadEndpoints(){
        SerenityRest.given().header("Authorization", "Bearer " + token).delete(setDeleteUserThreadEndpoints());
    }
    @Step
    public void getResponse7Code200 () {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step
    public void receiveMessagedelete () {
        restAssuredThat(response -> response.body("message", equalTo("therad successfully deleted")));

    }
}
