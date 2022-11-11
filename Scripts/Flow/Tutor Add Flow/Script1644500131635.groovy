import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.constants.GlobalStringConstants as GlobalStringConstants
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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.netkathir.Util as WebUtil
import java.awt.event.KeyEvent as KeyEvent
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import java.awt.Robot as Robot
import java.awt.Toolkit as Toolkit
import java.awt.datatransfer.StringSelection as StringSelection

String testCaseName = 'Add New Tutor Report'

def filterBy = ['Add_tutor', 'tutor']

def data = WebUtil.getData(GlobalVariable.projectRootPath + '\\TestDataXls\\add_tutor.xlsx', 'reassign', filterBy)

WebUtil.stopOnEmptyData(data)

for (def row : data) {
    WebUI.openBrowser('')

    WebUI.deleteAllCookies()

    WebUI.callTestCase(findTestCase('Generic/Tutor Login General'), [('testCaseName') : testCaseName, ('testCaseData') : row], 
        FailureHandling.CONTINUE_ON_FAILURE)
    String currentUrl = WebUI.getUrl(FailureHandling.CONTINUE_ON_FAILURE).toString()
    if (currentUrl.contains('dashboard')) {
        WebUI.callTestCase(findTestCase('Generic/Tutor Add Tutor General'), [('testCaseName') : testCaseName, ('testCaseData') : row], 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
}

String currentUrl1 = WebUI.getUrl(FailureHandling.CONTINUE_ON_FAILURE).toString()

if (currentUrl1.contains('business-profile')) {
    filterBy = ['profile', 'tutor']
    data = WebUtil.getData(GlobalVariable.projectRootPath + '\\TestDataXls\\profile-tutor.xlsx', 'profile', filterBy)
    WebUtil.stopOnEmptyData(data)
    for (def row : data) {
        WebUI.callTestCase(findTestCase('Generic/Tutor Profile General'), [('testCaseName') : testCaseName, ('testCaseData') : row], 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
}

WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)

WebUtil.generateReport(testCaseName, filterBy)

