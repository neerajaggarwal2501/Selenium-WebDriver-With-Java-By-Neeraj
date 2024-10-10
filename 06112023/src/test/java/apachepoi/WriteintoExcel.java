package apachepoi;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteintoExcel {
	public static void main(String[] args) throws IOException {
		String path = "TestData.xlsx";
		FileInputStream fs = new FileInputStream(path);
		try (Workbook wb = new XSSFWorkbook(fs)) {
			Sheet sheet1 = wb.getSheetAt(0); // 0 Based Index
			int lastRow = sheet1.getLastRowNum(); // 0 based index. -1 if no row exists
			for (int i = 0; i <= lastRow; i++) { // if row count is 1 =>Loop execution(0->0) || if row count is 2 => Loop execution 0->1  
				Row row = sheet1.getRow(i);
				Cell cell = row.createCell(2);

				cell.setCellValue("WriteintoExcel");

			}
			FileOutputStream fos = new FileOutputStream(path);
			wb.write(fos);
			fos.close();
		}
	}
}