package tech.csm.vsreq.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tech.csm.vsreq.model.ServiceType;

@Repository
public class ServiceTypeDaoImpl implements ServiceTypeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ServiceType> getAllServiceTypes() {
		
		String sql="SELECT service_type_name FROM service_type";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ServiceType.class));
		
	}

}
