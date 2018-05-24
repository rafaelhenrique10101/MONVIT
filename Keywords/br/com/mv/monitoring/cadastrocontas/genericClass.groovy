package br.com.mv.monitoring.cadastrocontas

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.lang.reflect.Array

import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class genericClass {
	
	/**
	 * This method receive the parameters and validate 
	 * if when problem was simulated the correct message was displayed
	 * 
	 * @param: objField 	>> The object corresponding to the element that validated
	 * @param: objLabelMsg 	>> The object corresponding to the label element that displayed a alert message
	 * @param: msg 			>> String that contains the message that will validated
	 * 
	 * @return: true if correct message was displayed or otherwise false
	 */
	@Keyword
	public boolean validadeRequiredFields(Object objField, Object objLabelMsg, String msg){
		
		if(Mobile.getAttribute(findTestObject('OBJ_SCREEN_REGISTER/' + objField), 'text', 5) == '')
		{
			if(Mobile.getAttribute(findTestObject('OBJ_SCREEN_REGISTER/' + objLabelMsg), 'text', 5) == msg)
			{
				return false
			}
		}
		else
		{
			return true
		}
		
	}
}
