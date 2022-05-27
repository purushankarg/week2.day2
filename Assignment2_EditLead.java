package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_EditLead {

	public static void main(String[] args) throws InterruptedException {
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		//Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		//Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		//Enter first name
		driver.findElement(By.xpath("//div[contains(@class,'x-panel-body-noheader')]//input[contains(@class,' x-form-text') and contains(@name,'firstName')]")).sendKeys("Rajesh");
		//Click Find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(3000);
		
		//Click on first resulting lead // partial text based xpath
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();                                                  
		//Verify title of the page
		driver.getTitle();
		//Click Edit // Use Index based xpath
		driver.findElement(By.xpath("(//a[@class='subMenuButton'])[3]")).click();
		//Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("GOOGLE");
		
		//Click Update
		driver.findElement(By.className("smallSubmit")).click();
		
		//Confirm the changed name appears
		String companyname = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		//String text=companyName.getText();
		
		if (companyname.contains("GOOGLE")) {
			System.out.println("Company Name Updated as"+companyname);
		}
		else {
			System.out.println("Company Name not updated");
		}
		//Close the browser (Do not log out)
		driver.close();
	}

}

