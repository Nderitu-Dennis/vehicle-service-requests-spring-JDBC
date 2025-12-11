package tech.csm.vsreq.dao;

import java.util.List;

import tech.csm.vsreq.model.ServiceSubType;

public interface ServiceSubTypeDao {

	List<ServiceSubType> getServiceSubTypeByServiceTypeId(Integer service_type_id);

}
