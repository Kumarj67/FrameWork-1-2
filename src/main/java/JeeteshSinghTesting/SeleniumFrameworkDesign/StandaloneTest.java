package JeeteshSinghTesting.SeleniumFrameworkDesign;

import org.testng.Assert;

import JeeteshSinghTesting.SeleniumFrameworkDesignpageObject.CartPage;
import JeeteshSinghTesting.SeleniumFrameworkDesignpageObject.CheckoutPage;
import JeeteshSinghTesting.SeleniumFrameworkDesignpageObject.ConfirmationPage;
import JeeteshSinghTesting.SeleniumFrameworkDesignpageObject.LandingPage;
import JeeteshSinghTesting.SeleniumFrameworkDesignpageObject.ProductCatelogue;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
		String productsName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://rahulshettyacademy.com/client/");

		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		ProductCatelogue productCatelogue = landingPage.loginApplication("biharairtel21@gmail.com", "NJeet@123");

//		driver.findElement(By.id("userEmail")).sendKeys("biharairtel21@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("NJeet@123");
//		driver.findElement(By.cssSelector("input[type='submit']")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//	products.stream().filter(product->product.getText().equalsIgnoreCase("zara coat 3"));
//		ProductCatelogue productCatelogue = new ProductCatelogue(driver);
		List<WebElement> products = productCatelogue.getProducts();
		productCatelogue.addProductToCart(productsName);

//		WebElement prod = products.stream()
//				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productsName)).findFirst()
//				.orElse(null);

//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(driver.findElement(By.cssSelector(".ng-animating"))));
//		driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
		CartPage cartPage = productCatelogue.goToCart();

//		CartPage cartPage=new CartPage(driver);
		Boolean Match = cartPage.verifyProductDisplay(productsName);
		Assert.assertTrue(Match);
		cartPage.goToCheckout();

//		List<WebElement> cartsProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//		Boolean Match = cartsProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productsName));
//		Assert.assertTrue(Match);
//		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
//
		CheckoutPage checkOutPage=cartPage.goToCheckout();
		checkOutPage.selectCountry("India");
		ConfirmationPage confirmationPage=checkOutPage.submitCountry();
		String message=confirmationPage.getConfirmationMessage();
		Assert.assertTrue(message.equalsIgnoreCase(" Thankyou for the order. "));
		driver.close();
		
		
		
//		Actions a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
//
////		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//		driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
//		driver.findElement(By.cssSelector(".action__submit ")).click();

	}
}
