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
	/* if (testCaseData.tutortype == 'individual') {
		WebUI.click(findTestObject('Object Repository/tutor-add-class/individual_tutor_add_class'))
	} else {  */
	WebUI.delay(2)

	WebUI.click(findTestObject('Object Repository/tutor-add-class/add_class_link'))

	WebUI.delay(2)

	WebUI.click(findTestObject('Object Repository/tutor-add-class/div_Add Class'))

	WebUI.delay(2)

	// }
	bill = testCaseData.billing_type.toInteger()

	if (bill == 0) {
		print('billing type - ' + testCaseData.billing_type)
		WebUI.delay(2)
		WebUI.click(findTestObject('tutor-add-class/billing_type_0'))
	} else if (bill == 1) {
		WebUI.delay(1)
		WebUI.click(findTestObject('tutor-add-class/billing_type_1'))
	} else {
		WebUI.click(findTestObject('tutor-add-class/billing_type_2'))

		WebUI.delay(2)
		month_type = testCaseData.Monthly_type.toInteger()
		
		print(month_type)
		if (month_type == 1) {
			WebUI.click(findTestObject('Object Repository/tutor-add-class/monthly_type'))
		} else {
			WebUI.click(findTestObject('Object Repository/tutor-add-class/monthly_type1'))
		}
	}
	
	WebUI.delay(2)
	
	WebUI.click(findTestObject('Object Repository/tutor-add-class/classes_taught'))
	WebUtil.setVal(testCaseData.classes_taught)
	WebUI.delay(2)
	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)

	WebUI.setText(findTestObject('tutor-add-class/class_name'), testCaseData.class_name)

	WebUI.delay(1)
	if (testCaseData.teaching_type == 'individual') {
		WebUI.click(findTestObject('Object Repository/tutor-add-class/teaching_type_individual'))
	} else {
		WebUI.click(findTestObject('Object Repository/tutor-add-class/teaching_type_group'))

		WebUI.setText(findTestObject('tutor-add-class/input__no_of_max_students'), testCaseData.seats.toString())
	}
	
	WebUI.delay(1)
	if (testCaseData.teaching_level == 'beginner') {
		WebUI.click(findTestObject('Object Repository/tutor-add-class/teaching_level_beginner'))
	} else if (testCaseData.teaching_level == 'intermediate') {
		WebUI.click(findTestObject('Object Repository/tutor-add-class/teaching_level_Intermediate'))
	} else {
		WebUI.click(findTestObject('Object Repository/tutor-add-class/teaching_level_expert'))
	}
	
	WebUI.delay(1)
	def online = '//span[normalize-space()=\'Online\']'

	def person = '//span[normalize-space()=\'In-Person\']'

	def driv = '//span[normalize-space()=\'Drive To Student\']'

	WebDriver driver = DriverFactory.getWebDriver()

	if (testCaseData.teaching_mode == 'online') {
		WebElement element = driver.findElement(By.xpath(online))

		element.click()
	} else if (testCaseData.teaching_mode == 'drive') {
		WebElement element = driver.findElement(By.xpath(driv))

		element.click()
	} else {
		WebElement element = driver.findElement(By.xpath(person))

		element.click()
	}
	
	WebUI.delay(1)
	def age_groups = testCaseData.age_groups //0,1//1,2 //2,5//1,5//6,8//9,12//18,100

	//div[@id='age_group_label']
	xpath = " //input[@value='$age_groups']"

	WebElement element1 = driver.findElement(By.xpath(xpath))

	element1.click()

	WebUI.delay(1)
	if (testCaseData.teaching_mode == 'in_person') {
		WebUI.sendKeys(findTestObject('Object Repository/tutor-add-class/location_taught'), Keys.chord([Keys.DOWN, Keys.DOWN
					, Keys.ENTER] ))
	}
	
	WebUI.setText(findTestObject('Object Repository/tutor-add-class/tax_percentage'), testCaseData.tax_percentage)

//	WebUI.setText(findTestObject('Object Repository/tutor-add-class/input__years_of_teaching'), testCaseData.years_of_teaching)
	WebUI.delay(2)
	def classFrequencyArr = ['Every week', 'Every alternative week', 'Once in a month on', 'Twice in a month', 'Thrice in a month'
		, 'Four times in a month']

	TestObject classFrequency = findTestObject('Object Repository/tutor-add-class/input_occurrence_type')

	String val = testCaseData.class_frequency

	def index = classFrequencyArr.findIndexOf({
			it == val
		})

	def arr = []

	for (int i = 0; i <= index; i++) {
		arr.add(Keys.DOWN)
		WebUI.delay(2)
		}
	WebUI.delay(2)
	arr.add(Keys.ENTER)
	WebUI.delay(2)
	WebUI.sendKeys(classFrequency, Keys.chord(arr))
	WebUI.delay(2)
	if (testCaseData.teaching_type == 'individual') {
		WebUI.setText(findTestObject('Object Repository/tutor-add-class/duration'), testCaseData.duration)
	}
	
//	days_count = testCaseData.numofdays.toInteger()
	def days = []
	
	days = testCaseData.day_of_week.split(",")
	
	print(days)
	def day_size = days.size();
	
	print(day_size + " ")
		
	for (i=0; i<day_size; i++)
	{
		
		val1 = days[i]
		print("Value is " + val1 + " ")		
		val = "${val1.toLowerCase()}"
		println('week is - '+val)
//		WebUI.sendKeys(val)		
		WebUI.click(findTestObject('Object Repository/tutor-add-class/select_day'))
		WebUtil.setVal(val)
		WebUI.delay(2)		
		WebUtil.robot.keyPress(KeyEvent.VK_ENTER)		
		WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
		
	//	WebUI.setText(findTestObject('Object Repository/tutor-add-class/select_day'), val)
	
	/*	def dayArr = ['sunday', 'monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday']

	print(i + " ")
	val1 = days[i]
	print("Value is " + val1 + " ")
	
	val = "${val1.toLowerCase()}"
	println('week is - '+val)
	index = dayArr.findIndexOf({it == val})
	print("Index is " + index + " ")
	TestObject day_of_week = findTestObject('Object Repository/tutor-add-class/day_of_week')
	def arr1 = []
	for (int j = 0; j <= index; j++) {
		arr1.add(Keys.DOWN)		
	}	
	arr1.add(Keys.ENTER)
	print("Day of the week is " + day_of_week + " ")	
	WebUI.sendKeys(day_of_week, Keys.chord(arr1))	
	WebUI.delay(2)  */
	
		String startTime;
		String closeTime; 
		 
		if (testCaseData.teaching_type == 'group')
			{
				//		println ("start time is : " + startTime)
				startTime = (val + '_start_time')
				closeTime = (val + '_end_time')
				println('start time is : ' + startTime)
				println('close time is : ' + closeTime)
			}
			else if (testCaseData.teaching_type == 'individual')
				{
					startTime = (val + '_start_time_0')
					closeTime = (val + '_end_time_0')
					println('start time is : ' + startTime)
					println('close time is : ' + closeTime)
				}
				def x = "//input[@id='"+ startTime +"']"
				print(x)
				WebElement opening_time = driver.findElement(By.xpath(x))
				def start1
				if (testCaseData.teaching_type == 'individual')
					{
						start1 = (testCaseData.start_time1).substring(0, 5)
						println('start time is : ' + start1)
						opening_time.sendKeys(start1)
					}
					else
						{
							start1 = (testCaseData.start_time1).substring(0, 7)
							println('start time is : ' + start1)
							println('start time is : ' + opening_time)
							opening_time.sendKeys(start1)
						}
						WebUI.delay(1)
						opening_time.sendKeys(Keys.ENTER)
						WebUI.delay(1)
						def y = '//input[@id="'+ closeTime +'"]'
						WebElement close_time = driver.findElement(By.xpath(y))
						print(y)
						def close1
						if (testCaseData.teaching_type == 'individual')
							{
								close1 = (testCaseData.close_time1).substring(0, 5)
								println('start time is : ' + close1)
								close_time.sendKeys(close1)
							}
							else
								{
									close1 = (testCaseData.close_time1).substring(0, 7)
									close_time.sendKeys(close1)
								}
								//WebUI.delay(1)
								close_time.sendKeys(Keys.ENTER)
								WebUI.delay(2)
	}
	WebUI.delay(1)

	WebElement start_date = driver.findElement(By.id('occurrence_start'))

	//WebUI.delay(1)
	start_date.sendKeys(testCaseData.start_date)

	WebUI.delay(1)

	start_date.sendKeys(Keys.TAB)

	start_date.sendKeys(Keys.TAB)

	//WebUI.delay(1)
	WebElement end_date = driver.findElement(By.id('occurrence_validity'))

	//WebUI.delay(1)
	end_date.sendKeys(testCaseData.end_date)

	WebUI.delay(1)

	end_date.sendKeys(Keys.TAB)

	end_date.sendKeys(Keys.TAB)

	WebUI.setText(findTestObject('Object Repository/tutor-add-class/meeting_link'), testCaseData.meetinglink)

	WebUI.delay(1)

	WebUI.setText(findTestObject('Object Repository/tutor-add-class/passcode'), testCaseData.passcode)

	WebUI.delay(1)

	WebUI.setText(findTestObject('Object Repository/tutor-add-class/courselink'), testCaseData.course)

	WebUI.delay(1)

	WebUI.setText(findTestObject('Object Repository/tutor-add-class/test_link'), testCaseData.test)

	WebUI.delay(1)

	WebUtil.fileUploadHandler(findTestObject('Object Repository/tutor-add-class/span_Upload'), testCaseData.photo)

	WebUI.delay(2)

	WebUtil.robot.keyPress(KeyEvent.VK_TAB)

	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)

	WebUtil.setVal(testCaseData.prereq)
	
	WebUI.delay(2)
	
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)

	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)


	WebUtil.setVal(testCaseData.description)

	WebUI.delay(2)

	WebUI.setText(findTestObject('Object Repository/tutor-add-class/input__price'), testCaseData.price)

	def err = WebUtil.isErrorExists()

	if (err.size() > 0) {
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor add class form has error : ' + err.toString(),
			true)
	} else {
		WebUI.click(findTestObject('Object Repository/generic/button_Submit'))

		WebUI.delay(3)

		err = WebUtil.isErrorExists()

		def a = err.toString()

		println('Value of a is : ' + a)

		if (a.contains('success')) {
			WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor add class submitted successfully :' + a)
		} else {
			WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor add class submission has error :' + a, true)
		}
	}
}

catch (Exception e) {
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor add class has error : ' + e.getMessage(), true)
}