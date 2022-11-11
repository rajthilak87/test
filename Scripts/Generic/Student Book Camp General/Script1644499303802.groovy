import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUIHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import com.netkathir.Util as WebUtil
import java.math.*;
try {
WebDriver driver = DriverFactory.getWebDriver()
String currentScreenUrl = WebUI.getUrl()
if (currentScreenUrl.contains('dashboard'))
	{
		WebUI.setText(findTestObject('Object Repository/test/Page_Nurtem/input_Rosa Foad_rc_select_3'), testCaseData.subject)
	    WebUI.delay(2)
	    WebUI.sendKeys(findTestObject('Object Repository/test/Page_Nurtem/input_Rosa Foad_rc_select_3'), Keys.chord([Keys.DOWN, Keys.ENTER]))
	    WebUI.delay(5)
		WebUI.click(findTestObject("bookaclass/Camp/Camp_button"))
		WebUI.delay(2)
		WebUI.navigateToUrl(WebUtil.getAbsoluteUrl(GlobalVariable.profile+testCaseData.profile), FailureHandling.STOP_ON_FAILURE)
	    WebUI.delay(3)
		WebUI.click(findTestObject("bookaclass/Camp/Camp_button2"))
		WebUI.delay(2)		
		def g
		for (g = 0; g<10; g++ )
		{
			String xpathClass = ('//a[contains(@href,"/view-camp/' + testCaseData.viewClass) + '/")]'
			WebUI.delay(2)
			if(driver.findElements(By.xpath(xpathClass)).size() != 0)				
			{
				driver.findElement(By.xpath(xpathClass)).click()
				break;
			}
			else
			{
				WebUI.scrollToElement(findTestObject('Object Repository/bookaclass/findclass'), 60)
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click()
			}
		}	   
		WebUI.delay(3)	
		WebUI.click(findTestObject("Object Repository/bookaclass/Camp/Select_button"))
		WebUI.delay(2)
		if (testCaseData.add_on == 'yes')
			{
				WebUI.click(findTestObject("Object Repository/bookaclass/Camp/add_on_select"))
			}	
			WebUI.delay(1)
			WebUI.scrollToElement(findTestObject('Object Repository/bookaclass/footer_scrolldown'), 60)
			WebUI.click(findTestObject("Object Repository/bookaclass/Camp/Add_to_cart_button"))
		WebUI.delay(3)			
		WebUtil.clickElement('Object Repository/bookaclass/to_whom')	
		WebUI.delay(1)			
		String count = testCaseData.dept_count
			String val = testCaseData.to_whom
		for (int i=0;i<val;i++)
			{		
				WebUtil.robot.keyPress(KeyEvent.VK_DOWN)		
				WebUtil.robot.keyPress(KeyEvent.VK_ENTER)	
			}												
						def a = testCaseData.Tot_ses_price
						BigDecimal b1 = new BigDecimal(a);
						BigDecimal b3 = b1.stripTrailingZeros();
						println(b1 + " after removing trailing zeros " + b3)
						def result = WebUI.getText(findTestObject('Object Repository/bookaclass/Camp/read_price'))
						result = result.substring(1);
						
						BigDecimal b11 = new BigDecimal(result);
						BigDecimal b13 = b11.stripTrailingZeros();
						println(" b13 is " + b13)
						if (b13 == b3)
							{
								WebUtil.report(testCaseName, testCaseData, 'Camp Price is correct : ' + result)
							}
						else
							{
								WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Camp Price is incorrect'+result+ ' , Actual price is : ' + b3, true)
							}
					
	def b = testCaseData.tax
	println("value of a is" + b)	
	BigDecimal b6 = new BigDecimal(b);
	BigDecimal b7 = b6.stripTrailingZeros();	
	println(b6 + " after removing trailing zeros " + b7)
	def resul = WebUI.getText(findTestObject('Object Repository/bookaclass/read_tax_value'))	
	resul = resul.substring(1);	
	resul.toString()	
	println("result is" + resul)	
	BigDecimal b16 = new BigDecimal(resul);
	BigDecimal b17 = b16.stripTrailingZeros();
	if (b17 == b7 )
		{	
			WebUtil.report(testCaseName, testCaseData, 'Tax value is correct : ' + resul)
		}
	else
		{
			WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tax value is incorrect : '+resul+ ' ,  Actual Tax value is ' + b7, true)
		}
	def c = testCaseData.Grand_tot	
	println("value of a is" + c)	
	BigDecimal b4 = new BigDecimal(c);
	BigDecimal b5 = b4.stripTrailingZeros();
	def resu = WebUI.getText(findTestObject('Object Repository/bookaclass/read_tot_value'))	
	resu = resu.substring(1);	
	resu.toString()	
	println("result is" + resu)	
	BigDecimal b14 = new BigDecimal(resu);
	BigDecimal b15 = b14.stripTrailingZeros();	
	if ( b15 == b5 )
		{	
			WebUtil.report(testCaseName, testCaseData, 'Total price is correct : ' + resu)
		}
	else
		{
			WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Total Price is incorrect : '+resu+ ' , Actual price is ' + b5, true)
		}
if (testCaseData.check_coupon_value == '0')
		{
	
			WebUtil.setVal(findTestObject('bookaclass/coupon_value'), testCaseData.coupon_value)
			driver.findElement(By.xpath('//span[contains(text(),"Apply Coupon")]')).click()	
			WebUI.delay(2)
		
			/*err = WebUtil.isErrorExists()
				def zz = err.toString()
				if (zz.contains("success")) 	
				  {*/
					  
					  def i = testCaseData.ses_value_after_coupon
					  println("value of a is" + i)
					  BigDecimal bb4 = new BigDecimal(i);
					  BigDecimal bb5 = bb4.stripTrailingZeros();
					  def result1 = WebUI.getText(findTestObject('Object Repository/bookaclass/ses_value_after_coupon'))
					  result1 = result1.substring(1);
					  println("result is" + result1)
					  BigDecimal bb14 = new BigDecimal( result1);
					  BigDecimal bb15 = bb14.stripTrailingZeros();
					  if (bb5 == bb15 )
						  {
							  WebUtil.report(testCaseName, testCaseData, ' Price is correct after applying coupon : ' + result1)
							  WebUI.delay(5)
						  }
					  else
						  {
							  WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Price is incorrect after applying the coupon :'+result1+' , Actual price is ' + bb5, true)
						  }
							  def J = testCaseData.tax_disc
							  println("value of a is" + J)
							  BigDecimal bb6 = new BigDecimal(J);
							  BigDecimal bb7 = bb6.stripTrailingZeros();
							  println(bb6 + " after removing trailing zeros " + bb7)
							  def resul1 = WebUI.getText(findTestObject('Object Repository/bookaclass/read_tax_value'))
							  resul1 = resul1.substring(1);
							  println("result is" + resul1)
							  BigDecimal bb16 = new BigDecimal(resul1);
							  BigDecimal bb17 = bb16.stripTrailingZeros();
							  if (bb7 == bb17 )
								  {
									  WebUtil.report(testCaseName, testCaseData, 'Tax value is correct after applying the coupon : ' + resul1)
									  WebUI.delay(5)
								  }
							  else
								  {
									  WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tax value is incorrect after applying the coupon : '+resul1+ ' , Actual Tax value is ' + bb7, true)
								  }
									  def k = testCaseData.grand_total_after_coupon
									  println("value of a is" + c)
									  BigDecimal bb1 = new BigDecimal(k);
									  BigDecimal bb3 = bb1.stripTrailingZeros();
									  def resu1 = WebUI.getText(findTestObject('Object Repository/bookaclass/read_tot_value'))
									  resu1 = resu1.substring(1);
									  println("result is" + resu1)
									  BigDecimal bb11 = new BigDecimal(resu1);
									  BigDecimal bb13 = bb11.stripTrailingZeros();
									  if (bb3 == bb13 )
										  {
											  WebUtil.report(testCaseName, testCaseData, 'Total price after applying coupon is correct : ' + resu1)
										  }
									  else
										  {
											  WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Total Price after applying coupon is incorrect : '+resu1+ ' , Actual price is ' + bb3, true)
										  }
				  
					 
				 /*}
			 else
				 {
					 WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Coupon Code : ' + err.toString(),true)
				 }*/
	
		}
WebUI.scrollToElement(findTestObject('Object Repository/bookaclass/footer_scrolldown'), 3)
err = WebUtil.isErrorExists()	
if (err.size() > 0)
	{
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Cart Page : ' + err.toString())
	}
else
	{
	WebUtil.clickElement('Object Repository/bookaclass/paynowbtn')
	WebUtil.reportAndtakeScreenshotIfErrorExists(testCaseName, testCaseData,'Cart Page is in progress')
	}
	WebUtil.clickElement('Object Repository/bookaclass/paynowbtn')
		WebUI.delay(3)
		WebUtil.setVal(testCaseData.username)
	    WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	    WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	    WebUtil.setVal(testCaseData.cardnumber)
	    WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	    WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	    WebUtil.setVal(testCaseData.expdate)
	    WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	    WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	    WebUtil.setVal(testCaseData.cvc)
		err = WebUtil.isErrorExists()
		if (err.size() > 0)
			{
				WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Payment Form : ' + err.toString(),true)
			}
		else
			{
				WebUtil.robot.keyPress(KeyEvent.VK_TAB)
				WebUtil.robot.keyRelease(KeyEvent.VK_TAB)	
				WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
			    WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
				err = WebUtil.isErrorExists()
				def z = err.toString()
				if (z.contains("success")) 	
					{
						WebUtil.report(testCaseName, testCaseData,'Payment Submission: '+ err.toString())
					}
				else
					{
						WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData,'Payment Submission: '+ err.toString(),true)
					}
			}
	}
}
catch (org.openqa.selenium.NoSuchElementException | com.kms.katalon.core.exception.StepFailedException  e)
{
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor request has error : ' + e.getMessage(),true)
}