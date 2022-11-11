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
	import org.openqa.selenium.By as By
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver as WebDriver
	
	import org.openqa.selenium.WebElement as WebElement
	
	import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
	
	import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.util.Calendar as Calendar
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.time.format.TextStyle as TextStyle
import java.util.Locale as Locale
import java.time.DayOfWeek;


try {
	WebDriver driver = DriverFactory.getWebDriver()
	LocalDate date = LocalDate.now(); // LocalDate = 2010-02-23
	DayOfWeek dow = date.getDayOfWeek();  // Extracts a `DayOfWeek` enum object.
	String output = dow.getDisplayName(TextStyle.FULL, Locale.US);
	println('the day is - '+output)
	def cc = testCaseData.class_name
	def f = testCaseData.day_of_week
	
		if(output.equalsIgnoreCase(f)) {
			String xpath1 = "//div[normalize-space()='$cc']"
			
			print("the xpath is -"+xpath1)
			WebElement element1 = driver.findElement(By.xpath(xpath1))
			element1.click()
			WebUI.delay(3)
		
		//def classname =	WebUI.getText(findTestObject('Object Repository/tutor_class_checking/Todays_classes'))
		String currentUrl = WebUI.getUrl(FailureHandling.CONTINUE_ON_FAILURE).toString()
		if (currentUrl.contains('class-details'))
			{
			WebUtil.report(testCaseName, testCaseData, 'Todays class is present')
			 }
				else
					{
						WebUtil.report(testCaseName, testCaseData, 'Todays class is  NOT present because today is not - '+f+'')
			}
		
		

		}
		else
			{
				WebUtil.report(testCaseName, testCaseData, 'Todays class is  NOT present because today is not - '+f+'')
	}
	

	
WebUI.click(findTestObject("Object Repository/tutor_class_checking/Dashboard"))
WebUI.delay(3)
	String ExpectedValue = testCaseData.class_name
	String nxtsession = testCaseData.next_session
	String teachinglevel = testCaseData.teaching_level

	println('expec val : '+ExpectedValue)
	def taught = testCaseData.classes_taught
	String xpath1 = "//div[normalize-space()='$taught']"
	print("the xpath is -"+xpath1)
	WebElement element1 = driver.findElement(By.xpath(xpath1))
	element1.click()
	WebUI.delay(2)
	//def table_xpath2 ="//body/div[@id='root']/div/div/div/div/div/div/div/div/div/div/div/div/div[1]"
	def table_xpath2 ='//*[@id="root"]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div'
	WebElement Table = driver.findElement(By.xpath(table_xpath2))
	List<WebElement> Rows = Table.findElements(By.tagName('tr'))
	println('No. of rows: ' + Rows.size())
	def k=2
	def e=1
	def t=0
	table: for (int i = 1; i < Rows.size(); i++)
		{
			print('i value is :'+i)
			List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
			print('value of k cols - '+Cols.size())
			for (int j = 0; j < Cols.size(); j++)
				{
					if(j==0)
						{
							print('the class name is -  '+Cols.get(1).getText())
							if (Cols.get(1).getText().equalsIgnoreCase(ExpectedValue))
								{
									if(e!=1)
										{
											WebUtil.report(testCaseName, testCaseData, 'Already created the class : '+Cols.get(1).getText(),true)
										}
										else
											{
												WebUtil.report(testCaseName, testCaseData, 'Class name correct on categories : '+Cols.get(1).getText())
												e=2
												t=1
												if (Cols.get(3).getText().equalsIgnoreCase(nxtsession))
													{
			
														WebUtil.report(testCaseName, testCaseData, 'Next session is correct on categories : '+Cols.get(3).getText())
														print('the next session is : '+Cols.get(3).getText()+'-')
													}	else
													{
														print('the next session is : '+Cols.get(3).getText()+'-')
														WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Wrong Next session displayed on categories : '+Cols.get(3).getText()+' , The correct next session is : '+nxtsession,true)
													}
													if (Cols.get(4).getText().equalsIgnoreCase(teachinglevel))
														{
				
															WebUtil.report(testCaseName, testCaseData, 'Grade is correct on categories: '+Cols.get(4).getText())
														
														}	else
														{
															
															WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Grade displayed on categories: '+Cols.get(4).getText()+' , The correct grade is : '+teaching_level,true)
														}
														GlobalVariable.seatsleft =  (Cols.get(5).getText().toInteger())
														println('the seats left is - '+GlobalVariable.seatsleft)
														WebUI.delay(1)
														//Cols.get(6).findElement(By.tagName('button')).click()
														WebElement ele = Cols.get(6).findElement(By.tagName('button'))
														JavascriptExecutor jse = (JavascriptExecutor)driver;
														jse.executeScript("arguments[0].click()", ele);
														WebUI.delay(3)
														String Class = WebUI.getText(findTestObject('Object Repository/tutor_class_checking/classname_after_click'))
														
														if (Class==ExpectedValue) {
															WebUtil.report(testCaseName, testCaseData, 'Class categories is Working : ' + Class)
														} else {
															WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, (('Class categories has diff name: ' + Class) + ' , Crct Class categories is : ') + ExpectedValue)
														}
											}
								}
								else
									{
										//WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Student not booked : '+Cols.get(j).getText()+'  correct student name is  : '+ExpectedValue,true)
									}
						}
						if(t==1)
							{
								break
							}
				}
				if(t==1)
					{
						break
					}
		}
		if (t == 0)
				{
					if(WebUI.verifyElementPresent(findTestObject('Object Repository/bookaclass/enrol/next_button'),20,FailureHandling.OPTIONAL))
					{
						WebUI.click(findTestObject('Object Repository/bookaclass/enrol/next_button'))
					}
					
				}
		WebUI.delay(2)
		
		
		

}
/*catch (StepFailedException  | Exception e) {
    WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Class checking has error - ' + e.getMessage(), true)
}*/
catch (Exception e) {
    WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Class  categories checking has error - ' + e.getMessage(), true)
}