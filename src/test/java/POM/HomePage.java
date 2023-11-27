package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@name='q']")public WebElement Search;
	@FindBy(xpath="//*[contains(@placeholder,'Search for Products, Brands and More')]")WebElement Search2;
	@FindBy(xpath="/html/body/div[2]/div/div")WebElement Alertbody;
	@FindBy(xpath="/html/body/div[2]/div/div/button")WebElement x;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")WebElement Submit;

	
	public void DealAlert() {
		try {
		if(x.isDisplayed()) {
			x.click();
		
		}else {
			driver.quit();
		}
		}catch(Exception e) {
			e.getMessage();
		}
	} 

}
