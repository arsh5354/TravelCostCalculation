package utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public FileOutputStream fs;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFRow row;
	public XSSFCell cell;
	
	public void createExcel(String path, String sheetName) throws IOException {
		
		File file = new File(path);
		
		if(file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			fis.close();
		}
		else {
			wb = new XSSFWorkbook();
		}
		
		ws = wb.createSheet(sheetName);
		
	}
	
	public void setData(int rownum, int cellNum, String data) {
		
		row = ws.getRow(rownum);
		if(row == null) {
			row = ws.createRow(rownum);
		}
		
		cell =row.createCell(cellNum);
		cell.setCellValue(data);
		
	}
	
	
	public void saveData(String path) throws IOException  {
		
		fs = new FileOutputStream(path);
		wb.write(fs);
		fs.close();
		wb.close();
		
	}
	
}
