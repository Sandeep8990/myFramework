package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class WelcomePage extends BasePage{
	
	WebDriver driver;
	
	public WelcomePage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }

	@FindBy(how=How.NAME, using="userName")
	private WebElement user_name;

	@FindBy(how=How.NAME, using="password")
	public WebElement password;

	public void login()
	{
		user_name.sendKeys("sandeep");
		password.sendKeys("sandeep");
	}
}
