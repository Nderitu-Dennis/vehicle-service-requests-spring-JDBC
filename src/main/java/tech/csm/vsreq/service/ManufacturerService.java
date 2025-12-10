package tech.csm.vsreq.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.vsreq.model.Manufacturer;
import tech.csm.vsreq.repository.ManufacturerRepository;

@Service
public interface ManufacturerService {


	public List<Manufacturer> getAllManufacturers();
	

}
