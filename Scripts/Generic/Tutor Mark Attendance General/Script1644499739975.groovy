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
import org.openqa.selenium.JavascriptExecutor;
try
{	
	//WebUI.delay(2)
	//WebUI.refresh()
	//WebUI.delay(5)
	//WebUI.maximizeWindow()
	//def table_xpath = "//div[@class='row tutor-attendance-page tutor-tab nurtem-table mt-4']//div[@class='col-12']"
	def table_xpath ='//*[@id="root"]/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div/div/div/div'
	WebDriver driver = DriverFactory.getWebDriver()
	//WebUI.delay(2)
	String ExpectedValue = testCaseData.stu_name.trim()
	String k = testCaseData.column
	def scrol
	int p =  k.toInteger()
	def temp = 0
	String xpath1 = "(//th[@class='ant-table-cell'])[$p]"
	println('The column num is ' + xpath1)
	WebElement element1 = driver.findElement(By.xpath(xpath1))
	def date = element1.getText()
	if(temp==0) {
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'The Date is -  ' +date)
	}
	for (int z=0; z<=1; z++)
		{
	WebElement Table = driver.findElement(By.xpath(table_xpath))
	List<WebElement> Rows = Table.findElements(By.tagName('tr'))
	println('No. of rows: ' + Rows.size())	
	def rw=Rows.size()
	println('No. of rows: ' + rw)
	def e=1
	//for (int z=0; z<=2; z++)
	//{
	table: for (int i = 0; i < rw; i++)
		{
			print('i value is :'+i)
			List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
			for (int j = 0; j < Cols.size(); j++)
				{					
					if(j==0)
						{
							if (Cols.get(j).getText().equalsIgnoreCase(ExpectedValue))
								{
									print('the name is - '+Cols.get(j).getText())	
													temp = 1
													println('The column num is ' + k)
													println('The column num is ' + p)																																						
													WebElement ele = Cols.get(p).findElement(By.className('ant-checkbox-input'))
													JavascriptExecutor jse = (JavascriptExecutor)driver;
													jse.executeScript("arguments[0].click()", ele);
													WebUI.delay(1)																																																		
													def err = WebUtil.isErrorExists()
													def a = err.toString()
													println ("Value of a is : " + a)
													if (a.contains("successfully"))
														{
															WebUtil.report(testCaseName, testCaseData, 'Mark att submited succesfully :' +  a)
														}
														else
															{
																WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Mark att has error :' +  a,true)
															}
												
													
												//	WebUI.verifyElementChecked(Cols.get(2).findElement(By.className('ant-checkbox-input')),10,,FailureHandling.OPTIONAL)
								}
								if(temp==1)
								{
									break
								}
								/*else
									{
										WebUtil.report(testCaseName, testCaseData, 'wrong User: '+Cols.get(j).getText(),true)
									}*/
						}						
				}
		}
		if (temp == 1)
			{
				break
			}
		}								
}
	
catch (org.openqa.selenium.NoSuchElementException e)
{
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor request has error : ' + e.getMessage(),true)
}