package Utilities;



import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import cucumber.api.Scenario;


public class BaseClass {
	 public static Properties readprop;
	 public static WebDriver driver;
	

	public static WebDriver openBrowser() throws Exception {
		driver = null;
		readprop= new Properties();
	    FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Resourses\\Config.Properties");
		readprop.load(fis);
				if(readprop.getProperty("name").equals("Chrome")) {
			
				  ChromeOptions ops = new ChromeOptions();
	            ops.addArguments("--disable-notifications");
	            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\Resourses\\chromedriver.exe");
			driver=new ChromeDriver(ops);
				}
				else if(readprop.getProperty("name").equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\java\\Resourses\\geckodriver.exe");
			driver=new FirefoxDriver();
				}
				driver.get(readprop.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			    return driver;
		}
	
	
	public static void takescreenshot(Scenario scenario) throws InterruptedException, Exception {
		   try {
			  byte[] scrnshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			  File screenshot_with_scenario_name=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileHandler.copy(screenshot_with_scenario_name, new File(System.getProperty("user.dir")+"\\target\\FailedScenarios\\"+scenario.getName()+System.currentTimeMillis()+".png"));
			  System.out.println(scenario.getName());
			  scenario.embed(scrnshot, "image/png");
		  
		   }catch(WebDriverException somePlatformsDontSupportScreenshots) {
			   System.err.println(somePlatformsDontSupportScreenshots.getMessage());
		   }
			}
			
		public static void closeBrowser() {
			if(driver!=null) {
				   driver.quit();
			}
		}
	


public static void javaScriptClick(WebElement element, WebDriver driver) {
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
}

public static void flash(WebElement element) {
	changeColor("2px Red dashed", element);
}

public static void changeColor(String color,WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].style.border='"+color+"'", element);
}

	
	protected void handlewebAppearance(int timer) {
		try{
			int k=timer;
		do{
			Thread.sleep(timer);
		
		if(driver.findElement(By.xpath("//div[@class='loading-mask']")).getAttribute("style").equals("display: none;"))
		{
			break;
		}
		else {
			Thread.sleep(timer);
			k=k+timer;
		}
	}while(k < 10000);
}catch(InterruptedException ie) {
	
}
}

	}













