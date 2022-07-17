package Starter.LikeThread;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.response.Response;

public class PostLikeThread {
    protected String url = "https://capstone-go.dikatest.xyz/";
    protected static String token="";

    public JSONObject setLoginToken(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email","ii@gmail.com");
        requestBody.put("password","123");
        return requestBody;
    }

    @Step
    public void successAuth(){
        SerenityRest.given().header("Content-Type", "application/json").body(setLoginToken().toJSONString()).post(url+"auth/login");
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("token");

    }
    @Step
    public String postLikeThreadEndpoints(){
        return url + "t/therad/like";
    }
    @Step
    public void likeUsingThreadId(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("therad_id",52);
        SerenityRest.given().header("Content-Type","application/json").header("Authorization", "Bearer "+token).body(requestBody.toJSONString()).post(postLikeThreadEndpoints());
    }

    @Step
    public void  getResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step
    public void receiveMassageLikeSucces(){
        restAssuredThat(response -> response.body("message", equalTo("anda berhasil menyukai therad ini")));
    }
}
