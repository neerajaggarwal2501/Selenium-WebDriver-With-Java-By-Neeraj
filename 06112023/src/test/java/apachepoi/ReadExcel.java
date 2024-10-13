package apachepoi;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws IOException {
		// Path of the excel file
		FileInputStream fs = new FileInputStream(Path.of(System.getProperty("user.dir"), "src", "test", "resources", "testdata", "excel", "TestData.xlsx").toString());

		// Creating a workbook
		try (XSSFWorkbook workbook = new XSSFWorkbook(fs)) {
			XSSFSheet sheet = workbook.getSheet("read");

			// Create a DataFormatter to format and get each cell's value as String
			DataFormatter dataFormatter = new DataFormatter();

			for (Row row : sheet) {
				for (Cell cell : row) {

					String cellValue = dataFormatter.formatCellValue(cell); // Returns the formatted value of a cell as a String regardless of the cell type.
																			// If the Excel format pattern cannot be parsed then the cell value will be formatted using a default format.
					System.out.print(cellValue + "\t");
				}
				System.out.println();
			}
		}
	}
}