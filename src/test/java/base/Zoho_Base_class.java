package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Zoho_Base_class {
	
	public static WebDriver driver ;
	public static Properties pr = new Properties();
	public static Properties Loc =new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	
	
	@BeforeTest
	public void Setup() throws IOException
	{
		if (driver==null)
		{
			 fr = new FileReader("C:\\Users\\admin\\Desktop\\Automation\\NewBatch\\Zoho_Web\\src\\test\\resources\\Config\\config.properties");
			 fr1 = new FileReader("C:\\Users\\admin\\Desktop\\Automation\\NewBatch\\Zoho_Web\\src\\test\\resources\\Config\\config.locators");
			pr.load(fr);
			Loc.load(fr1);
			
	}

		if (pr.getProperty("browser").equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get(pr.getProperty("Zoho_URL"));
		driver.manage().window().maximize();
		}
		
		else if (pr.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(pr.getProperty("Zoho_URL"));
			driver.manage().window().maximize();
		}
	}
	@AfterTest
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
		System.out.println("Tear down succesfully");
		
	}



}
