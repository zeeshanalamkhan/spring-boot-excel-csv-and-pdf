package com.zeeshan.ecp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zeeshan.ecp.entities.Vendor;
import com.zeeshan.ecp.repository.VendorDAO;
import com.zeeshan.ecp.view.CSVView;
import com.zeeshan.ecp.view.ExcelView;
import com.zeeshan.ecp.view.PdfView;

@Controller
public class ViewController {

	@Autowired
	private VendorDAO dao;

	@RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
	public ModelAndView downloadExcel() {

		List<Vendor> vendors = dao.findAll();
		return new ModelAndView(new ExcelView(), "vens", vendors);
	}

	@RequestMapping(value = "/downloadCsv", method = RequestMethod.GET)
	public ModelAndView downloadCSV() {

		List<Vendor> vendors = dao.findAll();
		return new ModelAndView(new CSVView(), "vens", vendors);
	}

	@RequestMapping(value = "/downloadPdf", method = RequestMethod.GET)
	public ModelAndView downloadPdf() {

		List<Vendor> vendors = dao.findAll();
		return new ModelAndView(new PdfView(), "vens", vendors);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap map) {

		return "index";
	}
}
