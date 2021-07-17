package test;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testNg.TestNGListener;

@Listeners(TestNGListener.class)
public class LoginTest {

		WebDriver driver;
		
		XSSFWorkbook wbook;
	    XSSFSheet sheet;

	@BeforeMethod
	public void setup() throws IOException  
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		driver=new ChromeDriver();
		//WebDriver driver=new FirefoxDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		FileInputStream fis = new FileInputStream("data.xlsx");
        
		 wbook = new XSSFWorkbook(fis);
        
        sheet = wbook.getSheet("data");
	}
	
	@Test
	@Parameters({"username","password"})
	public void Testcase1(String username,String password) 
	{
WebElement LoginLink=driver.findElement(By.linkText("Log in"));
		
		LoginLink.click();
		WebElement rememberMe=driver.findElement(By.className("rememberMe"));
		WebElement Username=driver.findElement(By.name("user_login"));
		WebElement Password=driver.findElement(By.id("password"));
		WebElement LoginBtn=driver.findElement(By.name("btn_login"));
		
		String excelUsername= sheet.getRow(0).getCell(0).getStringCellValue();
		String excelPassword= sheet.getRow(0).getCell(1).getStringCellValue();
		
		rememberMe.click();
		Username.sendKeys(excelUsername);
		Password.sendKeys(excelPassword);
		LoginBtn.click();
		
		WebElement LoginError=driver.findElement(By.id("msg_box"));
		String ActError=LoginError.getText();
		String ExpError="The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActError, ExpError);
		
		List<WebElement> links= driver.findElements(By.tagName("input"));
		System.out.println("total links" + links.size());
	}
	
	@AfterMethod
	public void cleanup() 
	{
		driver.quit();
	}
}
