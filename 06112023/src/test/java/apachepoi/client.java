package apachepoi;

import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.Test;

public class client {

	@Test
	public void tc001() throws IOException {

		String[][] dataProvider1 = ReadExcel.excelDataProvider("TestData.xlsx", "read");
		System.out.println(Arrays.deepToString(dataProvider1));

	}
}
