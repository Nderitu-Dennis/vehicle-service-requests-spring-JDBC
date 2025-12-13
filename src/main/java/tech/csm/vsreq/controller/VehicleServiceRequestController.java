package tech.csm.vsreq.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import tech.csm.vsreq.dto.ServiceRequestDto;
import tech.csm.vsreq.model.ServiceRequest;
import tech.csm.vsreq.model.ServiceSubType;
import tech.csm.vsreq.model.VehicleModel;
import tech.csm.vsreq.service.ManufacturerService;
import tech.csm.vsreq.service.ServiceRequestService;
import tech.csm.vsreq.service.ServiceSubTypeService;
import tech.csm.vsreq.service.ServiceTypeService;
import tech.csm.vsreq.service.VehicleModelService;
import tech.csm.vsreq.util.FileUtil;

@Controller
@RequestMapping("/requests")
public class VehicleServiceRequestController {

	@Autowired
	private ManufacturerService manufacturerService;

	@Autowired
	private ServiceTypeService serviceTypeService;

	@Autowired
	private VehicleModelService vehicleModelService;

	@Autowired
	private ServiceSubTypeService serviceSubTypeService;

	@Autowired
	private ServiceRequestService serviceRequestService;
	
		// injecting file util
	@Autowired
	private FileUtil fileUtil;

	// create service request form
	@GetMapping("/create")
	public String createServiceRequest(Model model) { //Model-Pass data from the controller to the view
		model.addAttribute("manufacturers", manufacturerService.getAllManufacturers());
		model.addAttribute("serviceTypes", serviceTypeService.getAllServiceTypes());
		return "form";
	}

	// AJAX // get models by manufacturer_id

	@GetMapping("/models")
	@ResponseBody
	public List<VehicleModel> getVehicleModelsByManufacturerId(
			@RequestParam("manufacturer_id") Integer manufacturer_id) {

		return vehicleModelService.getModelsByManufacturerId(manufacturer_id);
	}

	// Get service sub types by service type id

	@GetMapping("/subtypes")

	@ResponseBody
	public List<ServiceSubType> getServiceSubTypeByServiceTypeId(
			@RequestParam("service_type_id") Integer service_type_id) {
		return serviceSubTypeService.getServiceSubTypeByServiceTypeId(service_type_id);
	}

	// save a request
/*
 * @ModelAttribute-here used as a method param
 * Bind HTTP request form data to a Java object (model/entity/DTO) automatically
 * in the saveRequest method below, 'request' object now contains all form data automatically mapped
 * Binds form data with a Bean-Data binding, no need to parse each form field individually
 * */
	@PostMapping("/save")
	public String saveRequest(@Valid @ModelAttribute ServiceRequest request, BindingResult rs,
			@RequestParam("file") MultipartFile file, RedirectAttributes rd) {
		// run validations first

		if (rs.hasErrors()) {
			rd.addFlashAttribute("validationErrors", rs.getAllErrors());
			return "redirect:/requests/create";

		}

		// Validate child entities

		if (request.getModel_id() == 0) {
			rd.addFlashAttribute("error", "Please select a valid vehicle model");
			return "redirect:/requests/create";
		}

		if (request.getService_subtype_id() == 0) {
			rd.addFlashAttribute("error", "Please select a valid service sub type");
			return "redirect:/requests/create";
		}

		
		 // Upload file only if present
		if(file != null && !file.isEmpty()) { 
			String contentType = file.getContentType();
		// check file type
		if (contentType == null || !(contentType.equals("image/png") || contentType.equals("image/jpg")
				|| contentType.equals("image/jpeg") || contentType.equals("application/pdf"))) {
		  
		  rd.addFlashAttribute("error", "Only PNG, JPG, JPEG, PDF files allowed");
		  return "redirect:/requests/create"; }
		  
		  String uploadedFileName = fileUtil.uploadFile(file);
		  request.setAttachment_path(uploadedFileName); }
		 

		// proceed to save after validations
		int savedRequest = serviceRequestService.saveRequest(request);

		String msg = request.getCustomer_name() + ", your request has been received";
		rd.addFlashAttribute("msg", msg);
		return "redirect:/requests/create";

	}

//	file download 
	@GetMapping("/download")
	public ResponseEntity<Resource> downloadFile(@RequestParam("attachmentPath") String fileName) {

		try {
			Path filePath = Paths.get(fileUtil.getDirPath() + fileName);
			Resource resource = new UrlResource(filePath.toUri());

			if (!resource.exists()) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resource.getFilename())
					.body(resource);

		} catch (Exception e) {
			throw new RuntimeException("Error downloading file", e);
		}
	}


 // get requests list
 
	@GetMapping("")
	public String getServiceRequests(Model model) {
		List<ServiceRequestDto> requests = serviceRequestService.getAllRequestsView();

		// if null(no request), return an empty list
		if (requests == null) {
			requests = Collections.emptyList();
		}

		model.addAttribute("requests", requests);

		return "list";
	}
  
  
  
 // delete =vsreqs/requests/delete/service_request_id

@GetMapping("/delete")
public String deleteRequest(@RequestParam("service_request_id") Integer service_request_id, RedirectAttributes rd) {
	serviceRequestService.deleteRequestById(service_request_id);
	String msg = "Request delete success";
	rd.addFlashAttribute("msg", msg);
	return "redirect:/requests";
  }

//Use a direct view return when fetching data for display -return "form"
//Use a redirect after save, update, or del operations to prevent duplicate submissions. - return "redirect:/requests"

  
  }
