package tech.csm.vsreq.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tech.csm.vsreq.dto.ServiceRequestDto;
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

	@Override
	public List<ServiceRequest> getAllRequests() {
		String sql="SELECT * FROM service_request";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ServiceRequest.class));
	}

	@Override
	public List<ServiceRequestDto> getAllRequestsView() {
		
		String sql = 
	            "SELECT sr.service_request_id, sr.customer_name, sr.priority, " +
	            "sr.scheduled_date, sr.attachment_path, sr.created_at, " +
	            		
	            "m.manufacturer_name, "
	            + "vm.model_name,"
	            + " st.service_type_name, " +
	            "sst.service_subtype_name " +
	            
	            "FROM service_request sr " +
	            
	            "JOIN manufacturer m ON sr.manufacturer_id = m.manufacturer_id " +
	            "JOIN vehicle_model vm ON sr.model_id = vm.model_id " +
	            "JOIN service_type st ON sr.service_type_id = st.service_type_id " +
	            "JOIN service_subtype sst ON sr.service_subtype_id = sst.service_subtype_id";

	        return jdbcTemplate.query(sql, new RowMapper<ServiceRequestDto>() {
	            @Override
	            public ServiceRequestDto mapRow(ResultSet rs, int rowNum) throws SQLException {
	                ServiceRequestDto dto = new ServiceRequestDto();

	                dto.setService_request_id(rs.getInt("service_request_id"));
	                dto.setCustomer_name(rs.getString("customer_name"));
	                dto.setPriority(rs.getString("priority"));
	                
	                //allow null at scheduled date
	                Date sched = rs.getDate("scheduled_date");
	                if (sched != null) {
	                    dto.setScheduled_date(sched.toLocalDate());
	                }	
	                
	                dto.setAttachment_path(rs.getString("attachment_path"));

	                dto.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());

	                dto.setManufacturer_name(rs.getString("manufacturer_name"));
	                dto.setModel_name(rs.getString("model_name"));
	                dto.setService_type_name(rs.getString("service_type_name"));
	                dto.setService_subtype_name(rs.getString("service_subtype_name"));

	                return dto;
	            }
	        });
	    }
	
	}




