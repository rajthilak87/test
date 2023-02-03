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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
try {
//WebUI.waitForPageLoad(GlobalVariable.)
//WebUI.delay(2)
String ExpectedValue = testCaseData.class_name
print("the class name is :"+ExpectedValue)
WebDriver driver = DriverFactory.getWebDriver()
'To locate table'
def temp=0
page: for (int z=0; z<6; z++) 
	{
		WebElement Table = driver.findElement(By.xpath('(//table/tbody)[1]'))
		List<WebElement> Rows = Table.findElements(By.tagName('tr'))	
		println('No. of rows: ' + Rows.size())		
		table: for (int i = 0; i < Rows.size(); i++) 
				{
					print('i value is :'+i)	
					List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))		
					for (int j = 0; j < Cols.size(); j++) 
						{ 
							print("j value is :"+j)					
							if (Cols.get(j).getText().equalsIgnoreCase(ExpectedValue))
								{									
									Cols.get(5).findElement(By.tagName('button')).click()
									//def addcamp_link	= "//div[@role='tablist']//div[8]"									
									//driver.findElement(By.xpath(addcamp_link)).click()
									temp = 1				
									table: break				
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
					WebUI.click(findTestObject('Object Repository/bookaclass/enrol/next_button'))
					i=0
					j=0
					WebUI.delay(3)
	}
	/*WebUI.scrollToElement(findTestObject('Object Repository/bookaclass/enrol/scroll'),1)
	WebUI.delay(5)*/
	WebUI.click(findTestObject('Object Repository/bookaclass/enrol/enroll_button'))
	WebUI.delay(2)		
	if (testCaseData.user_type == 'dependent')
		{
			WebUI.click(findTestObject('Object Repository/bookaclass/enrol/user_type'))
			WebUI.delay(2)
			WebUI.setText(findTestObject('Object Repository/bookaclass/enrol/enteringid'), testCaseData.student_id)
			WebUI.delay(2)
			WebUI.setText(findTestObject('Object Repository/bookaclass/enrol/entering_dep_id'), testCaseData.dependent_id)
			WebUtil.robot.keyPress(KeyEvent.VK_TAB)
			WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
			WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
			WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
			WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
			WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
		}
		else
			{
				//WebUI.delay(5)
				//WebUI.click(findTestObject('Object Repository/bookaclass/enrol/enteringid'))
				WebUI.delay(2)
				WebUI.setText(findTestObject('Object Repository/bookaclass/enrol/enteringid'), testCaseData.student_id)
				WebUtil.robot.keyPress(KeyEvent.VK_TAB)
				WebUtil.robot.keyRelease(KeyEvent.VK_TAB)							
			WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
			WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
			WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
			WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
			}			
			WebUI.delay(2)
			/*def whichday = testCaseData.which_day
			print ('data in which day is :'+whichday)
			String xpath1 = "//div[@role='tab'][normalize-space()='$whichday']"
			print("the xpath is -"+xpath1)
			WebElement element1 = driver.findElement(By.xpath(xpath1))
			element1.click()
			WebUI.delay(2)*/	
			def whichday = testCaseData.which_day
			print ('data in which day is :'+whichday)
			String xpath1 = "//div[@role='tab'][normalize-space()='$whichday']"
			print("the xpath is -"+xpath1)
			
			if(whichday!='') {
			WebElement element1 = driver.findElement(By.xpath(xpath1))
			element1.click()
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/bookaclass/enrol/submit'))
			WebUI.delay(2)
			}
			else {
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/bookaclass/enrol/submit'))
			WebUI.delay(2)
			}
			
			if (testCaseData.teaching_type == 'session')
				{
					WebUtil.setVal(findTestObject('bookaclass/session'), testCaseData.session)
					def a = testCaseData.tot_ses_cost
					BigDecimal b1 = new BigDecimal(a);
					BigDecimal b3 = b1.stripTrailingZeros();
					println(b1 + " after removing trailing zeros " + b3)
					def result = WebUI.getText(findTestObject('Object Repository/bookaclass/enrol/read_ses_price'))
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
							WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Session Price is incorrect : '+result+' Actual price is ' + b13, true)
						}
				}
				else if(testCaseData.teaching_type == 'monthly')
					{
						def a = testCaseData.tot_ses_cost
						BigDecimal b1 = new BigDecimal(a);
						BigDecimal b3 = b1.stripTrailingZeros();
						println(b1 + " after removing trailing zeros " + b3)
						def result = WebUI.getText(findTestObject('Object Repository/bookaclass/enrol/read_ses_price'))
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
								WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Monthly Price is incorrect'+result+ ' Actual price is : ' + b3, true)
							}
					}
			else 
				{
					def a = testCaseData.tot_subscription_cost
					BigDecimal b1 = new BigDecimal(a);
					BigDecimal b3 = b1.stripTrailingZeros();
					println(b1 + " after removing trailing zeros " + b3)
					def result = WebUI.getText(findTestObject('Object Repository/bookaclass/enrol/read_ses_price'))
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
							WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Subscription Price is incorrect : '+result+' Actual price is ' + b13, true)
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
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tax value is incorrect : '+resul+ ' Actual Tax value is ' + b7, true)
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
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Total Price is incorrect : '+resu+ ' Actual price is ' + b5, true)
	}
			//WebUI.scrollToElement(findTestObject('Object Repository/bookaclass/enrol/scroll'),1)
			
			//WebUI.click(findTestObject('Object Repository/bookaclass/enrol/pay button'))
			WebElement ele = driver.findElement(By.xpath("//span[normalize-space()='Enroll Student']"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", ele);
			err = WebUtil.isErrorExistsEnroll()
			def z = err.toString()
			if (z.contains("Success"))
				{
					WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor enrolment booked succesfully : ' + z)
				}
				else
					{
						WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor enrolment has error : '+z,true)
					}
}
catch (org.openqa.selenium.NoSuchElementException | com.kms.katalon.core.exception.StepFailedException  e)
{
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor request has error : ' + e.getMessage(),true)
}