package Starter.Register;

import com.github.javafaker.Faker;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostRegist7 {
    public static String url = "https://capstone-go.dikatest.xyz/";
    protected static String email="";
    protected static String firstname="";
    protected static String lastname="";
    protected static String password="";
    protected static String tgl_lahir="";

    @Step("user post regist endpoint1")
    public String postregisendpoint7(){
        return url + "auth/register";
    }

    @Step("user regist using empty jenis kelamin")
    public void registUsingEmptyJenisKelamin(){
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        firstname=faker.name().firstName();
        lastname=faker.name().lastName();
        password=faker.internet().password();
        tgl_lahir= String.valueOf(faker.date().birthday(17,90));
        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname", firstname);
        requestBody.put("lastname", lastname);
        requestBody.put("email", email);
        requestBody.put("password", password);
        requestBody.put("tanggal_lahir", tgl_lahir);

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(postregisendpoint7());
    }
    @Step("user unsucces regist respon 400")
    public void  unsuccesregist7responcode400(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user get a message")
    public void receivemessage7(){
        restAssuredThat(response -> response.body("message", equalTo("proses register berhasil")));
    }
}
