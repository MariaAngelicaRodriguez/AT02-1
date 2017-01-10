package com.bdd.steps;

/**
 * Created by Administrator on 1/9/2017.
 */

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacion.common.drivers.Driver;
import org.fundacion.pages.home.HomePage;
import org.fundacion.pages.login.LoginPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.testng.Assert.assertTrue;


public class LoginStep {
  private WebDriver driver;
  LoginPage loginpage;
  Object home;

  private boolean login;
  @Given("^that I open pivotal tracker page$")
  public void logout() {
    login = false;
  }

  @When("^I logged in as a user \"(.*?)\" and password \"(.*?)\"$")
  public void login(String user, String password) throws IOException {
    driver = Driver.getDriver().openBrowser();
    loginpage = new LoginPage(driver);
    loginpage.setUserName(user);
    loginpage.clickContinue();
    loginpage.setPassword(password);
  }


  @Then("^page go to homePage$")
  public void thePageGoToHomePage() throws Throwable{
    home = loginpage.clickSubmit();
    boolean resultado = home instanceof HomePage;
    assertTrue(resultado);
  }

}
