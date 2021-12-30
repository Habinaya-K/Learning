package seleniumbasics;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver","C:\\SeleniumBrowserDrivers\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();		
		driver.get("http://zero.webappsecurity.com/index.html");
		
		//1. Purchase Foreign currency
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        
        driver.findElement(By.linkText("Pay Bills")).click();
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        
        driver.findElement(By.xpath("//input[@value='Purchase']")).click();
		Alert purchase = driver.switchTo().alert();
		String foreign = purchase.getText();
		System.out.println(foreign);
		purchase.accept();
		
		//2-Handle Confirm in W3Schools
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
		String W3school =driver.getCurrentUrl();
		Assert.assertEquals(W3school, "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm","URL is not matching");
		System.out.println(W3school);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		String popup = driver.switchTo().alert().getText();
		Assert.assertEquals(popup,"Click on ok","popup handled");
		System.out.println(popup);
		driver.switchTo().alert().accept();
		
		//3 - Windows handle in Naukri
		driver.get("https://www.naukri.com/");

//      Alert naukri = driver.switchTo().alert();
//		String popup = naukri.getText();
//		System.out.println(popup);
		
//		Alert pcancel = driver.switchTo().alert();
//		pcancel.dismiss();
		
		driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[3]/div[1]/div[1]/ul[1]/li[1]/a[1]/img[1]")).click();
		String winhand = driver.getWindowHandle();
		System.out.println(winhand);
		Set <String> handles = driver.getWindowHandles();
		System.out.println(handles);
		
		for (String h :handles) {
			System.out.println("value of handle is: "+h);
			driver.switchTo().window(h);
			System.out.println(driver.getTitle());
			}
		driver.switchTo().window(winhand);
		
		driver.close();
		driver.quit();
		
		}

}
