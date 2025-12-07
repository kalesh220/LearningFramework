package utility;

import org.testng.annotations.DataProvider;

public class ProviderFromExcel {

    @DataProvider(name = "login-data")
    public Object[][] getData() {

        String path = "./src/test/resources/data.xlsx";
        String sheetName = "sheet1";

        int rows = ExcelFileHandling.getRowsCount(sheetName, path);
        int cells = ExcelFileHandling.getCellsCount(path, sheetName, rows);
        Object[][] data = new String[rows][cells];
        System.out.println(rows + " " + cells);
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cells; j++) {
                data[i][j] = ExcelFileHandling.getCellData(path, sheetName, i, j);
            }
        }
        return data;
    }
}
