import br.com.mv.monitoring.cadastrocontas.genericClass as GenericClass
import br.com.mv.monitoring.excel.ExcelUtils as ExcelUtils

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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.testdata.DBData as DBData

// Instanciando objetos ExcelData
ExcelData dataConfig = findTestData('CONFIG')
ExcelData dataTC = findTestData('DP_MONITORING_VITALS')
DBData usersResultQuery = findTestData('DB_CADASTRAR_CONTA')

// Instanciando objetos GenericClass

GenericClass gc = new genericClass()
ExcelUtils eu = new ExcelUtils()

// Inicializndo nome do TestCase e Path do APK
def testCaseID = dataTC.getValue(2, 1)
def pathAPK = dataConfig.getValue(2, 2)
def idxImgEvidence = 0

// Criando estrutura de diretórios de evidências

new File(dataConfig.getValue(3, 3) + testCaseID).mkdirs()

// Inputs e Objetos informados na planilha
def objTituloTela = dataTC.getValue(13, 6)
def valueTituloTela = dataTC.getValue(14, 6)
def objNomeCompleto = dataTC.getValue(13, 7)
def valueNomeCompleto = dataTC.getValue(14, 7)
def objCPF = dataTC.getValue(13, 8)
def valueCPF = dataTC.getValue(14, 8)
def objDataNascimento = dataTC.getValue(13, 9)
def valueDataNascimento = dataTC.getValue(14, 9)
def objSexo = dataTC.getValue(13, 10)
def objItemSexo = dataTC.getValue(14, 10)
def objCelular = dataTC.getValue(13, 11)
def valueCelular = dataTC.getValue(14, 11)


// Objetos da Aplicação

def AppObjTituloTela = findTestObject('OBJ_SCREEN_REGISTER/lblTituloTela')
def nomeCompleto = findTestObject('OBJ_SCREEN_REGISTER/txtNomeCompleto')
def lblNomeCompleto = findTestObject('OBJ_SCREEN_REGISTER/lblNomeCompleto')

// Mensagens de validação

def requiredFields = 'Este campo é obrigatório'

//========================================================================================
//========================================================================================

// TC_START_APPLICATION
WebUI.callTestCase(findTestCase('START_APPLICATION/TC_START_APPLICATION'), [('pathApp') : pathAPK], FailureHandling.STOP_ON_FAILURE)

// TC_NAVIGATION_CADASTRO
WebUI.callTestCase(findTestCase('NAVIGATION_MENU/TC_NAVIGATION_CADASTRO'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.hideKeyboard()

Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

// Validação de obrigatoriedade de campos

if(gc.textEquals('OBJ_SCREEN_REGISTER/' + AppObjTituloTela, valueTituloTela))
{
	Mobile.tap(findTestObject('OBJ_SCREEN_REGISTER/btnSalvar'), 5)
	
	if(gc.validadeRequiredFields(nomeCompleto, lblNomeCompleto, requiredFields))
	{
		
	}
}

if (Mobile.getAttribute(findTestObject('OBJ_SCREEN_REGISTER/lblTituloTela'), 'text', 5) == valueTituloTela) {

    Mobile.setText(findTestObject('OBJ_SCREEN_REGISTER/' + objNomeCompleto), valueNomeCompleto, 5)
    Mobile.setText(findTestObject('OBJ_SCREEN_REGISTER/' + objCPF), valueCPF, 5)
    Mobile.setText(findTestObject('OBJ_SCREEN_REGISTER/' + objDataNascimento), valueDataNascimento, 5)
    Mobile.tap(findTestObject('OBJ_SCREEN_REGISTER/' + objSexo), 5)
    Mobile.tap(findTestObject('OBJ_SCREEN_REGISTER/' + objItemSexo), 5)
    Mobile.setText(findTestObject('OBJ_SCREEN_REGISTER/' + objCelular), valueCelular, 5)

    Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

    Mobile.takeScreenshot(((((dataConfig.getValue(3, 3) + '/') + testCaseID) + '/') + (idxImgEvidence + 1)) + '.png')

    idxImgEvidence = (idxImgEvidence + 1)

    
}

def userTableResult = usersResultQuery.getAllData()

Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

