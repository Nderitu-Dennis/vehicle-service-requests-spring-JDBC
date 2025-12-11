package tech.csm.vsreq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tech.csm.vsreq.model.Manufacturer;

@Service
public interface ManufacturerService {

	public List<Manufacturer> getAllManufacturers();
	

}
