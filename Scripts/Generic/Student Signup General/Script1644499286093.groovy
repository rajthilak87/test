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


try {
    WebUI.navigateToUrl((GlobalVariable.base_url), FailureHandling.STOP_ON_FAILURE)
    WebUI.click(findTestObject('sign-in/1_Student Login_link'))
    WebUI.click(findTestObject('sign-up/a_Signup here'))
    WebUI.setText(findTestObject('Object Repository/sign-up/username'), testCaseData.username)
    WebUI.setText(findTestObject('Object Repository/sign-up/password'), testCaseData.password)
	WebUI.delay(1)
    def err = WebUtil.isErrorExists()	
	if (err.size() > 0)
		{
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Signup Form : ' + err.toString(),true)		
		return
		}
		else
			{
				WebUI.click(findTestObject('Object Repository/sign-up/button_Submit'))
				WebUI.delay(3)
				err = WebUtil.isErrorExists()		
				def a = err.toString()
				println ("Value of a is : " + a)
				if (a.contains("success"))
					{
						WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Signup from submitted successfully :' +  a)
					}
					else
						{
							WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Signup Form submission has error : ' + err.toString(),true)
						return
						}				
						
			} 
	}
	catch (Exception e)
	{
		WebUI.delay(5)
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Signup Form : ' + e.getMessage())
	}