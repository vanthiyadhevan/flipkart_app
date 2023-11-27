package reUsable;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class Reusable_methods {
	WebDriver driver;
	public Reusable_methods(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void Click(WebElement Element) {
		Element.click();
	}
	public  void SendKeys(WebElement Element,String strng) {
		Element.sendKeys(strng+Keys.ENTER);
	}
    public void Dropdown(List<WebElement>list,String strng ) {
    	for(WebElement Option:list) {
    		System.out.println(Option.getText());
    		if(Option.getText().equals(strng)){ 
    			Option.click();
    		}
    	}
    }
}
