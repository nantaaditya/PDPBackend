package blibli.ptp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import blibli.ptp.base.BasePath;
import blibli.ptp.dto.DepartmentDTO;
import blibli.ptp.exception.UnauthorizedException;
import blibli.ptp.model.BaseResponse;
import blibli.ptp.model.SingleBaseResponse;
import blibli.ptp.service.DepartmentService;
import blibli.ptp.util.Credential;

@RestController
@RequestMapping(value=BasePath.BASE_PATH+BasePath.DEPARTMENT)
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	private static final Logger log = Logger.getLogger(DepartmentController.class);
	
	@RequestMapping(
		value	= "/add",
		method	= RequestMethod.POST,
		consumes= {MediaType.APPLICATION_JSON_VALUE}
	)	
	public BaseResponse save(@RequestParam String requestId, @RequestBody DepartmentDTO department) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			boolean result = departmentService.save(department);
			log.info("Department Controller - Add");
			return new BaseResponse(200, requestId, "Saved department : "+result);
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}
	@RequestMapping(
			value	= "/update/{departmentCode}",
			method	= RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE}
	)	
	public BaseResponse update(@RequestParam String requestId,@RequestParam("departmentCode") String id, @RequestBody DepartmentDTO department) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			department.setDepartmentCode(id);
			boolean result = departmentService.update(department);
			log.info("Department Controller - Add");
			return new BaseResponse(200, requestId, "Saved department : "+result);
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}
	@RequestMapping(
		value	= "/get/{departmentCode}",
		method	= RequestMethod.GET,
		produces= {MediaType.APPLICATION_JSON_VALUE}
	)
	public SingleBaseResponse<DepartmentDTO> getDepartment(@RequestParam String requestId, @PathVariable("departmentCode") String id) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			DepartmentDTO dto = departmentService.getDepartmentById(id);
			log.info("Department Controller - Get By Id");
			return new SingleBaseResponse<DepartmentDTO>(200, "Get department by id : "+id, requestId, dto);
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}
	@RequestMapping(
		value	= "/getAll",
		method	= RequestMethod.GET,
		produces= {MediaType.APPLICATION_JSON_VALUE}
	)
	public SingleBaseResponse<List<DepartmentDTO>> getAll(@RequestParam String requestId) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){	
			List<DepartmentDTO> list = departmentService.getListDepartment();
			log.info("Department Controller - Get All");
			return new SingleBaseResponse<List<DepartmentDTO>>(200, "Get list department", requestId, list);
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}
	public BaseResponse delete(@RequestParam String requestId, @PathVariable("departmentCode") String id) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			boolean result = departmentService.deleteById(id);
			log.info("Department Controller - Delete");
			return new BaseResponse(200, requestId, "Delete department : "+id+" result : "+result);
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}
	
}
