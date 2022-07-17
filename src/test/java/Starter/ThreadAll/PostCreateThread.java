package Starter.ThreadAll;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostCreateThread {
    public static String url = "https://capstone-go.dikatest.xyz/";

    @Step("user post login endpoints")
    public String postloginendpoint(){
        return url + "auth/login";
    }

    @Step("user login with valid email and valid password")
    public void loginusingvalidemailandpassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "hening@gmail.com");
        requestBody.put("password", "aiueo");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(postloginendpoint());
    }
    @Step("user succes login respon 200 OK on login 1")
    public void  succesloginresponcode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user receive valid token")
    public void receivevalidtoken(){
        restAssuredThat(response -> response.body("token", equalTo("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJkYXRhIjp7ImVtYWlsIjoiaGVuaW5nQGdtYWlsLmNvbSIsImZpcnN0bmFtZSI6InNpdGkiLCJpZCI6ODEsImxhc3RuYW1lIjoiRGkgbXV0ZSIsInJvbGVJZCI6MX0sImV4cCI6MTY1NzMwMTE3NH0.tILEdjUaxM5tedIyuUJz0KHQSP3O7GcCJUxHoZjVj_o")));
    }
}
