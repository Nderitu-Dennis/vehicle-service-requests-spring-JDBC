package tech.csm.vsreq.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

//when moving from JPA 	to spring JDBC remove anything frm: jakarta.persistence.

public class ServiceRequest implements Serializable {

	private Integer service_request_id;

	@NotBlank(message = "customer name cannot be blank")
	private String customer_name;

	private Integer manufacturer_id;;

	private Integer model_id;

	
	private Integer service_type_id;

	private Integer service_subtype_id;

	private String priority;

	@FutureOrPresent(message = "scheduled date cannot be in the past")
	private LocalDate scheduled_date;

	private String attachment_path;

	private LocalDateTime created_at = LocalDateTime.now();

}
