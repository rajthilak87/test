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
    ////input[@id='classes_taught']
    ////input[@id='location_taught']
    //	WebUI.click(findTestObject('tutor-add-class/a_Tutor Dashboard'))
    WebUI.click(findTestObject("Object Repository/coupon/coupon_click"))
	WebUI.delay(2)
	WebUI.click(findTestObject("Object Repository/coupon/add_coupon"))
	WebUI.delay(2)
	WebUI.setText(findTestObject('Object Repository/coupon/coupon_name'), testCaseData.coupon_name)
	WebUI.delay(2)

    if (testCaseData.Coupon_type == 'percentage')
		{
	        WebUI.click(findTestObject('Object Repository/coupon/percentage'))
			WebUI.setText(findTestObject('Object Repository/coupon/percentage_data'), testCaseData.Percentage)
			WebUI.setText(findTestObject('Object Repository/coupon/min_value'), testCaseData.min_value)
			WebUI.setText(findTestObject('Object Repository/coupon/max_dis'), testCaseData.max_discount)
			WebUI.setText(findTestObject('Object Repository/coupon/no_of_avails'), testCaseData.num_of_avails)
		}
		else if (testCaseData.Coupon_type == 'flat')
			{
		        WebUI.click(findTestObject('Object Repository/coupon/flat'))
				WebUI.setText(findTestObject('Object Repository/coupon/amt'), testCaseData.amount)
				WebUI.setText(findTestObject('Object Repository/coupon/min_value'), testCaseData.min_value)
				WebUI.setText(findTestObject('Object Repository/coupon/no_of_avails'), testCaseData.num_of_avails)
			}
			else
				{
			        WebUI.click(findTestObject('Object Repository/coupon/item_based'))	
					WebUI.setText(findTestObject('Object Repository/coupon/no_of_dep'), testCaseData.no_of_dependent)
					WebUI.setText(findTestObject('Object Repository/coupon/amt'), testCaseData.amount)
					WebUI.setText(findTestObject('Object Repository/coupon/min_value'), testCaseData.min_value)
					WebUI.setText(findTestObject('Object Repository/coupon/max_dis'), testCaseData.max_discount)
					WebUI.setText(findTestObject('Object Repository/coupon/no_of_avails'), testCaseData.num_of_avails)
				}
				WebUI.delay(2)
				WebUI.setText(findTestObject('Object Repository/coupon/description'), testCaseData.descp)
				WebUI.delay(2)	
				WebDriver driver = DriverFactory.getWebDriver()
				WebElement start = driver.findElement(By.id('start_date'))
				WebUI.delay(1)
				start.sendKeys(testCaseData.starting_date)
				WebUI.delay(1)
			    start.sendKeys(Keys.ENTER)
			    WebUI.delay(1)
			    WebElement end = driver.findElement(By.id('end_date'))
			    WebUI.delay(1)
			    end.sendKeys(testCaseData.ending_date)
			    WebUI.delay(1)
			    end.sendKeys(Keys.ENTER)
			    def err = WebUtil.isErrorExists()
				if (err.size() > 0)
					{
						WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor add coupon has error : ' + err.toString(),true) //	WebUI.delay(2)       
					}
					else
						{
							WebUI.click(findTestObject('Object Repository/coupon/button_Submit'))		
							err = WebUtil.isErrorExists()
							def a = err.toString()
							println ("Value of a is : " + a)
							if (a.contains("success"))
								{
									WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor Login Form :' +  a)
								}
								else
									{
										WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor Login Form :' +  a,true)
									}

       						}
	}
	catch (org.openqa.selenium.NoSuchElementException e)
	{
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor add coupon has error : ' + e.getMessage(),true)
	} 
