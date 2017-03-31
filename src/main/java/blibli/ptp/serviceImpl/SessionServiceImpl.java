package blibli.ptp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import blibli.ptp.entity.Session;
import blibli.ptp.repository.SessionRepository;
import blibli.ptp.service.SessionService;
import blibli.ptp.util.Credential;

@Service
@Transactional(readOnly = true)
public class SessionServiceImpl implements SessionService {

  @Autowired
  private SessionRepository sessionRepository;

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void create(String username) throws Exception {
    if (StringUtils.isEmpty(username)) {
      throw new Exception("Invalid username");
    }
    Session savedSession = this.sessionRepository.findByUsername(username);
    if (savedSession != null) {
      this.sessionRepository.delete(savedSession.getId());
      this.sessionRepository.flush();
    }
    Session session = new Session();
    session.setUsername(username);
    session.setSessionId(Credential.getSessionId());
    session.setHostname(Credential.getHostname());
    this.sessionRepository.save(session);
  }

  @Override
  public boolean isAuthorized() throws Exception {
    Session session =
        this.sessionRepository.findByUsernameAndSessionId(
            Credential.getUsername(), Credential.getSessionId());
    return session != null;
  }

  @Override
  @Transactional(readOnly = false, rollbackFor = Exception.class)
  public void remove() throws Exception {
    Session session =
        this.sessionRepository.findByUsernameAndSessionId(
            Credential.getUsername(), Credential.getSessionId());
    if (session != null) {
      this.sessionRepository.delete(session.getId());
    }
  }
}
