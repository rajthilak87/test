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

try {
	WebUI.click(findTestObject("Object Repository/add_tutor/My_tutor_button"))
	WebUI.delay(1)
	WebUI.click(findTestObject("Object Repository/add_tutor/add_tutor_button"))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/add_tutor/Username'), testCaseData.newtutorname)
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/add_tutor/password'), testCaseData.password)
	WebUI.delay(1)
	WebUI.click(findTestObject("Object Repository/add_tutor/create"))
	
def err = WebUtil.isErrorExists()
def z = err.toString()
if (z.contains("Success"))
{
WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData,'Add tutor Submited'+z)
}else {
WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData,'Add tutor has error '+ z,true)
}
if (testCaseData.Add_profile == 'yes')
	{
		WebUI.click(findTestObject("Object Repository/add_tutor/Yes button"))
		
	}
	else
	{
		WebUI.click(findTestObject("Object Repository/add_tutor/No button"))
	}
}
catch (Exception e)
{
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Add tutor has error : ' + e.getMessage(),true)
}