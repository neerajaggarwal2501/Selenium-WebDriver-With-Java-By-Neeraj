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
		// Open the Excel File in Java as a Stream
		FileInputStream fis = new FileInputStream(Path.of(System.getProperty("user.dir"), "src", "test", "resources", "testdata", "excel", "TestData.xlsx").toString());

		try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

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

	public static String[][] excelDataProvider(String fileName, String sheetName) throws IOException {

		// Placeholder to output

		String[][] dataArray;

		// Open the Excel File in Java as a Stream
		FileInputStream fis = new FileInputStream(Path.of(System.getProperty("user.dir"), "src", "test", "resources", "testdata", "excel", fileName).toString());

		try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum() + 1;
			int colCount = sheet.getRow(0).getLastCellNum();
			dataArray = new String[rowCount][colCount];

			// Create a DataFormatter to format and get each cell's value as String
			DataFormatter dataFormatter = new DataFormatter();

			for (Row row : sheet) {
				for (Cell cell : row) {

					String cellValue = dataFormatter.formatCellValue(cell); // Returns the formatted value of a cell as a String regardless of the cell type.
																			// If the Excel format pattern cannot be parsed then the cell value will be formatted using a default format.
					dataArray[row.getRowNum()][cell.getAddress().getColumn()] = cellValue;
				}
				System.out.println();
			}
		}

		return dataArray;
	}
}