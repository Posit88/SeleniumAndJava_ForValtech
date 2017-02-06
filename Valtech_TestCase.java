package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Valtech_TestCase {

	public static void main(String[] args) throws InterruptedException {
		// Create a new instance of the Firefox driver
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.14.0-win32\\geckodriver.exe");
		driver =new FirefoxDriver();
		
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        String actText = "";
        
		System.out.println("Start Of Test"+"\n");
        
       // Open the page we want to open
        driver.get("http://www.valtech.com");
        
        // Print a message to the console that site opened
        System.out.println("Successfully opened the website www.valtech.com"+"\n");
        
        //verify whether 'Latest news' text is present in the web page or not
        String expText = "Latest news"; 
        
        String pageSource = driver.getPageSource();
        if(pageSource.contains(expText)){
            System.out.println("Expected text '"+expText+"' is present in the web page."+"\n");
        }else{
            System.out.println("Expected text '"+expText+"' is not present in the web page."+"\n");
        }
              
        System.out.println("Going to cases page");
        driver.findElement(By.xpath("//a[@href='/cases/']")).click();
        Thread.sleep(3000);        
        expText = "Cases";
        actText = driver.findElement(By.xpath("//header[contains(@class,'page-header')]/h1")).getText();
        if(actText.contains(expText)){
            System.out.println("Expected H1 tag text '"+expText+"' is present in the web page."+"\n");
        }else{
            System.out.println("Expected H1 tag text '"+expText+"' is NOT present in the web page." + " Instead the text '" + actText + "' was found."+"\n");
        }        
        
		System.out.println("Going to services page");
        driver.findElement(By.xpath("//a[@href='/services/']")).click();
        Thread.sleep(3000);
        expText = "Services";
        actText = driver.findElement(By.xpath("//header[contains(@class,'page-header')]/h1")).getText();
        if(actText.contains(expText)){
            System.out.println("Expected H1 tag text '"+expText+"' is present in the web page."+"\n");
        }else{
            System.out.println("Expected H1 tag text '"+expText+"' is NOT present in the web page." + " Instead the text '" + actText + "' was found."+"\n");
        }        
        
        System.out.println("Going to jobs page");
        driver.findElement(By.xpath("//a[@href='/jobs/']")).click();
        Thread.sleep(3000);  
        expText = "Jobs";
        actText = driver.findElement(By.xpath("//div[contains(@class,'page-header')]/h1")).getText();
        if(actText.contains(expText)){
            System.out.println("Expected H1 tag text '"+expText+"' is present in the web page."+"\n");
        }else{
            System.out.println("Expected H1 tag text '"+expText+"' is NOT present in the web page." + " Instead the text '" + actText + "' was found."+"\n");
        }        
        
        System.out.println("Clicking 'Hamburger flip' Icon"+"\n");
        driver.findElement(By.id("contacticon")).click();
        Thread.sleep(3000);        
        
        java.util.List<WebElement> links = driver.findElements(By.xpath("//a[contains(@href,'contact-us')]"));
        
		System.out.println("There are "+links.size()+" Valtech Offices displayed on the 'Contact' Page"+"\n");
 
		System.out.println("The list of displayed offices is as follows:");
		for (int i = 0; i<links.size(); i++)
 
		{
 			System.out.println(links.get(i).getText());
		}
        
		System.out.println("\n"+"End Of Test");
		
        driver.close();

        driver.quit();
    }

}
