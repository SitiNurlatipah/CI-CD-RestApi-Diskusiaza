package Starter.Register;

import com.github.javafaker.Faker;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostRegist2 {
    public static String url = "https://capstone-go.dikatest.xyz/";
    protected static String email="";
    protected static String lastname="";
    protected static String password="";
    protected static String tgl_lahir="";

    @Step("user post regist endpoint2")
    public String postregisendpoint2(){
        return url + "auth/register";
    }

    @Step("user regist using no input firstname")
    public void registUsingEmptyFirstname(){
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        lastname=faker.name().lastName();
        password=faker.internet().password();
        tgl_lahir= String.valueOf(faker.date().birthday(17,90));
        JSONObject requestBody = new JSONObject();
        requestBody.put("lastname", lastname);
        requestBody.put("email", email);
        requestBody.put("password", password);
        requestBody.put("tanggal_lahir", tgl_lahir);
        requestBody.put("jenis_kelamin", "P");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(postregisendpoint2());
    }
    @Step("user unsucces regist respon 400 on regist 2")
    public void  unsuccesregist2responcode400(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user get a message")
    public void receivemessage2(){
        restAssuredThat(response -> response.body("message", equalTo("proses register berhasil")));
    }
}
