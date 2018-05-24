package br.com.mv.monitoring.excel
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.lang.reflect.Array
import java.util.concurrent.atomic.Striped64.Cell

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


class ExcelUtils {
	/**
	 * Update a value in specific cell
	 * @param String pathFile	>> Path to Workbook that will be updated
	 * @param String msg		>> Message that will be writed in cell to file
	 * @param int row			>> Index of row in Workbook
	 * @param int column		>> Index of column in Workbook
	 * @param int sheetNumber	>> Index of sheet in Workbook
	 * @return true if value was writed, otherwise false
	 */
	@Keyword
	public boolean setValueCell(String pathFile, String msg, int row, int column, int sheetNumber){
				
		FileInputStream fileIn= new FileInputStream(new File(pathFile));		
		HSSFWorkbook wb = new HSSFWorkbook(fileIn)
		
		HSSFSheet worksheet = wb.getSheetAt(sheetNumber)
		
		Cell cell = null;
		
		cell = worksheet.getRow(row).getCell(column);
		cell.setCellValue(msg);
		fileIn.close();

		FileOutputStream fileOut =new FileOutputStream(new File(pathFile));
		
		wb.write(fileOut);
		fileOut.close();
	}
}