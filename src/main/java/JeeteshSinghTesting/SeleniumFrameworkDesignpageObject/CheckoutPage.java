package JeeteshSinghTesting.SeleniumFrameworkDesignpageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jeeteshTesting.SeleniumFramework.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
By taResult=By.cssSelector(".ta-results");
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;
	@FindBy(css=".ta-item:nth-child(3)")
	WebElement SelectCountry;
	@FindBy(css=".action__submit ")
	WebElement Submit;
	
	
	
	public void selectCountry(String CountryName) {
		Actions a = new Actions(driver);
		a.sendKeys(Country, CountryName).build().perform();
		waitForElementToAppear(taResult);

		SelectCountry.click();
		
	}
	public ConfirmationPage submitCountry() {
		Submit.click();
		return new ConfirmationPage(driver);
		
	}
	
	
	
	
	
	

}
