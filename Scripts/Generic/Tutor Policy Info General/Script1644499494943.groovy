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


try
	{
		def click_profile = "//div[normalize-space()='Policies']"
		def click_profile1 = "//span[contains(text(),'My Profile')]"
		WebDriver driver = DriverFactory.getWebDriver()
		//driver.findElement(By.xpath(click_profile1)).click()
		WebUI.delay(2)
		driver.findElement(By.xpath(click_profile)).click()
		WebUI.delay(3)	
		WebUI.setText(findTestObject('Object Repository/tutor-media-info/policydescp'), testCaseData.policydescp)
		WebUI.delay(2)
		WebUtil.robot.keyPress(KeyEvent.VK_TAB)
		WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
		WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
		WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)		
						//WebUI.click(findTestObject('Object Repository/tutor-media-info/submit1'))
						def err = WebUtil.isErrorExists()
						def a = err.toString()
						println ("Value of a is : " + a)
						if (a.contains("Class Policy updated successfully."))
							{
								WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor policy info successfully :' +  a)
							}
							else
								{
									WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor policy info has error :' +  a,true)
								}
	}
	catch (org.openqa.selenium.NoSuchElementException e)
		{
			WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor policy info error : ' + e.getMessage(),true)
		}
		catch (Exception e)
			{
				WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor policy info has error : ' + e.getMessage(),true)
			}
