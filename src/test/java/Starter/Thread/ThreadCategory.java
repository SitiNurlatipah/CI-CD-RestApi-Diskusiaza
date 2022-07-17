package Starter.Thread;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ThreadCategory {
    protected String url = "https://capstone-go.dikatest.xyz/";
    protected static String token = "";

    public JSONObject setLoginTokenn() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ii@gmail.com");
        requestBody.put("password", "123");
        return requestBody;
    }
    @Step
    public void successAuthorized() {
        SerenityRest.given().header("Content-Type", "application/json").body(setLoginTokenn().toJSONString()).post(url + "auth/login");
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("token");
    }
    @Step
    public String setGetThreadCategoryEndpoints(){
        return url + "t/therad/kategori";
    }
    @Step
    public void sendGetThreadCategoryEndpoints(){
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setGetThreadCategoryEndpoints());
    }
    @Step
    public void  getResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step
    public void receiveCategoryName(){
        restAssuredThat(response -> response.body("'data'.kategori_name[0]", equalTo("Cerita Lucu")));
    }
}
