package tech.csm.vsreq.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tech.csm.vsreq.model.ServiceRequest;

@Repository
public class ServiceRequestDaoImpl implements ServiceRequestDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveRequest(ServiceRequest request) {
	    String sql = "INSERT INTO service_request "
	            + "(customer_name, manufacturer_id, model_id, service_type_id, service_subtype_id, "
	            + "priority, scheduled_date, attachment_path, created_at) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    return jdbcTemplate.update(sql,
	            request.getCustomer_name(),
	            request.getManufacturer_id(),
	            request.getModel_id(),
	            request.getService_type_id(),
	            request.getService_subtype_id(),
	            request.getPriority(),
	            request.getScheduled_date(),  // can be null if priority != SCHEDULED
	            request.getAttachment_path(), // can be null if no file uploaded
	            java.sql.Timestamp.valueOf(request.getCreated_at())
	    );
	}

	  

}
