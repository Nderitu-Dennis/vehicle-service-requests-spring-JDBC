package tech.csm.vsreq.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tech.csm.vsreq.model.ServiceSubType;
import tech.csm.vsreq.model.VehicleModel;

@Repository
public class ServiceSubTypeDaoImpl implements ServiceSubTypeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ServiceSubType> getServiceSubTypeByServiceTypeId(Integer service_type_id) {
		  String sql = "SELECT service_subtype_id, service_subtype_name " +
                  "FROM service_subtype WHERE service_type_id = ?";

     return jdbcTemplate.query(
             sql,
             (rs, rowNum) -> {
                 ServiceSubType subtype = new ServiceSubType();
                 subtype.setService_subtype_id(rs.getInt("service_subtype_id"));
                 subtype.setService_subtype_name(rs.getString("service_subtype_name"));
                 return subtype;
             },

             service_type_id

             );
	}
	  
         

}
