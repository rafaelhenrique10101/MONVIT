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

// TC_START_APPLICATION
WebUI.callTestCase(findTestCase('START_APPLICATION/TC_START_APPLICATION'), [('pathApp') : 'APK/MONVIT_v1.7.24.apk'], FailureHandling.STOP_ON_FAILURE)

// TC_NAVIGATION_CADASTRO
WebUI.callTestCase(findTestCase('NAVIGATION_MENU/TC_NAVIGATION_CADASTRO'), [:], FailureHandling.STOP_ON_FAILURE)

def pathTestCaseName = 'Screenshots/TC_MONVIT_CADC_001'

def folderTestCaseName = new File(pathTestCaseName)

def idxImgEvidence = 0

// Mensagens de validação 
def strMsgCampoObrigatorio = 'Esse campo é obrigatório.'
def strMsgNomeCompleto = 'Você precisa informar o seu nome completo'
def strInvalidCPF = 'CPF inválido'
def strMinCharactersCPF = 'Pelo menos 11 caracteres'
def strMaxAgeDate = 'A idade máxima é de 150 anos'
def strMinAgeDate = 'A idade mínima é de 5 anos'
def strInvalidEmail = 'Endereço de email inválido'
def strPassSmall = 'Senha muito curta'
def strUseTerms = 'Senha muito curta'

Mobile.hideKeyboard()
Mobile.tap(findTestObject('OBJ_SCREEN_REGISTER/btnSalvar'), 5)
Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

// Verificando se diretório de Screenshots do TestCase existe
if (!(folderTestCaseName.exists())) {
    folderTestCaseName.mkdirs()
}

// Validando obrigatoriedade do campo Nome Completo, CPF e Data Nascimento

if ((Mobile.getAttribute(findTestObject('OBJ_SCREEN_REGISTER/MSG_VALIDATIONS/lblValidationNomeCompleto'), 'text', 5) == strMsgCampoObrigatorio) && (Mobile.getAttribute(findTestObject('OBJ_SCREEN_REGISTER/MSG_VALIDATIONS/lblValidationCPF'), 'text', 5) == strMsgCampoObrigatorio) && (Mobile.getAttribute(findTestObject('OBJ_SCREEN_REGISTER/MSG_VALIDATIONS/lblValidationDataNascimento'), 'text', 5) == strMsgCampoObrigatorio)) {
    Mobile.takeScreenshot(((pathTestCaseName + '/') + (idxImgEvidence + 1)) + '.png')

    idxImgEvidence = (idxImgEvidence + 1)
}