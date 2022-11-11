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
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUIHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import com.netkathir.Util as WebUtil

//testCaseName
//testCaseData
//try {
WebDriver driver = DriverFactory.getWebDriver()

// String currentScreenUrl = WebUI.getUrl()
WebUI.navigateToUrl((GlobalVariable.base_url), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUtil.clickElement('sign-in/1_Student Login_link')

WebUI.delay(5)

// if (currentScreenUrl.contains('dashboard')) {
WebUtil.clickElement('Object Repository/forget_pass/pass_link')

WebUI.delay(3)

WebUtil.setVal(findTestObject('Object Repository/forget_pass/email'), testCaseData.email)

err = WebUtil.isErrorExists()

if (err.size() > 0) {
    WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Forgot pass Form : ' + err.toString(), true)
} else {
    WebUtil.clickElement('Object Repository/forget_pass/reset_button')

    err = WebUtil.isErrorExists()

    def z = err.toString()

    if (z.contains('success')) {
        WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Forgot pass clicked succesfully: ' +z)
    } else {
        WebUtil.reportAndtakeScreenshot(testCaseName, testCaseData, 'Forgot pass has error: ' + z, true)
    }
}

WebUI.delay(10)