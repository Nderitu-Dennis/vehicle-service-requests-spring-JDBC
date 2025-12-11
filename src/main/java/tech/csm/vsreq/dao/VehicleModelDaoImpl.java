package tech.csm.vsreq.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tech.csm.vsreq.model.VehicleModel;

@Repository
public class VehicleModelDaoImpl implements VehicleModelDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<VehicleModel> getModelsByManufacturerId(Integer manufacturer_id) {

        String sql = "SELECT model_id, model_name " +
                     "FROM vehicle_model WHERE manufacturer_id = ?";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {
                    VehicleModel model = new VehicleModel();
                    model.setModel_id(rs.getInt("model_id"));
                    model.setModel_name(rs.getString("model_name"));
                    return model;
                },
                manufacturer_id
                );
    }
}

