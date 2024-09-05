package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public XSSFWorkbook workbook;
	public FileInputStream file;
	public XSSFSheet worksheet;
	public XSSFCell cell;
	
	public ExcelUtility(String fi, String sheet) throws IOException {
		// TODO Auto-generated constructor stub
		file = new FileInputStream(fi);
		workbook = new XSSFWorkbook(file);
		worksheet=workbook.getSheet(sheet);
		
	}
	public int getRowCount() throws IOException {
		int rowCount = worksheet.getLastRowNum();
		return rowCount;
	}
	public int getCellCount() throws IOException {
		int cellCount = worksheet.getRow(0).getLastCellNum();
		return cellCount;
	}
	
	public String getCellValue(int rowNum, int cellNum) throws IOException {
		cell = worksheet.getRow(rowNum).getCell(cellNum);
		String data = cell.getStringCellValue(); 
		return data;
	}
//	public static void main(String args[]) throws IOException {
//		//ExcelUtility exc= new ExcelUtility(System.getProperty("user.dir")+"\\testData\\FlipkartTestData.xlsx", "Sheet1");
//		ExcelUtility exc= new ExcelUtility("./testData\\FlipkartTestData.xlsx", "Sheet1");
//		exc.cell = exc.worksheet.getRow(1).getCell(0);
//		String data = exc.cell.getStringCellValue(); 
//		System.out.println(data);
//	}
}
