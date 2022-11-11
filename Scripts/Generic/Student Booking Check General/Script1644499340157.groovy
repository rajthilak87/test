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

import org.openqa.selenium.WebDriver as WebDriver

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
try {
def my_class = 	"//span[contains(text(),'My Classes')]"
WebDriver driver = DriverFactory.getWebDriver()
driver.findElement(By.xpath(my_class)).click()
WebUI.delay(5)
if(testCaseData.which_user == 'depn')
	{
		WebUI.click(findTestObject('Object Repository/message/which user'))
		WebUI.delay(2)
	}
String ExpectedValue = testCaseData.class_name.trim()
//String depnvalue = testCaseData.depn_name.trim()
WebElement Table = driver.findElement(By.xpath("//div[@class='nurtem-card-design nurtem-table py-4 mt-2 mb-3']"))

List<WebElement> Rows = Table.findElements(By.tagName('tr'))	
println('No. of rows: ' + Rows.size())
def k=2
def e=1	
table: for (int i = 1; i < Rows.size(); i++)
	{
		print('i value is :'+i)		
		List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))		
		print('value of k is'+k)		
		for (int j = 0; j < Cols.size(); j++) 
			{
				if(j==0)
					{
						if (Cols.get(j).getText().equalsIgnoreCase(ExpectedValue))
							{
								if(e!=1)
									{
										WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'class  registration has already done  : '+Cols.get(j).getText(),true)						
									}
									else
										{
											WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'class  registration : '+Cols.get(j).getText())
											e=2
										}
							}
							/*else
								{
									WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'wrong class booked : '+Cols.get(j).getText())			
								}*/
					}
					/*if(j==1)
						{
							if (Cols.get(j).getText().equalsIgnoreCase(depnvalue))
							{
								if(k!=2)
									{
										WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'class  registration has already done for the dependent : '+Cols.get(j).getText(),true)
									}
									else
										{
											WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'class  registration depn name: '+Cols.get(j).getText())
											k=3
										}
							} 
							else
								{
									WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'wrong dependent: '+Cols.get(j).getText(),true)
								}
						}*/		
			}
		}
		//WebUI.verifyElementPresent(findTestObject('Object Repository/stuenroll/New Test Object'), 3, FailureHandling.CONTINUE_ON_FAILURE)
	//WebUI.click(findTestObject('Object Repository/bookaclass/enrol/next_button'))
	//WebUI.delay(5)
//}

/*WebUI.scrollToElement(findTestObject('Object Repository/bookaclass/enrol/scroll3'),1)

 def temp1 = 0

def h = testCaseData.student_login

println("value os h is : " + h)

//def result = WebUI.getText(findTestObject('Object Repository/bookaclass/read_ses_price'))

for (int c=0; c<6; c++)
{
	WebElement Table = driver.findElement(By.xpath('//div[@class="ant-table"]'))
	
	'To locate rows of table it will Capture all the rows available in the table '
	
	List<WebElement> Rows = Table.findElements(By.tagName('tr'))
	
	// println('No. of rows: ' + Rows.size())
	
	'Find a matching text in a table and performing action'
	
	'Loop will execute for all the rows of the table'
	
	table: for (int d = 0; d < Rows.size(); d++)
	{
	
		'To locate columns(cells) of that specific row'
		
		List<WebElement> Cols = Rows.get(d).findElements(By.tagName('td'))
		
		for (int e = 0; e < Cols.size(); e++)
		{
			def l = Cols.get(e).getText()
			
			'Verifying the expected text in the each cell'
			if (l.contains(h))
			{
				'To locate anchor in the expected value matched row to perform action'
					
						WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Student is registered : ' + h )
						temp1 = 1
						break
					}
					
			}
			if (temp1 == 1)
				{
					break
				}
		}
		if (temp1 == 1)
			{
				break
			}
			
	}
	if (temp1 == 0)
	{
		WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Student is not registered : ' + h, true)
	}*/
}
catch (org.openqa.selenium.NoSuchElementException | com.kms.katalon.core.exception.StepFailedException  e)
{
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor request has error : ' + e.getMessage(),true)
}