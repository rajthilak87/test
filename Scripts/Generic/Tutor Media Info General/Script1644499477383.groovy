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
	WebDriver driver = DriverFactory.getWebDriver()
	def click_profile = "//span[contains(text(),'My Profile')]"
	
		def click_media = "//div[normalize-space()='Media & Annoncements']"
		
		def click_profile1 = "//span[contains(text(),'My Profile')]"
		driver.findElement(By.xpath(click_profile1)).click()
		WebUI.delay(3)
		//driver.findElement(By.xpath(click_profile)).click()
		WebUI.delay(3)
		driver.findElement(By.xpath(click_media)).click()
		
		WebUI.delay(3)
		WebUI.setText(findTestObject('Object Repository/tutor-media-info/video_link'), testCaseData.videolink)	
		WebUI.click(findTestObject('Object Repository/tutor-media-info/add_button'))	
		if (testCaseData.editvideolink == 'yes')
			{
				WebUI.click(findTestObject('Object Repository/tutor-media-info/del_button1'))
			}							
			WebUI.delay(2)				
			WebUI.setText(findTestObject('Object Repository/tutor-media-info/audio_link'), testCaseData.audiolink)	
			WebUI.click(findTestObject('Object Repository/tutor-media-info/add_button2'))	
			if (testCaseData.editaudiolink == 'yes')
				{
					WebUI.click(findTestObject('Object Repository/tutor-media-info/del_button2'))
				}
			WebUI.setText(findTestObject('Object Repository/tutor-media-info/announcement'), testCaseData.announcement)	
			WebUI.delay(2)			
			WebUtil.robot.keyPress(KeyEvent.VK_TAB)
			WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
			WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
			WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)		
							//WebUI.sendKeys(findTestObject('Object Repository/tutor-media-info/submit'), Keys.chord(Keys.ENTER))
							def err = WebUtil.isErrorExists()
							def a = err.toString()
							println ("Value of a is : " + a)
							if (a.contains("Media and announcement updated successfully."))
								{
									WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor media info successfully :' +  a)
								}
								else
									{
										WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor media info has error :' +  a,true)
									}
						
	}
		catch (org.openqa.selenium.NoSuchElementException e)
			{
				WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor media info has error : ' + e.getMessage(),true)
			}
			catch (Exception e)
				{
					WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor media info has error : ' + e.getMessage(),true)
				}