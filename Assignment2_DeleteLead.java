package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_DeleteLead {

	public static void main(String[] args) throws InterruptedException {

		// Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
				
		// Enter the username & password
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		// Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		// Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		// Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		// Click on Phone
		driver.findElement(By.linkText("Phone")).click();
		// Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		// Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		// Capture lead ID of First Resulting lead
		Thread.sleep(2000);
		String leadId = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a")).getText();
		System.out.println(leadId);
		Thread.sleep(3000);
		
		// Click First Resulting lead
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a")).click();
		// Click Delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		// Click find Lead
		driver.findElement(By.linkText("Find Leads")).click();
		//Enter captured lead ID
	    driver.findElement(By.name("id")).sendKeys(leadId );
		//Click find leads button
	    driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	    Thread.sleep(3000);
		
	    String textMsg= driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
	    System.out.println(textMsg);
		// Verify message "No records to display" in the Lead List. This message confirms the successful deletion
	    if(textMsg.contains("No record")) {
	    	System.out.println("Record delete successfully");
	    }
	    else {
	    	System.out.println("No record deleted");
	    }
		// Close the browser (Do not log out)
		driver.close();

	}

}
