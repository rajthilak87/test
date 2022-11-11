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
		def div_addcamp	= 		"//a[normalize-space()='Add a Camp']"
		def addcamp   	=		"(//button[@type='submit'])[1]"
		def addon_add	=		"//button[@type='button']//span[contains(text(),'Add Now')]"
		def addon_cost	=		"//input[@class='ant-input-number-input' and @name='new_addon_cost']"
		def addon_desc	=		"//input[@class='ant-input' and @name='new_addon_description']"
		def addon_min	=		"//input[@id='no_of_min_addons']"
		def addon_name	=		"//input[@class='ant-input' and @name='new_addon_name']"
		def agegroup	=		"//div[@id='age_group_label' and @class='ant-checkbox-group']"
		def camp_about	=		"//input[@id='camps_taught']"
		def camp_name	=		"(//input[@id='name'])[1]"
		def package_name =      "(//input[@id='name'])[2]"
		def pack_cost	=		"//input[@id='price']"
		def description =	 	"//div[@class='notranslate public-DraftEditor-content']"
		def image1		=		"//div[@class='ant-upload-text']"
		def input_submit =		"(//button[@type='submit'])[2]"
		def mand		=		"//button[@name='new_addon_mandat']"
		def max_seats	=		"//input[@id='no_of_max_students']"
		def tax_percentage	=	"//input[@id='tax_percentage']"
		def pack_desc	=		"//textarea[@id='description']"
		def teaching_level_beginner	 = "//span[normalize-space()='Beginner']"
		def teaching_level_expert	=  "//span[normalize-space()='Expert']"
		def teaching_level_intermediate	= "//span[normalize-space()='Intermediate']"
		def teaching_mode_inperson	=	"//span[normalize-space()='In-Person']"
		def teaching_mode_online	=	"//span[normalize-space()='Online']" 
		def addcamp_link	= 		"//span[contains(text(),'My Camps')]"			
		WebDriver driver = DriverFactory.getWebDriver()		
		driver.findElement(By.xpath(addcamp_link)).click()
		WebUI.delay(3)		
		driver.findElement(By.xpath(div_addcamp)).click()
		WebUI.delay(3)		
		driver.findElement(By.xpath(camp_about)).sendKeys(testCaseData.camp_about)		
		WebUI.delay(3)		
		//WebUtil.robot.keyPress(KeyEvent.VK_DOWN)		
		//WebUtil.robot.keyRelease(KeyEvent.VK_DOWN)	
		WebUtil.robot.keyPress(KeyEvent.VK_ENTER)		
		WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)	
		driver.findElement(By.xpath(camp_name)).sendKeys(testCaseData.camp_name)		
		def teaching_level1 = testCaseData.teaching_level 
		String xpath1 = "//div[@id='levels'] //input[@value='$teaching_level1']"
		driver.findElement(By.xpath(xpath1)).click()
		WebUI.delay(1)
		def teaching_mode1 = testCaseData.teaching_mode		
		String xpath2 = "//div[@id='teaching_mode'] //input[@value='$teaching_mode1']"		
		driver.findElement(By.xpath(xpath2)).click()	
		WebUI.delay(1)
		driver.findElement(By.xpath(max_seats)).sendKeys(testCaseData.max_seats)	
		WebUI.delay(1)
		WebUtil.fileUploadHandler(findTestObject('Object Repository/tutor_add_camp/image'),testCaseData.picture1)	
		WebUI.delay(1)
		driver.findElement(By.xpath(description)).sendKeys(testCaseData.description1)	
		WebUI.delay(1)
		def age_group = testCaseData.age_groups //'0,1' //1,2 //2,5//1,5//6,8//9,12//18,100		
		xpath = "//div[@id='age_group_label'] //input[@value='$age_group']"		
		WebElement element1 = driver.findElement(By.xpath(xpath))	
		element1.click()	
		WebUI.delay(1)
		driver.findElement(By.xpath(tax_percentage)).sendKeys(testCaseData.tax_per)		
		WebUI.delay(1)
		driver.findElement(By.xpath(package_name)).sendKeys(testCaseData.pack_name)		
		WebUI.delay(1)
		WebElement start_date3 = driver.findElement(By.xpath('//input[@id="start_date"]'))
		WebUI.delay(1)
		start_date3.sendKeys(testCaseData.start_date1)
		WebUI.delay(1)
		start_date3.sendKeys(Keys.TAB)
		start_date3.sendKeys(Keys.TAB)
		WebUI.delay(1)		
		WebElement end_date2 = driver.findElement(By.xpath('//input[@id="end_date"]'))
		WebUI.delay(1)
		end_date2.sendKeys(testCaseData.end_date1)
		WebUI.delay(1)
		end_date2.sendKeys(Keys.TAB)
		end_date2.sendKeys(Keys.TAB)
		WebUI.delay(1)				
		WebElement start_time3 = driver.findElement(By.xpath('//input[@id="start_time"]'))
		WebUI.delay(1)
		start_time3.sendKeys(testCaseData.start_time1)
		WebUI.delay(1)
		start_time3.sendKeys(Keys.ENTER)			
		WebElement end_time2 = driver.findElement(By.xpath('//input[@id="end_time"]'))
		WebUI.delay(1)
		end_time2.sendKeys(testCaseData.close_time1)
		WebUI.delay(1)
		end_time2.sendKeys(Keys.ENTER)
		//end_time2.sendKeys(Keys.TAB)
		WebUI.delay(1)		
		driver.findElement(By.xpath(pack_cost)).sendKeys(testCaseData.pack_cost1)
		WebUI.delay(1)
		driver.findElement(By.xpath(pack_desc)).sendKeys(testCaseData.pack_desc1)		
		WebUI.delay(1)
		driver.findElement(By.xpath(addcamp)).submit();		
		def err = WebUtil.isErrorExists()		
		if (err.size() > 0)
			{
				WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor add camp has error : ' + err.toString(),true)
				return
			}
			driver.findElement(By.xpath(addon_min)).sendKeys(testCaseData.min_addons)
			WebUI.delay(1)
			driver.findElement(By.xpath(addon_name)).sendKeys(testCaseData.addon_name1)
			WebUI.delay(1)
			driver.findElement(By.xpath(addon_desc)).sendKeys(testCaseData.addon_desc1)
			WebUI.delay(1)
			driver.findElement(By.xpath(addon_cost)).sendKeys(testCaseData.addon_cost1)  	
			WebUI.delay(1)
			if (testCaseData.mandatory == '1')
				{
					driver.findElement(By.xpath(mand)).click()
				} 					
				WebUI.delay(2)
				driver.findElement(By.xpath(addon_add)).click();			
				err = WebUtil.isErrorExists()		
				if (err.size() > 0)
					{
						WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor add camp with addon has error : ' + err.toString(),true)
					}
					else
						{  
							driver.findElement(By.xpath(input_submit)).submit();
							err = WebUtil.isErrorExists()						
							def a = err.toString()
							println ("Value of a is : " + a)
							if (a.contains("successfully"))
								{								
									WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor add camp submitted sucesfully : ' + a)
								}
							else
								{
								WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor add camp has submission error'+a,true)
								}													
						}
	}
	catch (org.openqa.selenium.NoSuchElementException | Exception e)
	{
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor add camp has error : ' + e.getMessage(),true)
	} 