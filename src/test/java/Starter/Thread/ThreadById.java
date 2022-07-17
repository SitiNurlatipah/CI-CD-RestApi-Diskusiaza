package Starter.Thread;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ThreadById {
    protected String url = "https://capstone-go.dikatest.xyz/";
    protected static String token = "";

    public JSONObject setLoginToken3() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ii@gmail.com");
        requestBody.put("password", "123");
        return requestBody;
    }
    @Step
    public void successAuth3() {
        SerenityRest.given().header("Content-Type", "application/json").body(setLoginToken3().toJSONString()).post(url + "auth/login");
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("token");
    }
    @Step
    public String setGetThreadByIDEndpoints(){
        return url + "t/therad/46";
    }
    @Step
    public void sendGetThreadByIDEndpoints(){
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setGetThreadByIDEndpoints());
    }
    @Step
    public void  getResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step
    public void receiveMassageLikeSucces(){
        restAssuredThat(response -> response.body("'data'.judul", equalTo("Haloo edit tambah fotot")));
    }
}
