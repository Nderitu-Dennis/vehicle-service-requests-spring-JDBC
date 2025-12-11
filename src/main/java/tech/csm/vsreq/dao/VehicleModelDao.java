package tech.csm.vsreq.dao;

import java.util.List;

import tech.csm.vsreq.model.VehicleModel;

public interface VehicleModelDao {

	List<VehicleModel> getModelsByManufacturerId(Integer manufacturer_id);

}
