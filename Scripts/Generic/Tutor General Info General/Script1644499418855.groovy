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

try {
	    
	    def general_info = "//div[normalize-space()='General Info']"
	    WebDriver driver = DriverFactory.getWebDriver()
		def click_profile = "//span[contains(text(),'My Profile')]"
	    driver.findElement(By.xpath(click_profile)).click()
	    WebUI.delay(3)
	    driver.findElement(By.xpath(general_info)).click()
	    WebUI.delay(3)
	    WebUI.setText(findTestObject('Object Repository/tutor-general-info/description'), testCaseData.description1)
	    WebUI.delay(3)
	    WebUtil.robot.keyPress(KeyEvent.VK_TAB)
	    //elewidth = WebUI.getElementWidth(findTestObject('tutor-general-info/slider'))
	    //WebUI.dragAndDropByOffset(findTestObject('tutor-general-info/slider'), elewidth + 14, 0)
	    WebUI.delay(3)
	    WebUtil.robot.keyPress(KeyEvent.VK_TAB)
		WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	    WebUtil.setText(testCaseData.certificate)//div[@class='tab-pane active']//div[@class='tutor-onboarding-scroll-height hidden-scroll-x']//div//button[@type='submit']
	    WebUI.delay(2)
		WebUtil.robot.keyPress(KeyEvent.VK_TAB)
		WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
	    WebUtil.setVal(testCaseData.noofstudents)	   
		WebUI.delay(2)
		WebUtil.robot.keyPress(KeyEvent.VK_TAB)
		WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
		WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
		WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
					//WebUI.click(findTestObject('Object Repository/tutor-general-info/submit'))
					def err = WebUtil.isErrorExists()
					def a = err.toString()
					println ("Value of a is : " + a)
					if (a.contains("General info updated successfully"))
						{
							WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor general info submitted successfully :' +  a)
						}
						else
							{
								WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor general info submission has error :' +  a,true)
							}
					
					
				
	}
	catch (org.openqa.selenium.NoSuchElementException e)
	{
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor  general info has error : ' + e.getMessage(),true)
	} 
	catch (Exception e)
	{
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor  general info has error : ' + e.getMessage(),true)
	} 

