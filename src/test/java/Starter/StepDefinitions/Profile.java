package Starter.StepDefinitions;

import Starter.Profile.GetProfile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class Profile {
    @Steps
    GetProfile getprofile;

    @Given("user login and success auth using token")
    public void authSuccess(){
        getprofile.successAutho();
    }
    @When("user set get profile endpoints")
    public void setGetProfileEndpoints(){
        getprofile.setGetProfileEndpoints();
    }
    @And("user send get profile endpoints")
    public void sendGetProfileEndpoints(){
        getprofile.sendGetProfileEndpoints();
    }
    @Then("user get profile respon code 200")
    public void succesGetProfileResponCode200() {
        getprofile.getResponseCode200();
    }
    @And("user get valid data profile")
    public void receivevaliddataprofile(){
        getprofile.receiveValidDataProfile();
    }

    //thread by user
    @Given("user success auth using token 7")
    public void authSuccess7(){
        getprofile.successAutho();
    }
    @When("user set get user thread endpoints")
    public void setGetUserThreadEndpoints(){
        getprofile.setGetProfileEndpoints();
    }
    @And("user send get user thread endpoints")
    public void sendGetUserThreadeEndpoints(){
        getprofile.sendGetProfileEndpoints();
    }
    @Then("user get profile respon7 code 200")
    public void succesGetResponCode200() {
        getprofile.getResponseCode200();
    }

    //delete my thread
    @Given("user success auth using token 8")
    public void authSuccess8(){
        getprofile.successAutho();
    }
    @When("user set delete user thread endpoints")
    public void setDeleteEndpoints(){
        getprofile.setGetProfileEndpoints();
    }
    @And("user send delete user thread endpoints")
    public void sendDeleteUserThreadEndpoints(){
        getprofile.sendGetProfileEndpoints();
    }
    @Then("user get profile respon8 code 200")
    public void succesGetResponseCode200() {
        getprofile.getResponseCode200();
    }
    @And("user get message delete succes")
    public void receiveMessage(){
        getprofile.receiveValidDataProfile();
    }
}
