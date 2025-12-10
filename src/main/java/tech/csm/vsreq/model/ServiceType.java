package tech.csm.vsreq.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

public class ServiceType implements Serializable {
	
	private Integer service_type_id;
	
	private String service_type_name;

}
