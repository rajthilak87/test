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
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


try {
	WebUI.click(findTestObject('Object Repository/Faq/Add questions'))
	WebUI.delay(1)
	WebUtil.setVal(findTestObject('Object Repository/Faq/question'), testCaseData.question)
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Faq/Answer'), testCaseData.answer)
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Faq/submit'))
	def err = WebUtil.isErrorExists()
	def a = err.toString()
	println ("Value of a is : " + a)
	if (a.contains("successfully"))
		{
			WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Faq submitted successfully :' +  a)
		}
		else
			{
				WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Faq submission has error :' +  a,true)
			}
}
catch (org.openqa.selenium.NoSuchElementException | com.kms.katalon.core.exception.StepFailedException  e)
{
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor milestone has error : ' + e.getMessage(),true)
}