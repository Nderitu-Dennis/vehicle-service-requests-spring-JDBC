package tech.csm.vsreq.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tech.csm.vsreq.model.Manufacturer;

@Repository
public class ManufacturerDaoImpl implements ManufacturerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Manufacturer> getAllManufacturers() {
		String sql="SELECT manufacturer_id,manufacturer_name FROM manufacturer";
		//important to select fields needed by the view select element, esp id & name
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Manufacturer.class));
		
		
	}

}
