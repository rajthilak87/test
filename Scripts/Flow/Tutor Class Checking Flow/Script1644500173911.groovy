import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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

String testCaseName = 'Tutor Class Check Report'
def filterBy = ['add_class', 'tutor']
def data = WebUtil.getData(GlobalVariable.projectRootPath + '\\TestDataXls\\tutor_add_class_501.xlsx', 'add_class', filterBy)
WebUtil.stopOnEmptyData(data)
for (def row : data)
	{
		WebUI.openBrowser('')
		//WebUI.maximizeWindow()
		WebUI.deleteAllCookies()
		//login with credential
		WebUI.callTestCase(findTestCase('Generic/Tutor Login General'), [('testCaseName') : testCaseName, ('testCaseData') : row], 
        FailureHandling.CONTINUE_ON_FAILURE)
		if(testCaseData.tutortyp == 'bus')
		{	
		  WebUI.callTestCase(findTestCase('Generic/Tutor Class category check general'), [('testCaseName') : testCaseName, ('testCaseData') : row],
		  FailureHandling.CONTINUE_ON_FAILURE)
		}
		else
		{
		   WebUI.callTestCase(findTestCase('Generic/Tutor Class Checking General'), [('testCaseName') : testCaseName, ('testCaseData') : row],
			   FailureHandling.CONTINUE_ON_FAILURE)
		}
	   }
	 filterBy = ['Class_check', 'student']
	 data = WebUtil.getData(GlobalVariable.projectRootPath + '\\TestDataXls\\tutor_add_class_501.xlsx', 'Sheet1', filterBy)
	WebUtil.stopOnEmptyData(data)
	for (def row : data)
		{
			WebUI.delay(2)
			//WebUI.callTestCase(findTestCase('Generic/Tutor Booking Check General1'), [('testCaseName') : testCaseName, ('testCaseData') : row],
			//FailureHandling.CONTINUE_ON_FAILURE)
		}	
	
	WebUtil.generateReport(testCaseName, filterBy)
	WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)