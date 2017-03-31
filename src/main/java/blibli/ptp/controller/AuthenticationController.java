package blibli.ptp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import blibli.ptp.base.BasePath;
import blibli.ptp.dto.AuthenticateRequest;
import blibli.ptp.dto.RegisterRequest;
import blibli.ptp.entity.User;
import blibli.ptp.model.BaseResponse;
import blibli.ptp.model.SingleBaseResponse;
import blibli.ptp.service.UserService;
import blibli.ptp.util.Credential;

@RestController
@RequestMapping(value = BasePath.BASE_PATH)
public class AuthenticationController {

  @Autowired
  private UserService userService;
  private static final Logger log = Logger.getLogger(AuthenticationController.class);

  @RequestMapping(
	value = BasePath.SIGNUP,
	method = RequestMethod.POST,
	consumes = {MediaType.APPLICATION_JSON_VALUE}
  )
 public BaseResponse register(@RequestParam String requestId, @RequestBody RegisterRequest request) throws Exception {    
    this.userService.register(request);
    log.info("Authenticate Controller - Register");
    return new BaseResponse(200, requestId, "Successfully registered");
  }
	  
  @RequestMapping(
    value = BasePath.LOGIN,
    method = RequestMethod.POST,
    consumes = {MediaType.APPLICATION_JSON_VALUE}
  )
  public SingleBaseResponse<String> authenticate(@RequestParam String requestId, @RequestBody AuthenticateRequest request) throws Exception {    
    String jwtToken = this.userService.authenticate(request.getUsername(), request.getPassword());
    log.info("Authenticate Controller - Login");
    return new SingleBaseResponse<String>(200, "Successfully logging in", requestId, jwtToken);
  }

  @RequestMapping(value = BasePath.LOGOUT, method = RequestMethod.GET)
  public BaseResponse unauthenticate(@RequestParam String requestId) throws Exception {
    this.userService.unauthenticate();
    log.info("Authenticate Controller - Logout");
    return new BaseResponse(200, requestId, "Successfully logging out");
  }
}
