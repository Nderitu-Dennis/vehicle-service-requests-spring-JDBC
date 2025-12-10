package tech.csm.vsreq.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Manufacturer implements Serializable {

	private Integer manufacturer_id;

	private String manufacturer_name;

	private LocalDate created_at;

}
