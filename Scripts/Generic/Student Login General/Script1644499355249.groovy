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

String choosesigin = testCaseData.signintype

if (choosesigin == 'n') {

	WebUI.navigateToUrl((GlobalVariable.base_url), FailureHandling.STOP_ON_FAILURE)
	
	WebUtil.clickElement('sign-in/1_Student Login_link')
	
	WebUtil.submitLoginForm(testCaseName, testCaseData)	
	
} else if (choosesigin == 'f')  {
	
	WebUI.navigateToUrl((GlobalVariable.base_url), FailureHandling.STOP_ON_FAILURE)
	
	WebUtil.clickElement('sign-in/1_Student Login_link')
	
	WebUtil.studfbLoginForm(testCaseName, testCaseData)
	
} else if (choosesigin == 'g')  {
	
	WebUI.navigateToUrl((GlobalVariable.base_url), FailureHandling.STOP_ON_FAILURE)
	
	WebUtil.clickElement('sign-in/1_Student Login_link')
	
	WebUtil.studgmLoginForm(testCaseName, testCaseData)
}