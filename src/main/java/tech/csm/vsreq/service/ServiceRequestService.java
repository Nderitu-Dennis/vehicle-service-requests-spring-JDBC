package tech.csm.vsreq.service;

import java.util.List;

import tech.csm.vsreq.dto.ServiceRequestDto;
import tech.csm.vsreq.model.ServiceRequest;

public interface ServiceRequestService {

	int saveRequest(ServiceRequest request);

	List<ServiceRequest> getAllRequests();
	
    List<ServiceRequestDto> getAllRequestsView();

int deleteRequestById(Integer service_request_id);


}
