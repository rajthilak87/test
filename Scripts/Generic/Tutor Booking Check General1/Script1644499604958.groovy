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
def ExpectedValue = testCaseData.stu_name
println('expec val : '+ExpectedValue)
WebDriver driver = DriverFactory.getWebDriver()
//def table_xpath2 = '//*[@id="rc-tabs-2-panel-1"]/div/div[2]/div/div[1]/div/div/div/div/div/div/table'
def table_xpath2 ="//div[@class='ant-tabs-tabpane ant-tabs-tabpane-active']"
WebElement Table = driver.findElement(By.xpath(table_xpath2))
List<WebElement> Rows = Table.findElements(By.tagName('tr'))	
println('No. of rows: ' + Rows.size())
def k=2
def e=1
def t=0
table: for (int i = 0; i < Rows.size(); i++)
	{
		print('i value is :'+i)		
		List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))		
		print('value of k is'+k)		
		for (int j = 0; j < Cols.size(); j++) 
			{
				if(j==0)
					{																	
						if (Cols.get(j).getText().contains(ExpectedValue))
							{
								if(e!=1)
									{
										WebUtil.reporttwo(testCaseName, testCaseData, 'This Student has already booked the class : '+Cols.get(j).getText(),true)						
									}
									else
										{
											WebUtil.reporttwo(testCaseName, testCaseData, 'Student booking verified : '+Cols.get(j).getText())
											e=2
											t=1
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
			WebUtil.reporttwo(testCaseName, testCaseData, 'Student not booked : ' + ExpectedValue,true)
		}
	WebUI.delay(2)
}
catch (org.openqa.selenium.NoSuchElementException | com.kms.katalon.core.exception.StepFailedException  e)
{
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor request has error : ' + e.getMessage(),true)
}