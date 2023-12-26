package stepDefination;

import application.pages.Login_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestLoginPage {
	
	Login_Page loginpage;
	
	

@Given("OpenCart Application Launched")
public void open_cart_application_launched() {
loginpage= Login_Page.getLogin_Page();
  loginpage.launch_Application();
}


@Then("Application Logo Should be available")
public void application_logo_should_be_available() {
 loginpage = Login_Page.getLogin_Page();
	 loginpage.Verify_logo();
   
}

@When("I click My Account menu")
public void i_click_my_account_menu() {
	  loginpage = Login_Page.getLogin_Page();
}

@When("click on Login Link")
public void click_on_login_link() {
	 loginpage = Login_Page.getLogin_Page();
	 loginpage.Click_Loginlink();
}
@Then("I should get  LoginPage")
public void i_should_get_login_page() {
	 loginpage = Login_Page.getLogin_Page();
	 loginpage.validate_loginPage();
}

@When("^I Enter (.*) and (.*)in login page$")
public void i_enter_com001_gmail_com_and_master_in_login_page(String Email,String password) {
	 loginpage = Login_Page.getLogin_Page();
	 loginpage.Enter_loginData(Email, password);
   
}


@When("I clicked on Login button")
public void i_clicked_on_login_button() {
	 loginpage = Login_Page.getLogin_Page();
	 loginpage.click_loginBtn();
 
}
@Then("I should get account overview page")
public void i_should_get_account_overview_page() {
	loginpage = Login_Page.getLogin_Page();
	 loginpage.Login_vlidation();
  
}


@When("Click on Register link in Login page")
public void click_on_register_link_in_login_page() {
	loginpage = Login_Page.getLogin_Page();
	 loginpage.click_RegisterAccountContinueBtn();
  
}


@Then("Registration page should be displayed")
public void registration_page_should_be_displayed() {
	loginpage = Login_Page.getLogin_Page();
	 loginpage.validate_Register_accountPage();

}

}
