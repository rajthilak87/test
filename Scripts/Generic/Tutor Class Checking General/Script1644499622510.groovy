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
import java.util.Calendar as Calendar
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.time.format.TextStyle as TextStyle
import java.util.Locale as Locale
import java.time.DayOfWeek;

WebUtil.classCheck(testCaseName, testCaseData)
WebDriver driver = DriverFactory.getWebDriver()

try {
    def teaching = WebUI.getText(findTestObject('Object Repository/tutor_class_checking/teaching_type'))

    WebUI.scrollToElement(findTestObject('Object Repository/tutor_class_checking/teaching_type'), 1)

    a = testCaseData.teaching_mode

    if (teaching.contains(a)) {
        WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Teaching mode is CORRECT : ' + teaching)
    } else {
        WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, (('Teaching mode displayed is : ' + 
            teaching) + ' ,  crct teaching mode is : ') + a, true)
    }
    
    /*def age = WebUI.getText(findTestObject('Object Repository/tutor_class_checking/teaching_type'))
		b=testCaseData.age_groups
		if(age.contains(b))
		{
			WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'age group is CORRECT : ' + age)
		}
		else
			{
				WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'age group is InCORRECT : ' + age,true)
			}*/
    def ses = WebUI.getText(findTestObject('Object Repository/tutor_class_checking/session_price'))

    c = testCaseData.tot_session_price

    ses = ses.substring(1)

    if (ses == c) {
        WebUtil.report(testCaseName, testCaseData, 'Sesion price is CORRECT : ' + ses)
    } else {
        WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, (('Session price is displayed is : ' + 
            ses) + ' , correct price is : ') + c, true)
    }
	d = testCaseData.num_session
	WebUI.scrollToElement(findTestObject('Object Repository/tutor_class_checking/time'), 1)
	/*String xpath1 = "//div[normalize-space()='$d']"
	print("the xpath is -"+xpath1)
	WebElement element1 = driver.findElement(By.xpath(xpath1))
	element1.getText()
	def num_ses = element1
    def num_ses = WebUI.getText(findTestObject('Object Repository/tutor_class_checking/num_of_session'))
	print('the num of ses is - '+num_ses)
    

    if (num_ses == d) {
        WebUtil.report(testCaseName, testCaseData, 'Number of sesion is CORRECT : ' + num_ses)
    } else {
        WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, (('Number of session displayed is: ' + num_ses) + ' , Crct num of session is : ') + d, true)
    }*/
    
    def freq = WebUI.getText(findTestObject('Object Repository/tutor_class_checking/class_frequency'))

    e = testCaseData.class_frequency

    if (freq == e) {
        WebUtil.report(testCaseName, testCaseData, 'Class freq is CORRECT : ' + freq)
    } else {
        WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, (('Class freq is displayed is : ' + 
            freq) + '  crct class freq is : ') + e, true)
    }
    
    //def week = WebUI.getText(findTestObject('Object Repository/tutor_class_checking/week_day'))

    String f = testCaseData.day_of_week	
	f = f.substring(0, 1).toUpperCase() + f.substring(1);
	println ('the week is - '+f+'-')
	String xpath1 = "//div[normalize-space()='$f']"
	print("the xpath is -"+xpath1)
	WebElement element1 = driver.findElement(By.xpath(xpath1))
	
	def numses = element1.getText()
	//equalsIgnoreCase
    if (numses==f) {
        WebUtil.report(testCaseName, testCaseData, 'Week is CORRECT : ' + numses)
    } else {
        WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, (('Week is INCORRECT,week displayed is ' + numses) + '  Crct week is : ') + 
            f, true)
    }
    
  /*  def time = WebUI.getText(findTestObject('Object Repository/tutor_class_checking/time'))

    g = testCaseData.time

    if (time == g) {
        WebUtil.report(testCaseName, testCaseData, 'Time is CORRECT : ' + time)
    } else {
        WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, (('Time is INCORRECT,Time displayed is ' + time) + '  Crct time is : ') + 
            g, true)
    }
    
    def enroll = WebUI.getText(findTestObject('Object Repository/tutor_class_checking/enroll')).toInteger()
	//def table_xpath3 = '//*[@id="rc-tabs-2-panel-1"]/div/div[2]/div/div[1]/div/div/div/div/div/div/table'
	def table_xpath3 = "//div[@class='full-width']//div[contains(@class,'hidden-scroll-x')]"
    WebElement Table1 = driver.findElement(By.xpath(table_xpath3))

    List<WebElement> Row = Table1.findElements(By.tagName('tr'))

    int r = Row.size()

    if (enroll > 0) {
        int seats = WebUI.getText(findTestObject('Object Repository/tutor_class_checking/seats')).toInteger()

        int St = testCaseData.seats.toInteger()

        print('the row size is' + r)

        r = (r - 1)

        print('the row size is' + r)

        def resu = St - r

        print('number of seats in excel' + St)

        print('stu booked is   ' + resu)

        if (seats == resu) {
            WebUtil.report(testCaseName, testCaseData, 'Seats is CORRECT : ' + resu)
        } else {
            WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, (('Seats is InCORRECT,seats displayed is : ' + seats) + 
                '  crct seats is : ') + resu, true)
        }
        
        if (enroll == r) {
            WebUtil.report(testCaseName, testCaseData, 'Number of enrollment is CORRECT : ' + r)
        } else {
            WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, (('Number of enrollment is InCORRECT,enroll displayed is : ' + 
                enroll) + '  crct enroll is : ') + r, true)
        }
    } else {
        int seats = WebUI.getText(findTestObject('Object Repository/tutor_class_checking/seats')).toInteger()

        print('Seats is' + seats)

        WebUtil.report(testCaseName, testCaseData, 'No one has booked so the total seats left is : ' + 
            seats)
    }
	if(enroll == GlobalVariable.seatsleft) {
		WebUtil.report(testCaseName, testCaseData, 'Number of seats is CORRECT in class categories : '+GlobalVariable.seatsleft )
	}
	else {
		WebUtil.report(testCaseName, testCaseData, (('Number of seats in class cat is InCORRECT,enroll displayed is : ' +GlobalVariable.seatsleft) + '  crct seats is : ') + r, true)
	}
	
	
		

}
catch (StepFailedException  | Exception e) {
    WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Class checking has error - ' + e.getMessage(), true)
}*/
}
catch (Exception e) {
    WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Class checking has error - ' + e.getMessage(), true)
}