package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_Radio {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/radio.html");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Click the radio button
		driver.findElement(By.xpath("//div[contains(@class,'large-6 small-12 columns')]//input[@class='myradio' and @value='0']")).click();
		
		WebElement selected = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input[2]"));
		boolean status=selected.isSelected();
		System.out.println("default selected radio button- Checked= "+ status);
		
		boolean above40= driver.findElement(By.xpath("//div[contains(@class,'large-6 small-12 columns')]/input[@value='2']")).isSelected();
		System.out.println("age selected is"+above40);
		
		driver.findElement(By.xpath("//div[contains(@class,'large-6 small-12 columns')]/input[@value='2']")).click();	
		
		Thread.sleep(3000);
		driver.close();
		
		

	}

}
