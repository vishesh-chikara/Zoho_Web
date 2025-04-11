package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


import base.Zoho_Base_class;

public class FirstTest extends Zoho_Base_class  {

	@Test(description="to signIn into zoho")
	public void SignIn() throws InterruptedException
	{
	
		driver.getTitle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText(Loc.getProperty("Sign_Button"))).click();
		//Thread.sleep(5000);
		driver.findElement(By.id(Loc.getProperty("email_field"))).sendKeys("vishesh@gmail.com");
		driver.findElement(By.xpath(Loc.getProperty("Next_button"))).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(Loc.getProperty("pass_field"))).sendKeys("Test");
		//Thread.sleep(6000);
		driver.findElement(By.xpath(Loc.getProperty("Login_Next_Button"))).click();
		//Thread.sleep(3000);


	}


}
