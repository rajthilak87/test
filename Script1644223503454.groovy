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
	WebUI.delay(2)
	def  table_xpath = '(//div[@class="ant-table"])[1]'
	/*if(GlobalVariable.Classtype == 'camp') {
	def  table_xpath = '(//div[@class="ant-table"])[1]'
	}
	else {
		def table_xpath = '//div[@class="ant-table"]'
	}*/
	WebDriver driver = DriverFactory.getWebDriver()
	WebUI.delay(2)
	String ExpectedValue = testCaseData.user.trim()
	String depnvalue = testCaseData.class_name.trim()
	def temp = 0
	//for (int z=0; z<=1; z++)
	//	{
	WebElement Table = driver.findElement(By.xpath(table_xpath))
	List<WebElement> Rows = Table.findElements(By.tagName('tr'))
	println('No. of rows: ' + Rows.size())
	def rw=Rows.size()
	println('No. of rows: ' + rw)
	def e=1
	//for (int z=0; z<=2; z++)
	//{
	table: for (int i = 0; i < 2; i++)
		{
			print('i value is :'+i)
			List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
			//println('No. of rows: ' + Cols.size())
			for (int j = 0; j < Cols.size(); j++)
				{
					print('No. of rows: ' + Cols.size())
					print('NAME in 1st : ' +Cols.get(j).getText())
					if(j==0)
						{
							if (Cols.get(j).getText().equalsIgnoreCase(ExpectedValue))
								{
									print('the name is - '+Cols.get(j))
									//if(j==1)
									//{
										if (Cols.get(j).getText().equalsIgnoreCase(depnvalue))
										{
												
											
											if (testCaseData.request_Type == '0')
												{
													temp = 1
													//WebUI.click(findTestObject("Object Repository/request/accept"))
													Cols.get(2).findElement(By.tagName('button')).click()
													WebUI.delay(1)
													TestObject alertModelTestObjectNo = findTestObject('Object Repository/request/no')
													if (alertModelTestObjectNo == null)
														{
															WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'request accept failed')
															return
														}
														else
															{
																WebUtil.clickElement('Object Repository/request/confirm')
																def err = WebUtil.isErrorExists()
																err = WebUtil.isErrorExists()
																def a = err.toString()
																println ("Value of a is : " + a)
																if (a.contains("success"))
																	{
																	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'request accepeted:' +  a)
																	}
																	else
																		{
																			WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'request accepting failed' +  a,true)
																		}
															}
												}
												else
													{
														temp = 1
														WebUI.click(findTestObject("Object Repository/request/reject"))
														//Cols.get(3).findElement(By.tagName('button')).click()
														TestObject alertModelTestObjectNo1 = findTestObject('Object Repository/request/no')
															if (alertModelTestObjectNo1 == null)
																{
																	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'request accept failed')
																	return
																}
																else
																	{
																		WebUtil.clickElement('Object Repository/request/confirm')
																		err = WebUtil.isErrorExists()
																		def b = err.toString()
																		println ("Value of b is : " + b)
																		if (b.contains("success"))
																				{
																					WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'request canceled:' +  b)
																				}
																				else
																					{
																						WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'request cancelation failed' +  b,true)
																					}
																	}
													}
									}
									else
										{
											WebUtil.report(testCaseName, testCaseData, 'wrong Class '+Cols.get(j).getText(),true)
										}
								}
								else
									{
										WebUtil.report(testCaseName, testCaseData, 'Wrong Name '+Cols.get(j).getText(),true)
									}
						}
				}
				if (temp == 1)
					{
						break
					}
		}
}
//}
catch (org.openqa.selenium.NoSuchElementException e)
{
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor request has error : ' + e.getMessage(),true)
}