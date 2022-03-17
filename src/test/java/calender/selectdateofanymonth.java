package calender;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class selectdateofanymonth {
	@Test
	public void selectdate()
	{
		String monthandyear ="July 2022";
		String date = "26";
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");

	Actions actions = new Actions(driver) ;
	actions.moveByOffset(10, 10).click().perform();

	driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	
String arrowpath = "//span[@aria-label='Next Month']";
String datexpath ="//div[text()='"+monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
for(;;)	{
	try {
		driver.findElement(By.xpath(datexpath)).click();
		break;
	} catch (Exception e) {
		driver.findElement(By.xpath(arrowpath)).click();
	}
	}
	}
}
