package blibli.ptp.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blibli.ptp.converter.RoleConverter;
import blibli.ptp.dto.RoleDTO;
import blibli.ptp.entity.Role;
import blibli.ptp.repository.RoleRepository;
import blibli.ptp.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	private static final Logger log = Logger.getLogger(RoleServiceImpl.class);

	@Override
	public boolean save(RoleDTO dto) throws Exception {
		try{
			Role entity = RoleConverter.toEntity(dto);
			Role savedRole = roleRepository.findOne(dto.getRole());
			if(savedRole != null)
				throw new Exception("Role already exist");
			roleRepository.save(entity);
			return true;
		}catch(Exception e){
			log.error(e);
			return false;
		}		
	}

	@Override
	public boolean update(RoleDTO dto) throws Exception {
		try{
			Role entity = RoleConverter.toEntity(dto);		
			Role savedRole = roleRepository.findOne(dto.getRole());
			if(savedRole == null){
				throw new Exception("Role code not found");
			}
			roleRepository.save(entity);
			return true;
		}catch(Exception e){
			log.error(e);
			return false;
		}
	}

	@Override
	public RoleDTO getRoleById(String id) throws Exception {
		try{
			Role entity = roleRepository.findOne(id);			
			return RoleConverter.toDto(entity);
		}catch(Exception e){
			log.error(e);
			return null;
		}		
	}

	@Override
	public List<RoleDTO> getListRole() throws Exception {
		try{
			List<Role> listEntity = (List<Role>)roleRepository.findAll();
			return RoleConverter.toDto(listEntity);
		}catch(Exception e){
			log.error(e);
			return null;
		}		
	}

	@Override
	public boolean deleteById(String id) throws Exception {
		try{
			roleRepository.delete(id);
			return true;
		}catch(Exception e){
			log.error(e);
			return false;
		}		
	}

}
