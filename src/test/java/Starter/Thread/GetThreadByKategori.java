package Starter.Thread;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetThreadByKategori {
    protected String url = "https://capstone-go.dikatest.xyz/";
    protected static String token = "";

    public JSONObject setLoginToken5() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ii@gmail.com");
        requestBody.put("password", "123");
        return requestBody;
    }

    @Step
    public void successAuth5() {
        SerenityRest.given().header("Content-Type", "application/json").body(setLoginToken5().toJSONString()).post(url + "auth/login");
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("token");
    }

    @Step
    public String setGetThreadByCategoryEndpoints() {
        return url + "t/therad/kategori/1";
    }

    @Step
    public void sendGetThreadByCategoryEndpoints() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setGetThreadByCategoryEndpoints());
    }
    @Step
    public void getResponseCode200 () {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step
    public void receiveThreadByCategory () {
        restAssuredThat(response -> response.body("kategori_name", equalTo("Cerita Lucu")));
    }
}
