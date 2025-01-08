package ProblemUser;

import java.util.PriorityQueue;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class MainTestCase2 {
	WebDriver driver =new ChromeDriver();
	
	String myWebSite ="https://www.saucedemo.com/";
	String UserName ="problem_user";
	String Passwordid ="secret_sauce";
	@BeforeTest 
	
	public void MySetup () {
		driver.get(myWebSite);
		driver.manage().window().maximize();
	    //driver.manage().window().minimize();
		//driver.manage().window().fullscreen();
	}
	
    @Test(priority = 1)
    
   public void Login () {
    	driver.findElement(By.id("user-name")).sendKeys(UserName); 
    	driver.findElement(By.id("password")).sendKeys(Passwordid);
    	driver.findElement(By.id("login-button")).click();
    }
     @Test (priority = 2)
     
     public void AddToCard  ( )throws InterruptedException {
    	 Thread.sleep(4000);
    	driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    	
     }

 	@Test (priority = 3)
 	public void RemoveItem() throws InterruptedException  {
 		Thread.sleep(4000);
 		driver.findElement(By.id("remove-sauce-labs-backpack")).click(); 
 		
 		}
    @AfterTest
    
    public void AfterMyTest () {
    	
    }
	
}
