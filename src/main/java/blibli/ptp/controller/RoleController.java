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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import blibli.ptp.base.BasePath;
import blibli.ptp.dto.RoleDTO;
import blibli.ptp.exception.UnauthorizedException;
import blibli.ptp.model.BaseResponse;
import blibli.ptp.model.SingleBaseResponse;
import blibli.ptp.service.RoleService;
import blibli.ptp.util.Credential;

@RestController
@RequestMapping(value=BasePath.BASE_PATH+BasePath.ROLE)
public class RoleController {
	@Autowired
	private RoleService roleService;
	private static final Logger log = Logger.getLogger(RoleController.class); 
	
	@RequestMapping(
		value	= "/add",
		method	= RequestMethod.POST,
		consumes= {MediaType.APPLICATION_JSON_VALUE}
	)
	public BaseResponse save(@RequestParam String requestId, @RequestBody RoleDTO role) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			boolean value = roleService.save(role);		
			log.info("Role Controller - Add");
			return new BaseResponse(200, requestId, "Saved status : "+value);		
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}
	@RequestMapping(
		value	= "/udpate/{roleCode}",
		method	= RequestMethod.POST,
		consumes= {MediaType.APPLICATION_JSON_VALUE}
	)
	public BaseResponse update(@RequestParam String requestId, @RequestParam("roleCode") String id, @RequestBody RoleDTO role) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			role.setRole(id);
			boolean value = roleService.update(role);
			log.info("Role Controller - update");
			return new BaseResponse(200, requestId, "Update id : "+id+" status : "+value);		
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}
	@RequestMapping(
		value	= "/get/{roleCode}",
		method	= RequestMethod.GET,
		produces= {MediaType.APPLICATION_JSON_VALUE}
	)
	public @ResponseBody SingleBaseResponse<RoleDTO> getRole(@RequestParam String requestId, @PathVariable("roleCode") String id)  throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			RoleDTO role = roleService.getRoleById(id);
			log.info("Role Controller - Get by Id");
			return new SingleBaseResponse<RoleDTO>(200, "Get role by role code : "+id, requestId, role);
		}else{
			throw new UnauthorizedException("Unauthorized api access");			
		}
	}
	@RequestMapping(
			value	= "/getAll",
			method	= RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE}
	)
	public @ResponseBody SingleBaseResponse<List<RoleDTO>> getAllRole(@RequestParam String requestId) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			List<RoleDTO> listRole = roleService.getListRole();
			log.info("Role Controller - Get All");
			return new SingleBaseResponse<List<RoleDTO>>(200, "Get list role", requestId, listRole);
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}
	@RequestMapping(
			value	= "/remove/{roleCode}",
			method	= RequestMethod.DELETE,
			produces= {MediaType.APPLICATION_JSON_VALUE}
	)	
	public BaseResponse delete(@RequestParam String requestId, @PathVariable("roleCode") String id) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			boolean result = roleService.deleteById(id);
			log.info("Role Controller - Delete");
			return new BaseResponse(200, requestId, "Deleted role code : "+id+" status : "+result);
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}	
}
