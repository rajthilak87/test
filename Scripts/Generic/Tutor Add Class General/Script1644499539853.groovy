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

		if (testCaseData.Monthly_type == 1) {
			WebUI.click(findTestObject('Object Repository/tutor-add-class/monthly_type'))
		} else {
			WebUI.click(findTestObject('Object Repository/tutor-add-class/monthly_type1'))
		}
	}
	
	WebUI.delay(2)

	WebUI.sendKeys(findTestObject('Object Repository/tutor-add-class/classes_taught'), Keys.chord([Keys.DOWN, Keys.ENTER]))

	//WebUI.selectOptionByLabel(findTestObject('Object Repository/tutor-add-class/classes_taught'), testCaseData.dd_name , false)
	/*    WebUI.click(findTestObject('Object Repository/tutor-add-class/classes_taught'))

	def vv = testCaseData.classes_taught_list_num

	print(('value of vv is : ' + vv) + ' -')

	if (vv != 0) {
		for (int i = 0; i != vv; i++) {
			//WebUI.sendKeys(findTestObject('Object Repository/tutor-add-class/classes_taught'), Keys.chord(Keys.DOWN))
			WebUtil.robot.keyPress(KeyEvent.VK_DOWN)

			WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
		}
		
		WebUtil.robot.keyPress(KeyEvent.VK_ENTER)

		WebUtil.robot.keyRelease(KeyEvent.VK_ENTER //WebUI.delay(1)
			)
	}  */
	WebUI.setText(findTestObject('tutor-add-class/class_name'), testCaseData.class_name)

	//WebUI.delay(1)
	if (testCaseData.teaching_type == 'individual') {
		WebUI.click(findTestObject('Object Repository/tutor-add-class/teaching_type_individual'))
	} else {
		WebUI.click(findTestObject('Object Repository/tutor-add-class/teaching_type_group'))

		WebUI.setText(findTestObject('tutor-add-class/input__no_of_max_students'), testCaseData.seats.toString())
	}
	
	//WebUI.delay(1)
	if (testCaseData.teaching_level == 'beginner') {
		WebUI.click(findTestObject('Object Repository/tutor-add-class/teaching_level_beginner'))
	} else if (testCaseData.teaching_level == 'intermediate') {
		WebUI.click(findTestObject('Object Repository/tutor-add-class/teaching_level_Intermediate'))
	} else {
		WebUI.click(findTestObject('Object Repository/tutor-add-class/teaching_level_expert'))
	}
	
	//WebUI.delay(1)
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
	
	//WebUI.delay(1)
	def age_groups = testCaseData.age_groups //0,1//1,2 //2,5//1,5//6,8//9,12//18,100

	xpath = "//div[@id='age_group_label'] //input[@value='$age_groups']"

	WebElement element1 = driver.findElement(By.xpath(xpath))

	element1.click()

	//WebUI.delay(1)
	if (testCaseData.teaching_mode == 'in_person') {
		WebUI.sendKeys(findTestObject('Object Repository/tutor-add-class/location_taught'), Keys.chord([Keys.DOWN, Keys.DOWN
					, Keys.ENTER] //WebUI.delay(1)
				))
	}
	
	WebUI.setText(findTestObject('Object Repository/tutor-add-class/tax_percentage'), testCaseData.tax_percentage)

//	WebUI.delay(1)
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
	
	def dayArr = ['sunday', 'monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday']

	val1 = testCaseData.day_of_week

	val = "${val1.toLowerCase()}"
	//println('week is - '+val)
	index = dayArr.findIndexOf({
			it == val
		})
    

	
//	TestObject day_of_week = findTestObject('Object Repository/tutor-add-class/day_of_week')
	week_day = findTestObject('Object Repository/tutor-add-class/day_of_week')
//	String csvLine = "IND,PAK,USA,AUS";
	def list = week_day
	for (def item : list) {
	print(item)
	}
		
	def arr1 = []

	for (int i = 0; i <= index; i++) {
		arr1.add(Keys.DOWN)
	}
//	arr1.add(Keys.DOWN)
	WebUI.delay(1)
	arr1.add(Keys.ENTER)

	WebUI.sendKeys(day_of_week, Keys.chord(arr1))

	WebUI.delay(2)
	
	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	
	if (testCaseData.teaching_type == 'individual')
		{
			WebUtil.setVal(findTestObject('Object Repository/tutor-add-class/duration'), testCaseData.duration)
		}

	/* start1 = testCaseData.start_time1.substring(0, 7)

	close1 = testCaseData.close_time1.substring(0, 7)

	WebUtil.robot.keyPress(KeyEvent.VK_TAB)

	WebUI.delay(1)

	WebUtil.setText(start1)

	WebUI.delay(1)

	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)

	WebUI.delay(1)

	//WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)

  //  WebUI.delay(1)

  //  WebUtil.robot.keyPress(KeyEvent.VK_TAB)

	WebUI.delay(1)

	//WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUtil.setText(close1)

	WebUI.delay(1)

	WebUtil.robot.keyPress(KeyEvent.VK_ENTER)

	WebUI.delay(1)

	WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)

	WebUI.delay(1)  

		WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	
	def v = testCaseData.numofdays.toInteger()

	if (v > 0) {
		for (int c = 0; c < v; c++) {
			//print("value of c is " + c)
			WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
			WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
		}
	}
	
	if 	(testCaseData.numofdays ==2 ) {
		
		//def dayArr1 = ['sunday','monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday']
		val1 = testCaseData.day_of_week1
		   
		index = dayArr.findIndexOf({ it == val1  })
		day_of_week = findTestObject('Object Repository/tutor-add-class/day_of_week')
		//def arr1 = []
		for (int i = 0; i <= index; i++)
			{
				arr1.add(Keys.DOWN)
			}
			arr1.add(Keys.ENTER)
			WebUI.sendKeys(day_of_week1, Keys.chord(arr1))
			WebUI.delay(2)
	
		if (testCaseData.teaching_type == 'individual')
		{
			WebUtil.setVal(findTestObject('Object Repository/tutor-add-class/duration'), testCaseData.duration)
		}
		String startTime;
		String closeTime; } */
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
//				WebUI.delay(1)
//				println('start time is : ' + startTime)
		//		WebElement opening_time = driver.findElement(By.id(startTime))
				def x = "//input[@id='"+ startTime +"']"
				print(x)
			//	WebElement element21 = driver.findElement(By.id(x))
				WebElement opening_time = driver.findElement(By.xpath(x))
		//		println('start time is : ' + opening_time)
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
//						WebElement close_time = driver.findElement(By.id(closeTime))	
						def y = '//input[@id="'+ closeTime +'"]'					
						WebElement close_time = driver.findElement(By.xpath(y))
						print(y)
						//WebUI.delay(1)
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
	//WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	//WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	//WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	//WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	WebUI.delay(1)

	/*   if (v > 0) {
		for (int n = 1; n <= v; n++) {
			//WebUtil.robot.keyPress(KeyEvent.VK_TAB)
			WebUtil.robot.keyPress(KeyEvent.VK_TAB)

			WebUtil.setText(testCaseData.start_time1)

			WebUtil.robot.keyPress(KeyEvent.VK_ENTER)

			//WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
			WebUtil.robot.keyPress(KeyEvent.VK_TAB)

			WebUtil.robot.keyPress(KeyEvent.VK_TAB)

			//WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
			WebUtil.setText(testCaseData.close_time1)

			WebUtil.robot.keyPress(KeyEvent.VK_ENTER)

			WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)

			WebUI.delay(1)
		}
	}   */
	//WebUI.delay(1)
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

	//WebUI.setText(findTestObject('Object Repository/tutor-add-class/desc'), testCaseData.description)
	WebUtil.setVal(testCaseData.prereq)
	
	WebUI.delay(2)
	
	WebUtil.robot.keyPress(KeyEvent.VK_TAB)

	WebUtil.robot.keyRelease(KeyEvent.VK_TAB)

	//WebUI.setText(findTestObject('Object Repository/tutor-add-class/desc'), testCaseData.description)
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

		if (a.contains('Class created successfully.')) {
			WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor add class submitted successfully :' + a)
		} else {
			WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor add class submission has error :' + a, true)
		}
	}
}
catch (Exception e) {
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor add class has error : ' + e.getMessage(), true)
}