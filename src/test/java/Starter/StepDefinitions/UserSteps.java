package Starter.StepDefinitions;

import Starter.User.GetAllUsers;
import Starter.User.GetFollowersDetails;
import Starter.User.GetFollowingDetails;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class UserSteps {
    @Steps
    GetAllUsers users;
    @Steps
    GetFollowersDetails follower;
    @Steps
    GetFollowingDetails following;

    @Given("user success auth using token a")
    public void successAuthTokenA(){
        users.successAuthA();
    }
    @When("user set get all user endpoints")
    public void setGetAllUser(){
        users.setGetAllUser();
    }
    @And("user send get all user endpoints")
    public void sendGetAlluser(){
        users.sendGetAllUserEndpoints();
    }
    @Then("user get 1 respon code 200")
    public void getResponse1Code200() {
        users.get1ResponseCode200();
    }

    //
    @Given("user success auth using token b")
    public void successAuthTokenB(){
        follower.successAuthB();
    }
    @When("user set get followers details endpoints")
    public void setGetFollowers(){
        follower.setGetFollowersDetailsEndpoints();
    }
    @And("user send get followers details endpoints")
    public void sendGetFollowers(){
        follower.sendFollowersdetailsEndpoints();
    }
    @Then("user get 2 respon code 200")
    public void get2ResponseCode() {
        follower.get2ResponseCode200();
    }
    @And("user get message details followers")
    public void getDetailsFollowers() {
        follower.receiveDetailsFollowers();
    }

    //
    @Given("user success auth using token c")
    public void successAuthToken(){
        following.successAuthC();
    }
    @When("user set get following details endpoints")
    public void getDetailsFollowingEndpoints() {
        following.setGetFollowingDetailsEndpoints();
    }
    @And("user send get following details endpoints")
    public void sendGetFollowingEndpoints(){
        following.sendFollowingdetailsEndpoints();
    }
    @Then("user get 3 respon code 200")
    public void get3ResponseCode() {
        following.get3ResponseCode200();
    }
    @And("user get message details following")
    public void getDetailsFollowingg() {
        following.receiveDetailsFollowing();
    }
}
