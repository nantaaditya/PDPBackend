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
import blibli.ptp.dto.CompanyDTO;
import blibli.ptp.exception.UnauthorizedException;
import blibli.ptp.model.BaseResponse;
import blibli.ptp.model.SingleBaseResponse;
import blibli.ptp.service.CompanyService;
import blibli.ptp.util.Credential;

@RestController
@RequestMapping(value=BasePath.BASE_PATH+BasePath.COMPANY)
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	private static final Logger log = Logger.getLogger(CompanyController.class);
	
	
	@RequestMapping(
		value	= "/add",
		method	= RequestMethod.POST,
		consumes= {MediaType.APPLICATION_JSON_VALUE}				
	)
	public BaseResponse save(@RequestParam String requestId, @RequestBody CompanyDTO company) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			boolean result = companyService.save(company);
			log.info("Company Controller - Add");
			return new BaseResponse(200, requestId, "Saved company : "+result);
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}
	@RequestMapping(
			value	= "/update/{companyCode}",
			method	= RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE}				
	)
	public BaseResponse update(@RequestParam String requestId,@RequestParam("companyCode") String id, @RequestBody CompanyDTO company) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			company.setCompanyCode(id);
			boolean result = companyService.update(company);
			log.info("Company Controller - Update");
			return new BaseResponse(200, requestId, "Saved company : "+result);
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}
	@RequestMapping(
		value	= "/get/{companyCode}",
		method	= RequestMethod.GET,
		produces= {MediaType.APPLICATION_JSON_VALUE}
	)	
	public SingleBaseResponse<CompanyDTO> getCompany(@RequestParam String requestId, @PathVariable("companyCode") String id) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			CompanyDTO dto	= companyService.getCompanyById(id);
			log.info("Company Controller - Get By Id");
			return new SingleBaseResponse<CompanyDTO>(200, "Get company by id : "+id, requestId, dto);
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}
	@RequestMapping(
		value	= "/getAll",
		method	= RequestMethod.GET,
		produces= {MediaType.APPLICATION_JSON_VALUE}
	)
	public SingleBaseResponse<List<CompanyDTO>> getAll(@RequestParam String requestId) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){
			List<CompanyDTO> listDto = companyService.getListCompany();
			log.info("Company Controller - Get All");
			return new SingleBaseResponse<List<CompanyDTO>>(200, "Get list company", requestId, listDto);
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}
	@RequestMapping(
		value	= "/delete/{companyCode}",
		method	= RequestMethod.DELETE,
		produces={MediaType.APPLICATION_JSON_VALUE}
	)
	public BaseResponse delete(@RequestParam String requestId, @PathVariable("companyCode") String id) throws Exception{
		log.warn(Credential.getUsername()+" { "+Credential.getRole()+" } -- { "+Credential.getAccessibility()+" }");
		if(Credential.getRole().contains("ROLE_ADMIN")){	
			boolean result = companyService.deleteById(id);
			log.info("Company COntroller - Delete");
			return new BaseResponse(200, requestId, "Delete company code : "+id+" status : "+result);
		}else{
			throw new UnauthorizedException("Unauthorized api access");
		}
	}
	
}
