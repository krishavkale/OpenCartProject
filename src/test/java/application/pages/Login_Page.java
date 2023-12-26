package application.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import application.webdriver.WebDriverClass;
import utils.ReadPropFile;
import webcommons.WebCommons;



public class Login_Page {
	
	
	WebCommons action = new WebCommons();

	// LoginPage WebElement

	@FindBy(xpath = ("//div[@id='logo']"))
	WebElement logo;

	@FindBy(xpath = ("//li[@class='breadcrumb-item'][1]"))
	WebElement Home_Tab;

	@FindBy(xpath = ("//img[@alt='iPhone 6']"))
	WebElement HomePage_Iphone6;

	@FindBy(xpath = ("//li[@class='breadcrumb-item'][3]"))
	WebElement loginPage_Tital;

	@FindBy(xpath = ("//button[@type='submit']/following::a[text()='Forgotten Password']"))
	WebElement forgotPass_Link;

	@FindBy(xpath = ("//h1[text()='Forgot Your Password?']"))
	WebElement forgotPassPage_Tital;

	@FindBy(xpath = ("//a[@class='btn btn-primary']"))
	WebElement CreateRegisterContinue_Btn;

	@FindBy(xpath = ("//h1[text()='Register Account']"))
	WebElement RegisterPage_Tital;

	@FindBy(xpath = ("//span[text()='My Account']"))
	WebElement myAccount;

	@FindBy(xpath = ("//a[text()='Login']"))
	WebElement Login_Label;

	@FindBy(xpath = ("//input[@id='input-email']"))
	WebElement User_TextBox;

	@FindBy(xpath = ("//input[@id='input-password']"))
	WebElement Password_TextBox;

	@FindBy(xpath = ("//button[text()='Login']"))
	WebElement Login_Btn;

	@FindBy(xpath = ("//a[text()='Account']"))
	WebElement AccountPage_Tital;

	By home_tab = By.xpath("//li[@class='breadcrumb-item'][1]");
	By registerPage_tital = By.xpath("//h1[text()='Register Account']");
	By forgotPassPage_tital = By.xpath("//h1[text()='Forgot Your Password?']");
	By registerCereateNewContinue_Btn = By.xpath("//a[@class='btn btn-primary']");
	By ForgotPassword_Link = By.xpath("//button[@type='submit']/following::a[text()='Forgotten Password']");

	// Method
	
	public void launch_Application() {
		action.driver.get(ReadPropFile.readData("Config.properties").getProperty("url")) ;
		
	}

	public void Verify_logo() {
		Assert.assertTrue(action.checkAvailability(logo));
		//action.report("Logo successfully displayed");
	}

	// click on Login
	public void Click_Loginlink() {   
		action.click_element(myAccount);
		action.moveToElement(Login_Label);
		action.click_element(Login_Label);
	}
	
	 // Validation login Page open
   public void validate_loginPage() {        
		Assert.assertTrue(action.checkAvailability(loginPage_Tital));
		action.report("Login Page is Open");
	}

   
    // Enter login Data
	public void Enter_loginData( String Email, String password) {
		action.click_element(myAccount);
		action.moveToElement(Login_Label);
		action.click_element(Login_Label);
		action.EnterText(User_TextBox, Email);
		action.EnterText(Password_TextBox, password);
	}
	 // click Login Button
	public void click_loginBtn() {	
		action.click_element(Login_Btn);
	}
		// Login Validation
			public void Login_vlidation() {
			String caption = action.getElementText(AccountPage_Tital);
			Assert.assertEquals(caption, "Account");
			System.out.println("Application Login successful");
		

	}
			
			// click forogot link in loginPage
	public void Click_forgotLink() {	
		action.click_element(myAccount);
		action.moveToElement(Login_Label);
		action.click_element(Login_Label);
		action.waitForElement(ForgotPassword_Link);
		action.moveToElement(forgotPass_Link);
		action.click_element(forgotPass_Link);
		// Validation Forogot Password Page open
		action.waitForElement(forgotPassPage_tital);
		String Caption = action.getElementText(forgotPassPage_Tital);
		Assert.assertEquals(Caption, "Forgot Your Password?");
		action.report("Forogot Password is Open");

	}

	// Open New Customer Account Page click on ContinueBtn in loginPage
	public void click_RegisterAccountContinueBtn() {
		action.click_element(myAccount);
		action.moveToElement(Login_Label);
		action.click_element(Login_Label);
		action.waitForElement(registerCereateNewContinue_Btn);
		action.moveToElement(CreateRegisterContinue_Btn);
		action.click_element(CreateRegisterContinue_Btn);
	}
	
		// Check RegistrAccount Page is Open or not
	public void validate_Register_accountPage() {
		action.waitForElement(registerPage_tital);
		String pcation = action.getElementText(RegisterPage_Tital);
		Assert.assertEquals(pcation, "Register Account");
		action.report("Register account Page Open");

	}

	public void click_homeTab() {
		// click on home tab in loginPge
		action.click_element(myAccount);
		action.moveToElement(Login_Label);
		action.click_element(Login_Label);
		action.waitForElement(home_tab);
		action.click_element(Home_Tab);
		// Validation home page open
		Assert.assertTrue(action.checkAvailability(HomePage_Iphone6));
		action.report("Home Page Displyade");
	}

	public static Login_Page getLogin_Page() {
		return PageFactory.initElements(WebDriverClass.getDriver(), Login_Page.class);
	}

}
