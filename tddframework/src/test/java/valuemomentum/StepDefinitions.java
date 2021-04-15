package valuemomentum;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	WebDriver driver;
	JavascriptExecutor js;

	@Given("User is on Home Page")
	public void user_is_on_home_page() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

	}

	@Then("User clicks on mobiles category")
	public void user_clicks_on_mobiles_category() {

		driver.findElement(By.xpath("//*[text()='Mobiles']")).click();

	}

	@When("User hits on checkBox button")
	public void user_hits_on_check_box_button() {

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//*[text()='Cloudtail India']")).click();

	}

	@Then("User click on product")
	public void user_click_on_product() {

		driver.findElement(
	By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/h2/a/span"))
				.click();
		String currentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> ite = windows.iterator();
		while (ite.hasNext()) {
			String newWindow = ite.next();
			if (!currentWindow.equals(newWindow)) {
				driver.switchTo().window(newWindow);
			}
		}

	}

	@Then("User hits add to cart button")
	public void user_hits_add_to_cart_button() {
		
		driver.findElement(By.xpath("//*[@id='a-autoid-0-announce']")).click();
		driver.close();
		driver.quit();

	}

	/*
	 * @Given("User is on Home Page") public void user_is_on_home_page() {
	 * 
	 * //System.out.println(" Before Suite");
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:\\chromedriver\\chromedriver.exe"); driver = new ChromeDriver();
	 * driver.manage().window().maximize(); driver.get("https://www.amazon.in/");
	 * 
	 * }
	 * 
	 * @Then("^User enters search keyword \"([^\"]*)\"$") public void
	 * user_enters_search_keyword(String value) {
	 * driver.findElement(By.id("twotabsearchtextbox")).sendKeys(value);
	 * 
	 * }
	 * 
	 * @When("User hits on search button") public void user_hits_on_search_button()
	 * { driver.findElement(By.id("nav-search-submit-button")).click();
	 * 
	 * }
	 * 
	 * @Then("User should land in results page") public void
	 * user_should_land_in_results_page() { driver.findElement(By.
	 * xpath("//*[text()='New Apple iPhone 11 (128GB) - Purple']")).click(); String
	 * currentWindow=driver.getWindowHandle(); Set<String> windows =
	 * driver.getWindowHandles(); Iterator<String> ite = windows.iterator();
	 * while(ite.hasNext()) { String newWindow=ite.next();
	 * if(!currentWindow.equals(newWindow)) { driver.switchTo().window(newWindow); }
	 * }
	 * 
	 * 
	 * }
	 * 
	 * @Then("User hits add to cart button") public void
	 * user_hits_add_to_cart_button() {
	 * driver.findElement(By.id("add-to-cart-button")).click();
	 * 
	 * }
	 * 
	 * @Then("User clicks proceed to buy") public void user_clicks_proceed_to_buy()
	 * {
	 * 
	 * driver.findElement(By.id("hlb-ptc-btn")).click();
	 * 
	 * driver.close(); driver.quit();
	 * 
	 * }
	 */

}
