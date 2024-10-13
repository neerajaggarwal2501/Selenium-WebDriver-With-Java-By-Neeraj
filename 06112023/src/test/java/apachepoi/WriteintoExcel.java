package apachepoi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteintoExcel {
	public static void main(String[] args) throws IOException {
		// Open the Excel File in Java as a Stream
		Path path = Path.of(System.getProperty("user.dir"), "src", "test", "resources", "testdata", "excel", "TestData.xlsx");
		FileInputStream fis = new FileInputStream(path.toString());
		
		try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = workbook.getSheet("write");

			for (Row row : sheet) {
				Cell cell = row.createCell(2);

				cell.setCellValue("Updated using Apache POI Library on " + new Date());

			}
			FileOutputStream fos = new FileOutputStream(path.toString());
			workbook.write(fos);
			fos.close();
			System.out.println("Excel File Updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}