package tech.csm.vsreq.service;

import java.util.List;

import tech.csm.vsreq.model.VehicleModel;

public interface VehicleModelService {

	List<VehicleModel> getModelsByManufacturerId(Integer manufacturer_id);

}
