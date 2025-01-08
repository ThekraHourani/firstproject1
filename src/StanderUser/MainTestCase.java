package StanderUser;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class MainTestCase {
	WebDriver driver =new ChromeDriver();
	Random rand=new Random();
	String myWebSite ="https://www.saucedemo.com/";
	String UserName ="standard_user";
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
    	

    	WebElement UserNameInput = driver.findElement(By.id("user-name"));
		WebElement PasswordInput = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserNameInput.sendKeys(UserName);
		PasswordInput.sendKeys(Passwordid);
		LoginButton.click();
    }
    
    
     @Test (priority = 2, enabled = true)
     
    public void AddAllItemToCard  ( )throws InterruptedException {
    	 Thread.sleep(2000);
    	
			
		
    	 List<WebElement> AddToCartButtons = driver.findElements(By.className("btn")) ; 
    	 for(int i = 0 ; i  < AddToCartButtons .size();i=i+2) {
 		
 			// if(i%2!=0)
 			AddToCartButtons.get(i).click();
    	 }
     }
 		
    	  @Test (priority = 2, enabled =false)
    	     
    public void AddCertainNumofItem () throws InterruptedException {
    		  Thread.sleep(2000); 
    			
    			
    	    	 List<WebElement> AddToCartButtons = driver.findElements(By.className("btn")) ; 
    	    	 for(int i = 0 ; i  < AddToCartButtons .size();i++) {
    	 		if(i==0||i==2) {
    	 	continue;
    	 		}
    	 			AddToCartButtons.get(i).click();
    	 			}
    	  }
     	    	 
    	  @Test (priority = 2, enabled =true)
 	     
  	public void AddItemThatStartWithSouse () throws InterruptedException {
    		  Thread.sleep(2000);
  	    	
  				
    		  List<WebElement> ItemName = driver.findElements(By.className("inventory_item_name")) ; 
  	    	 List<WebElement> AddToCartButtons = driver.findElements(By.className("btn")) ; 
  	    	 for(int i = 0 ; i  <ItemName .size();i++) {
  	 	
  	 			
  	 			if (ItemName.get(i).getText().startsWith("Sauce")) {
  	 				
  	 					continue;
  	 				}
  	 				AddToCartButtons.get(i).click();
					
				}
  	 			}
  @Test(priority = 2 ,enabled = true)
    public void AddRandomItem() throws InterruptedException {
	  Thread.sleep(2000);

	  List<WebElement> AddToCartButtons = driver.findElements(By.className("btn")) ; 
	  int randomIndex =rand.nextInt(AddToCartButtons.size());
   AddToCartButtons.get(randomIndex).click();
   }
    
  
  
  @Test(priority = 3) 	
  
    public void Checkout() throws InterruptedException	{
	  Thread.sleep(2000);
   WebElement shoppingCart =driver.findElement(By.className("shopping_cart_link"));
   shoppingCart.click();
    WebElement CheckOutButton=driver.findElement(By.id("checkout"));	
    CheckOutButton.click();
    String[] firstNames = {"John", "Emma", "Michael", "Sophia", "David"};
     int randomFirstName=rand.nextInt(firstNames.length);
    // Array of last names
    String[] lastNames = {"Smith", "Johnson", "Brown", "Taylor", "Anderson"};
    int randomLastName=rand.nextInt(lastNames.length);
   String[] zipCodes = {"10001", "90210", "33101", "60601"," 94105"};
    int randomzip=rand.nextInt(zipCodes.length);
    WebElement firstnameInput =driver.findElement(By.id("first-name"))	;
    WebElement LastnameInput =driver.findElement(By.id("last-name"))	;
    WebElement zipcode =driver.findElement(By.id("postal-code"))	;
    firstnameInput.sendKeys(firstNames[randomFirstName]);
    LastnameInput.sendKeys(lastNames[randomLastName]);
    zipcode.sendKeys(zipCodes[randomzip]);
    WebElement contBot=driver.findElement(By.id("continue"));
    contBot.click();
    WebElement finshBot=driver.findElement(By.id("finish"));
    finshBot.click();
    // hai m7adra 5 bdha drasa random mhma
    }   
}
    	 
  	    	    	
    	    	 
    	  
    	    
     
     
     
     

	

