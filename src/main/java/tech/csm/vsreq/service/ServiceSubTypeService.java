package tech.csm.vsreq.service;

import java.util.List;

import tech.csm.vsreq.model.ServiceSubType;

public interface ServiceSubTypeService {

	List<ServiceSubType> getServiceSubTypeByServiceTypeId(Integer service_type_id);

}
