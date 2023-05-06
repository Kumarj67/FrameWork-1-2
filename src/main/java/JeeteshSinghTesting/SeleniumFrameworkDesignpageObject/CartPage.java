package JeeteshSinghTesting.SeleniumFrameworkDesignpageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jeeteshTesting.SeleniumFramework.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOut;

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean verifyProductDisplay(String productName) {
		Boolean Match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
		return Match;
	}
	public CheckoutPage goToCheckout() {
		checkOut.click();
		return	new CheckoutPage(driver);
		
	}

}
