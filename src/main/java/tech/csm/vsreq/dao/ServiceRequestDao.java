package tech.csm.vsreq.dao;

import java.util.List;

import tech.csm.vsreq.dto.ServiceRequestDto;
import tech.csm.vsreq.model.ServiceRequest;

public interface ServiceRequestDao {

	int saveRequest(ServiceRequest request);

	List<ServiceRequest> getAllRequests();

	List<ServiceRequestDto> getAllRequestsView();

}
