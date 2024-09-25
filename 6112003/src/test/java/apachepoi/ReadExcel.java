package apachepoi;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//https://www.browserstack.com/guide/read-data-from-excel-using-selenium

public class ReadExcel {
	public static void main(String[] args) throws IOException {
//Path of the excel file
		FileInputStream fs = new FileInputStream("TestData.xlsx");
//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(1); //0 based index

		Row row0 = sheet.getRow(0); // 0 based index
		Cell cell = row0.getCell(1); // 0 based index
		System.out.println(cell);  //[0][0]
		System.out.println(sheet.getRow(0).getCell(1) + "\n"); //[0][1] RC

		Row row1 = sheet.getRow(1);
		Cell cell1 = row1.getCell(1);
		System.out.println(cell1); // [1][1]
		System.out.println(sheet.getRow(1).getCell(1) + "\n"); // [1][1] RC

		Row row2 = sheet.getRow(2);
		Cell cell2 = row2.getCell(1);
		System.out.println(cell2); // [2][1]
		System.out.println(sheet.getRow(2).getCell(1) + "\n"); // [2][1] RC

		Row row3 = sheet.getRow(3);
		Cell cell3 = row3.getCell(1);
		System.out.println(cell3); // [2][1] RC
		System.out.println(sheet.getRow(2).getCell(1) + "\n"); //[3][1] RC

		
	}
}