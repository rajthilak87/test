import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.constants.GlobalStringConstants as GlobalStringConstants
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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.netkathir.Util as WebUtil
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

String testCaseName = 'Add Faq Report'
def filterBy = ['signin', 'tutor']
def data = WebUtil.getData(GlobalVariable.projectRootPath + '\\TestDataXls\\Faq.xlsx', 'Faq', filterBy)
WebUtil.stopOnEmptyData(data)
for (def row : data)
	{
		WebUI.openBrowser('')
		WebUI.deleteAllCookies()
		//WebUI.maximizeWindow()
		WebUI.callTestCase(findTestCase('Generic/Tutor Login General'), [('testCaseName') : testCaseName, ('testCaseData') : row],FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/tutor-add-class/add_class_link'))
		WebUI.callTestCase(findTestCase('Test Cases/Generic/Tutor Add Faq General'), [('testCaseName') : testCaseName, ('testCaseData') : row],FailureHandling.CONTINUE_ON_FAILURE)
	}
		String currentUrl = WebUI.getUrl(FailureHandling.CONTINUE_ON_FAILURE).toString()
		if (currentUrl.contains('class-details'))
			{	
				filterBy = ['Faq', 'tutor']
				data = WebUtil.getData(GlobalVariable.projectRootPath + '\\TestDataXls\\Faq.xlsx', 'Faq_list', filterBy)
				WebUtil.stopOnEmptyData(data)
				for (def row : data)
					{
						WebUI.callTestCase(findTestCase('Test Cases/Generic/Tutor Add Faq General one'), [('testCaseName') : testCaseName, ('testCaseData') : row],FailureHandling.CONTINUE_ON_FAILURE)
					}
			}
			else
			{
				WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor Milestone has error : ',true)
			}
			WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)
	
WebUtil.generateReport(testCaseName, filterBy)