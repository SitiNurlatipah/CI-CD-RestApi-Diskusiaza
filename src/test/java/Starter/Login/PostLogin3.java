package Starter.Login;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostLogin3 {
    public static String url = "https://capstone-go.dikatest.xyz/";

    @Step("user post login endpoints3")
    public String postloginendpoint3(){
        return url + "auth/login";
    }
    @Step("user login with unvalid email and valid password")
    public void loginusingunvalidemailandvalidpassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ardhitoprakoso@gmail.com");
        requestBody.put("password", "123");
        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(postloginendpoint3());
    }
    @Step("user succes login respon 401 on login 3")
    public void  unsucceslogin2responcode401(){
        restAssuredThat(response -> response.statusCode(401));
    }

    @Step("user receive message email/password salah")
    public void receivemassage2(){
        restAssuredThat(response -> response.body("message", equalTo("email atau password salah")));
    }
}
