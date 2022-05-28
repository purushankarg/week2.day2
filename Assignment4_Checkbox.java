package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_Checkbox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.findElement(By.xpath("//div[@class='example']//input")).click();
		System.out.println(driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following::input")).isSelected());
		boolean selected = driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).isSelected();
		System.out.println(selected);
		if(selected=true)		{
			driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).click();
		}else
			System.out.println("Not selected the check box");

	}

}
