package Starter.StepDefinitions;

import Starter.Register.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RegisSteps {
    @Steps
    PostRegist regist;
    @Steps
    PostRegist2 regist2;
    @Steps
    PostRegist3 regist3;
    @Steps
    PostRegist4 regist4;
    @Steps
    PostRegist5 regist5;
    @Steps
    PostRegist6 regist6;
    @Steps
    PostRegist7 regist7;
    @Given("user post regist endpoint1")
    public void postregistendpoints(){
        regist.postregisendpoint();
    }
    @When("user regist using valid data")
    public void loginusingvalidemailandpassword(){
        regist.registusingvalidemailandpassword();
    }
    @Then("user succes regist respon 200 OK on regist 1")
    public void succesRegistResponCode200() {
        regist.succesregistresponcode200();
    }
    @And("user get a message {}")
    public void receiveMassage(String massage){
       regist.receivemessage();
    }


    @Given("user post regist endpoint2")
    public void postregistendpoints2(){
        regist2.postregisendpoint2();
    }
    @When("user regist using empty firstname")
    public void registUsingEmptyFirstname(){
        regist2.registUsingEmptyFirstname();
    }
    @Then("user unsucces regist respon 400 OK on regist 2")
    public void unsuccesRegist1ResponCode400() {
        regist2.unsuccesregist2responcode400();
    }
    @And("user get a message2 {}")
    public void receiveMassage2(String massage){
        regist2.receivemessage2();
    }


    @Given("user post regist endpoint3")
    public void postregistendpoints3(){
        regist3.postregisendpoint3();
    }
    @When("user regist using empty lastname")
    public void registUsingEmptyLastname(){
        regist3.registUsingEmptyLastname();
    }
    @Then("user unsucces regist respon 400 Bad Request on regist 3")
    public void unsuccesRegist2ResponCode400() {
        regist3.unsuccesregist3responcode400();
    }
    @And("user get a message3 {}")
    public void receiveMassage3(String massage){
        regist3.receivemessage3();
    }


    @Given("user post regist endpoint4")
    public void postregistendpoints4(){
        regist4.postregisendpoint4();
    }
    @When("user regist using empty email")
    public void registUsingEmptyEmail(){
        regist4.registUsingEmptyEmail();
    }
    @Then("user unsucces regist respon 400 Bad Request on regist 4")
    public void unsuccesRegist3ResponCode400() {
        regist4.unsuccesregist4responcode400();
    }
    @And("user get a message4 {}")
    public void receiveMassage4(String massage){
        regist4.receivemessage4();
    }


    @Given("user post regist endpoint5")
    public void postregistendpoints5(){
        regist5.postregisendpoint5();
    }
    @When("user regist using empty password")
    public void registUsingEmptyPassword(){
        regist5.registUsingEmptyPassword();
    }
    @Then("user unsucces regist respon 400 Bad Request on regist 5")
    public void unsuccesRegist4ResponCode400() {
        regist5.unsuccesregist5responcode400();
    }
    @And("user get a message5 {}")
    public void receiveMassage5(String massage){
        regist5.receivemessage5();
    }


    @Given("user post regist endpoint6")
    public void postregistendpoints6(){
        regist6.postregisendpoint6();
    }
    @When("user regist using empty tanggal lahir")
    public void registUsingEmptyTglLahir(){
        regist6.registUsingEmptyTanggalLahir();
    }
    @Then("user unsucces regist respon 400 Bad Request on regist 6")
    public void unsuccesRegist5ResponCode400() {
        regist6.unsuccesregist6responcode400();
    }
    @And("user get a message6 {}")
    public void receiveMassage6(String massage){
        regist6.receivemessage6();
    }


    @Given("user post regist endpoint7")
    public void postregistendpoints7(){
        regist7.postregisendpoint7();
    }
    @When("user regist using empty jenis kelamin")
    public void registUsingEmptyJenisKelamin(){
        regist7.registUsingEmptyJenisKelamin();
    }
    @Then("user unsucces regist respon 400 Bad Request on regist 7")
    public void unsuccesRegist6ResponCode400() {
        regist7.unsuccesregist7responcode400();
    }
    @And("user get a message7 {}")
    public void receiveMassage7(String massage){
        regist7.receivemessage7();
    }

}
