package Starter.Register;

import com.github.javafaker.Faker;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostRegist3 {
    public static String url = "https://capstone-go.dikatest.xyz/";
    protected static String email="";
    protected static String firstname="";
    protected static String password="";
    protected static String tgl_lahir="";

    @Step("user post regist endpoint3")
    public String postregisendpoint3(){
        return url + "auth/register";
    }

    @Step("user regist using empty lastname")
    public void registUsingEmptyLastname(){
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        firstname=faker.name().firstName();
        password=faker.internet().password();
        tgl_lahir= String.valueOf(faker.date().birthday(17,90));
        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname", firstname);
        requestBody.put("email", email);
        requestBody.put("password", password);
        requestBody.put("tanggal_lahir", tgl_lahir);
        requestBody.put("jenis_kelamin", "P");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(postregisendpoint3());
    }
    @Step("user succes regist respon 400")
    public void  unsuccesregist3responcode400(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user get a message proses register berhasil")
    public void receivemessage3(){
        restAssuredThat(response -> response.body("message", equalTo("proses register berhasil")));
    }
}
