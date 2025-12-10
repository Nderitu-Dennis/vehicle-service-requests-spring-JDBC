package tech.csm.vsreq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.vsreq.dao.ServiceTypeDao;
import tech.csm.vsreq.model.ServiceType;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
	
	@Autowired
	private ServiceTypeDao serviceTypeDao;

	@Override
	public List<ServiceType> getAllServiceTypes() {
		return serviceTypeDao.getAllServiceTypes();
	}

}
