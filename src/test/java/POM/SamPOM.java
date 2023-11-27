package POM;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SamPOM extends BasePage {
	public SamPOM(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement Add;
	@FindBy(xpath = "//span[contains(text(),'Page')]")
	WebElement pages;
	// @FindBy(xpath="//*[@id=\\\"container\\\"]/div/div[3]/div[1]/div[2]/div[26]/div/div/nav/a["+i+"]")WebElement
	// Xpath;
	public void SelectMOBILE(String model) {
		List<WebElement> list = driver.findElements(By.xpath("//*[@class='_4rR01T']"));
		for (WebElement item : list) {
			System.out.println(item.getText());
			if (item.getText().contains(model)) {
				item.click();
			}
		}
	}
	public void AddCart() {
		Add.click();
	}
	public void Switch_window() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
		}
	}
	public void No_pages() throws InterruptedException {
		System.out.println(pages.getText());
		String text = pages.getText();
		int pageNo = Integer.parseInt(text.substring(text.indexOf("f") + 2));
		System.out.println(pageNo);
		boolean itemFound = false;
		for (int i = 1; i <= pageNo && !itemFound; i++) {
		    if (pageNo > 1) {
		        WebElement select = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[26]/div/div/nav/a[" + i + "]"));
		        select.click();
		        Thread.sleep(2000);
		    }
		    List<WebElement> list = driver.findElements(By.xpath("//*[@class='_4rR01T']"));
		    for (WebElement item : list) {
		        if (item.getText().equals("SAMSUNG Galaxy A03 Core (Mint, 32 GB)")) {
		            item.click();
		            // Perform desired action after clicking the item
		            // ...
		            itemFound = true;
		            break; // Break out of the inner loop
		        }
		    }
		    if (itemFound) {
		        break; // Break out of the outer loop
		    }
		}
	}
}
