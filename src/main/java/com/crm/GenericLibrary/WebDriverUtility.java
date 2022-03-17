package com.crm.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.mysql.cj.jdbc.Driver;

/**
 * This class consisting of all generic method related to weddriver
 * @author prave
 *
 */
public class WebDriverUtility 
{
	/**
	 * This method will max window
	 * @param driver
	 */
public void maximizewindow(WebDriver driver)
{
driver.manage().window().maximize();
}
/**
 * This method will wait for 20secfor page to load
 * @param driver
 */
public void waitForPageLoad(WebDriver driver)
{
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

/**
 * This method will wait for 10sec for the elementto be clickable
 * @param driver
 * @param element
 */
public void waitForElementTobeClickable(WebDriver driver,WebElement element)
{
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * This method will wait for 20secfor the visible element
 */
public void  waitForElementTobeVisible(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(element));
}

/**
 * this method will select the data from dropdown using index
 * @param element
 * @param index
 */
public void select(WebElement element,int index)
{
 Select sel = new Select(element);	
 sel.selectByIndex(index);

}
/**
 * this method will select the data from dropdown using value
 * @param value
 * @param element
 */
public void select(String value,WebElement element)
{
Select sel = new Select(element);
sel.selectByValue(value);
}
/**
 * this method will select the data from dropdown using text
 * @param element
 * @param text
 */
public void select(WebElement element,String text)
{
Select sel = new Select(element);
sel.selectByVisibleText(text);  //method overloading
}
/**This will perform mouse over action
 * perform mousehover action
 * @param driver
 * @param element
 */
public void mouseHover(WebDriver driver ,WebElement element)
{ 
Actions act = new Actions(driver);
act.moveToElement(element).perform();
}
/**
 * This will perform drag and drop action
 * @param driver
 * @param src
 * @param target
 */
public void dragAndDrop(WebDriver driver,WebElement src,WebElement target )
{
	Actions act = new Actions(driver);
	act.dragAndDrop(src, target);
	
	}
/**
 *This method will double click on element 
 */
public void doubleClickAction(WebDriver driver)
{
	Actions act = new Actions(driver);
	act.doubleClick();
}
/**
 * This method will double click on the element
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	 act.doubleClick(element).perform();
	}
/**
 * This method will perform rightclick action
 * @param driver
 */
public void rightClick(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
    act.contextClick(element).perform();
}
/**
 * This method will press enter key
 * @param driver
 */
public void enterkeypress(WebDriver driver)
{
	Actions act = new Actions(driver);
	act.sendKeys(Keys.ENTER).perform();
}

/**
 * This method will press enter keys
 * @throws Throwable
 */
public void enterkey() throws Throwable
{
	Robot rb = new Robot();
	rb.keyPress(KeyEvent.VK_ENTER);
}                                                     

/**
 * This mwthod will release enter key
 * @throws Throwable
 */
public void enterRelease() throws Throwable
{
	Robot rb = new Robot();
	rb.keyRelease(KeyEvent.VK_ENTER);
}
/**
 * This method  will switch the frame based on index 
 * @param driver
 * @param index
 */
public void switchtoFrame(WebDriver driver,int index)
{
driver.switchTo().frame(index);
}

/**
 * this method eill switch the frame based on name  or id
 * @param driver
 * @param nameorid
 */
public void swithctoFrame(WebDriver driver, String nameorid )
{
	driver.switchTo().frame(nameorid);
}
/**
 * This method will switch the frame  based on address of the element
 * @param driver
 * @param address
 */
public void switchtoFrame(WebDriver driver, String address)
{
driver.switchTo().frame(address);
}
/**
 * this method used to accept alert popup
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
driver.switchTo().alert().accept();
}
/**
 * cancel the alert popup
 * @param driver
 */
public void cancelAlert(WebDriver driver)

{
driver.switchTo().alert().dismiss();	
}
/**
 * switch to window depending on partial window  title
 * @param driver
 * @param partialWinTitle
 */
public void switchToWindow(WebDriver driver,String partialWinTitle)
{
	//step1-use get windowhandles to capture all window ids
Set<String> windows = driver.getWindowHandles();
//iterate thru the winbow
Iterator<String> it = windows.iterator();
//check wheter there is next window
while(it.hasNext())
{
//capture currnet window	
String windId = it.next();
//swith to current windowa and capture title
 String currentwindowTitle = driver.switchTo().window(windId).getTitle();
 //check wheter current window is expected
 if(currentwindowTitle.contains(partialWinTitle))
 {
	 break;
 }
}
}

/**
 * This method willtake screen shot and store it in folder called as screenshot
 * @throws Throwable 
 */
public String getScreenShot(WebDriver driver,String screenshotName) throws Throwable
{
TakesScreenshot ts = (TakesScreenshot) driver;	
File src = ts.getScreenshotAs(OutputType.FILE);
File dst = new File(".//screenshoot//"+screenshotName+".png");
Files.copy(src, dst);
return dst.getAbsolutePath();

}
/**
 * this method perform random scroll 
 * @param driver
 */
public void scrollAction(WebDriver driver)
{
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,500)", "");
}
/**
 * this method will scroll until the specifid element is found
 * @param driver
 * @param element
 */
public void scrollAction(WebDriver driver,WebElement element)
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	int y = element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")", element);
//js.executescript("argument[0].scrollIntoview()",element);
}

/**
	 * This method will switch to window based on index 
	 * @param driver
	 * @param index
	 */
	public void switchToWindow(WebDriver driver, int index)
	{
		//step1: use getWindowHandles to capture all window ids
		Set<String> windows = driver.getWindowHandles();
		ArrayList<String> arraywin= new ArrayList<String>(windows);
		driver.switchTo().window(arraywin.get(index));		
	}
	/**
	 * this method will accept the alert popups
	 * @param driver
	 */
public void acceptalert(WebDriver driver)
{
driver.switchTo().alert().accept();
}
/**
 * this method will dismiss the alert popup
 * 
 */
public void cancelalert(WebDriver driver)
{
driver.switchTo().alert().dismiss();	
}
}



