package Starter.Register;

import com.github.javafaker.Faker;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostRegist4 {
    public static String url = "https://capstone-go.dikatest.xyz/";
    protected static String email="";
    protected static String firstname="";
    protected static String lastname="";
    protected static String password="";
    protected static String tgl_lahir="";
    private static int min_age=17;
    private static int max_age=100;
    @Step("user post regist endpoint1")
    public String postregisendpoint4(){
        return url + "auth/register";
    }

    @Step("user regist using no input email")
    public void registUsingEmptyEmail(){
        Faker faker = new Faker();
        firstname=faker.name().firstName();
        lastname=faker.name().lastName();
        password=faker.internet().password();
        tgl_lahir= String.valueOf(faker.date().birthday(17,90));
        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname", firstname);
        requestBody.put("lastname", lastname);
        requestBody.put("password", password);
        requestBody.put("tanggal_lahir", tgl_lahir);
        requestBody.put("jenis_kelamin", "P");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(postregisendpoint4());
    }
    @Step("user succes regist respon 400")
    public void  unsuccesregist4responcode400(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("user get a message")
    public void receivemessage4(){
        restAssuredThat(response -> response.body("message", equalTo("ada inputan yang tidak sesuai")));
    }
}
