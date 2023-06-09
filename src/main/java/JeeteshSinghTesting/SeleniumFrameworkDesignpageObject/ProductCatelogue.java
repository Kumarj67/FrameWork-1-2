package JeeteshSinghTesting.SeleniumFrameworkDesignpageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jeeteshTesting.SeleniumFramework.AbstractComponents.AbstractComponents;

public class ProductCatelogue extends AbstractComponents {
	WebDriver driver;

//	constructor
	public ProductCatelogue(WebDriver driver) {
		super(driver);
//		initialistion
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By productsBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By tostMessage=By.cssSelector("#toast-container");
	
	
	public List<WebElement> getProducts() {
		waitForElementToAppear(productsBy);
		return products;
	}
	public WebElement getProductsByName(String productName) {
		WebElement prod = products.stream()
			.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
			.orElse(null);
		return prod;

		
	}

public void addProductToCart(String productName) {
	WebElement prod=getProductsByName(productName);
	prod.findElement(addToCart).click();
	waitForElementToAppear(tostMessage);
	waitForElementToDisapper(spinner);
}

	

}
