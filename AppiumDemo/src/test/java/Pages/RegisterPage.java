package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GlobalInitializer.GlobalVariable;

public class RegisterPage {

	//public WebDriver driver;
	public static GlobalVariable initializer = GlobalVariable.initialize();
	
	
	@FindBy(xpath="//android.widget.EditText[@content-desc='my_text_fieldCD']")
	private WebElement localization_txt;
	
	@FindBy(xpath="//android.widget.ImageButton[@content-desc='startUserRegistrationCD']")
	private WebElement browse_btn;
	
	@FindBy(xpath="//android.widget.EditText[@index='2']")
	private WebElement username_txt;
	
	@FindBy(id="io.selendroid.testapp:id/inputEmail")
	private WebElement email_txt;
	
	@FindBy(id="io.selendroid.testapp:id/inputPassword")
	private WebElement password_txt;
	
	
	@FindBy(id="io.selendroid.testapp:id/inputName")
	private WebElement name_txt;
	
	@FindBy(id="io.selendroid.testapp:id/input_preferedProgrammingLanguage")
	private WebElement languageDD;
	
	@FindBy(xpath="//android.widget.CheckedTextView[@text='Java']")
	private WebElement java;
	
	@FindBy(id="io.selendroid.testapp:id/input_adds")
	private WebElement accept_chk;
	
	@FindBy(id="io.selendroid.testapp:id/btnRegisterUser")
	private WebElement registerUser;
	
	
	
	public RegisterPage() 
	{
	//this.driver=driver;
	PageFactory.initElements(initializer.driver, this);;		
	}
	
	public void enterLocalization(String input) {
		localization_txt.sendKeys(input);
	}
	
	public void click_Browse() {
		browse_btn.click();
	}
	
	public void enterUserDetails(String userName,String email,String password,String name) throws InterruptedException {
		username_txt.sendKeys(userName+"\n");
		Thread.sleep(3000);
		email_txt.sendKeys(email+"\n");
		password_txt.sendKeys(password+"\n");
		name_txt.clear();
		name_txt.sendKeys(name+"\n");
	}
	
	public void click_Java() {
		languageDD.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.click();
	}
	
	
	
	public void click_AcceptCheckbox() {
		accept_chk.click();
	}
	
	public void click_RegisterUser() {
		registerUser.click();
	}
	
	
	
}
