package SeleniumAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class stringFormat {
    WebDriver driver;

	public static void main(String[] args) {
//		String locator_01 = "//div[@class='%s']";

		String newLocator_01 = String.format("//div[@class='%s']", "Dybala");
		System.out.println("newLocator_01 = " + newLocator_01);
	}


	public void input(String locator, String value, String dynamic) {
		String dynamicLocator = String.format(locator, dynamic);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		element.sendKeys(value);
	}

	public String getTextDynamicElement(String locator, String dynamic) {
    	String dynamicLocator = String.format(locator, dynamic);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		return element.getText();
	}
}
