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

String testCaseName = 'Student id Report'
def filterBy = ['signin', 'student']
def data = WebUtil.getData(GlobalVariable.projectRootPath + '\\TestDataXls\\Enrollment.xlsx', 'signin', filterBy)
WebUtil.stopOnEmptyData(data)
for (def row : data)
	{
		WebUI.openBrowser('')	
		WebUI.deleteAllCookies()			
		WebUI.callTestCase(findTestCase('Generic/Student Login General'), [('testCaseName') : testCaseName, ('testCaseData') : row],
		FailureHandling.CONTINUE_ON_FAILURE)	
		String profileurl = WebUI.getUrl(FailureHandling.CONTINUE_ON_FAILURE)	
		if(profileurl.contains('user/dashboard'))
			{		
				WebUI.navigateToUrl(WebUtil.getAbsoluteUrl('user/settings'))	
			}
			else
				{
					return
				}
				 def result = WebUI.getText(findTestObject('bookaclass/enrol/id'))
					 def result1 = WebUI.getText(findTestObject('Object Repository/bookaclass/enrol/id 1'))
					 WebUtil.report(testCaseName, testCaseData,result)
					 WebUtil.report(testCaseName, testCaseData,result1)
	}
	WebUtil.generateReport(testCaseName, filterBy)
	WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)