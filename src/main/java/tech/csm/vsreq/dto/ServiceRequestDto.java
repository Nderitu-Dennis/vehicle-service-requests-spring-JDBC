package tech.csm.vsreq.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServiceRequestDto {


    private Integer service_request_id;
    private String customer_name;

    private String manufacturer_name;
    private String model_name;
    private String service_type_name;
    private String service_subtype_name;

    private String priority;
    private LocalDate scheduled_date;
    private String attachment_path;
    private LocalDateTime created_at;
}
