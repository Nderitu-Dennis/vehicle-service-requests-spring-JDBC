package tech.csm.vsreq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.vsreq.dao.VehicleModelDao;
import tech.csm.vsreq.model.VehicleModel;

@Service
public class VehicleModelServiceImpl implements VehicleModelService {
	
	@Autowired
	private VehicleModelDao vehicleModelDao;

	@Override
	public List<VehicleModel> getModelsByManufacturerId(Integer manufacturer_id) {
		return vehicleModelDao.getModelsByManufacturerId(manufacturer_id);
	}

}
