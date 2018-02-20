package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public WebDriver driver;
	
	@FindBy(xpath="//a[text()='Log in']")
	private WebElement login;
	
	@FindBy(id="Email")
	private WebElement txt_email;
	
	@FindBy(id="Password")
	private WebElement txt_password;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement login_btn;
	
	
	
	public LoginPage(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);;		
	}
	
	
	public void login(String uname,String pwd) throws InterruptedException{
		login.click();
		Thread.sleep(3000);
		txt_email.sendKeys(uname);
		txt_password.sendKeys(pwd);
		login_btn.click();
	}
	
	
	
	
}