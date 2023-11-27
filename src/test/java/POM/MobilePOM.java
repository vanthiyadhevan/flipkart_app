package POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobilePOM extends BasePage {
	public MobilePOM(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//div[@class='_31Kbhn _28DFQy']")
	WebElement Min;
	@FindBy(xpath = "//*[@class='_31Kbhn WC_zGJ']")
	WebElement max;
	@FindBy(xpath="//*[@title='SAMSUNG']")WebElement Sam;
	public Actions act;
	public WebDriverWait mywait;

	public void DragMin() {
		int sl = Min.getSize().width;
		act=new Actions(driver);
		act.dragAndDropBy(Min, sl*2, 0).build().perform();
	}
	public void DragMax() {
		int s2=max.getSize().width;
		act=new Actions(driver);
		act.dragAndDropBy(max,- s2*2, 0).build().perform();
	}
	public void ClickSam() {
		Sam.click(); 
	}
}
