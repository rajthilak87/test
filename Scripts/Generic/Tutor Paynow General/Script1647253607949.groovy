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
import java.awt.Robot as Robot
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection

import org.openqa.selenium.WebDriver as WebDriver

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

try {
	WebUI.click(findTestObject("Object Repository/tutor-add-class/add_class_link"))
	WebUI.delay(2)
	String ExpectedValue1 = testCaseData.class_name
	
	print("the class name is :"+ExpectedValue1)
	
	WebDriver driver = DriverFactory.getWebDriver()
	
	'To locate table'
	def temp=0
	page: for (int z=0; z<3; z++)
	{
		WebElement Table = driver.findElement(By.xpath('(//table/tbody)[1]'))
		List<WebElement> Rows = Table.findElements(By.tagName('tr'))
		table: for (int i = 0; i < Rows.size(); i++)
		{
			List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
			print('the colm size is'+Cols.size())
			for (int j = 0; j < Cols.size(); j++)
				{
					if(j==0)
						{
							if (Cols.get(j).getText().equalsIgnoreCase(ExpectedValue1))
								{
									Cols.get(5).findElement(By.tagName('button')).click()
									WebUI.delay(2)																		
									temp = 1
									table: break
								}
								if (temp==1)
									{
										break
									}
						}
									
				}
				if (temp==1)
					{
						break
					}
		}
		if(temp==0) {
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/bookaclass/enrol/next_button'),20,FailureHandling.OPTIONAL))
			{
				WebUI.click(findTestObject('Object Repository/bookaclass/enrol/next_button'))
			}
	}
	if (temp==1)
		{
			break
		}
	}
	
def ExpectedValue = testCaseData.stu_name
println('expec val : '+ExpectedValue)
//WebDriver driver = DriverFactory.getWebDriver()
//def table_xpath2 = '//*[@id="rc-tabs-2-panel-1"]/div/div[2]/div/div[1]/div/div/div/div/div/div/table'
//def table_xpath2 ="//div[@class='ant-tabs-tabpane ant-tabs-tabpane-active']"
def table_xpath2 ="(//div[@class='full-width'])[3]"
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
		def rr = i
		print('value of rr is - '+rr+'--')		
		for (int j = 0; j < Cols.size(); j++) 
			{
				if(j==0)
					{																	
						if (Cols.get(j).getText().contains(ExpectedValue))
							{
								if(e!=1)
									{
										WebUtil.report(testCaseName, testCaseData, 'This Student has already booked the class : '+Cols.get(j).getText(),true)						
									}
									else
										{
											WebUtil.report(testCaseName, testCaseData, 'Student booking verified : '+Cols.get(j).getText())
											WebUI.scrollToElement(findTestObject('Object Repository/tutor_paynow/scroll'), 1)
											e=2
											t=1
											String xpath123 = "(//span[contains(text(),'Pay Now')])[$rr]"
											print("the xpath is -"+xpath123)
											WebElement element1 = driver.findElement(By.xpath(xpath123))
											element1.click()
											WebUI.delay(2)
											WebUI.click(findTestObject("Object Repository/tutor_paynow/payment_options"))
											WebUI.delay(2)
											WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
											WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)
											WebUI.delay(1)
											WebUI.click(findTestObject("Object Repository/tutor_paynow/Submit"))
											WebUI.delay(2)
											if (testCaseData.teaching_type == '0')
												{
													WebUtil.setVal(findTestObject('bookaclass/session'), testCaseData.session)
													def a = testCaseData.tot_ses_cost
													BigDecimal b1 = new BigDecimal(a);
													BigDecimal b3 = b1.stripTrailingZeros();
													println(b1 + " after removing trailing zeros " + b3)
													def result = WebUI.getText(findTestObject('Object Repository/tutor_paynow/read_ses_price'))
													result = result.substring(1);
													println(" b3 is " + b3)
													BigDecimal b11 = new BigDecimal(result);
													BigDecimal b13 = b11.stripTrailingZeros();
													if (b13 == b3)
														{
															WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Session Price is correct : ' + result)
														}
													else
														{
															WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Session Price is incorrect : '+result+' , Actual price is ' + b13, true)
														}
												}
											else if(testCaseData.teaching_type == '1')
												{
													def a = testCaseData.tot_subscription_cost
													BigDecimal b1 = new BigDecimal(a);
													BigDecimal b3 = b1.stripTrailingZeros();
													println(b1 + " after removing trailing zeros " + b3)
													def result = WebUI.getText(findTestObject('Object Repository/tutor_paynow/read_ses_price'))
													result = result.substring(1);
													println(" b3 is " + b3)
													BigDecimal b11 = new BigDecimal(result);
													BigDecimal b13 = b11.stripTrailingZeros();
													if (b13 == b3)
														{
															WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Subscription Price is correct : ' + result)
														}
													else
														{
															WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Subscription Price is incorrect : '+result+' , Actual price is ' + b13, true)
														}
												}
												else
												{
													def a = testCaseData.tot_ses_cost
													BigDecimal b1 = new BigDecimal(a);
													BigDecimal b3 = b1.stripTrailingZeros();
													println(b1 + " after removing trailing zeros " + b3)
													def result = WebUI.getText(findTestObject('Object Repository/tutor_paynow/read_ses_price'))
													result = result.substring(1);
													
													BigDecimal b11 = new BigDecimal(result);
													BigDecimal b13 = b11.stripTrailingZeros();
													println(" b13 is " + b13)
													if (b13 == b3)
														{
															WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Monthly Price is correct : ' + result)
														}
													else
														{
															WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Monthly Price is incorrect'+result+ ' , Actual price is : ' + b3, true)
														}
												}
								def b = testCaseData.total_tax
								println("value of a is" + b)
								BigDecimal b6 = new BigDecimal(b);
								BigDecimal b7 = b6.stripTrailingZeros();
								println(b6 + " after removing trailing zeros " + b7)
								def resul = WebUI.getText(findTestObject('Object Repository/bookaclass/read_tax_value'))
								resul = resul.substring(1);
								resul.toString()
								println("result is" + resul)
								BigDecimal b16 = new BigDecimal(resul);
								BigDecimal b17 = b16.stripTrailingZeros();
								if (b17 == b7 )
									{
										WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tax value is correct : ' + resul)
									}
								else
									{
										WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tax value is incorrect : '+resul+ ' , Actual Tax value is ' + b7, true)
									}
								def c = testCaseData.Grand_tot
								println("value of a is" + c)
								BigDecimal b4 = new BigDecimal(c);
								BigDecimal b5 = b4.stripTrailingZeros();
								def resu = WebUI.getText(findTestObject('Object Repository/bookaclass/read_tot_value'))
								resu = resu.substring(1);
								resu.toString()
								println("result is" + resu)
								BigDecimal b14 = new BigDecimal(resu);
								BigDecimal b15 = b14.stripTrailingZeros();
								if ( b15 == b5 )
									{
										WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Total price is correct : ' + resu)
									}
								else
									{
										WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Total Price is incorrect : '+resu+ ' , Actual price is ' + b5, true)
									}
							
								WebUI.scrollToElement(findTestObject('Object Repository/bookaclass/footer_scrolldown'), 3)
								WebUI.delay(1)
								WebUtil.clickElement('Object Repository/tutor_paynow/Enroll a student final')									
											err = WebUtil.isErrorExists()
											def z = err.toString()
											if (z.contains("success"))
												{
													WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData,'Payment Submission: '+ err.toString())
												}
											else
												{
													WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData,'Payment Submission: '+ err.toString(),true)
												}
										
											/*(//span[contains(text(),'Pay Now')])[1]
											Cols.get(3).findElement(By.tagName("button"))
											WebUI.delay(2)
											WebUtil.robot.keyPress(KeyEvent.VK_TAB)
											WebUtil.robot.keyRelease(KeyEvent.VK_TAB)
											WebUtil.robot.keyPress(KeyEvent.VK_ENTER)
											WebUtil.robot.keyRelease(KeyEvent.VK_ENTER)*/
											
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
			WebUtil.report(testCaseName, testCaseData, 'Student not booked : ' + ExpectedValue,true)
		}
	WebUI.delay(2)
}
catch (org.openqa.selenium.NoSuchElementException | com.kms.katalon.core.exception.StepFailedException  e)
{
	WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Tutor request has error : ' + e.getMessage(),true)
}