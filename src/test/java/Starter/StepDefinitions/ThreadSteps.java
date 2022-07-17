package Starter.StepDefinitions;
import Starter.Thread.*;
import Starter.Thread.Thread;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ThreadSteps {
    @Steps
    Thread allThread;
    @Steps
    ThreadById byId;
    @Steps
    ThreadCategory category;
    @Steps
    GetTrendingThread trending;
    @Steps
    GetThreadByKategori byKategori;

    //category
    @Given("user kategori success auth using token")
    public void successAuthhh(){
        category.successAuthorized();
    }
    @When("user set get category thread endpoints")
    public void setGetCategory(){
        category.setGetThreadCategoryEndpoints();
    }
    @And("user send get category thread endpoints")
    public void sendGetCategory(){
        category.sendGetThreadCategoryEndpoints();
    }
    @Then("user get respon code 200")
    public void responseCode200() {
        category.getResponseCode200();
    }
    @And("user receive details category thread")
    public void detailsCategory(){
        category.receiveCategoryName();
    }

    //by all thread
    @Given("user success auth using token3")
    public void successauthh3(){
        allThread.successAuth2();
    }
    @When("user set get all thread endpoints")
    public void setGetAllThread(){
        allThread.setGetThreadEndpoints();
    }
    @And("user send get all thread endpoints")
    public void sendGetAllThread(){
        allThread.sendGetThreadEndpoints();
    }
    @Then("user get response code2 200")
    public void getResponseCode200() {
        allThread.getResponseCode200();
    }
    @And("user receive details all thread")
    public void receiveDetailsAllThread(){
        allThread.receiveMassageLikeSucces2();
    }

    //all by id
    @Given("user success auth using token4")
    public void successauthh(){
        byId.successAuth3();
    }
    @When("user set get thread by id endpoints")
    public void setGetThreadById(){
        byId.setGetThreadByIDEndpoints();
    }
    @And("user send get thread by id endpoints")
    public void sendGetThreadById(){
        byId.sendGetThreadByIDEndpoints();
    }
    @Then("user get response code3 200")
    public void getResponse3Code200() {
        byId.getResponseCode200();
    }
    @And("user receive thread by id")
    public void receiveThreadById(){
        byId.receiveMassageLikeSucces();
    }

    //thread by categori
    @Given("user success auth using token 5")
    public void successauthh5(){
        byKategori.successAuth5();
    }
    @When("user set get thread by kategori endpoints")
    public void setGetThreadByCategory(){
        byKategori.setGetThreadByCategoryEndpoints();
    }
    @And("user send get thread by kategori endpoints")
    public void sendGetThreadByCategory(){
        byKategori.sendGetThreadByCategoryEndpoints();
    }
    @Then("user get response code4 200")
    public void getResponse4Code200() {
        byKategori.getResponseCode200();
    }
    @And("user receive thread by kategori")
    public void receiveThreadByCategory(){
        byKategori.receiveThreadByCategory();
    }

    //trending thread
    @Given("user success auth using token 6")
    public void successauthh6(){
        trending.successAuth6();
    }
    @When("user set get thread trending endpoints")
    public void setGetThreadTrending(){
        trending.setGetThreadTrendingEndpoints();
    }
    @And("user send get thread trending endpoints")
    public void sendGetThreadTrending(){
        trending.sendGetThreadTrendingEndpoints();
    }
    @Then("user get response code5 200")
    public void getResponse5Code200() {
        trending.getResponseCode200();
    }
    @And("user receive thread trending")
    public void receiveThreadTrending(){
        trending.receiveThreadTrending();
    }
}
