package blibli.ptp.model;

import java.io.Serializable;

public class BaseResponse implements Serializable {

  private int code;
  private String requestId;
  private String message;

  public BaseResponse() {
	  this.code	= 200;	  
  }
  
  public BaseResponse(int code, String requestId, String message){	  
	  this.code	= code;
	  this.requestId = requestId;
	  this.message	= message;
  }
  
  public String getRequestId() {
	return requestId;
  }
	
  public void setRequestId(String requestId) {
	this.requestId = requestId;
  }

  public int getCode() {
	return code;
  }
	
  public void setCode(int code) {
	  this.code = code;
  }
	
  public String getMessage() {
	  return message;
  }
	
  public void setMessage(String message) {
	  this.message = message;
  }
	
  @Override
  public String toString() {
	  return "BaseResponse{"
			  + "code='"
			  + code
			  + '\''
			  + ", message='"
			  + message        
			  + '}';
  }
}
