package blibli.ptp.service;

import blibli.ptp.dto.RegisterRequest;
import blibli.ptp.entity.User;
import io.jsonwebtoken.Claims;

public interface UserService {

  String authenticate(String username, String password) throws Exception;
  String generateJwtToken(User user) throws Exception;
  User findByUsername(String username) throws Exception;
  Claims parseJwtToken(String jwtToken);
  void register(RegisterRequest dto) throws Exception;
  void unauthenticate() throws Exception;
  
}
