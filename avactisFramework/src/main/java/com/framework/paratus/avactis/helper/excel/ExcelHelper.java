package com.framework.paratus.avactis.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.framework.paratus.avactis.helper.logger.LoggerHelper;
import com.framework.paratus.avactis.helper.resource.ResourceHelper;

public class ExcelHelper {
	private Logger logger = LoggerHelper.getLogger(ExcelHelper.class);

	public static Object[][] getExcelData(String excelLocation, String sheetName) {

		Object[][] data = null;
		FileInputStream file = null;
		XSSFWorkbook workbook = null;

		try {
			file = new FileInputStream(new File(excelLocation));
			workbook = new XSSFWorkbook(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		XSSFSheet sheet = workbook.getSheet(sheetName);

		// count active rows
		int totalRows = sheet.getLastRowNum() + 1;
		// count active column
		short totalColumns = sheet.getRow(0).getLastCellNum();
		data = new Object[totalRows][totalColumns];

		Iterator<Row> rowIterator = sheet.rowIterator();
		int i = 0;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			int j = 0;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = cell.getNumericCellValue();
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				case FORMULA:
					data[i][j] = cell.getCellFormula();
					break;

				default:
					System.out.println("Dont have matching data found");
					break;
				}
				j++;
			}
			System.out.println();
			i++;
		}
		return data;
	}

	public void updateResult(String excelLocation, String sheetName, String TestCaseName, String testStatus) {

		FileInputStream file = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;

		try {
			file = new FileInputStream(new File(excelLocation));
			workbook = new XSSFWorkbook(file);
		} catch (FileNotFoundException e) {
			System.out.println(excelLocation + " not found");
		} catch (IOException e) {
			System.out.println("IO Exception");
		}
		sheet = workbook.getSheet("testdata");
		int totalRows = sheet.getFirstRowNum() + 1;
		for (int i = 0; i < totalRows; i++) {
			XSSFRow row = sheet.getRow(i);
			String ce = row.getCell(0).getStringCellValue();
			if (ce.contains(TestCaseName)) {
				row.createCell(1).setCellValue(testStatus);
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				logger.info("result updated...");
				try {
					FileOutputStream out = new FileOutputStream(new File(excelLocation));
					workbook.write(out);
					out.close();
					break;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		String excelLocation = ResourceHelper.getResouce("/src/main/resources/configfile/demo.xlsx");
		Object[][] data = getExcelData(excelLocation, "demo");
		for (Object[] objects : data) {
			for (Object objects2 : objects) {
				System.out.print(objects2.toString() + "  ");
			}
			System.out.println();
		}
	}

}
