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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.support.FindAll as FindAll
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.netkathir.Util as WebUtil
import java.awt.event.KeyEvent as KeyEvent
import java.awt.Robot as Robot
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection

try {
	print("value of excel" + testCaseData.type)
    if (testCaseData.type == 'individual') {
        WebUI.click(findTestObject('Object Repository/tutor-profile/Individual'))
    }
	 else {
        WebUI.click(findTestObject('Object Repository/tutor-profile/business'))
    }
    
    if (testCaseData.mode_of_teaching == "a") {
        WebUI.click(findTestObject('Object Repository/tutor-profile/studio'))
		WebUI.delay(1)
    }
    
    if (testCaseData.mode_of_teaching == "b") {
		WebUI.click(findTestObject('Object Repository/tutor-profile/studio'))
		WebUI.delay(1)
        WebUI.click(findTestObject('Object Repository/tutor-profile/online'))
		WebUI.delay(1)
    }
    
	print("Value is : " + testCaseData.mode_of_teaching)
	
    if (testCaseData.mode_of_teaching == "c") {
		WebUI.click(findTestObject('Object Repository/tutor-profile/studio'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/tutor-profile/online'))
		WebUI.delay(1)
        WebUI.click(findTestObject('Object Repository/tutor-profile/drive-to-student'))
		WebUI.delay(1)
    }
    
	if (testCaseData.type != 'individual') {
		WebUtil.setVal(findTestObject('Object Repository/tutor-profile/business_name'), testCaseData.business_name)
	}
	else {
		WebUtil.setVal(findTestObject('Object Repository/tutor-profile/first-name'), testCaseData.firstname)
		print("last name" + testCaseData.lastname)
		WebUtil.setVal(findTestObject('Object Repository/tutor-profile/last-name'), testCaseData.lastname)
		WebUI.delay(3)
	}
	WebUI.scrollToElement(findTestObject('Object Repository/tutor-profile/country'), 3)
	WebUtil.setVal(findTestObject('Object Repository/tutor-profile/country'), testCaseData.country)
	
		WebUI.delay(2)
	
		WebUtil.robot.keyPress(KeyEvent.VK_DOWN)
	
		WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
	
		WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
	
		WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
		WebUI.delay(1)
	
		WebUtil.setVal(findTestObject('Object Repository/tutor-profile/zipcode'), testCaseData.zipcode)
	
		WebUI.delay(2)
	
		WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	
		WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	
		WebUI.delay(2)
	
//		WebUtil.setVal(testCaseData.address)
		WebUtil.setVal(findTestObject('Object Repository/tutor-profile/address'), testCaseData.address)
		WebUI.delay(3)
		WebUtil.robot.keyPress(KeyEvent.VK_DOWN)	
		WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)
		WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
		WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
	
		WebUI.delay(2)
	
		WebUtil.setVal(findTestObject('Object Repository/tutor-profile/mobile with id'), testCaseData.mobile)


    WebUtil.robot.keyPress(KeyEvent.VK_TAB)

	if (testCaseData.type == 'individual')
		{
		if (testCaseData.gender == 'male') {
			WebUI.click(findTestObject('Object Repository/tutor-profile/gender-male'))
		} else if (testCaseData.gender == 'female') {
			WebUI.click(findTestObject('Object Repository/tutor-profile/gender-female'))
		} else {
		WebUI.click(findTestObject('Object Repository/tutor-profile/gender-notspecify'))
		}
		}
	
	WebUI.delay(2)
	
    
	WebUI.click(findTestObject('Object Repository/add_tutor_profile/classes-taught'))
	WebUtil.setVal(testCaseData.classes)
    WebUI.delay(5)

    WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
    WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)

    WebUtil.robot.keyPress(KeyEvent.VK_TAB)

    WebUI.delay(1)

    if (testCaseData.mode_of_teaching != 0) {
        WebUtil.setVal(testCaseData.cities)

        WebUI.delay(2)

        WebUtil.robot.keyPress(KeyEvent.VK_DOWN)

        WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)

        WebUtil.robot.keyPress(KeyEvent.VK_ENTER)

        WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
    }
    
	WebUtil.setVal(findTestObject('Object Repository/tutor-profile/business_hrs'), testCaseData.business_time) 
    
    
    WebUI.delay(2)

    WebUtil.setVal(findTestObject('Object Repository/tutor-profile/number of students'), testCaseData.num_of_students)

    WebUI.delay(1)
	WebUtil.setVal(findTestObject('tutor-profile/year-of-experiance'), testCaseData.experience)
	WebUI.delay(1)
    WebUtil.setVal(findTestObject('Object Repository/tutor-profile/profile-link'), testCaseData.profile_link)

    WebUI.delay(4)


    WebUtil.fileUploadHandler(findTestObject('Object Repository/tutor-profile/upload'), testCaseData.photo)

    WebUI.delay(2)

    WebUtil.setVal(findTestObject('Object Repository/tutor-profile/description'), testCaseData.description)

    def err = WebUtil.isErrorExists()

    if (err.size() > 0) {
        WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Profile Form : ' + err.toString(), true)

        WebUI.delay(5)
    } else {
        WebUI.click(findTestObject('Object Repository/tutor-profile/submit'))

        err = WebUtil.isErrorExists()

        def a = err.toString()

        println('Value of a is : ' + a)

        if (a.contains('Profile submitted')) {
            WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor profile submitted successfully :' + a)
        } else {
            WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor Profile submission has error :' + a, true)
        }
    }
}
catch (org.openqa.selenium.NoSuchElementException e) {
    WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor request has error : ' + e.getMessage(), true)
} 
catch (StepFailedException e) {
    WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor request has error : ' + e.getMessage(), true)
}
