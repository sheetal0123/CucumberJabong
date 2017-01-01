package jabong;

import org.openqa.selenium.WebDriver;

public class HomePage {
	
	static XMLRepoParser xmlrepoparser = new XMLRepoParser();

	public static void openLoginPage(WebDriver driver) {
		driver.findElement(
xmlrepoparser.getByElementFromRepo("HomePage", "SignIn"))
				.click();
	}

	public static void enterCredentials(WebDriver driver, String username,
			String password) {
//		driver.findElement(
//				xmlrepoparser.getByElementFromRepo("HomePage", "LogIn"))
//				.click();
		driver.findElement(
				xmlrepoparser.getByElementFromRepo("HomePage", "Username"))
				.sendKeys(username);
		driver.findElement(
				xmlrepoparser.getByElementFromRepo("HomePage", "Password"))
				.sendKeys(password);
		driver.findElement(
				xmlrepoparser.getByElementFromRepo("HomePage", "LogInButton"))
				.click();

	}

	public static void verifyLoginError(WebDriver driver) {
		driver.findElement(
				xmlrepoparser.getByElementFromRepo("HomePage", "LogInError"))
				.getText()
				.contains("Incorrect username or password.");

	}

	public static void verifyLoginUser(WebDriver driver, String hi_user) {
		driver.findElement(
				xmlrepoparser.getByElementFromRepo("HomePage", "HiUser"))
				.getText().contains(hi_user);
	}

	public static void search(WebDriver driver, String keyword) {
		driver.findElement(
				xmlrepoparser.getByElementFromRepo("HomePage", "SearchBar"))
				.clear();
		driver.findElement(
				xmlrepoparser.getByElementFromRepo("HomePage", "SearchBar"))
				.sendKeys(keyword);
		driver.findElement(
				xmlrepoparser.getByElementFromRepo("HomePage", "SearchButton"))
				.click();

	}

}
