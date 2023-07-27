package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	@DataProvider(name="login")
	public String[][] logindata() throws IOException
	{
		ExcelUtility xl = new ExcelUtility("/Users/anwaya/eclipse-workspace/MySutra_Life/testdata/mysutra.xlsx");
		
		int row = xl.getRowCount("data");
		int col = xl.getCellCount("data", 1);
		
		String data[][] = new String[row][col];
		
		for(int i=0;i<=row;i++)
		{
			for(int j=0;j<col;j++)
			{
				data[i][j] = xl.getCellData("data", i, j);
			}
		}
		
		return data;
	}
}
