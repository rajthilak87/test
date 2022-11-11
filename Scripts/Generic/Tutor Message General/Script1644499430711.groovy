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
	WebUI.click(findTestObject('Object Repository/message/tutor_message_link'))
	WebUI.delay(3)
	def result = WebUI.getText(findTestObject('Object Repository/message/stu_name_on_tutor'))	
		String depnvalue = testCaseData.Student_name.trim()
		print('the name is - '+result+'--')
	if (result.contains(depnvalue))
		//if (Cols.get(j).getText().equalsIgnoreCase(depnvalue))
							{
								String setmsg = testCaseData.set_message
								def result1 = WebUI.getText(findTestObject('Object Repository/message/get_msg_tutor'))
								
								if(result1 == setmsg)
								{
								WebUI.click(findTestObject('Object Repository/message/reply button'))
								WebUI.delay(3)
								}
								else
								{
									WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'WRONG MESSAGE - '+result1,true)
									return
								}
							}
							else {
								WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'WRONG STUDENT - '+result,true)
								return		
							}
							WebUI.setText(findTestObject('Object Repository/message/reply_msg_tutor'), testCaseData.reply_message)
							WebUI.delay(3)
							WebUI.click(findTestObject('Object Repository/message/tutor_reply_send'))
							WebUI.delay(3)
							def result2 = WebUI.getText(findTestObject('Object Repository/message/repy_text_tutor'))
							String repmsg = testCaseData.reply_message
							if(result2 == repmsg)
								{
								WebUtil.report(testCaseName, testCaseData, 'Msg replied successfully'+result2)
								}
								else
								{
									WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Msg was not replied - '+result2,true)									
								}							
	}
	catch (Exception e)
	{
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor Msg reply has error : ' + e.getMessage(),true)
	}