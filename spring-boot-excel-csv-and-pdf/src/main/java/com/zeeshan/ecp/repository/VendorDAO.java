package com.zeeshan.ecp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zeeshan.ecp.entities.Vendor;

public interface VendorDAO extends JpaRepository<Vendor, Integer> {

	// @Query(value = "SELECT new com.zeeshan.da.dto.VendorDTO(v.venType,
	// count(v.venType)) FROM com.zeeshan.da.Vendor v GROUP BY v.venType ")
	@Query("SELECT v.venType, count(v.venType) FROM com.zeeshan.ecp.entities.Vendor v GROUP BY  v.venType")
	public List<Object[]> getVendorTypeCount();
}