package com.netkathir
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.constants.StringConstants

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.keyword.internal.IKeyword
import com.kms.katalon.core.keyword.internal.KeywordExecutionContext
import com.kms.katalon.core.keyword.internal.KeywordExecutor
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUIHelper
import internal.GlobalVariable
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import com.kms.katalon.core.testdata.reader.ExcelFactory
import java.io.IOException
import java.lang.IllegalArgumentException
import java.text.MessageFormat
import javax.mail.Folder as Folder
import javax.mail.Message as Message
import javax.mail.MessagingException as MessagingException
import javax.mail.NoSuchProviderException as NoSuchProviderException
import javax.mail.Session as Session
import javax.mail.Store as Store
import javax.mail.Message.RecipientType as RecipientType
import javax.mail.search.AndTerm as AndTerm
import javax.mail.search.RecipientStringTerm as RecipientStringTerm
import javax.mail.search.SearchTerm as SearchTerm
import javax.mail.search.SubjectTerm as SubjectTerm
import com.sun.mail.util.SocketConnectException as SocketConnectException
import java.util.Properties as Properties
import javax.mail.Address as Address
import javax.mail.BodyPart as BodyPart
import javax.mail.Multipart as Multipart
import javax.mail.internet.MimeMultipart as MimeMultipart
import javax.mail.internet.MimeBodyPart as MimeBodyPart
import org.jsoup.Jsoup as Jsoup
import org.jsoup.nodes.Document as Document
import org.jsoup.nodes.Element as Element
import org.jsoup.select.Elements as Elements
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar as Calendar
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.time.format.TextStyle as TextStyle
import java.util.Locale as Locale
import java.time.DayOfWeek;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFHyperlink
import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.common.usermodel.HyperlinkType
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.Keys

public class Util {

	private static Robot robot = new Robot();

	private static KeywordLogger logger = KeywordLogger.getInstance(KeywordUtil.class);
	/**
	 * Get AbsoluteUrl
	 * @param String relativeUrlName
	 * @return String absoluteUrl
	 */
	@Keyword
	def static String getAbsoluteUrl(String relativeUrlName) {
		if(GlobalVariable.url == null) {
			Util.logger.logFailed("Please choose the right profile" )
		}else {
			String sign_in_page_url = GlobalVariable.url  + "/"  +  relativeUrlName
			return sign_in_page_url;
		}
	}


	/**
	 * Find element
	 * @param String name,
	 *  
	 */
	@Keyword
	def static WebElement getWebElement(String name) {

		try {
			WebElement element = WebUI.findWebElement(findTestObject(name));
			Util.logger.logInfo("Element found " + name);
			return element;
		} catch (WebElementNotFoundException e) {
			Util.logger.logInfo("Element not found (" + name + ")" )
		} catch (Exception e) {
			Util.logger.logInfo("Element not found (" + name + ") with Exception Message " + e.getMessage())
		}
	}

	/**
	 * Click element
	 * @param String name,
	 * @param TestObject to
	 */
	@Keyword
	def static void clickElement(String name) {
		try {
			WebElement element = Util.getWebElement(name);
			element.click()

			Util.logger.logInfo("Element has been clicked (" + name + ")" )
		} catch (Exception e) {
			Util.logger.logInfo("Element has NOT been clicked (" + name + ")")
		}
	}


	def static isErrorExists() {
		//check; is there any error message in the DOM/form
		TestObject errortestObject = findTestObject('Object Repository/generic/role-alert')
		List<WebElement> errormessage = WebUIHelper.findWebElements(errortestObject,10)

		def arr = [];

		if (errormessage.size() > 0) {
			errormessage.each {arr.add(it.getText())}
		}
		return arr
	}
	def static isErrorExistsEnroll() {
		//check; is there any error message in the DOM/form
		TestObject errortestObject = findTestObject('Object Repository/generic/role-alert')
		List<WebElement> errormessage = WebUIHelper.findWebElements(errortestObject,2)

		def arr = [];

		if (errormessage.size() > 0) {
			errormessage.each {arr.add(it.getText())}
		}
		return arr
	}


	/*	def static isErrorExistsformval() {
	 //check; is there any error message in the DOM/form
	 TestObject errortestObject = findTestObject('Object Repository/generic/role-alert')
	 List<WebElement> errormessage = WebUIHelper.findWebElements(errortestObject,20)
	 def arr = [];
	 if (errormessage.size() > 0) {
	 errormessage.each {arr.add(it.getText())}
	 }
	 def a = arr.toString()
	 println("value of a is" + a)
	 if(a.contains("success"))
	 {
	 arr.clear()
	 return arr
	 }
	 else  {
	 return arr
	 }
	 } */

	def static void reportAndtakeScreenshotIfErrorExists(String name, Map data, String msg) {
		WebUI.delay(1)
		def err = Util.isErrorExists();

		if(err.size() > 0) {
			Util.reportAndtakeScreenshot(name, data,msg + " : " +  err.toString())
			WebUI.delay(5)
		}
	}

	/**
	 * Submit LoginForm
	 * @param String name,
	 * @param TestObject to
	 */
	@Keyword
	def static void submitLoginForm(String tcName="", Map data=[:]) {

		try {
			//Fill user name
			WebUI.setText(findTestObject('sign-in/2_username_field'), data.username)

			//fill password
			WebUI.setText(findTestObject('sign-in/3_password_field'), data.password)
			WebUI.delay(1)

			//def err = Util.isErrorExists()

			/*if (err.size() > 0) {
			 Util.reportAndtakeScreenshot(tcName, data, 'Login Form:' +  err.toString(),true)
			 //WebUI.delay(2)
			 } else {*/
			Util.clickElement('Object Repository/sign-in/student_login_button')
			//WebUI.delay(2)
			def err = Util.isErrorExists()
			def a = err.toString()
			println ("Value of a is : " + a)
			if (a.contains("Error"))
			{

				Util.reportAndtakeScreenshot(tcName, data, 'Student Login Form Submission has error :' +  a,true)
			}else {
				Util.reportAndtakeScreenshot(tcName, data, 'Student Login Form submitted succesfully :' +  a)
				//	GlobalVariable.proceed =true;
			}
			/*if (a.contains("User login successfully."))
			 {
			 Util.reportAndtakeScreenshot(tcName, data, 'Student Login Form submitted successfully :' +  a)
			 } else if (a.contains("Warning"))
			 {
			 Util.reportAndtakeScreenshot(tcName, data, 'Student Login Form submitted successfully :' +  a)
			 }
			 else {
			 Util.reportAndtakeScreenshot(tcName, data, 'Student Login Form has error :' +  a,true)
			 //	GlobalVariable.proceed =true;
			 }*/
			//}

		}catch (StepFailedException e) {
			WebUI.delay(5)
			Util.reportAndtakeScreenshot(tcName, data, "Step Failed : Error at try catch block of login form submit")
		}
	}


	def static void tutorLoginForm1(String tcName="", Map data=[:]) {
		try {
			WebUI.setText(findTestObject('sign-in/tutor/username'), data.tutor_username)
			WebUI.setText(findTestObject('sign-in/tutor/password'), data.tutor_password)
			WebUI.delay(1)
			def err = Util.isErrorExists()
			Util.clickElement('sign-in/4_Login_submit_button')
			WebUI.delay(2)
			def a = err.toString()
			println ("Value of a is : " + a)
			if (a.contains("Error"))
			{
				Util.reportAndtakeScreenshot(tcName, data, 'Tutor Login Form Submission has error :' +  a,true)
			}else {
				Util.reportAndtakeScreenshot(tcName, data, 'Tutor Login Form submitted succesfully :' +  a)
			}
		}
		catch (Exception e) {
			WebUI.delay(5)
			Util.reportAndtakeScreenshot(tcName, data, 'Error in Tutor Login Form with Message: ' + e.getMessage())
		}
	}

	def static void studfbLoginForm(String tcName="", Map data=[:]) {

		try {
			//Fill user name
			WebUI.delay(1)
			def err = Util.isErrorExists()

			if (err.size() > 0) {

				Util.reportAndtakeScreenshot(tcName, data, 'Login Form:' +  err.toString())
			}else {
				//submit form
				Util.fblogin(findTestObject('Object Repository/sign-in/student_login_fb',), data.fb_username, data.fb_password)

				//check for error after submitting form
				err = Util.isErrorExists()
				if (err.size() > 0) {

					Util.reportAndtakeScreenshot(tcName, data, 'Student Login Form :' +  err.toString())
				}else {
					Util.reportAndtakeScreenshot(tcName, data, 'Login form Successfuly submitted')
					GlobalVariable.proceed =true;
				}
			}

		}catch (StepFailedException e) {
			WebUI.delay(5)
			Util.reportAndtakeScreenshot(tcName, data, "Step Failed : Error at try catch block of login form submit")
		}
	}


	def static void studgmLoginForm(String tcName="", Map data=[:]) {

		try {
			//Fill user name
			WebUI.delay(1)
			def err = Util.isErrorExists()

			if (err.size() > 0) {

				Util.reportAndtakeScreenshot(tcName, data, 'Login Form:' +  err.toString())
			}else {
				//submit form
				Util.gmlogin(findTestObject('Object Repository/sign-in/student_login_gm',), data.gm_username, data.gm_password)

				//check for error after submitting form
				err = Util.isErrorExists()
				if (err.size() > 0) {

					Util.reportAndtakeScreenshot(tcName, data, 'Student Login Form :' +  err.toString())
				}else {
					Util.reportAndtakeScreenshot(tcName, data, 'Login form Successfuly submitted')
					GlobalVariable.proceed =true;
				}
			}

		}catch (StepFailedException e) {
			WebUI.delay(5)
			Util.reportAndtakeScreenshot(tcName, data, "Step Failed : Error at try catch block of login form submit")
		}
	}
	/**
	 * Submit LoginForm
	 * @param String name,
	 * @param TestObject to
	 */
	@Keyword
	def static void tutorLoginForm(String tcName="", Map data=[:]) {
		try {
			WebUI.setText(findTestObject('sign-in/tutor/username'), data.username)
			WebUI.setText(findTestObject('sign-in/tutor/password'), data.password)
			WebUI.delay(1)
			/*def err = Util.isErrorExists()
			 if (err.size() > 0) {
			 Util.reportAndtakeScreenshot(tcName, data, 'Tutor Login Form:' +  err.toString(),true)
			 WebUI.delay(2)
			 } else {*/
			//submit form
			Util.clickElement('sign-in/4_Login_submit_button')
			//WebUI.delay(2)
			//check for error after submitting form
			def err = Util.isErrorExists()
			def a = err.toString()
			println ("Value of a is : " + a)
			if (a.contains("Error"))
			{

				Util.reportAndtakeScreenshot(tcName, data, 'Tutor Login Form Submission has error :' +  a,true)
			}else {
				Util.reportAndtakeScreenshot(tcName, data, 'Tutor Login Form submitted succesfully :' +  a)
				//	GlobalVariable.proceed =true;
			}

			//}



		}catch (Exception e) {
			WebUI.delay(5)
			Util.reportAndtakeScreenshot(tcName, data, 'Error in Tutor Login Form with Message: ' + e.getMessage())
		}
	}


	def static void tutfbLoginForm(String tcName="", Map data=[:]) {

		try {
			//Fill user name
			WebUI.delay(1)
			def err = Util.isErrorExists()

			if (err.size() > 0) {

				Util.reportAndtakeScreenshot(tcName, data, 'Tutor Login Form:' +  err.toString())
			}else {
				//submit form
				Util.fblogin(findTestObject('Object Repository/sign-in/tutor/tutor_fb_link',), data.fb_username, data.fb_password)

				//check for error after submitting form
				err = Util.isErrorExists()
				if (err.size() > 0) {

					Util.reportAndtakeScreenshot(tcName, data, 'Tutor Login Form :' +  err.toString())
				}else {
					Util.reportAndtakeScreenshot(tcName, data, 'Login form Successfuly submitted')
					GlobalVariable.proceed =true;
				}
			}

		}catch (StepFailedException e) {
			WebUI.delay(5)
			Util.reportAndtakeScreenshot(tcName, data, "Step Failed : Error at try catch block of login form submit")
		}
	}


	def static void tutgmLoginForm(String tcName="", Map data=[:]) {

		try {
			//Fill user name
			WebUI.delay(1)
			def err = Util.isErrorExists()

			if (err.size() > 0) {

				Util.reportAndtakeScreenshot(tcName, data, 'Tutor Login Form:' +  err.toString())
			}else {
				//submit form
				Util.gmlogin(findTestObject('Object Repository/sign-in/tutor/tutor_gm_link',), data.gm_username, data.gm_password)

				//check for error after submitting form
				err = Util.isErrorExists()
				if (err.size() > 0) {

					Util.reportAndtakeScreenshot(tcName, data, 'Tutor Login Form :' +  err.toString())
				}else {
					Util.reportAndtakeScreenshot(tcName, data, 'Login form Successfuly submitted')
					GlobalVariable.proceed =true;
				}
			}

		}catch (StepFailedException e) {
			WebUI.delay(5)
			Util.reportAndtakeScreenshot(tcName, data, "Step Failed : Error at try catch block of login form submit")
		}
	}


	/**
	 * verify the Presents of text in the DOM and log also return true / false
	 * @param String text
	 * @return Boolean
	 */
	def static boolean verifyPresent(String name, String tcName="", Map data=[:]) {
		try {
			WebElement element = WebUI.findWebElement(findTestObject(name));
			println ("value of element is : " + element)
			if(element != null && element.isDisplayed()) {
				return true
			}else {
				return false
			}
		}catch (StepFailedException | WebElementNotFoundException | IllegalArgumentException | NullPointerException e) {
			Util.reportAndtakeScreenshot(tcName, data, 'Error with Message: ' + e.getMessage(), true)
			return false
		}
	}



	def static void verifyPresentAndLog(String text) {
		try {

			WebUI.verifyTextPresent(text, false);
			Util.logger.logPassed('Successfull')
		} catch (StepFailedException e) {
			Util.logger.logInfo("Failed!!!")
			KeywordUtil.markErrorAndStop("Stopped  the Testcase")
		}
	}


	def static void stopOnEmptyData(data) {
		if ((data == null) || (data.isEmpty())) {
			Util.logger.logFailed("Data is empty / null")
			KeywordUtil.markErrorAndStop("Stopped  the Testcase")
		}
	}

	/**
	 * File upload pop-up form hander
	 * @param TestObject to
	 * @param String filePath
	 */

	def static void fileUploadHandler(TestObject to, String filePath) {
		//WebUI.focus(to)
		WebUI.click(to)
		WebUI.delay(3) //weight to open the file upload pop-up window;

		StringSelection strsel = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strsel, null);
		WebUI.delay(1) //Delay

		//Robot robot = new Robot();
		Util.robot.keyPress(KeyEvent.VK_CONTROL);
		Util.robot.keyPress(KeyEvent.VK_V);
		Util.robot.keyRelease(KeyEvent.VK_V);
		Util.robot.keyRelease(KeyEvent.VK_CONTROL);
		Util.robot.keyPress(KeyEvent.VK_ENTER);
		Util.robot.keyRelease(KeyEvent.VK_ENTER);
	}

	def static void fblogin(TestObject to, String Un, String Pw) {
		//WebUI.focus(to)
		WebUI.click(to)
		WebUI.delay(2) //weight to open the file upload pop-up window;

		StringSelection strsel = new StringSelection(Un);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strsel, null);
		WebUI.delay(1) //Delay

		//Robot robot = new Robot();
		Util.robot.keyPress(KeyEvent.VK_CONTROL);
		Util.robot.keyPress(KeyEvent.VK_V);
		Util.robot.keyRelease(KeyEvent.VK_V);
		Util.robot.keyRelease(KeyEvent.VK_CONTROL);
		Util.robot.keyPress(KeyEvent.VK_TAB);

		WebUI.delay(3)

		StringSelection strselc = new StringSelection(Pw);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strselc, null);
		WebUI.delay(1) //Delay

		Util.robot.keyPress(KeyEvent.VK_CONTROL);
		Util.robot.keyPress(KeyEvent.VK_V);
		Util.robot.keyRelease(KeyEvent.VK_V);
		Util.robot.keyRelease(KeyEvent.VK_CONTROL);
		Util.robot.keyPress(KeyEvent.VK_ENTER);
		Util.robot.keyRelease(KeyEvent.VK_ENTER);
	}

	def static void gmlogin(TestObject to, String Un, String Pw) {
		//WebUI.focus(to)
		WebUI.click(to)
		WebUI.delay(2) //weight to open the file upload pop-up window;

		StringSelection strsel = new StringSelection(Un);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strsel, null);
		WebUI.delay(1) //Delay

		//Robot robot = new Robot();
		Util.robot.keyPress(KeyEvent.VK_CONTROL);
		Util.robot.keyPress(KeyEvent.VK_V);
		Util.robot.keyRelease(KeyEvent.VK_V);
		Util.robot.keyRelease(KeyEvent.VK_CONTROL);
		Util.robot.keyPress(KeyEvent.VK_TAB);
		WebUI.delay(2)
		Util.robot.keyPress(KeyEvent.VK_TAB);
		Util.robot.keyPress(KeyEvent.VK_ENTER);
		Util.robot.keyRelease(KeyEvent.VK_ENTER);

		WebUI.delay(2)

		StringSelection strselc = new StringSelection(Pw);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strselc, null);
		WebUI.delay(1) //Delay

		Util.robot.keyPress(KeyEvent.VK_CONTROL);
		Util.robot.keyPress(KeyEvent.VK_V);
		Util.robot.keyRelease(KeyEvent.VK_V);
		Util.robot.keyRelease(KeyEvent.VK_CONTROL);
		Util.robot.keyPress(KeyEvent.VK_ENTER);
		Util.robot.keyRelease(KeyEvent.VK_ENTER);
	}


	def static void pastValue(String value) {

		StringSelection strsel = new StringSelection(value);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strsel, null);

		Util.robot.keyPress(KeyEvent.VK_CONTROL);
		Util.robot.keyPress(KeyEvent.VK_V);
		Util.robot.keyRelease(KeyEvent.VK_V);
	}

	/**
	 * Set value using JWT Robot api
	 * @param field
	 * @param value
	 * @return void
	 */

	def static void setVal(TestObject field, String value) {

		try {
			WebUI.sendKeys(field, Keys.chord(Keys.CONTROL, 'a'))
			WebUI.sendKeys(field, Keys.chord(Keys.BACK_SPACE))
			WebUI.setText(field, value)
			WebUI.delay(1)

		} catch (java.lang.IllegalStateException | StepFailedException e) {
			Util.logger.logInfo("cannot open system clipboard");
		}


	}



	def static void setVal(String value) {

		try {
			StringSelection strsel = new StringSelection(value);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strsel, null);
			WebUI.delay(1) //Delay

			Util.robot.keyPress(KeyEvent.VK_CONTROL)
			Util.robot.keyPress(KeyEvent.VK_A)
			Util.robot.keyRelease(KeyEvent.VK_A)
			Util.robot.keyRelease(KeyEvent.VK_CONTROL)

			Util.robot.keyPress(KeyEvent.VK_CONTROL)
			Util.robot.keyPress(KeyEvent.VK_V)
			Util.robot.keyRelease(KeyEvent.VK_V)
			Util.robot.keyRelease(KeyEvent.VK_CONTROL)
			WebUI.delay(1)

		} catch (java.lang.IllegalStateException | StepFailedException e) {
			Util.logger.logInfo("cannot open system clipboard");
		}


	}


	def static void setText(String value) {

		try {
			StringSelection strsel = new StringSelection(value);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strsel, null);
			WebUI.delay(1) //Delay
			Util.robot.keyPress(KeyEvent.VK_CONTROL)
			Util.robot.keyPress(KeyEvent.VK_V)
			Util.robot.keyRelease(KeyEvent.VK_V)
			Util.robot.keyRelease(KeyEvent.VK_CONTROL)
			WebUI.delay(1)

		} catch (java.lang.IllegalStateException | StepFailedException e) {
			Util.logger.logInfo("cannot open system clipboard");
		}


	}


	/*
	 * Generater report
	 */
	def static void generateReport(String tcName, def filterBy) {

		String fileName = GlobalVariable.projectRootPath + "\\Screenshots\\" + tcName + ".xlsx";

		def data = Util.getData(fileName, 'Error_report', filterBy)

		Map myFailedList = [:];
		Map myList = [:];

		for(row in data) {
			if(row['Report'] =='Failed') {
				myFailedList[row['TestCase']] = row['Report'];

			}else {
				myList[row['TestCase']] = row['Report'];
			}
		}

		def successList = [:];
		for(def lst in myList) {
			if(!myFailedList.containsKey(lst.key)) {
				successList[lst.key] =lst.value;
			}
		}


		Util.logger.logInfo("****************************************")
		Util.logger.logInfo("**********TEST CASE REPORT**************")
		Util.logger.logInfo("****************************************")

		//log error test cases
		for(def list in myFailedList) {
			Util.logger.logInfo("Test Case " + list.key + " Failed");
		}

		Util.logger.logInfo("****************************************")
		// log Successful test cases
		for(def list in successList) {
			Util.logger.logInfo("Test Case " + list.key + " Passed");
		}
		Util.logger.logInfo("****************************************")

		Util.logger.logInfo("Total Number of test cases:" + ((int) myFailedList.size() + (int) successList.size()))
		Util.logger.logInfo("Number of Failed test cases:" + myFailedList.size())
		Util.logger.logInfo("Number of passed test cases:" + successList.size())
		Util.logger.logInfo("****************************************")
		Util.logger.logInfo("****************************************")


	}

	def static void generateData(String tcName='', Map data = [:], String msg='', String msg1='', String msg2='', String msg3='', String msg4='',String msg5='',String msg6='',String msg7='',boolean reportErr=false) {

		Util.logger.logInfo(tcName)
		Util.logger.logInfo(data.toString())

		//get element and show to the user for debugging
		def timestamp = new Date().format("YYYY-MM-dd-HH-mm-ss")
		String url = WebUI.getUrl()

		String pathToScreenshots = GlobalVariable.projectRootPath + "\\Screenshots\\" + timestamp + '.png';
		//com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
		WebUI.takeScreenshot(pathToScreenshots, ["text" : msg, "x" : 10, "y" : 5], FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(1)

		try {


			String fileName = GlobalVariable.projectRootPath + "\\Screenshots\\" + tcName + ".xlsx";
			def file = new File(fileName);
			if(file.exists()) {



				def excelData = ExcelFactory.getExcelDataWithDefaultSheet(fileName,"Error_report", true);

				def existingRows = excelData.getAllData()

				FileInputStream fisxls = new FileInputStream(fileName)
				XSSFWorkbook workbook = new XSSFWorkbook(fisxls)
				CreationHelper createHelper = workbook.getCreationHelper();
				XSSFSheet sheet = workbook.getSheet("Error_report")


				Row row = sheet.createRow(existingRows.size() + 1)


				data.eachWithIndex { entry, i ->
					Cell cell = row.createCell(i)
					cell.setCellValue(entry.value)
					sheet.autoSizeColumn(i)
				}


				CellStyle bgStyle = workbook.createCellStyle();

				if(reportErr)
				{
					bgStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
					bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

					Cell cell = row.createCell(data.size() + 10)
					cell.setCellValue('Failed')
					cell.setCellStyle(bgStyle);

					sheet.autoSizeColumn(data.size() + 10)
				}else {
					bgStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
					bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

					Cell cell = row.createCell(data.size() + 10)
					cell.setCellValue('Passed')
					cell.setCellStyle(bgStyle);

					sheet.autoSizeColumn(data.size() + 10)
				}


				Font linkFont = workbook.createFont();
				linkFont.setItalic(true);
				linkFont.setFontHeightInPoints((short) 12);
				linkFont.setColor(IndexedColors.BLUE.getIndex());

				CellStyle linkFontStyle = workbook.createCellStyle();
				linkFontStyle.setFont(linkFont);

				String path = './Screenshots/' + timestamp + '.png';
				//create next cell
				Cell imgcell = row.createCell(data.size() + 1);
				imgcell.setCellValue(path)
				imgcell.setCellStyle(linkFontStyle)
				sheet.autoSizeColumn(data.size() + 1)

				Cell msgcell = row.createCell(data.size() + 2);
				msgcell.setCellValue(msg)
				sheet.autoSizeColumn(data.size() + 2)

				Cell msgcell1 = row.createCell(data.size() + 3);
				msgcell1.setCellValue(msg1)
				sheet.autoSizeColumn(data.size() + 3)

				Cell msgcell2 = row.createCell(data.size() + 4);
				msgcell2.setCellValue(msg2)
				sheet.autoSizeColumn(data.size() + 4)

				Cell msgcell3 = row.createCell(data.size() + 5);
				msgcell3.setCellValue(msg3)
				sheet.autoSizeColumn(data.size() + 5)

				Cell msgcell4 = row.createCell(data.size() + 6);
				msgcell4.setCellValue(msg4)
				sheet.autoSizeColumn(data.size() + 6)

				Cell msgcell5 = row.createCell(data.size() + 7);
				msgcell5.setCellValue(msg5)
				sheet.autoSizeColumn(data.size() + 7)

				Cell msgcell6 = row.createCell(data.size() + 8);
				msgcell6.setCellValue(msg6)
				sheet.autoSizeColumn(data.size() + 8)

				Cell msgcell7 = row.createCell(data.size() + 9);
				msgcell7.setCellValue(msg7)
				sheet.autoSizeColumn(data.size() + 9)

				String screenshotPath = new File(path).toURI().toString();

				def link = (XSSFHyperlink) createHelper.createHyperlink(HyperlinkType.valueOf("FILE"));
				link.setAddress(screenshotPath);
				imgcell.setHyperlink(link);

				FileOutputStream fos = new FileOutputStream(fileName);
				workbook.write(fos);
				fos.close();
			}else {

				XSSFWorkbook workbook = new XSSFWorkbook();
				CreationHelper createHelper = workbook.getCreationHelper();

				// Create a Font for styling header cells
				Font headerFont = workbook.createFont();
				headerFont.setBold(true);
				headerFont.setFontHeightInPoints((short) 14);
				headerFont.setColor(IndexedColors.GREEN.getIndex());

				CellStyle headerCellStyle = workbook.createCellStyle();
				headerCellStyle.setFont(headerFont);


				XSSFSheet sheet = workbook.createSheet("Error_report");
				Row rowHeader = sheet.createRow(0);

				CellStyle bgStyle = workbook.createCellStyle();


				//set header Row
				data.eachWithIndex { entry, i ->
					Cell cell = rowHeader.createCell(i)
					cell.setCellValue(entry.key)
					sheet.autoSizeColumn(i)
					cell.setCellStyle(headerCellStyle)
				}

				Cell imgcellHeader = rowHeader.createCell(data.size() + 1);
				imgcellHeader.setCellValue("Path To Screenshots")
				imgcellHeader.setCellStyle(headerCellStyle)

				Cell msgcellHeader = rowHeader.createCell(data.size() + 2);
				msgcellHeader.setCellValue("url")
				msgcellHeader.setCellStyle(headerCellStyle)

				Cell msgcellHeader1 = rowHeader.createCell(data.size() + 3);
				msgcellHeader1.setCellValue("Provider name")
				msgcellHeader1.setCellStyle(headerCellStyle)

				Cell msgcellHeader2 = rowHeader.createCell(data.size() + 4);
				msgcellHeader2.setCellValue("contact_name")
				msgcellHeader2.setCellStyle(headerCellStyle)

				Cell msgcellHeader3 = rowHeader.createCell(data.size() + 5);
				msgcellHeader3.setCellValue("Designation")
				msgcellHeader3.setCellStyle(headerCellStyle)

				Cell msgcellHeader4 = rowHeader.createCell(data.size() + 6);
				msgcellHeader4.setCellValue("Address")
				msgcellHeader4.setCellStyle(headerCellStyle)

				Cell msgcellHeader5 = rowHeader.createCell(data.size() + 7);
				msgcellHeader5.setCellValue("Website")
				msgcellHeader5.setCellStyle(headerCellStyle)

				Cell msgcellHeader6 = rowHeader.createCell(data.size() + 8);
				msgcellHeader6.setCellValue("Services 1")
				msgcellHeader6.setCellStyle(headerCellStyle)

				Cell msgcellHeader7 = rowHeader.createCell(data.size() + 9);
				msgcellHeader7.setCellValue("Services 2")
				msgcellHeader7.setCellStyle(headerCellStyle)

				Cell msg1cellHeader = rowHeader.createCell(data.size() + 10);
				msg1cellHeader.setCellValue("Report")
				msg1cellHeader.setCellStyle(headerCellStyle)

				//add first row
				Row firstRow = sheet.createRow(1);
				data.eachWithIndex { entry, i ->
					Cell cell = firstRow.createCell(i)
					cell.setCellValue(entry.value)
					sheet.autoSizeColumn(i)
				}

				if(reportErr)
				{
					Cell cell1 = firstRow.createCell(data.size() + 3)
					cell1.setCellValue('Failed')
					bgStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
					bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

					cell1.setCellStyle(bgStyle)
					sheet.autoSizeColumn(data.size() + 3)
				}else {
					Cell cell2 = firstRow.createCell(data.size() + 3)
					cell2.setCellValue('Passed')
					bgStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
					bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
					cell2.setCellStyle(bgStyle);
					sheet.autoSizeColumn(data.size() + 3)
				}

				Font linkFont = workbook.createFont();
				linkFont.setItalic(true);
				linkFont.setFontHeightInPoints((short) 12);
				linkFont.setColor(IndexedColors.BLUE.getIndex());

				CellStyle linkFontStyle = workbook.createCellStyle();
				linkFontStyle.setFont(linkFont);

				String path = './Screenshots/' + timestamp + '.png';
				String screenshotPath = new File(path).toURI().toString();
				//create next cell
				Cell imgcell = firstRow.createCell(data.size() + 1);
				imgcell.setCellValue(path)
				imgcell.setCellStyle(linkFontStyle)
				sheet.autoSizeColumn(data.size() + 1)

				Cell msgcell = firstRow.createCell(data.size() + 2);
				msgcell.setCellValue(msg)
				sheet.autoSizeColumn(data.size() + 2)


				def link = (XSSFHyperlink) createHelper.createHyperlink(HyperlinkType.valueOf("FILE"));
				link.setAddress(screenshotPath);
				imgcell.setHyperlink(link);

				FileOutputStream fos = new FileOutputStream(fileName);
				workbook.write(fos);
				fos.close();

			}
		} catch (FileNotFoundException e) {
			Util.logger.logInfo(e.getMessage())
		} catch (IOException e) {
			Util.logger.logInfo(e.getMessage())
		}

	}


	def static void reportAndtakeScreenshot(String tcName='', Map data = [:], String msg='',boolean reportErr=false) {

		Util.logger.logInfo(tcName)
		Util.logger.logInfo(data.toString())

		//get element and show to the user for debugging
		def timestamp = new Date().format("YYYY-MM-dd-HH-mm-ss")
		String url = WebUI.getUrl()

		String pathToScreenshots = GlobalVariable.projectRootPath + "\\Screenshots\\" + timestamp + '.png';
		//com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
		WebUI.takeScreenshot(pathToScreenshots, ["text" : msg, "x" : 10, "y" : 5], FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(1)

		try {


			String fileName = GlobalVariable.projectRootPath + "\\Screenshots\\" + tcName + ".xlsx";
			def file = new File(fileName);
			if(file.exists()) {



				def excelData = ExcelFactory.getExcelDataWithDefaultSheet(fileName,"Error_report", true);

				def existingRows = excelData.getAllData()

				FileInputStream fisxls = new FileInputStream(fileName)
				XSSFWorkbook workbook = new XSSFWorkbook(fisxls)
				CreationHelper createHelper = workbook.getCreationHelper();
				XSSFSheet sheet = workbook.getSheet("Error_report")


				Row row = sheet.createRow(existingRows.size() + 1)


				data.eachWithIndex { entry, i ->
					Cell cell = row.createCell(i)
					cell.setCellValue(entry.value)
					sheet.autoSizeColumn(i)
				}


				CellStyle bgStyle = workbook.createCellStyle();

				if(reportErr)
				{
					bgStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
					bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

					Cell cell = row.createCell(data.size() + 3)
					cell.setCellValue('Failed')
					cell.setCellStyle(bgStyle);

					sheet.autoSizeColumn(data.size() + 3)
				}else {
					bgStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
					bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

					Cell cell = row.createCell(data.size() + 3)
					cell.setCellValue('Passed')
					cell.setCellStyle(bgStyle);

					sheet.autoSizeColumn(data.size() + 3)
				}


				Font linkFont = workbook.createFont();
				linkFont.setItalic(true);
				linkFont.setFontHeightInPoints((short) 12);
				linkFont.setColor(IndexedColors.BLUE.getIndex());

				CellStyle linkFontStyle = workbook.createCellStyle();
				linkFontStyle.setFont(linkFont);

				String path = './Screenshots/' + timestamp + '.png';
				//create next cell
				Cell imgcell = row.createCell(data.size() + 1);
				imgcell.setCellValue(path)
				imgcell.setCellStyle(linkFontStyle)
				sheet.autoSizeColumn(data.size() + 1)

				Cell msgcell = row.createCell(data.size() + 2);
				msgcell.setCellValue(msg)
				sheet.autoSizeColumn(data.size() + 2)

				String screenshotPath = new File(path).toURI().toString();

				def link = (XSSFHyperlink) createHelper.createHyperlink(HyperlinkType.valueOf("FILE"));
				link.setAddress(screenshotPath);
				imgcell.setHyperlink(link);

				FileOutputStream fos = new FileOutputStream(fileName);
				workbook.write(fos);
				fos.close();
			}else {

				XSSFWorkbook workbook = new XSSFWorkbook();
				CreationHelper createHelper = workbook.getCreationHelper();

				// Create a Font for styling header cells
				Font headerFont = workbook.createFont();
				headerFont.setBold(true);
				headerFont.setFontHeightInPoints((short) 14);
				headerFont.setColor(IndexedColors.GREEN.getIndex());

				CellStyle headerCellStyle = workbook.createCellStyle();
				headerCellStyle.setFont(headerFont);


				XSSFSheet sheet = workbook.createSheet("Error_report");
				Row rowHeader = sheet.createRow(0);

				CellStyle bgStyle = workbook.createCellStyle();


				//set header Row
				data.eachWithIndex { entry, i ->
					Cell cell = rowHeader.createCell(i)
					cell.setCellValue(entry.key)
					sheet.autoSizeColumn(i)
					cell.setCellStyle(headerCellStyle)
				}

				Cell imgcellHeader = rowHeader.createCell(data.size() + 1);
				imgcellHeader.setCellValue("Path To Screenshots")
				imgcellHeader.setCellStyle(headerCellStyle)

				Cell msgcellHeader = rowHeader.createCell(data.size() + 2);
				msgcellHeader.setCellValue("Message")
				msgcellHeader.setCellStyle(headerCellStyle)

				Cell msg1cellHeader = rowHeader.createCell(data.size() + 3);
				msg1cellHeader.setCellValue("Report")
				msg1cellHeader.setCellStyle(headerCellStyle)

				//add first row
				Row firstRow = sheet.createRow(1);
				data.eachWithIndex { entry, i ->
					Cell cell = firstRow.createCell(i)
					cell.setCellValue(entry.value)
					sheet.autoSizeColumn(i)
				}

				if(reportErr)
				{
					Cell cell1 = firstRow.createCell(data.size() + 3)
					cell1.setCellValue('Failed')
					bgStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
					bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

					cell1.setCellStyle(bgStyle)
					sheet.autoSizeColumn(data.size() + 3)
				}else {
					Cell cell2 = firstRow.createCell(data.size() + 3)
					cell2.setCellValue('Passed')
					bgStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
					bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
					cell2.setCellStyle(bgStyle);
					sheet.autoSizeColumn(data.size() + 3)
				}

				Font linkFont = workbook.createFont();
				linkFont.setItalic(true);
				linkFont.setFontHeightInPoints((short) 12);
				linkFont.setColor(IndexedColors.BLUE.getIndex());

				CellStyle linkFontStyle = workbook.createCellStyle();
				linkFontStyle.setFont(linkFont);

				String path = './Screenshots/' + timestamp + '.png';
				String screenshotPath = new File(path).toURI().toString();
				//create next cell
				Cell imgcell = firstRow.createCell(data.size() + 1);
				imgcell.setCellValue(path)
				imgcell.setCellStyle(linkFontStyle)
				sheet.autoSizeColumn(data.size() + 1)

				Cell msgcell = firstRow.createCell(data.size() + 2);
				msgcell.setCellValue(msg)
				sheet.autoSizeColumn(data.size() + 2)


				def link = (XSSFHyperlink) createHelper.createHyperlink(HyperlinkType.valueOf("FILE"));
				link.setAddress(screenshotPath);
				imgcell.setHyperlink(link);

				FileOutputStream fos = new FileOutputStream(fileName);
				workbook.write(fos);
				fos.close();

			}
		} catch (FileNotFoundException e) {
			Util.logger.logInfo(e.getMessage())
		} catch (IOException e) {
			Util.logger.logInfo(e.getMessage())
		}

	}

	def static void report(String tcName='', Map data = [:], String msg='',boolean reportErr=false) {

		Util.logger.logInfo(tcName)
		Util.logger.logInfo(data.toString())

		/*get element and show to the user for debugging
		 def timestamp = new Date().format("YYYY-MM-dd-HH-mm-ss")
		 String url = WebUI.getUrl()
		 String pathToScreenshots = GlobalVariable.projectRootPath + "\\Screenshots\\" + timestamp + '.png';
		 com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
		 WebUI.takeScreenshot(pathToScreenshots, ["text" : msg, "x" : 10, "y" : 5], FailureHandling.CONTINUE_ON_FAILURE)
		 WebUI.delay(1)*/
		def timestamp = new Date().format("YYYY-MM-dd-HH-mm-ss")
		String url = WebUI.getUrl()
		try {


			String fileName = GlobalVariable.projectRootPath + "\\Screenshots\\" + tcName + ".xlsx";
			def file = new File(fileName);
			if(file.exists()) {



				def excelData = ExcelFactory.getExcelDataWithDefaultSheet(fileName,"Error_report", true);

				def existingRows = excelData.getAllData()

				FileInputStream fisxls = new FileInputStream(fileName)
				XSSFWorkbook workbook = new XSSFWorkbook(fisxls)
				CreationHelper createHelper = workbook.getCreationHelper();
				XSSFSheet sheet = workbook.getSheet("Error_report")


				Row row = sheet.createRow(existingRows.size() + 1)


				data.eachWithIndex { entry, i ->
					Cell cell = row.createCell(i)
					cell.setCellValue(entry.value)
					sheet.autoSizeColumn(i)
				}


				CellStyle bgStyle = workbook.createCellStyle();

				if(reportErr)
				{
					bgStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
					bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

					Cell cell = row.createCell(data.size() + 3)
					cell.setCellValue('Failed')
					cell.setCellStyle(bgStyle);

					sheet.autoSizeColumn(data.size() + 3)
				}else {
					bgStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
					bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

					Cell cell = row.createCell(data.size() + 3)
					cell.setCellValue('Passed')
					cell.setCellStyle(bgStyle);

					sheet.autoSizeColumn(data.size() + 3)
				}


				Font linkFont = workbook.createFont();
				linkFont.setItalic(true);
				linkFont.setFontHeightInPoints((short) 12);
				linkFont.setColor(IndexedColors.BLUE.getIndex());

				CellStyle linkFontStyle = workbook.createCellStyle();
				linkFontStyle.setFont(linkFont);

				String path = './Screenshots/' + timestamp + '.png';
				//create next cell
				Cell imgcell = row.createCell(data.size() + 1);
				imgcell.setCellValue(path)
				imgcell.setCellStyle(linkFontStyle)
				sheet.autoSizeColumn(data.size() + 1)

				Cell msgcell = row.createCell(data.size() + 2);
				msgcell.setCellValue(msg)
				sheet.autoSizeColumn(data.size() + 2)

				String screenshotPath = new File(path).toURI().toString();

				def link = (XSSFHyperlink) createHelper.createHyperlink(HyperlinkType.valueOf("FILE"));
				link.setAddress(screenshotPath);
				imgcell.setHyperlink(link);

				FileOutputStream fos = new FileOutputStream(fileName);
				workbook.write(fos);
				fos.close();
			}else {

				XSSFWorkbook workbook = new XSSFWorkbook();
				CreationHelper createHelper = workbook.getCreationHelper();

				// Create a Font for styling header cells
				Font headerFont = workbook.createFont();
				headerFont.setBold(true);
				headerFont.setFontHeightInPoints((short) 14);
				headerFont.setColor(IndexedColors.GREEN.getIndex());

				CellStyle headerCellStyle = workbook.createCellStyle();
				headerCellStyle.setFont(headerFont);


				XSSFSheet sheet = workbook.createSheet("Error_report");
				Row rowHeader = sheet.createRow(0);

				CellStyle bgStyle = workbook.createCellStyle();


				//set header Row
				data.eachWithIndex { entry, i ->
					Cell cell = rowHeader.createCell(i)
					cell.setCellValue(entry.key)
					sheet.autoSizeColumn(i)
					cell.setCellStyle(headerCellStyle)
				}

				Cell imgcellHeader = rowHeader.createCell(data.size() + 1);
				imgcellHeader.setCellValue("Path To Screenshots")
				imgcellHeader.setCellStyle(headerCellStyle)

				Cell msgcellHeader = rowHeader.createCell(data.size() + 2);
				msgcellHeader.setCellValue("Message")
				msgcellHeader.setCellStyle(headerCellStyle)

				Cell msg1cellHeader = rowHeader.createCell(data.size() + 3);
				msg1cellHeader.setCellValue("Report")
				msg1cellHeader.setCellStyle(headerCellStyle)

				//add first row
				Row firstRow = sheet.createRow(1);
				data.eachWithIndex { entry, i ->
					Cell cell = firstRow.createCell(i)
					cell.setCellValue(entry.value)
					sheet.autoSizeColumn(i)
				}

				if(reportErr)
				{
					Cell cell1 = firstRow.createCell(data.size() + 3)
					cell1.setCellValue('Failed')
					bgStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
					bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

					cell1.setCellStyle(bgStyle)
					sheet.autoSizeColumn(data.size() + 3)
				}else {
					Cell cell2 = firstRow.createCell(data.size() + 3)
					cell2.setCellValue('Passed')
					bgStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
					bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
					cell2.setCellStyle(bgStyle);
					sheet.autoSizeColumn(data.size() + 3)
				}

				Font linkFont = workbook.createFont();
				linkFont.setItalic(true);
				linkFont.setFontHeightInPoints((short) 12);
				linkFont.setColor(IndexedColors.BLUE.getIndex());

				CellStyle linkFontStyle = workbook.createCellStyle();
				linkFontStyle.setFont(linkFont);

				String path = './Screenshots/' + timestamp + '.png';
				String screenshotPath = new File(path).toURI().toString();
				//create next cell
				Cell imgcell = firstRow.createCell(data.size() + 1);
				imgcell.setCellValue(path)
				imgcell.setCellStyle(linkFontStyle)
				sheet.autoSizeColumn(data.size() + 1)

				Cell msgcell = firstRow.createCell(data.size() + 2);
				msgcell.setCellValue(msg)
				sheet.autoSizeColumn(data.size() + 2)


				def link = (XSSFHyperlink) createHelper.createHyperlink(HyperlinkType.valueOf("FILE"));
				link.setAddress(screenshotPath);
				imgcell.setHyperlink(link);

				FileOutputStream fos = new FileOutputStream(fileName);
				workbook.write(fos);
				fos.close();

			}
		} catch (FileNotFoundException e) {
			Util.logger.logInfo(e.getMessage())
		} catch (IOException e) {
			Util.logger.logInfo(e.getMessage())
		}

	}


	def static void reporttwo(String tcName='', Map data = [:], String msg='',boolean reportErr=false) {

		Util.logger.logInfo(tcName)
		Util.logger.logInfo(data.toString())

		/*get element and show to the user for debugging
		 def timestamp = new Date().format("YYYY-MM-dd-HH-mm-ss")
		 String url = WebUI.getUrl()
		 String pathToScreenshots = GlobalVariable.projectRootPath + "\\Screenshots\\" + timestamp + '.png';
		 com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
		 WebUI.takeScreenshot(pathToScreenshots, ["text" : msg, "x" : 10, "y" : 5], FailureHandling.CONTINUE_ON_FAILURE)
		 WebUI.delay(1)*/
		def timestamp = new Date().format("YYYY-MM-dd-HH-mm-ss")
		String url = WebUI.getUrl()
		try {


			String fileName = GlobalVariable.projectRootPath + "\\Screenshots\\" + tcName + ".xlsx";
			def file = new File(fileName);
			if(file.exists()) {
				def excelData = ExcelFactory.getExcelDataWithDefaultSheet(fileName,"Error_report", true);
				//def existingRows = excelData.getAllData()
				FileInputStream fisxls = new FileInputStream(fileName)
				XSSFWorkbook workbook = new XSSFWorkbook(fisxls)
				if (workbook.getNumberOfSheets() != 1) {
					excelData = ExcelFactory.getExcelDataWithDefaultSheet(fileName,"Error_report", true);
					excelData.changeSheet("Error_report _2");
					def existingRows = excelData.getAllData();
					CreationHelper createHelper = workbook.getCreationHelper();
					XSSFSheet sheet = workbook.getSheet("Error_report _2");

					Row row = sheet.createRow(existingRows.size() + 1)

					data.eachWithIndex { entry, i ->
						Cell cell = row.createCell(i)
						cell.setCellValue(entry.value)
						sheet.autoSizeColumn(i)
					}


					CellStyle bgStyle = workbook.createCellStyle();

					if(reportErr)
					{
						bgStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
						bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

						Cell cell = row.createCell(data.size() + 3)
						cell.setCellValue('Failed')
						cell.setCellStyle(bgStyle);

						sheet.autoSizeColumn(data.size() + 3)
					}else {
						bgStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
						bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

						Cell cell = row.createCell(data.size() + 3)
						cell.setCellValue('Passed')
						cell.setCellStyle(bgStyle);

						sheet.autoSizeColumn(data.size() + 3)
					}


					Font linkFont = workbook.createFont();
					linkFont.setItalic(true);
					linkFont.setFontHeightInPoints((short) 12);
					linkFont.setColor(IndexedColors.BLUE.getIndex());

					CellStyle linkFontStyle = workbook.createCellStyle();
					linkFontStyle.setFont(linkFont);

					String path = './Screenshots/' + timestamp + '.png';
					//create next cell
					Cell imgcell = row.createCell(data.size() + 1);
					imgcell.setCellValue(path)
					imgcell.setCellStyle(linkFontStyle)
					sheet.autoSizeColumn(data.size() + 1)

					Cell msgcell = row.createCell(data.size() + 2);
					msgcell.setCellValue(msg)
					sheet.autoSizeColumn(data.size() + 2)

					String screenshotPath = new File(path).toURI().toString();

					def link = (XSSFHyperlink) createHelper.createHyperlink(HyperlinkType.valueOf("FILE"));
					link.setAddress(screenshotPath);
					imgcell.setHyperlink(link);

					FileOutputStream fos = new FileOutputStream(fileName);
					workbook.write(fos);
					fos.close();
				}
				else {

					//XSSFWorkbook workbook = new XSSFWorkbook();
					CreationHelper createHelper = workbook.getCreationHelper();


					// Create a Font for styling header cells
					Font headerFont = workbook.createFont();
					headerFont.setBold(true);
					headerFont.setFontHeightInPoints((short) 14);
					headerFont.setColor(IndexedColors.GREEN.getIndex());

					CellStyle headerCellStyle = workbook.createCellStyle();
					headerCellStyle.setFont(headerFont);


					XSSFSheet sheet = workbook.createSheet("Error_report _2");
					Row rowHeader = sheet.createRow(0);

					CellStyle bgStyle = workbook.createCellStyle();


					//set header Row
					data.eachWithIndex { entry, i ->
						Cell cell = rowHeader.createCell(i)
						cell.setCellValue(entry.key)
						sheet.autoSizeColumn(i)
						cell.setCellStyle(headerCellStyle)
					}

					Cell imgcellHeader = rowHeader.createCell(data.size() + 1);
					imgcellHeader.setCellValue("Path To Screenshots")
					imgcellHeader.setCellStyle(headerCellStyle)

					Cell msgcellHeader = rowHeader.createCell(data.size() + 2);
					msgcellHeader.setCellValue("Message")
					msgcellHeader.setCellStyle(headerCellStyle)

					Cell msg1cellHeader = rowHeader.createCell(data.size() + 3);
					msg1cellHeader.setCellValue("Report")
					msg1cellHeader.setCellStyle(headerCellStyle)

					//add first row
					Row firstRow = sheet.createRow(1);
					data.eachWithIndex { entry, i ->
						Cell cell = firstRow.createCell(i)
						cell.setCellValue(entry.value)
						sheet.autoSizeColumn(i)
					}

					if(reportErr)
					{
						Cell cell1 = firstRow.createCell(data.size() + 3)
						cell1.setCellValue('Failed')
						bgStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
						bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

						cell1.setCellStyle(bgStyle)
						sheet.autoSizeColumn(data.size() + 3)
					}else {
						Cell cell2 = firstRow.createCell(data.size() + 3)
						cell2.setCellValue('Passed')
						bgStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
						bgStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
						cell2.setCellStyle(bgStyle);
						sheet.autoSizeColumn(data.size() + 3)
					}

					Font linkFont = workbook.createFont();
					linkFont.setItalic(true);
					linkFont.setFontHeightInPoints((short) 12);
					linkFont.setColor(IndexedColors.BLUE.getIndex());

					CellStyle linkFontStyle = workbook.createCellStyle();
					linkFontStyle.setFont(linkFont);

					String path = './Screenshots/' + timestamp + '.png';
					String screenshotPath = new File(path).toURI().toString();
					//create next cell
					Cell imgcell = firstRow.createCell(data.size() + 1);
					imgcell.setCellValue(path)
					imgcell.setCellStyle(linkFontStyle)
					sheet.autoSizeColumn(data.size() + 1)

					Cell msgcell = firstRow.createCell(data.size() + 2);
					msgcell.setCellValue(msg)
					sheet.autoSizeColumn(data.size() + 2)


					def link = (XSSFHyperlink) createHelper.createHyperlink(HyperlinkType.valueOf("FILE"));
					link.setAddress(screenshotPath);
					imgcell.setHyperlink(link);

					FileOutputStream fos = new FileOutputStream(fileName);
					workbook.write(fos);
					fos.close();

				}
			}

		} catch (FileNotFoundException e) {
			Util.logger.logInfo(e.getMessage())
		} catch (IOException e) {
			Util.logger.logInfo(e.getMessage())
		}

	}


	/**
	 * Logout
	 */
	def static void logout() {
		//click on the user menu
		WebUI.click(findTestObject('Object Repository/generic/user-menu'));

		WebUI.click(findTestObject('Object Repository/generic/logout'));
	}


	def static getDataMap(keys,values){
		int keysSize = keys.size();
		int valuesSize = values.size();

		if (keysSize != valuesSize) {
			Util.logger.logFailed("Not able tp generate map ; key value length not matching")
			throw new IllegalArgumentException("The number of keys doesn't match the number of values.");
		}

		def map = [:];
		if (keysSize == 0) {
			return map;
		}

		for (int i = 0; i < keysSize; i++) {
			map[keys[i]]= (values[i] == null) ? '' : values[i];
		}

		return map;
	}



	/**
	 * get list data from file
	 * @param filePath
	 * @param sheetName
	 * @param filterKeys [] in the order of column 
	 * @param hasHeaderRow
	 * @return 
	 */
	def static getData(filePath,sheetName,filterKeys){
		try {

			def excelData = ExcelFactory.getExcelDataWithDefaultSheet(filePath,sheetName, true);

			def data = excelData.getAllData();


			def mylist = [];

			for(row in data) {
				if(row[0] == filterKeys[0] && row[1] == filterKeys[1]) {
					mylist.add(row);
				}
			}


			//convert indexed list to  key value paired map
			def colNameList = excelData.getColumnNames();
			def newList = [];
			for(rw in mylist) {
				def rowMap = Util.getDataMap(colNameList, rw);
				newList.add(rowMap);
			}

			return newList;
		} catch (IOException e) {
			Util.logger.logFailed(e.getMessage())
			Util.logger.logFailed("Not able to fetch data or doesn't exist")
			Util.logger.logFailed("pl.check sheet name and filter properties properly")
			return null;
		} catch (IllegalArgumentException e){
			Util.logger.logFailed(e.getMessage())
			Util.logger.logFailed("Not able to fetch data or doesn't exist")
			Util.logger.logFailed("pl.check sheet name and filter properties properly")
			return null;
		} catch(java.lang.NullPointerException e) {
			Util.logger.logFailed(e.getMessage())
			Util.logger.logFailed("Not able to fetch data or doesn't exist")
			Util.logger.logFailed("pl.check sheet name and filter properties properly")
			return null;

		}
	}



	def static verifyMail(String mailserver, String to, String pw, String subjectMsg, String linkText, String tcName="", Map data=[:]) {
		Properties props = new Properties()

		props.setProperty('mail.store.protocol', 'imaps')
		props.setProperty("mail.imap.ssl.enable", "true")

		Session session = Session.getDefaultInstance(props, null)

		Store store = session.getStore('imaps')

		store.connect(mailserver, to, pw)

		// SearchTerm t1 = new RecipientStringTerm(RecipientType.TO, "admin@nurtem.com");
		SearchTerm t2 = new SubjectTerm(subjectMsg)

		// SearchTerm filter = new AndTerm(t1, t2);
		Folder emailFolder = store.getFolder('INBOX')

		emailFolder.open(Folder.READ_ONLY)

		Message[] messages = emailFolder.search(t2)

		System.out.println('messages.length---' + messages.length)

		if (messages.length < 1)
		{
			Util.reportAndtakeScreenshot(tcName, data, 'Email not found' )
		}
		else
		{
			String subject = (messages[0]).getSubject()

			String from = ((messages[0]).getFrom()[0]).toString()

			System.out.println('messages---' + from)

			System.out.println('messages---' + subject)

			String contentType = (messages[0]).getContentType()

			String messageContent = ''

			if (contentType.contains('multipart')) {
				Multipart multiPart = (((messages[0]).getContent()) as Multipart)

				int numberOfParts = multiPart.getCount()

				for (int partCount = 0; partCount < numberOfParts; partCount++) {
					MimeBodyPart part = ((multiPart.getBodyPart(partCount)) as MimeBodyPart)

					messageContent += part.getContent().toString()
				}
			} else if (contentType.contains('text/plain') || contentType.contains('text/html')) {
				messageContent = (messages[0]).getContent().toString()
			}

			Document doc = Jsoup.parse(messageContent)

			Elements links = doc.select('a')

			for (Element link : links) {
				if (link.text() == linkText) {
					String url = link.attr('href')

					System.out.println('url: ' + url)

					WebUI.navigateToUrl(url)

					break
				}
			}
		}
	}



	def static passverifyMail(String mailserver, String to, String pw, String subjectMsg, String frglinkText, String tcName="", Map data=[:]) {
		Properties props = new Properties()

		props.setProperty('mail.store.protocol', 'imaps')
		props.setProperty("mail.imap.ssl.enable", "true")

		Session session = Session.getDefaultInstance(props, null)

		Store store = session.getStore('imaps')

		store.connect(mailserver, to, pw)

		// SearchTerm t1 = new RecipientStringTerm(RecipientType.TO, "admin@nurtem.com");
		SearchTerm t2 = new SubjectTerm(subjectMsg)

		// SearchTerm filter = new AndTerm(t1, t2);
		Folder emailFolder = store.getFolder('INBOX')

		emailFolder.open(Folder.READ_ONLY)

		Message[] messages = emailFolder.search(t2)

		System.out.println('messages.length---' + messages.length)

		if (messages.length < 1)
		{
			Util.reportAndtakeScreenshot(tcName, data, 'Email not found' )
		}
		else
		{
			String subject = (messages[0]).getSubject()

			String from = ((messages[0]).getFrom()[0]).toString()

			System.out.println('messages---' + from)

			System.out.println('messages---' + subject)

			String contentType = (messages[0]).getContentType()

			String messageContent = ''

			if (contentType.contains('multipart')) {
				Multipart multiPart = (((messages[0]).getContent()) as Multipart)

				int numberOfParts = multiPart.getCount()

				for (int partCount = 0; partCount < numberOfParts; partCount++) {
					MimeBodyPart part = ((multiPart.getBodyPart(partCount)) as MimeBodyPart)

					messageContent += part.getContent().toString()
				}
			} else if (contentType.contains('text/plain') || contentType.contains('text/html')) {
				messageContent = (messages[0]).getContent().toString()
			}

			Document doc = Jsoup.parse(messageContent)

			Elements links = doc.select('a')

			for (Element link : links) {
				if (link.text() == frglinkText) {
					String url = link.attr('href')

					System.out.println('url: ' + url)

					WebUI.navigateToUrl(url)

					break
				}
			}
		}
	}

	//
	//	def static Boolean verifyURL(String expectedUrl) {
	//		try {
	//			WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)
	//			String current = WebUI.getUrl()
	//			String baseurl = GlobalVariable.base_url;
	//			String expected = baseurl + '/' + expectedUrl
	//			if(current == expected) {
	//				return true
	//			}else {
	//				return false
	//			}
	//		} catch (StepFailedException e) {
	//			return false
	//		}
	//
	//	}


	def static String selectTime(String column, String time) {
		String  xpath_Time = "//div[@class='full-width nurtem-datepicker']//div[@class='ant-picker-time-panel']";

		int timePosition = Integer.parseInt(time) + 1;

		String columnNo = '1';
		if(column == 'min') {
			columnNo = '2';
		}
		String path = xpath_Time + '//ul[' + columnNo + ']//li[' + timePosition.toString() + ']'

		return  path

	}


	def static void myClass(String tcName="", Map data=[:]) {

		try {
			def my_class = 	"//span[contains(text(),'My Classes')]"
			def table_xpath = '//div[@class="ant-table"]'
			def table_xpath1 = '(//div[@class="ant-table"])[1]'
			def multipledays = "//body//div//div[@role='document']//div//div[2]"
			String m = data.Whichday
			int pp =  m.toInteger()
			WebDriver driver = DriverFactory.getWebDriver()
			driver.findElement(By.xpath(my_class)).click()
			WebUI.delay(5)
			def temp = 0
			String ExpectedValue = data.class_name.trim()
			WebElement Table = driver.findElement(By.xpath(table_xpath))
			for (int z=0; z<=12; z++)
			{
				if (z>0)
				{
					Table = driver.findElement(By.xpath(table_xpath1))
				}

				List<WebElement> Rows = Table.findElements(By.tagName('tr'))
				println('No. of rows: ' + Rows.size())
				def e=1
				table: for (int i = 0; i < Rows.size(); i++)
				{
					print('i value is :'+i)
					List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))
					for (int j = 0; j < Cols.size(); j++)
					{
						if(j==0)
						{
							if (Cols.get(j).getText().equalsIgnoreCase(ExpectedValue))
							{
								Cols.get(5).findElement(By.tagName('button')).click()
								temp=1
								WebUI.delay(2)
								Util.report(tcName, data, 'class name correct :  '+Cols.get(j).getText())
								WebUI.click(findTestObject('Object Repository/attendance/Viewatt'))
								WebUI.delay(2)
								if(WebUI.verifyElementPresent(findTestObject('Object Repository/bookaclass/enrol/next_button'),20,FailureHandling.OPTIONAL))
								{
									WebUI.click(findTestObject('Object Repository/mark_attend/multiple classes table'))
									WebUI.delay(2)
									String xpath11 = "//tbody/tr[$pp]/td[3]/div[1]/button[1]"
									driver.findElement(By.xpath(xpath11)).click()

								}
								//def g = data.previous
								if(data.previous == 'prev') {
									WebUI.click(findTestObject("Object Repository/mark_attend/previous_mnth"))
								}
							}
							/*else
							 {
							 Util.report(tcName, data, 'class name wrong :  '+Cols.get(j).getText()+' - Crct class is - '+ExpectedValue,true)
							 }*/
						}
					}
					if (temp == 1)
					{
						break
					}
				}
				//if(WebUI.verifyElementPresent(findTestObject('Object Repository/bookaclass/enrol/next_button'),20,FailureHandling.OPTIONAL))
				if(temp==0)
				{
					WebUI.click(findTestObject('Object Repository/bookaclass/enrol/next_button'))
				}
				else
				{
					break
				}
			}
		}
		catch (org.openqa.selenium.NoSuchElementException | com.kms.katalon.core.exception.StepFailedException  e)
		{
			Util.reportAndtakeScreenshot(tcName, data, 'Tutor request has error : ' + e.getMessage(),true)
		}
	}


	def static void classCheck(String tcName="", Map data=[:]) {

		try {
			def my_class = 	"//span[contains(text(),'My Classes')]"
			def table_xpath = '//div[@class="ant-table"]'
			def table_xpath1 = '(//div[@class="ant-table"])[1]'
			//def table_xpath2 = '(//div[@class="ant-table"])[2]'
			def table_xpath2 = '//*[@id="rc-tabs-2-panel-1"]/div/div[2]/div/div[1]/div/div/div/div/div/div/table'
			WebDriver driver = DriverFactory.getWebDriver()
			driver.findElement(By.xpath(my_class)).click()
			WebUI.delay(5)
			def temp = 0
			String ExpectedValue = data.class_name.trim()
			String depnvalue = data.tutor_name.trim()
			String nxtsession = data.next_session.trim()
			WebElement Table = driver.findElement(By.xpath(table_xpath))
			for (int z=0; z<=12; z++)
			{
				if (z>0)
				{
					Table = driver.findElement(By.xpath(table_xpath1))
				}

				List<WebElement> Rows = Table.findElements(By.tagName('tr'))
				println('No. of rows: ' + Rows.size())
				def k=2
				def e=1
				table: for (int i = 0; i < Rows.size(); i++)
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
									Util.report(tcName, data,, 'Class already created with same name  '+Cols.get(j).getText(),true)
								}
								else
								{
									Util.report(tcName, data,, 'Class name correct : '+Cols.get(j).getText())
									e=2
									//if(j==1)
									//{
									if (Cols.get(1).getText().equalsIgnoreCase(depnvalue))
									{
										Util.report(tcName, data,, 'Tutor name is correct : '+Cols.get(1).getText())
										print('The next session is- '+Cols.get(2).getText()+'-')
										temp = 1
										if (Cols.get(2).getText().equalsIgnoreCase(nxtsession))
										{

											Util.report(tcName, data,, 'Next session is correct : '+Cols.get(2).getText())
											print('the next session is : '+Cols.get(2).getText()+'-')
										}	else
										{
											Util.reportAndtakeScreenshot(tcName, data,, 'Wrong Next session displayed : '+Cols.get(2).getText()+' , The correct next session is : '+nxtsession,true)
										}
										Cols.get(5).findElement(By.tagName('button')).click()
									}
									else
									{
										Util.reportAndtakeScreenshot(tcName, data,, 'Wrong tutor dispayed : '+Cols.get(1).getText()+' , The crct tutor is : '+depnvalue,true)
									}
								}
							}
							else
							{
								Util.report(tcName, data,, 'Class name wrong : '+Cols.get(j).getText()+' , Crct class is : '+ExpectedValue,true)
							}
						}
						if (temp == 1)
						{
							break
						}
					}
					if (temp == 1)
					{
						break
					}
				}
				//TestObject nxt = (findTestObject('Object Repository/bookaclass/enrol/next_button'))
				if (temp == 0)
				{
					if(WebUI.verifyElementPresent(findTestObject('Object Repository/bookaclass/enrol/next_button'),20,FailureHandling.OPTIONAL))
					{
						WebUI.click(findTestObject('Object Repository/bookaclass/enrol/next_button'))
					}else
					{
						break
					}
				}
			}
		}

		catch (com.kms.katalon.core.exception.StepFailedException | Exception e)
		{
			Util.reportAndtakeScreenshot(tcName, data,, 'Class checking has error - ' + e.getMessage(),true)
		}


	}

	def static void dayofweek(String tcName="", Map data=[:]) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
		LocalDate date = LocalDate.parse("23/2/2010", formatter); // LocalDate = 2010-02-23
		DayOfWeek dow = date.getDayOfWeek();  // Extracts a `DayOfWeek` enum object.
		String output = dow.getDisplayName(TextStyle.SHORT, Locale.US);
	}
}
