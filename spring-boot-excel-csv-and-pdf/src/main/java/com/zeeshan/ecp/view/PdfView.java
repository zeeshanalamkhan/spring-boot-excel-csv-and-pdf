package com.zeeshan.ecp.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.zeeshan.ecp.entities.Vendor;

public class PdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 1:-to change file name and Download
		response.setHeader("Content-Disposition", "attachment;filename=VENDORS.pdf");

		// 2:-To read Data from Model Map
		@SuppressWarnings("unchecked")
		List<Vendor> vendors = (List<Vendor>) model.get("vens");

		// 3:-Create a Element Paragraph

		Paragraph paragraph = new Paragraph("Welcome to Vendor Pdf File!!\n");

		// Table with heading Data
		PdfPTable pdfPTable = new PdfPTable(8);
		pdfPTable.addCell("ID");
		pdfPTable.addCell("CODE");
		pdfPTable.addCell("NAME");
		pdfPTable.addCell("TYPE");
		pdfPTable.addCell("ADDRESS");
		pdfPTable.addCell("ID-PROOF");
		pdfPTable.addCell("ID-NUM");
		pdfPTable.addCell("NOTE");

		for (Vendor ven : vendors) {

			pdfPTable.addCell(ven.getVenId() + "");
			pdfPTable.addCell(ven.getVenCode());
			pdfPTable.addCell(ven.getVenName());
			pdfPTable.addCell(ven.getVenType());
			pdfPTable.addCell(ven.getAddr());
			pdfPTable.addCell(ven.getIdType());
			pdfPTable.addCell(ven.getIdNum());
			pdfPTable.addCell(ven.getDesc());

		}

		// 3:-add Element to document
		document.add(paragraph);
		document.add(pdfPTable);
		document.add(new Paragraph(new Date().toString()));
	}

}
