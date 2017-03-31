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
import blibli.ptp.dto.AccessibilityDTO;
import blibli.ptp.exception.UnauthorizedException;
import blibli.ptp.model.BaseResponse;
import blibli.ptp.model.SingleBaseResponse;
import blibli.ptp.service.AccessibilityService;
import blibli.ptp.util.Credential;

@RestController
@RequestMapping(value=BasePath.BASE_PATH+BasePath.ACCESSIBILITY)
public class AccessibilityController {
	@Autowired	
	private AccessibilityService accessibilityService;
	private static final Logger log = Logger.getLogger(AccessibilityController.class);

	@RequestMapping(
		value = "/add",
		method = RequestMethod.POST,
		consumes = {MediaType.APPLICATION_JSON_VALUE}
	)
	public BaseResponse save(@RequestParam String requestId, @RequestBody AccessibilityDTO accessibility) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			boolean value = accessibilityService.save(accessibility);
			log.info("Accessibility Controller - Add");
			return new BaseResponse(200, requestId, "Saved status : "+value);
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}
	@RequestMapping(
		value	= "/udpate/{accessibilityCode}",
		method	= RequestMethod.POST,
		consumes= {MediaType.APPLICATION_JSON_VALUE}
	)
	public BaseResponse update(@RequestParam String requestId, @RequestParam("accessibilityCode") String id, @RequestBody AccessibilityDTO accessibility) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			accessibility.setAccessibility(id);
			boolean value = accessibilityService.update(accessibility);
			log.info("Accessibility Controller - Update");
			return new BaseResponse(200, requestId, "Update id : "+id+" status : "+value);		
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}
	@RequestMapping(
		value = "/get/{accessibilityCode}",
		method = RequestMethod.GET,
		produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	public SingleBaseResponse<AccessibilityDTO> getRole(@RequestParam String requestId, @PathVariable("accessibilityCode") String id) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			AccessibilityDTO accessibility = accessibilityService.getAccessibilityById(id);
			log.info("Accessibility Controller - Get by Id");
			return new SingleBaseResponse<AccessibilityDTO>(200, "Get role by role code : "+id, requestId, accessibility);
		}else{
			throw new UnauthorizedException("Unauthorized api acces");
		}
	}
	@RequestMapping(
		value = "/getAll",
		method = RequestMethod.GET,
		produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	public SingleBaseResponse<List<AccessibilityDTO>> getAllRole(@RequestParam String requestId)throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			List<AccessibilityDTO> listAccessibilty = accessibilityService.getListAccessibility();
			log.info("Accessibility Controller - Get All");
			return new SingleBaseResponse<List<AccessibilityDTO>>(200, "Get list role", requestId, listAccessibilty);
		}else{
			throw new UnauthorizedException("Unauthorized api acces");
		}
	}
	@RequestMapping(
		value = "/remove/{accessibilityCode}",
		method = RequestMethod.DELETE,
		produces = {MediaType.APPLICATION_JSON_VALUE}
	)	
	public BaseResponse delete(@RequestParam String requestId, @PathVariable("accessibilityCode") String id) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			boolean result = accessibilityService.deleteById(id);
			log.info("Accessibility Controller - Delete");
			return new BaseResponse(200, requestId, "Deleted role code : "+id+" status : "+result);
		}else{
			throw new UnauthorizedException("Unauthorized api acces");
		}
	}
}
