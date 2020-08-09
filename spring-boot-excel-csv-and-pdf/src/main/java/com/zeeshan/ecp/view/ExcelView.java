package com.zeeshan.ecp.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.zeeshan.ecp.entities.Vendor;

public class ExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook book, HttpServletRequest requset,
			HttpServletResponse response) throws Exception {

		// Specify file name
		response.addHeader("Content-Disposition", "attachment;filename=VENDORS.xlsx");

		// Read data from Model Map
		@SuppressWarnings("unchecked")
		List<Vendor> vendors = (List<Vendor>) map.get("vens");

		// Create a sheet
		// HSSFSheet sheet = (HSSFSheet) book.createSheet();

		Sheet sheet = book.createSheet();

		// Set the head-row zero
		setHead(sheet);

		// set the body-List to rows
		setBody(sheet, vendors);

	}

	/* private void setBody(HSSFSheet sheet, List<Vendor> vendors) { */
	private void setBody(Sheet sheet, List<Vendor> vendors) {

		int rowNum = 1;
		for (Vendor v : vendors) {
			// HSSFRow row = sheet.createRow(rowNum++);

			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(v.getVenId());
			row.createCell(1).setCellValue(v.getVenCode());
			row.createCell(2).setCellValue(v.getVenName());
			row.createCell(3).setCellValue(v.getVenType());
			row.createCell(4).setCellValue(v.getAddr());
			row.createCell(5).setCellValue(v.getIdType());
			row.createCell(6).setCellValue(v.getIdNum());
			row.createCell(7).setCellValue(v.getDesc());

		}

	}

	/* private void setHead(HSSFSheet sheet) { */
	private void setHead(Sheet sheet) {

		int rowNum = 0;
		/* HSSFRow row = sheet.createRow(rowNum); */
		Row row = sheet.createRow(rowNum);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("NAME");
		row.createCell(3).setCellValue("TYPE");
		row.createCell(4).setCellValue("ADDRESS");
		row.createCell(5).setCellValue("IDPROOF");
		row.createCell(6).setCellValue("IDNUM");
		row.createCell(7).setCellValue("NOTE");

	}

}
