package com.zeeshan.ecp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
public class SpringBootExcelCsvAndPdfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExcelCsvAndPdfApplication.class, args);
	}

	@Bean
	public ViewResolver viewResolver1() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setViewClass(JstlView.class);
		irvr.setPrefix("/WEB-INF/pages/");
		irvr.setSuffix(".jsp");
	//	irvr.setOrder(2);
		return irvr;
	}

	/*
	 * @Bean("excelView") public ViewResolver viewResolver2() {
	 * 
	 * ResourceBundleViewResolver rbvr = new ResourceBundleViewResolver(); //
	 * rbvr.setBasename("views"); rbvr.setOrder(1); return rbvr;
	 * 
	 * }
	 */
}
