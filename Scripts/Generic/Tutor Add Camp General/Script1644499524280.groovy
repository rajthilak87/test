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
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.awt.event.KeyEvent as KeyEvent
import java.lang.Integer as Integer

try {
	
	// My camp link
	WebUI.click(findTestObject('Object Repository/Camp Record/Page_Nurtem/span_My Camps'))
	
	// Add Camp
	WebUI.click(findTestObject('Object Repository/Camp Record/Page_Nurtem/span_Add a Camp'))
	WebUI.delay(02)
		
	// camp service
	WebUI.click(findTestObject('Object Repository/Camp Record/Page_Nurtem/div_Clarinet'))
	//WebUtil.setVal(testCaseData.camp_about)
	WebUI.delay(3)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
	// camp name
	WebUI.click(findTestObject('Object Repository/Camp Record/Page_Nurtem/input__name'))
	WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/input__name'), testCaseData.camp_name)
	
	// camp image
	WebUtil.fileUploadHandler(findTestObject('Object Repository/Camp Record/Page_Nurtem/span_Upload'), testCaseData.picture1)
	
	// camp flyer
	WebUtil.fileUploadHandler(findTestObject('Object Repository/Camp Record/Page_Nurtem/div_Upload'), testCaseData.picture2)
	
	// camp description
	WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/div_Java is a high-level, class-based, obje_0290d3'),testCaseData.description1)
	
	//String a = testCaseData.Addon_value.toString()
	
	//println (a)
	
	// session name
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(3)
	WebUtil.setVal(testCaseData.pack_name)
	//WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/input_Session Name_session_name'), testCaseData.pack_name)
	
	// session type
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.Session_Type)
	WebUI.delay(3)
	//WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/div_Weekdays'), testCaseData.Session_Type)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
	
	if ( testCaseData.Session_Type == 'Other')
		{
			WebUtil.robot.keyPress(KeyEvent.VK_TAB)
			WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
			WebUI.delay(3)
			WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
			WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
			if ( testCaseData.Day == 'Monday')
				 {
					 WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
					 WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
			}
				else if ( testCaseData.Day == 'Tuesday')
					{
						WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
						WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
						WebUI.delay(3)
						WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
						WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
					}
					else if ( testCaseData.Day == 'Wednesday')
						{
							WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
							WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
							WebUI.delay(3)
							WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
							WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
							WebUI.delay(3)
							WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
							WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
						}
						else if ( testCaseData.Day == 'Thursday')
							{
								WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
								WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
								WebUI.delay(3)
								WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
								WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
								WebUI.delay(3)
								WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
								WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
								WebUI.delay(3)
								WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
								WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
							}
							else if ( testCaseData.Day == 'Friday')
								{
									WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
									WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
									WebUI.delay(3)
									WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
									WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
									WebUI.delay(3)
									WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
									WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
									WebUI.delay(3)
									WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
									WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
									WebUI.delay(3)
									WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
									WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
								}
								else if ( testCaseData.Day == 'Saturday')
									{
										WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
										WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
										WebUI.delay(3)
										WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
										WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
										WebUI.delay(3)
										WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
										WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
										WebUI.delay(3)
										WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
										WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
										WebUI.delay(3)
										WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
										WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
										WebUI.delay(3)
										WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
										WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
									}
									else
										{
											WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
											WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
											WebUI.delay(3)
											WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
											WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
											WebUI.delay(3)
											WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
											WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
											WebUI.delay(3)
											WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
											WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
											WebUI.delay(3)
											WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
											WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
											WebUI.delay(3)
											WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
											WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
										}
		}
	
	
	// Mode
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.teaching_mode)
	WebUI.delay(3)
	//WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/div_online'), testCaseData.teaching_mode)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
	// Learning level
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.teaching_level)
	WebUI.delay(3)
	//WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/div_Beginner'), testCaseData.teaching_level)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
	// Age Group
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.age_groups)
	WebUI.delay(3)
	//WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/div_Select Age Group'), testCaseData.age_groups)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
	// start date
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.start_date1)
	WebUI.delay(3)
	//WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/input_Start Date_start_date'), testCaseData.start_date1)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
	// end date
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	//WebUI.click(findTestObject('Object Repository/Camp Record/Page_Nurtem/input_End Date_end_date'))
	WebUtil.setVal(testCaseData.end_date1)
	WebUI.delay(3)
	//WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/input_End Date_end_date'), testCaseData.end_date1)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
	// start time
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.start_time1)
	WebUI.delay(3)
	//WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/input_Start time_start_time'), testCaseData.start_time1)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	WebUI.delay(5)
	
	// end time
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.close_time1)
	WebUI.delay(3)
	//WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/input_End time_end_time'), testCaseData.close_time1)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	WebUI.delay(5)
	
	// price
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.pack_cost1)
	//WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/input_Price_price'), testCaseData.pack_cost1)
	WebUI.delay(5)
	
	// Tax percentage
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.tax_per)
	//WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/input_Tax Percentage_tax_percentage'), testCaseData.tax_per)
	WebUI.delay(5)
	
	// Max no of seats
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.max_seats)
	//WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/input_Max no.of seats_no_of_max_students'), testCaseData.max_seats)
	WebUI.delay(5)
	
	// Location Taught
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(3)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	WebUI.delay(3)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	WebUI.delay(5)
	
	if ( testCaseData.teaching_mode == 'o') {
		
	// Meeting link
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.Meeting_link)
	WebUI.delay(5)
	
	// Meeting code
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.Meeting_Code)
	WebUI.delay(5)
	
	}
		
	// session description
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.description2)
	//WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/textarea__description'), testCaseData.description2)
	WebUI.delay(5)
	
	
	if ( testCaseData.Addon_value =='yes')
		{
			
		// Addon name
		WebUtil.robot.keyPress(KeyEvent.VK_TAB)
		WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
		//WebUI.click(findTestObject('Object Repository/Camp Record/Page_Nurtem/input__new_addon_name'))
		WebUtil.setVal(testCaseData.addon_name1)
		
		// Addon description
		WebUtil.robot.keyPress(KeyEvent.VK_TAB)
		WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
		WebUtil.setVal(testCaseData.addon_desc1)
		//WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/input__new_addon_description'), testCaseData.addon_desc1)
		
		// Addon Cost
		WebUtil.robot.keyPress(KeyEvent.VK_TAB)
		WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
		WebUtil.setVal(testCaseData.addon_cost1)
		//WebUI.setText(findTestObject('Object Repository/Camp Record/Page_Nurtem/input__new_addon_cost'), testCaseData.addon_cost1)
		
		// Addon add now
		WebUtil.robot.keyPress(KeyEvent.VK_TAB)
		WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
		WebUI.delay(3)
		WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
		WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
		//WebUI.click(findTestObject('Object Repository/Camp Record/Page_Nurtem/span_Add Now'))
		
		}
		else {
			WebUI.delay(3)
			WebUtil.robot.keyPress(KeyEvent.VK_TAB)
			WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
			WebUI.delay(3)
			WebUtil.robot.keyPress(KeyEvent.VK_TAB)
			WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
			WebUI.delay(3)
			WebUtil.robot.keyPress(KeyEvent.VK_TAB)
			WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
			WebUI.delay(3)
			WebUtil.robot.keyPress(KeyEvent.VK_TAB)
			WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
			WebUI.delay(3)
		}
	
	/*	// session addon
		WebUtil.robot.keyPress(KeyEvent.VK_TAB)
		WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
		WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
		WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
		WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
		WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
		WebUI.delay(5)  */
		
	// add now session
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(3)
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(3)
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(3)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	//WebUI.click(findTestObject('Object Repository/Camp Record/Page_Nurtem/span_Update Now'))
	WebUI.delay(5)
	
	// Submit
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(3)
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(3)
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(3)
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(3)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	//WebUI.click(findTestObject('Object Repository/Camp Record/Page_Nurtem/span_Submit'))
	WebUI.delay(20) 
	
	err = WebUtil.isErrorExists()
	
	def a = err.toString()
	if (a.contains('')) {
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Add Camp submitted successfully :' + a)
	} else {
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Add Camp submission has error :' + a, true)
	}
	
}

catch (Exception e) {
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor add class has error : ' + e.getMessage(), true)
}