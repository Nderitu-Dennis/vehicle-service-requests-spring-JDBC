package tech.csm.vsreq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.vsreq.dao.ServiceRequestDao;
import tech.csm.vsreq.model.ServiceRequest;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {
	
	@Autowired
	private ServiceRequestDao serviceRequestDao;

	@Override
	public int saveRequest(ServiceRequest request) {
		return serviceRequestDao.saveRequest(request);
	}

}
