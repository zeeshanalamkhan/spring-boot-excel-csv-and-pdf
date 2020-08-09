package com.zeeshan.ecp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeeshan.ecp.entities.Vendor;
import com.zeeshan.ecp.repository.VendorDAO;

@RestController
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private VendorDAO dao;

	@GetMapping("/all")
	public List<Vendor> getAll() {

		return dao.findAll();
	}

	@GetMapping("/{id}")
	public Vendor getVendor(@PathVariable Integer id) {

		return dao.findById(id).get();
	}

	@PostMapping("/new")
	public Vendor newVendor(@RequestBody Vendor vendor) {

		return dao.save(vendor);

	}

	@GetMapping("/count")
	public List<Object[]> findCount() {

		return dao.getVendorTypeCount();
	}

	@PutMapping("/update")
	public Vendor updateVendor(@RequestBody Vendor vendor) {

		return dao.save(vendor);
	}

}
