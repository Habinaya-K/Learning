package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException{
		
		//To open browser
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/index.html");
		
		//To login
		driver.findElement(By.className("search-query")).sendKeys("a");
		driver.findElement(By.id("signin_button")).click();
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		//Wrong password
		driver.findElement(By.name("user_login")).sendKeys("username");		
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("pass");
		
		//Getting error message
		driver.findElement(By.cssSelector("input[name='submit']")).click();
		System.out.println(driver.findElement(By.xpath("//form[@id='login_form']/div[1]")).getText());
		driver.navigate().back();
		
		//Forgot password
		driver.findElement(By.linkText("Forgot your password ?")).click();			
		driver.navigate().back();
		
		//correct login details
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		
		//Check box
		WebElement checkBox = driver.findElement(By.cssSelector("input#user_remember_me"));
		boolean ischeck = checkBox.isSelected();
		if(ischeck) {
			System.out.println("Check Box is selected already");
		}else {
			checkBox.click();
		    System.out.println("Check Box is selected now");
		    }	
		
		//signIn.click();
		driver.findElement(By.name("submit")).click();
		
		//to proceed with privacy error
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
		
        //PayBills - Add new payee
        driver.findElement(By.linkText("Pay Bills")).click();       
        driver.findElement(By.partialLinkText("New Payee")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.cssSelector("input.span4#np_new_payee_name")).sendKeys("Habinaya");
        driver.findElement(By.xpath("//textarea[@id='np_new_payee_address']")).sendKeys("India");
        driver.findElement(By.cssSelector("input#np_new_payee_account[name=\'account\']")).sendKeys("123");
        driver.findElement(By.cssSelector("input#np_new_payee_details")).sendKeys("New Payment");
        driver.findElement(By.cssSelector("#add_new_payee")).click();
        System.out.println(driver.findElement(By.id("alert_content")).getText());
        
        //FeedBack
        driver.findElement(By.linkText("Zero Bank")).click();
        driver.findElement(By.xpath("//strong[contains(text(),'Feedback')]")).click();
        driver.findElement(By.cssSelector("input#name")).sendKeys("Habinaya");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("newuser@mail.com");
        driver.findElement(By.cssSelector("input#subject")).sendKeys("Search Button");
        driver.findElement(By.cssSelector("textarea.span6")).sendKeys("Search button responding late");
        driver.findElement(By.cssSelector("input[value='Send Message']")).click();
        System.out.println(driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]")).getText());
                    
        //Logout
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.cssSelector("i.icon-user")).click();
        driver.findElement(By.id("logout_link")).click();
        System.out.println("Signed out successfully");
        
		//To close browser
		driver.close();
		driver.quit();		
	}

}
