package jabong;	

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepFile {

	WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("^user navigates to Jabong.com$")
	public void navigate_to_home_page() {
		driver.get("http://www.jabong.com");
	}

	@When("^user navigates to login page$")
	public void navigate_to_login_page() {
		HomePage.openLoginPage(driver);
	}

	@When("^user logs in using Username as \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void add_username_and_password(String username, String password) {
		HomePage.enterCredentials(driver, username, password);
	}

	@Then("^error message should be thrown$")
	public void check_error_message() {
		HomePage.verifyLoginError(driver);
	}

	@Then("^\"([^\"]*)\" should display on home page$")
	public void verify_user_name(String hi_user) {
		HomePage.verifyLoginUser(driver, hi_user);
	}

	@When("^user searched for \"([^\"]*)\"$")
	public void user_searched_for_shoes(String keyword) {
		HomePage.search(driver, keyword);
	}

	@Then("^user verifies title starts with \"([^\"]*)\"$")
	public void searchPage(String keyword) {
		SearchPage.verifyTitle(driver, keyword);
	}

}
