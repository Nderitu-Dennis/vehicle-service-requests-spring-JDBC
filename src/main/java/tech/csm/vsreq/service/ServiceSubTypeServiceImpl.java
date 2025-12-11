package tech.csm.vsreq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.vsreq.dao.ServiceSubTypeDao;
import tech.csm.vsreq.model.ServiceSubType;

@Service
public class ServiceSubTypeServiceImpl implements ServiceSubTypeService {
	
	@Autowired
	private ServiceSubTypeDao serviceSubTypeDao ; 

	@Override
	public List<ServiceSubType> getServiceSubTypeByServiceTypeId(Integer service_type_id) {
		return serviceSubTypeDao.getServiceSubTypeByServiceTypeId(service_type_id);
	}

}
