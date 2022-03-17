package calender;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selectdategoibbo 
{
@Test
public void selectdate()
{
String mmyy = "March 2022";
String date = "12";

WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().window().maximize();
//login to app
driver.get("https://www.goibibo.com/");
//from
driver.findElement(By.xpath("//span[@class='sc-ieecCq jlPAAY fswWidgetLabel']")).click();
driver.findElement(By.xpath("//input[@type='text']")).sendKeys("BLR");
driver.findElement(By.xpath("//img[@alt='flight Icon']")).click();
driver.findElement(By.xpath("//input[@type='text']")).sendKeys("New");
driver.findElement(By.xpath("//img[@alt='flight Icon']")).click();
//clickondatelink
//driver.findElement(By.xpath("//p[@class='sc-dJjYzT cjzxWN fswWidgetTitle']")).click();
//click on next month icon
//driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
String dateyr ="//div[text()='"+mmyy+"']/ancestor::div[@class='DayPicker-Months']/descendant::p[text()="+date+"]";
driver.findElement(By.xpath(dateyr)).click();
//click on done
driver.findElement(By.xpath("//span[@class='fswTrvl__done']")).click();
//click on done on passengers
driver.findElement(By.xpath("//a[@class='sc-dtMgUX daltrV']")).click();
//from

	}
}
