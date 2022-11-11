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

String testCaseName = 'Student Onboarding Flow'
def filterBy = ['signup', 'student']
def data = WebUtil.getData(GlobalVariable.projectRootPath + '\\TestDataXls\\signup.xlsx', 'signup', filterBy)
WebUtil.stopOnEmptyData(data)
for (def row : data)
	{
		WebUI.openBrowser('')
		//    WebUI.maximizeWindow()
		WebUI.deleteAllCookies()
		def message = WebUI.callTestCase(findTestCase('Generic/Student Signup General'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.STOP_ON_FAILURE)	
        WebUI.delay(5)
		def signupSuccess = WebUtil.verifyPresent('Object Repository/generic/signup_success', testCaseName, row)
        if (signupSuccess)
			{
				WebUI.delay(5)
				WebUtil.reportAndtakeScreenshot(testCaseName, row, 'Student signup successfull')
				WebUI.delay(5)
				WebUtil.verifyMail(row.mailserver, row.username, row.e_password, GlobalVariable.emailSubjectMsg, GlobalVariable.linkText, testCaseName, row)
				WebUI.delay(20)
				boolean EmailVerificationSuccess = WebUtil.verifyPresent('Object Repository/generic/success', testCaseName, row)
				if (EmailVerificationSuccess)
					{
						WebUtil.reportAndtakeScreenshot(testCaseName, row, 'Email Verified  Successfull')
						WebUI.delay(5)
						WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(5)
               			WebUI.openBrowser('')
						//login with that credential
						WebUI.callTestCase(findTestCase('Generic/Student Login General'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(5)          
					}
					else
						{
							WebUtil.reportAndtakeScreenshot(testCaseName, row, 'Email Verification failed',true)
						}
			}
			else
				{
					WebUtil.reportAndtakeScreenshot(testCaseName, row, 'Signup Failed',true)
				}
	}
    
    WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)
//}

WebUtil.generateReport(testCaseName, filterBy)