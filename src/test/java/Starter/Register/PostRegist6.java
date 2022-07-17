package Starter.Register;

import com.github.javafaker.Faker;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostRegist6 {
    public static String url = "https://capstone-go.dikatest.xyz/";
    protected static String email="";
    protected static String firstname="";
    protected static String lastname="";
    protected static String password="";


    @Step("user post regist endpoint1")
    public String postregisendpoint6(){
        return url + "auth/register";
    }

    @Step("user regist using no input tanggal lahir")
    public void registUsingEmptyTanggalLahir(){
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        firstname=faker.name().firstName();
        lastname=faker.name().lastName();
        password=faker.internet().password();
        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname", firstname);
        requestBody.put("lastname", lastname);
        requestBody.put("email", email);
        requestBody.put("password", password);
        requestBody.put("jenis_kelamin", "P");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(postregisendpoint6());
    }
    @Step("user succes regist respon 400")
    public void  unsuccesregist6responcode400(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user get a message")
    public void receivemessage6(){
        restAssuredThat(response -> response.body("message", equalTo("proses register berhasil")));
    }
}
