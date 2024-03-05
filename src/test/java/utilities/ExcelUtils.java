package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {
	FileInputStream fi;
	FileOutputStream fo;
	XSSFWorkbook wb;
	XSSFSheet ws;
	XSSFRow row;
	XSSFCell cell;

	public void writeExcel(String fileName, List<String> prodName, List<String> prodPrice) throws IOException {
		File file = new File(System.getProperty("user.dir") + "\\testdata\\" + fileName + ".xlsx");

		if (file.exists()) {
			fi = new FileInputStream(file);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet("NamePrice");
		} else {
			wb = new XSSFWorkbook();
			ws = wb.createSheet("NamePrice");
			createHeader(ws, "ProductName", "ProductPrice");
		}
		int r = 1;
		for (int i = 0; i < prodName.size(); i++) {
			row = ws.createRow(r);
			row.createCell(0).setCellValue(prodName.get(i));
			row.createCell(1).setCellValue(prodPrice.get(i));
			if (r <= 3) {
				colorRow(ws, row, IndexedColors.SKY_BLUE.getIndex());
			}
			r++;
		}
		ws.autoSizeColumn(0);
		ws.autoSizeColumn(1);
		fo = new FileOutputStream(file);
		wb.write(fo);
		fo.close(); // Close the FileOutputStream
	}

	public void writeExcelsDetails(String fileName, List<String> LivingStorage, List<String> Seating) throws IOException {
	    File file = new File(System.getProperty("user.dir") + "\\testdata\\" + fileName + ".xlsx");
	    if (file.exists()) {
	        fi = new FileInputStream(file);
	        wb = new XSSFWorkbook(fi);
	        if (wb.getSheet("Living") != null) {
	            ws = wb.getSheet("Living");
	            // Proceed with accessing the "Living" sheet
	            createHeader(ws, "LivingStorage", "Seating");
	        } else {
	            // Handle the case where the "Living" sheet does not exist
	        	ws = wb.createSheet("Living");
	        	createHeader(ws, "LivingStorage", "Seating");
	        }
	    } 
	    int r = 1;
	    for (int i = 0; i < LivingStorage.size(); i++) {
	        row = ws.createRow(r);
	        row.createCell(0).setCellValue(LivingStorage.get(i));
	        if (i < Seating.size()) {
	            row.createCell(1).setCellValue(Seating.get(i));
	        }
	        r++;
	    }
	    ws.autoSizeColumn(0);
	    ws.autoSizeColumn(1);
	    fo = new FileOutputStream(file);
	    wb.write(fo);
	    fo.close(); // Close the FileOutputStream
	}

	private void createHeader(XSSFSheet sheet, String Heading1, String Heading2) {
		Row headerRow = sheet.createRow(0);
		Cell productNameHeader = headerRow.createCell(0);
		productNameHeader.setCellValue(Heading1);
		Cell priceNameHeader = headerRow.createCell(1);
		priceNameHeader.setCellValue(Heading2);
		colorRow(sheet, headerRow, IndexedColors.DARK_BLUE.getIndex());
	}

	private void colorRow(XSSFSheet sheet, Row row, short color) {
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setFillForegroundColor(color);
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		Font font = sheet.getWorkbook().createFont();
		font.setBold(true);
		font.setColor(IndexedColors.WHITE.getIndex());
		cellStyle.setFont(font);
		for (Cell cell : row) {
			cell.setCellStyle(cellStyle);
		}
	}
}
