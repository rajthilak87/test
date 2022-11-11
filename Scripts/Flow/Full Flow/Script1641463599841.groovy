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

String testCaseName = 'student_on_boarding_flow'
def filterBy = ['signup', 'student']
def data = WebUtil.getData(GlobalVariable.projectRootPath + '\\TestDataXls\\signup.xlsx', 'signup', filterBy)
WebUtil.stopOnEmptyData(data)
for (def row : data)
	{
		WebUI.openBrowser('')
		//    WebUI.maximizeWindow()
		WebUI.deleteAllCookies()
		
						//login with that credential
						/*WebUI.callTestCase(findTestCase('Generic/Student Login General'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(5)
						WebUI.callTestCase(findTestCase('Generic/Student Profile General'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(5)
						WebUI.callTestCase(findTestCase('Flow/Tutor Onboarding Flow'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(5)*/
						WebUI.callTestCase(findTestCase('Flow/Tutor Profile Flow'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(5)
						//WebUI.callTestCase(findTestCase('Flow/Tutor Add Flow'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.CONTINUE_ON_FAILURE)
						//WebUI.delay(5)
						WebUI.callTestCase(findTestCase('Flow/Tutor Add Class Flow'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(5)
						/*WebUI.callTestCase(findTestCase('Flow/Tutor Add Coupon Flow'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(5)
						WebUI.callTestCase(findTestCase('Flow/Student Class Booking Flow'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(2)
						WebUI.callTestCase(findTestCase('Flow/Tutor Request Flow'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(2)
						WebUI.callTestCase(findTestCase('Flow/Tutor Class Checking Flow'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(5)
						WebUI.callTestCase(findTestCase('Flow/Student Messge Flow'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(2)
						WebUI.callTestCase(findTestCase('Flow/Tutor Markattend Flow'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(2)
						WebUI.callTestCase(findTestCase('Flow/Tutor Add Camp Flow'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(2)
						WebUI.callTestCase(findTestCase('Flow/Student Camp Booking Flow'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(2)*/
						
			
	}
	
	WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)
//