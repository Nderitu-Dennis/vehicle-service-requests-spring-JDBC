package tech.csm.vsreq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.vsreq.dao.ServiceRequestDao;
import tech.csm.vsreq.dto.ServiceRequestDto;
import tech.csm.vsreq.model.ServiceRequest;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {
	
	@Autowired
	private ServiceRequestDao serviceRequestDao;
	
	@Autowired
	private ServiceRequestDao dao;

	@Override
	public int saveRequest(ServiceRequest request) {
		return serviceRequestDao.saveRequest(request);
	}

	@Override
	public List<ServiceRequest> getAllRequests() {
		return serviceRequestDao.getAllRequests();
	}

	@Override
	public List<ServiceRequestDto> getAllRequestsView() {
        return dao.getAllRequestsView();

	}

}
