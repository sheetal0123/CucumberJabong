package jabong;

import org.openqa.selenium.WebDriver;

public class SearchPage {

	public static void verifyTitle(WebDriver driver,String keyword){
		driver.getTitle().startsWith(keyword);
	}
}
