package Starter.LikeThread;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteLikeThread {
    protected String url = "https://capstone-go.dikatest.xyz/";
    protected static String token="";

    public JSONObject setLoginToken1(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email","ii@gmail.com");
        requestBody.put("password","123");
        return requestBody;
    }
    @Step
    public void successAuth1(){
        SerenityRest.given().header("Content-Type", "application/json").body(setLoginToken1().toJSONString()).post(url+"auth/login");
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("token");
    }
    @Step
    public String DeleteLikeThreadEndpoints(){
        return url + "t/therad/like";
    }

    @Step
    public void inputthreadid1(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("therad_id",46);

        SerenityRest.given().header("Content-Type","application/json").header("Authorization", "Bearer "+token).body(requestBody.toJSONString()).delete(DeleteLikeThreadEndpoints());
    }
    @Step
    public void  getHttpsResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step
    public void receiveMassageUnlikeSucces(){
        restAssuredThat(response -> response.body("message", equalTo("anda berhasil unlike therad ini")));
    }
}
