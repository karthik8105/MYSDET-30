package RetryAnalyser;

import org.testng.Assert;
import org.testng.annotations.Test;
public class PracticeRetryAnalyser 
{
@Test(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyserImplements.class)
public void retry()
{
System.out.println("tet pass1");
Assert.fail();
System.out.println("tet pass2");
}}
