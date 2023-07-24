package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	@DataProvider(name="login")
	public String[][] logindata() throws IOException
	{
		ExcelUtility xl = new ExcelUtility("/Users/anwaya/eclipse-workspace/MySutra_Life/testdata/Mysutra_LoginData.xlsx");
		
		int row = xl.getRowCount("Sheet1");
		int col = xl.getCellCount("Sheet1", 1);
		
		String data[][] = new String[row][col];
		
		for(int i=1;i<=row;i++)
		{
			for(int j=0;j<col;j++)
			{
				data[i-1][j] = xl.getCellData("Sheet1", i, j);
			}
		}
		
		return data;
	}
}
