package Starter.StepDefinitions;
import Starter.Login.PostLogin;
import Starter.Login.PostLogin2;
import Starter.Login.PostLogin3;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginSteps {
    @Steps
    PostLogin post;
    @Steps
    PostLogin2 post2;
    @Steps
    PostLogin3 post3;

    @Given("user post login endpoints")
    public void postloginendpoints(){
        post.postloginendpoint();
    }
    @When("user login with valid email and valid password")
    public void loginusingvalidemailandpassword(){
        post.loginusingvalidemailandpassword();
    }
    @Then("user succes login respon 200 OK on login 1")
    public void succesloginresponcode200() {
        post.succesloginresponcode200();
    }

    @Given("user post login endpoints2")
    public void postloginendpoints2(){
        post2.postloginendpoint2();
    }
    @When("user login with valid email and unvalid password")
    public void loginusingvalidemailandunvalidpassword(){
        post2.loginusingvalidemailandunvalidpassword();
    }
    @Then("user unsucces login respon 401 on login 2")
    public void unsuccesloginresponcode200() {
        post2.unsuccesloginresponcode401();
    }
    @And("user receive message {}")
    public void receivemessage(String massage){
        post2.receivemassage();
    }

    @Given("user post login endpoints3")
    public void postloginendpoints3(){
        post3.postloginendpoint3();
    }
    @When("user login with unvalid email and valid password")
    public void loginusingunvalidemailandvalidpassword(){
        post3.loginusingunvalidemailandvalidpassword();
    }
    @Then("user unsucces login respon 401 on login 3")
    public void unsucceslogin2responcode401() {
        post3.unsucceslogin2responcode401();
    }
    @And("user receive message2 {}")
    public void receivemessage2(String massage){
        post3.receivemassage2();
    }

    @Given("user post login endpoints4")
    public void postloginendpoints4(){
        post3.postloginendpoint3();
    }
    @When("user login with unvalid email and unvalid password")
    public void loginusingunvalidemailandunvalidpassword(){
        post3.loginusingunvalidemailandvalidpassword();
    }
    @Then("user unsucces login respon 401 on login 4")
    public void unsucceslogin3responcode401() {
        post3.unsucceslogin2responcode401();
    }
    @And("user receive message3 {}")
    public void receivemessage3(String massage){
        post3.receivemassage2();
    }
}

