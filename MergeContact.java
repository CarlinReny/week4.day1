package week4.day1;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();		

		//Launch the Chrome Browser

		ChromeDriver driver = new ChromeDriver();

		//Load the URL

		driver.get("http://leaftaps.com/opentaps/control/main");

		//Maximize the Browser

		driver.manage().window().maximize();


		// Getting Username element and entering value

		WebElement Username = driver.findElement(By.id("username"));	
		Username.sendKeys("DemoSalesManager");

		//Getting Password element and entering value in 

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//press Login button

		driver.findElement(By.className("decorativeSubmit")).click();

		//Click CRM/SFA

		driver.findElement(By.linkText("CRM/SFA")).click();


		//Click on Contacts Tab

		driver.findElement(By.linkText("Contacts")).click();
 
		//Click on the Merge Contacts

		 driver.findElement(By.linkText("Merge Contacts")).click();
		
		
		driver.findElement(By.xpath("//img[@src = '/images/fieldlookup.gif'][1]")).click();
		
		Set<String> AllWindows = driver.getWindowHandles();
		
		List<String> AllWindowshandles = new ArrayList<String>(AllWindows);
		
	    String Childwindow = AllWindowshandles.get(1);
	    
	    String Parentwindow = AllWindowshandles.get(0);
		
	    driver.switchTo().window(Childwindow);
		
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
		
		driver.switchTo().window(Parentwindow);
		
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		
		Set<String> AllWindows1 = driver.getWindowHandles();
		
		List<String> AllWindowshandles1 = new ArrayList<String>(AllWindows1);
		
	    String Childwindow1 = AllWindowshandles1.get(1);	
	    String Parentwindow1 = AllWindowshandles.get(0);
	   
	    driver.switchTo().window(Childwindow1);
	    
	    driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		
	    driver.switchTo().window(Parentwindow1);
	    
	    
	    
	    driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
	    
	     driver.switchTo().alert().accept();
	     
	     String Title = driver.getTitle();
	     
	     System.out.println(Title);
	     
	    
	     
	}
	
}



		