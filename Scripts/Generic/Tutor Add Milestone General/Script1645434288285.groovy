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
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.WebDriver as WebDriver

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
try {
String ExpectedValue = testCaseData.class_name
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
									Cols.get(5).findElement(By.tagName('button')).click()
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
					i=0
					j=0
					WebUI.delay(3)
	}
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Milestone/Milestone button'))
	WebUI.delay(2)	
	
}
catch (org.openqa.selenium.NoSuchElementException | com.kms.katalon.core.exception.StepFailedException  e)
{
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor Milestone has error : ' + e.getMessage(),true)
}