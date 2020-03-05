package Utility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public XSSFWorkbook book = null;;
public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	public ExcelUtil(String filePath, String sheetName) throws IOException {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			book = new XSSFWorkbook(fis);
			fis.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);

	}

	public int getRowCount() { 
		return 0;

	}

	public int getColCount() {
		return 0;

	}

	public int get() {
		return 0;

	}



	public static void main(String[] args) throws IOException {	
		ExcelUtil obj=new ExcelUtil("H:\\eclipseWin10\\com.ResurrectionGridAF\\src\\main\\java\\Data\\ExcdlFile.xlsx", "Sheet1");
		System.out.println(obj.sheet.getPhysicalNumberOfRows()); //3
		System.out.println(obj.sheet.getRow(0).getPhysicalNumberOfCells());//3
		for(int i=0;i<obj.sheet.getPhysicalNumberOfRows();i++) {
			
			for(int j=0;j<obj.sheet.getRow(i).getPhysicalNumberOfCells();j++) {
				System.out.print(obj.sheet.getRow(i).getCell(j).getStringCellValue()+" ");			
			}
			System.out.println(" ");
		}
		
	
}
}