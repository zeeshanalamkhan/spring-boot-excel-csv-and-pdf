package com.zeeshan.ecp.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.zeeshan.ecp.entities.Vendor;

public class CSVView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Specify file name
		response.addHeader("Content-Disposition", "attachment;filename=VENDORS.csv");

		String[] header = { "venId", "venCode", "venName", "venType", "addr", "idType", "idNum", "desc" };

		// Read data from Model Map
		@SuppressWarnings("unchecked")
		List<Vendor> vendors = (List<Vendor>) model.get("vens");

		ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		csvBeanWriter.writeHeader(header);

		for (Vendor v : vendors) {
			csvBeanWriter.write(v, header);
		}

		csvBeanWriter.close();

	}

}
