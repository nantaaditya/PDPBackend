package blibli.ptp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import blibli.ptp.entity.Session;

public interface SessionRepository extends JpaRepository<Session, String> {

  Session findByUsername(String username) throws Exception;
  Session findByUsernameAndSessionId(String username, String sessionId) throws Exception;
  
}
