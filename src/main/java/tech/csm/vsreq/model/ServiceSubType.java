package tech.csm.vsreq.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

public class ServiceSubType implements Serializable {
	
	private Integer service_subtype_id;
	
	
	private Integer service_type_id; 
	
	private String service_subtype_name;
	

}
