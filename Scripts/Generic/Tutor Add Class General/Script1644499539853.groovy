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
	
	
	
	// My class link
	WebUI.click(findTestObject('Object Repository/tutor-add-class/add_class_link'))
	
	// WebUtil.myCamp(testCaseName, row)
	
/*	WebUI.delay(2)
	String ExpectedValue = testCaseData.class_name.trim()
	print("the class name is :"+ExpectedValue)
	WebDriver driver = DriverFactory.getWebDriver()
	'To locate table'
	def temp=0
	page: for (int z=0; z<6; z++)
	{
		WebElement Table = driver.findElement(By.xpath('(//table/tbody)[1]'))
		List<WebElement> Rows = Table.findElements(By.tagName('tr'))
		println('No. of rows: ' + Rows.size())
		table: for (int i = 0; i < Rows.size(); i++)
		{
			print('i value is :'+i)
			List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
			for (int j = 0; j < Cols.size(); j++)
			{
				print("j value is :"+j)
				if (Cols.get(j).getText().equalsIgnoreCase(ExpectedValue))
				{
					Cols.get(2).findElement(By.tagName('button')).click()
					WebUtil.editclass(testCaseName, testCaseData)
					temp = 1
					table: break
					
				}
			}
			if (temp==1)
			{
				break
			}
		}
		if (temp==1)
		{
			break
		}
		WebUI.click(findTestObject('Object Repository/bookaclass/enrol/next_button'))
		int	i=0
		int	j=0
		WebUI.delay(3)
		
		if(temp==0) {
		}
	}*/
	
	// Add Class
	WebUI.click(findTestObject('Object Repository/tutor-add-class/div_Add Class'))
	WebUI.delay(02)
	
	// Class service
	WebUI.click(findTestObject('Object Repository/tutor-add-class/classes_taught'))
	// WebUtil.setVal(testCaseData.classes_taught)
	WebUI.delay(3)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
	// Class name
	WebUI.click(findTestObject('Object Repository/tutor-add-class/class_name'))
	WebUI.setText(findTestObject('Object Repository/tutor-add-class/class_name'), testCaseData.class_name)
	
	// Class image
	WebUtil.fileUploadHandler(findTestObject('Object Repository/tutor-add-class/span_Upload'), testCaseData.photo)
	
	// Class flyer
	WebUtil.fileUploadHandler(findTestObject('Object Repository/tutor-add-class/Div_Upload'), testCaseData.photo1)
	
	// Class description
	WebUI.setText(findTestObject('Object Repository/tutor-add-class/Class_Description'),testCaseData.description)
	
	
	
	// session name
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.session_name)
	WebUI.delay(3)
	
	// Teaching type
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(3)
	WebUtil.setVal(testCaseData.teaching_type)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	WebUI.delay(3)
	
	println( "Class type" +testCaseData.class_type )
	
	// Class Type
	if ( testCaseData.class_type == 'session') {
		WebUtil.robot.keyPress(KeyEvent.VK_TAB)
		WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
		WebUI.delay(3)
		WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
		WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
		WebUI.delay(3)
		WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
		WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
		}
		
		else if ( testCaseData.class_type == 'monthly') {
			WebUtil.robot.keyPress(KeyEvent.VK_TAB)
			WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
			WebUI.delay(3)
			WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
			WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
			WebUI.delay(3)
			WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
			WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
			WebUI.delay(2)
			WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
			WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
			}
	
			else {
				WebUtil.robot.keyPress(KeyEvent.VK_TAB)
				WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
				WebUI.delay(3)
				WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
				WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
				WebUI.delay(3)
				WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
				WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
				WebUI.delay(3)
				WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
				WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
				WebUI.delay(4)
				WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
				WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
			}
	
	
	// Payment Cycle
	if ( testCaseData.class_type == 'monthly') {
		
		if ( testCaseData.payment_cycle == 'fixed') {
			WebUtil.robot.keyPress(KeyEvent.VK_TAB)
			WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
			WebUI.delay(3)
			WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
			WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
			WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
			WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
			}
			else {
				WebUtil.robot.keyPress(KeyEvent.VK_TAB)
				WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
				WebUI.delay(3)
				WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
				WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
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
	WebUI.delay(4)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
	// session type
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.Session_Type)
	WebUI.delay(4)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
	
	if ( testCaseData.Session_Type == 'Other')
		{
			WebUtil.robot.keyPress(KeyEvent.VK_TAB)
			WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
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
						WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
						WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
					}
					else if ( testCaseData.Day == 'Wednesday')
						{
							WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
							WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
							WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
							WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
							WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
							WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
						}
						else if ( testCaseData.Day == 'Thursday')
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
							else if ( testCaseData.Day == 'Friday')
								{
									WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
									WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
									WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
									WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
									WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
									WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
									WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
									WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
									WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
									WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
								}
								else if ( testCaseData.Day == 'Saturday')
									{
										WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
										WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
										WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
										WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
										WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
										WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
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
											WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
											WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
											WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
											WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
											WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
											WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
										}
		}
	
	// start date
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.start_date)
	WebUI.delay(5)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
	// end date
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.end_date)
	WebUI.delay(5)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
	// start time
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.start_time1)
	WebUI.delay(5)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	WebUI.delay(5)
	
	// end time
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.close_time1)
	WebUI.delay(4)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	WebUI.delay(5)
	
	// Learning level
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.teaching_level)
	WebUI.delay(4)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
	// Age Group
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.age_groups)
	WebUI.delay(4)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
	// Location Taught
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(5)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	WebUI.delay(5)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	WebUI.delay(5)
	
	// Max no of seats
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.seats)
	WebUI.delay(5)
	
	// price
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.price)
	WebUI.delay(5)
	
	// Tax percentage
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.tax_percentage)
	WebUI.delay(5)
	
	//meeting link
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.meeting_link)
	WebUI.delay(5)
	
	//meeting code
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.meeting_code)
	WebUI.delay(5)
	
	// session description
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.description1)	
	WebUI.delay(5)
	
	// Addon name
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.addon_name1)
	
	// Addon description
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.addon_desc1)
	
	
	// Addon Cost
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setVal(testCaseData.addon_cost1)
	
	
	// Addon add now
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(2)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	WebUI.delay(3)
	
	// session addon
	/*WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	WebUI.delay(5)*/
	
	// add now session
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(2)
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(2)
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(2)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	WebUI.delay(5)
	
	def err = WebUtil.isErrorExists()
	
		if (err.size() > 0) {
			WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'add session Form : ' + err.toString(), true)
	
			WebUI.delay(5)
		}
		
			
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