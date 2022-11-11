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

String testCaseName = 'Tutor Onboarding Report'
def filterBy = ['signup', 'tutor']
def data = WebUtil.getData(GlobalVariable.projectRootPath + '\\TestDataXls\\signup.xlsx', 'signup', filterBy)
WebUtil.stopOnEmptyData(data)
for (def row : data)
	{
		WebUI.openBrowser('')
		WebUI.deleteAllCookies()
		def message = WebUI.callTestCase(findTestCase('Test Cases/Generic/Tutor Signup General'), [('testCaseName') : testCaseName, ('testCaseData') : row], FailureHandling.STOP_ON_FAILURE)
	WebUI.comment(message)			
		WebUI.delay(5)		
		def signupSuccess = WebUtil.verifyPresent('Object Repository/generic/signup_success', testCaseName, row)		
		if (signupSuccess)
			{
				WebUI.delay(5)
				WebUtil.reportAndtakeScreenshot(testCaseName, row, 'Check signup successfull screen')		
				WebUI.delay(2)
				WebUtil.verifyMail(row.mailserver, row.username, row.e_password, GlobalVariable.emailSubjectMsg, GlobalVariable.linkText,testCaseName, row)		
				WebUI.delay(5)		
				boolean EmailVerificationSuccess = WebUtil.verifyPresent('Object Repository/generic/success', testCaseName, row)		
				if (EmailVerificationSuccess)
					{
						WebUtil.reportAndtakeScreenshot(testCaseName, row, 'Tutor Email Verified  Successfully')		
						WebUI.delay(5)		
						WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)		
						WebUI.delay(1)		
						WebUI.openBrowser('')		
						WebUI.callTestCase(findTestCase('Generic/Tutor Login General'), [('testCaseName') : testCaseName, ('testCaseData') : row],
						FailureHandling.CONTINUE_ON_FAILURE)			
					}
					else
						{
							WebUtil.reportAndtakeScreenshot(testCaseName, row, 'Tutor Email Verification failed', true)
						}
				}
				else
					{
						WebUtil.reportAndtakeScreenshot(testCaseName, row, 'Tutor Signup Failed', true)
					}
			}
			String currentUrl = WebUI.getUrl(FailureHandling.CONTINUE_ON_FAILURE).toString()
			if (currentUrl.contains('complete-profile'))
			{
				testCaseName = 'Tutor Profile Report'
				filterBy = ['profile', 'tutor']
				data = WebUtil.getData(GlobalVariable.projectRootPath + '\\TestDataXls\\profile-tutor.xlsx', 'profile', filterBy)
				WebUtil.stopOnEmptyData(data)
				for (def row : data)
					{
						/*WebUI.openBrowser('')
						WebUI.deleteAllCookies()
						WebUI.callTestCase(findTestCase('Generic/Tutor Login General'), [('testCaseName') : testCaseName, ('testCaseData') : row],FailureHandling.CONTINUE_ON_FAILURE)
						WebUI.delay(5)*/
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
			}
			String currentUrl1 = WebUI.getUrl(FailureHandling.CONTINUE_ON_FAILURE).toString()
			if (currentUrl1.contains('dashboard'))
			{
				testCaseName = 'Add class Report'
				filterBy = ['add_class', 'tutor']
				data = WebUtil.getData(GlobalVariable.projectRootPath + '\\TestDataXls\\tutor_add_class_501.xlsx', 'add_class', filterBy)
				WebUtil.stopOnEmptyData(data)
				for (def row : data)
					{
						WebUI.callTestCase(findTestCase('Generic/Tutor Login General'), [('testCaseName') : testCaseName, ('testCaseData') : row],
						FailureHandling.CONTINUE_ON_FAILURE)
						/*String currentUrl = WebUI.getUrl(FailureHandling.CONTINUE_ON_FAILURE).toString()
						if (currentUrl.contains('dashboard'))
							{
								WebUI.callTestCase(findTestCase('Generic/Tutor Add Class General'), [('testCaseName') : testCaseName, ('testCaseData') : row],
									FailureHandling.CONTINUE_ON_FAILURE)
							}
							else
								{
									WebUtil.reportAndtakeScreenshot(testCaseName, row, 'It looks profile Need to be filled first / login failed')
								}
								
								WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)*/
					}
					WebUtil.generateReport(testCaseName, filterBy)
			}
			
	WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)
WebUtil.generateReport(testCaseName, filterBy)