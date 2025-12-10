package tech.csm.vsreq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.vsreq.dao.ManufacturerDao;
import tech.csm.vsreq.model.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	@Autowired
	private ManufacturerDao manufacturerDao;

	@Override
	public List<Manufacturer> getAllManufacturers() {
		return manufacturerDao.getAllManufacturers();
			}

}
