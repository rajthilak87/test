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
import com.netkathir.Util as WebUtil
import org.openqa.selenium.By as By
import java.awt.event.KeyEvent as KeyEvent
import java.awt.Robot as Robot
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection
import org.openqa.selenium.WebDriver as WebDriver

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
try {
//def my_class = 	"//span[contains(text(),'My Classes')]"
/*def my_class = 	"//a[@href='/user/class-details']//span"
WebUI.delay(5)
driver.findElement(By.xpath(my_class)).click()
WebUI.delay(2)*/
	
	WebDriver driver = DriverFactory.getWebDriver()
	WebUI.click(findTestObject('Object Repository/Reorder/My_Classes'))//a[@href='/user/class-details']
	WebUI.delay(2)
	
if(testCaseData.which_user == 'depen')
	{
		WebUI.click(findTestObject('Object Repository/message/which user'))
		WebUI.delay(2)
	}
String ExpectedValue = testCaseData.class_name.trim()
String depnvalue = testCaseData.depn_name.trim()
table_loc = "//div[@class='nurtem-card-design nurtem-table py-4 mt-2 mb-3']"
WebUI.delay(2)
WebElement Table = driver.findElement(By.xpath(table_loc))

WebUI.delay(2)
List<WebElement> Rows = Table.findElements(By.tagName('tr'))	
println('No. of rows: ' + Rows.size())
def k=2
def e=1	
def temp=0
table: for (int i = 1; i < Rows.size(); i++)
	{
		print('i value is :'+i)		
		List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))		
		print('value of k is'+k)		
		for (int j = 0; j < Cols.size(); j++) 
			{
				if(j==0)
					{
						if (Cols.get(j).getText().equalsIgnoreCase(ExpectedValue))
							{
								if(e!=1)
									{
										WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'class  registration has already done  : '+Cols.get(j).getText(),true)						
									}
									else
										{
											WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Correct Class - '+Cols.get(j).getText())
											e=2
											Cols.get(6).findElement(By.xpath('//tbody//button[2]//span[1]')).click()
											WebUI.delay(2)
											WebUtil.robot.keyPress(KeyEvent.VK_TAB)
											WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
											WebUI.delay(2)
											WebUtil.robot.keyPress(KeyEvent.VK_TAB)
											WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
											WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
											WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
											temp = 1
											table: break
										}
							}
							else
								{
									WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Wrong class - '+Cols.get(j).getText(),true)			
								}
					}	
					if (temp==1)					
					{
						break
					}
				
			}
			if (temp==1)
				{
					break
				}
		}
		String count = testCaseData.dept_count
		String kk = testCaseData.to_whom
		int val =  kk.toInteger()
		//println('the value of who is'+val)
		if(val!=0) {
			WebUtil.clickElement('Object Repository/bookaclass/to_whom')
			if(testCaseData.which_user != 'parent')
				{
					for (int i=0;i<val;i++)
						{
							WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
							WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
							WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
							WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
							WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
							WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
							WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
							WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
						}
				}
				else {									
					for (int i=0;i<val;i++)
						{
							WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
							WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
							WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
							WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
						}
					}
			}
			WebUI.delay(3)
			//WebUtil.robot.keyPress(KeyEvent.VK_TAB)
			if (testCaseData.teaching_type == '0')
				{
					WebUtil.setVal(findTestObject('bookaclass/session'), testCaseData.session)
					def a = testCaseData.tot_ses_cost
					BigDecimal b1 = new BigDecimal(a);
					BigDecimal b3 = b1.stripTrailingZeros();
					println(b1 + " after removing trailing zeros " + b3)
					def result = WebUI.getText(findTestObject('Object Repository/bookaclass/read_ses_price'))
					result = result.substring(1);
					println(" b3 is " + b3)
					BigDecimal b11 = new BigDecimal(result);
					BigDecimal b13 = b11.stripTrailingZeros();
					if (b13 == b3)
						{
							WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Session Price is correct : ' + result)
						}
					else
						{
							WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Session Price is incorrect : '+result+' , Actual price is ' + b13, true)
						}
				}
			else if(testCaseData.teaching_type == '1')
				{
					def a = testCaseData.tot_subscription_cost
					BigDecimal b1 = new BigDecimal(a);
					BigDecimal b3 = b1.stripTrailingZeros();
					println(b1 + " after removing trailing zeros " + b3)
					def result = WebUI.getText(findTestObject('Object Repository/bookaclass/read_ses_price'))
					result = result.substring(1);
					println(" b3 is " + b3)
					BigDecimal b11 = new BigDecimal(result);
					BigDecimal b13 = b11.stripTrailingZeros();
					if (b13 == b3)
						{
							WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Subscription Price is correct : ' + result)
						}
					else
						{
							WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Subscription Price is incorrect : '+result+' , Actual price is ' + b13, true)
						}
				}
				else
				{
					def a = testCaseData.tot_ses_cost
					BigDecimal b1 = new BigDecimal(a);
					BigDecimal b3 = b1.stripTrailingZeros();
					println(b1 + " after removing trailing zeros " + b3)
					def result = WebUI.getText(findTestObject('Object Repository/bookaclass/read_ses_price'))
					result = result.substring(1);
					
					BigDecimal b11 = new BigDecimal(result);
					BigDecimal b13 = b11.stripTrailingZeros();
					println(" b13 is " + b13)
					if (b13 == b3)
						{
							WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Monthly Price is correct : ' + result)
						}
					else
						{
							WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Monthly Price is incorrect'+result+ ' , Actual price is : ' + b3, true)
						}
				}
def b = testCaseData.total_tax
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
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tax value is correct : ' + resul)
	}
else
	{
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tax value is incorrect : '+resul+ ' , Actual Tax value is ' + b7, true)
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
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Total price is correct : ' + resu)
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
	
		err = WebUtil.isErrorExists()
			def zz = err.toString()
			if (zz.contains("success"))
			  {
				  
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
						  WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, ' Price is correct after applying coupon : ' + result1)
			
					  }
				  else
					  {
						  WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Price is incorrect after applying the coupon :'+result1+' , Actual price is ' + bb5, true)
					  }
						  def J = testCaseData.tax_value_after_coupon
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
								  WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tax value is correct after applying the coupon : ' + resul1)
							
							  }
						  else
							  {
								  WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tax value is incorrect after applying the coupon : '+resul1+ ' , Actual Tax value is ' + bb7, true)
							  }
								  def k2 = testCaseData.grand_total_after_coupon
								  println("value of a is" + c)
								  BigDecimal bb1 = new BigDecimal(k2);
								  BigDecimal bb3 = bb1.stripTrailingZeros();
								  def resu1 = WebUI.getText(findTestObject('Object Repository/bookaclass/read_tot_value'))
								  resu1 = resu1.substring(1);
								  println("result is" + resu1)
								  BigDecimal bb11 = new BigDecimal(resu1);
								  BigDecimal bb13 = bb11.stripTrailingZeros();
								  if (bb3 == bb13 )
									  {
										  WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Total price after applying coupon is correct : ' + resu1)
									  }
								  else
									  {
										  WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Total Price after applying coupon is incorrect : '+resu1+' , Actual price is ' + bb3, true)
									  }
			  
				 
			  }
		 else
			 {
				 WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Coupon Code : ' + err.toString(),true)
			 }

	}
WebUI.scrollToElement(findTestObject('Object Repository/bookaclass/footer_scrolldown'), 3)
/*err = WebUtil.isErrorExists()
if (err.size() > 0)
{
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Cart Page : ' + err.toString())
}
else
{
WebUtil.clickElement('Object Repository/bookaclass/paynowbtn')
WebUtil.reportAndtakeScreenshotIfErrorExists(testCaseName, testCaseData,'Cart Page is in progress')
}*/
WebUI.delay(1)
WebUtil.clickElement('Object Repository/bookaclass/paynowbtn')
	WebUI.delay(1)
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
					WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData,'Payment Submission: '+ err.toString())
				}
			else
				{
					WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData,'Payment Submission: '+ err.toString(),true)
				}
		}
//}

}
catch (org.openqa.selenium.NoSuchElementException | com.kms.katalon.core.exception.StepFailedException  e)
{
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor request has error : ' + e.getMessage(),true)
}