package Starter.StepDefinitions;

import Starter.LikeThread.DeleteLikeThread;
import Starter.LikeThread.PostLikeThread;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LikeThread {
    @Steps
    PostLikeThread likeThread;
    @Steps
    DeleteLikeThread unlikeThread;

    //like thread
    @Given("user success auth using token")
    public void successAuthToken(){
        likeThread.successAuth();
    }
    @When("user post like thread endpoints")
    public void postLikeThreadEndpoints(){
        likeThread.postLikeThreadEndpoints();
    }
    @And("user input thread id")
    public void inputThreadID(){
        likeThread.likeUsingThreadId();
    }
    @Then("user succes like thread with respon code 200")
    public void succesLikeResponseCode() {
        likeThread.getResponseCode200();
    }
    @And("user got message {}")
    public void gotMessage1(String message) {
        likeThread.receiveMassageLikeSucces();
    }

    //unlike thread
    @Given("user success auth using token1")
    public void successAuthToken1(){
        unlikeThread.successAuth1();
    }
    @When("user delete like thread endpoints")
    public void deleteLikeThreadEndpoints(){
        unlikeThread.DeleteLikeThreadEndpoints();
    }

    @And("user input thread id2")
    public void unlikeUsingThreadId(){
        unlikeThread.inputthreadid1();
    }
    @Then("user succes unlike thread with respon code 200")
    public void getResponseCode() {
        unlikeThread.getHttpsResponseCode200();
    }
    @And("user got massage2 {}")
    public void gotMassage(String message) {
        unlikeThread.receiveMassageUnlikeSucces();
    }
}
