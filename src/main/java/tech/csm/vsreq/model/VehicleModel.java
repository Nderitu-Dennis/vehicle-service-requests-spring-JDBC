package tech.csm.vsreq.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class VehicleModel implements Serializable {
	

	private Integer model_id;
	
	//private Integer manufacturer_id;
	
	private String model_name;
	
	private LocalDate created_at;
	

}
