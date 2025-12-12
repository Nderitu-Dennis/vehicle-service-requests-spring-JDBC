package tech.csm.vsreq.dao;

import tech.csm.vsreq.model.ServiceRequest;

public interface ServiceRequestDao {

	int saveRequest(ServiceRequest request);

}
