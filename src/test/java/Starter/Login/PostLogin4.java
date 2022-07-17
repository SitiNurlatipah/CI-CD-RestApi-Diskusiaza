package Starter.Login;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostLogin4 {
    public static String url = "https://capstone-go.dikatest.xyz/";

    @Step("user post login endpoints4")
    public String postloginendpoint4(){
        return url + "auth/login";
    }
    @Step("user login with unvalid email and valid password")
    public void loginusingunvalidemailandunvalidpassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ardhitoprakoso@gmail.com");
        requestBody.put("password", "abcd");
        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(postloginendpoint4());
    }
    @Step("user unsucces login respon 401 on login 4")
    public void  unsucceslogin3responcode401(){
        restAssuredThat(response -> response.statusCode(401));
    }

    @Step("user receive message email/password salah")
    public void receivemassage3(){
        restAssuredThat(response -> response.body("message", equalTo("email atau password salah")));
    }
}
