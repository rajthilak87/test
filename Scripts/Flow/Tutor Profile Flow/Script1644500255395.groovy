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

String testCaseName = 'Tutor Profile Report'
def filterBy = ['profile', 'tutor']
def data = WebUtil.getData(GlobalVariable.projectRootPath + '\\TestDataXls\\profile-tutor.xlsx', 'profile', filterBy)
WebUtil.stopOnEmptyData(data)
for (def row : data)
	{
		WebUI.openBrowser('')
		//WebUI.maximizeWindow()
		WebUI.deleteAllCookies()
		//	login with that credential
		WebUI.callTestCase(findTestCase('Generic/Tutor Login General'), [('testCaseName') : testCaseName, ('testCaseData') : row],FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(5)
		String currentScreenUrl = WebUI.getUrl()
	    if (currentScreenUrl.contains('tutor/complete-profile'))
			{
				WebUtil.reportAndtakeScreenshot(testCaseName, row, 'Tutor Login Success')
				WebUI.delay(2)
				if (WebUtil.verifyPresent('Object Repository/tutor-profile/complete_profile', testCaseName, row))
					{
						WebUI.callTestCase(findTestCase('Test Cases/Generic/tutor login profile general'), [('testCaseName') : testCaseName, ('testCaseData') : row],FailureHandling.CONTINUE_ON_FAILURE)
					}
					else
						{
							WebUtil.reportAndtakeScreenshot(testCaseName, row, 'Tutor Profile Filled already: Success')
						}
						//WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)
			}
	}
WebUtil.generateReport(testCaseName, filterBy)
		/*	String currentScreenUrl1 = WebUI.getUrl()
			if (currentScreenUrl1.contains('dashboard'))
			{
				WebUI.click(findTestObject("Object Repository/tutor-profile/logout1"))
				WebUI.delay(2)
				WebUI.click(findTestObject("Object Repository/tutor-profile/logout2"))
			}  */
	//}
//	}
//WebUtil.generateReport(testCaseName, filterBy)
//
//WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)