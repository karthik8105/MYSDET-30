package calender;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Selectanydatafromcalender 
{
@Test
public void selectdate()
{
	String monthandyear ="March 2022";
	String date = "28";
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("https://www.makemytrip.com/");

Actions actions = new Actions(driver) ;
actions.moveByOffset(10, 10).click().perform();

driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
driver.findElement(By.xpath("//div[text()='"+monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
}
}
