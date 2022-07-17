package Starter.Login;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostLogin2 {
    public static String url = "https://capstone-go.dikatest.xyz/";

    @Step("user post login endpoints2")
    public String postloginendpoint2(){
        return url + "auth/login";
    }

    @Step("user login with valid email and unvalid password")
    public void loginusingvalidemailandunvalidpassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ardhikayoviyanto@gmail.com");
        requestBody.put("password", "abc");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(postloginendpoint2());
    }
    @Step("user succes login respon 401 on login 2")
    public void  unsuccesloginresponcode401(){
        restAssuredThat(response -> response.statusCode(401));
    }

    @Step("user receive message email atau password salah")
    public void receivemassage(){
        restAssuredThat(response -> response.body("message", equalTo("email atau password salah")));
    }
}
