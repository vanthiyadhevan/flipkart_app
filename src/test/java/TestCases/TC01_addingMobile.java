package TestCases;


import org.testng.annotations.Test;

import POM.HomePage;
import POM.MobilePOM;
import POM.SamPOM;
import TestBase.BaseClass;
import reUsable.Reusable_methods;

public class TC01_addingMobile extends BaseClass {

	@Test
	public void Mobile() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		Reusable_methods rm=new Reusable_methods(driver);
		rm.SendKeys(hp.Search, "mobiles");
		hp.DealAlert();
		Thread.sleep(2000);
 		MobilePOM mb=new MobilePOM(driver);
 		Thread.sleep(2000);
		mb.DragMin();
		Thread.sleep(2000);
		mb.DragMax();
		Thread.sleep(2000);
		mb.ClickSam();  
		Thread.sleep(2000);
		
		  SamPOM sam=new SamPOM(driver);
		  sam.No_pages();
		
		 Thread.sleep(2000);
		 sam.Switch_window();
		 System.out.println("Window got handled");
		 Thread.sleep(2000);
		 sam.AddCart();
		 
	
	}

}
                                 