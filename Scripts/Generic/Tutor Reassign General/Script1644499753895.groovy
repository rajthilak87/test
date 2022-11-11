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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import java.awt.event.KeyEvent as KeyEvent
import java.awt.Robot as Robot
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//WebUI.waitForPageLoad(GlobalVariable.)
try {
if (testCaseData.tutortype == 'individual')
	{
		WebUI.click(findTestObject("Object Repository/tutor-add-class/individual_tutor_add_class"))
	}
	else
	{
		WebUI.click(findTestObject("Object Repository/tutor-add-class/add_class_link"))		
	}
String ExpectedValue = testCaseData.class_name

print("the class name is :"+ExpectedValue)

WebDriver driver = DriverFactory.getWebDriver()

'To locate table'
def temp=0
page: for (int z=0; z<3; z++) 
{
	WebElement Table = driver.findElement(By.xpath('(//table/tbody)[1]'))
	List<WebElement> Rows = Table.findElements(By.tagName('tr'))
	table: for (int i = 0; i < Rows.size(); i++) 
	{
		List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
		print('the colm size is'+Cols.size())		
		for (int j = 0; j < Cols.size(); j++) 
			{ 
				if(j==0)
					{									
						if (Cols.get(j).getText().equalsIgnoreCase(ExpectedValue))
							{					
								Cols.get(5).findElement(By.tagName('button')).click()
								WebUI.delay(2)
								WebUtil.robot.keyPress(KeyEvent.VK_TAB)
								WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
								WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
								WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
								
								temp = 1				
								table: break	
							}	
							if (temp==1)
								{
									break
								}
					}
								
			}
			if (temp==1)
				{
					break
				}										
	}
	if(temp==0) {
	if(WebUI.verifyElementPresent(findTestObject('Object Repository/bookaclass/enrol/next_button'),20,FailureHandling.OPTIONAL))	
		{
			WebUI.click(findTestObject('Object Repository/bookaclass/enrol/next_button'))
		}			
}
if (temp==1)
	{
		break
	}
}
WebUI.click(findTestObject('Object Repository/bookaclass/enrol/reassign_tutor_name'))
	if (testCaseData.user_type == '0')
		{
			WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
			WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)	
		}
	else if (testCaseData.user_type == '1')
		{
			WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
			WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
			WebUtil.robot.keyPress(KeyEvent.VK_ENTER)	
			WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
		}
	else
		{
			WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
			WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
			WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
			WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
			WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
			WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
		}

		WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/bookaclass/enrol/submit'))
WebUI.delay(1)
def err = WebUtil.isErrorExists()
def z = err.toString()
if (z.contains("Success"))
{
WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData,'Tutor reassigned Submited'+z)
}else {
WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData,'Tutor reassign has error '+ z,true)
}
}
catch (Exception e)
{
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor reassign has error : ' + e.getMessage(),true)
}