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
import org.openqa.selenium.support.FindAll as FindAll
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.netkathir.Util as WebUtil
import java.awt.event.KeyEvent as KeyEvent
import java.awt.Robot as Robot
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection
try
{

String profileurl = WebUI.getUrl(FailureHandling.CONTINUE_ON_FAILURE) 
if(profileurl.contains('user/dashboard'))
	{
		WebUtil.clickElement('profile/1_profile_link')
	} 
WebUtil.fileUploadHandler(findTestObject('profile/profile_img'), testCaseData.photo)
WebUtil.logger.logInfo('profile photo set')
WebUI.delay(3)
WebUtil.setVal(findTestObject('profile/input_firstname'), testCaseData.firstname.trim())
WebUI.delay(1)
WebUtil.setVal(findTestObject('profile/input_lastname'), testCaseData.lastname.trim())
WebUI.delay(1)
WebUtil.setVal(findTestObject('profile/input_mobile_number'), testCaseData.mobile)
WebUtil.setVal(findTestObject('profile/input_age'), testCaseData.age)
WebUtil.robot.keyPress(KeyEvent.VK_TAB)
String genderToSelect = testCaseData.gender.toLowerCase()
WebUI.delay(2)
if (genderToSelect == 'male')
	{
		WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
		WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
		WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
		WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	}
	else if (genderToSelect == 'female')
		{
			WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
			WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
			WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
			WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
			WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
			WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
		}
		else
			{
				WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
				WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
				WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
				WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
				WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
				WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
				WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
				WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
			}
WebUtil.setVal(findTestObject('profile/input_address'), testCaseData.address)
WebUI.delay(3)
WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
WebUtil.setVal(findTestObject('profile/input_zip_code'), testCaseData.zipcode)
			def err = WebUtil.isErrorExists()
			if (err.size() > 0)
				{
					WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Profile Form : ' + err.toString())

				}
				else
					{
						WebUtil.clickElement('profile/input_submit1')

						err = WebUtil.isErrorExists()
						def z = err.toString()
						println(z)
						if (z.contains("Success"))
							{
								WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData,'Student Profile Submited'+ z)
							}
							else
								{
									WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData,'Student submitting has error '+ z,true)
								}
								TestObject alertModelTestObjectNo = findTestObject('Object Repository/profile/alert_model_button_press_no')
								if (alertModelTestObjectNo == null)
									{
										WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Profile Submit failed')		
									} 
									else
										{
											WebUtil.clickElement('Object Repository/profile/alert_model_button_press_yes')
										} 
					}
					if(testCaseData.depn_action==0)
						{
							WebUtil.clickElement('Object Repository/profile/dependent_delete')
						}
						else if(testCaseData.depn_action==1)
							{
								WebUtil.clickElement('Object Repository/profile/dependent_edit')}
								WebUtil.setVal(findTestObject('profile/firstname'), testCaseData.firstname1)
								WebUtil.setVal(findTestObject('profile/age'), testCaseData.age1)
								WebUtil.robot.keyPress(KeyEvent.VK_TAB)
								//WebUtil.clickElement('profile/gender_dept')
								String gender2 = testCaseData.gender1.toLowerCase()
								WebUI.delay(3)
								if (gender2 == 'male')
									{
										WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
										WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
										WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
										WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
									}
									else if (gender2 == 'female')
										{
											WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
											WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
											WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
											WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
											WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
											WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
										}
										else
											{
												WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
												WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
												WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
												WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
												WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
												WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
												WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
												WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
											}
											WebUtil.setVal(findTestObject('profile/relationship'), testCaseData.relationship)
											WebUtil.setVal(findTestObject('profile/dependent_email'), testCaseData.email1)
											WebUtil.setVal(findTestObject('profile/create_password'), testCaseData.password1)
											WebUtil.setVal(findTestObject('profile/confirm_password'), testCaseData.newpassword)
											//WebUI.scrollToElement(findTestObject('Object Repository/tutor-profile/footer'), 3)
											//WebUI.delay(3)
											err = WebUtil.isErrorExists()
											if (err.size() > 0)
												{
													WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Profile Form : ' + err.toString(),true)
												}
												else
													{
														WebUtil.clickElement('profile/input_submit2')
														err = WebUtil.isErrorExists()
														def z = err.toString()
														if (z.contains("successfully"))
															{
																WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData,'Dependent Submited'+z)
															}
															else
																{
																	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData,'Dependent submitting has error '+ z,true)
																}
													}
}
catch (org.openqa.selenium.NoSuchElementException | com.kms.katalon.core.exception.StepFailedException  e)
{
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor request has error : ' + e.getMessage(),true)
}
WebUI.closeBrowser()