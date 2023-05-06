package JeeteshSinghTesting.SeleniumFrameworkDesignpageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jeeteshTesting.SeleniumFramework.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

//	constructor
	public LandingPage(WebDriver driver) {
		super(driver);
//		initialistion
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	WebElement userEmail=driver.findElement(By.id("userEmail"));
//	pageFactoring
	@FindBy(id = "userEmail")
	WebElement userEmail;

//	driver.findElement(By.id("userPassword"))
	@FindBy(id = "userPassword")
	WebElement userPasswordEle;

	@FindBy(id = "login")
	WebElement submit;

	public ProductCatelogue loginApplication(String email, String Password) {
		userEmail.sendKeys(email);
		userPasswordEle.sendKeys(Password);
		submit.click();
		ProductCatelogue productCatelogue = new ProductCatelogue(driver);
		return productCatelogue;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

}
