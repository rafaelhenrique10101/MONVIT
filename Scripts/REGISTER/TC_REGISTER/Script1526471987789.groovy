import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.ExcelData as ExcelData

ExcelData data = findTestData('')

def pathScreenshots = 'Screenshots/MONVIT/';
def testCaseName = data.getValue('', 1)
def executionVersion = data.getValue('', 1)
def idx = 0

Mobile.delay(5, FailureHandling.CONTINUE_ON_FAILURE)

Mobile.pressBack()

Mobile.tap(findTestObject('OBJ_LOGIN_SCREEN/android.widget.Button1 - No tenho uma conta. Quero me cadastrar.'), 5)

def titleViewRegister = Mobile.getText(findTestObject('OBJ_SCREEN_REGISTER/btnCriarConta'), 
    10)

Mobile.delay(5, FailureHandling.CONTINUE_ON_FAILURE)

if (titleViewRegister == 'Crie sua conta') {	
	new File(pathScreenshots + '/' + testCaseName + '/' + executionVersion).mkdirs();
	Mobile.takeScreenshot(pathScreenshots + '/' + testCaseName + '/' + executionVersion + '/' + (idx++) + '.png')
	
	//Nome Completo	
	Mobile.setText(findTestObject(''), data.getValue('', 0), 5)
	
	//CPF
	Mobile.setText(findTestObject(''), data.getValue('', 0), 5)
	
	//Data de nasciemnto
	Mobile.setText(findTestObject(''), data.getValue('', 0), 5)
	
	//Sexo #1
	Mobile.tap(findTestObject(''), 5)
		
	if(data.getValue('', 0) == ''){
		Mobile.tap(findTestObject(''), 5)
	}else{
		Mobile.tap(findTestObject(''), 5)
	}
	
	//Telefone celular
	Mobile.setText(findTestObject(''), data.getValue('', 0), 5)
	
	//Email
	Mobile.setText(findTestObject(''), data.getValue('', 0), 5)
	
	//Confirmar email
	Mobile.setText(findTestObject(''), data.getValue('', 0), 5)
	
	//Senha
	Mobile.setText(findTestObject(''), data.getValue('', 0), 5)
	
	//Confirmar senha
	Mobile.setText(findTestObject(''), data.getValue('', 0), 5)
	
	//Termos de uso
	Mobile.tap(findTestObject(''), 5)
	
	//Salvar
	Mobile.tap(findTestObject(''), 5)
}

