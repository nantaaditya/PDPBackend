package blibli.ptp.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blibli.ptp.converter.AccessibilityConverter;
import blibli.ptp.dto.AccessibilityDTO;
import blibli.ptp.entity.Accessibility;
import blibli.ptp.repository.AccessibilityRepository;
import blibli.ptp.service.AccessibilityService;

@Service
public class AccessibilityServiceImpl implements AccessibilityService{
	@Autowired
	private AccessibilityRepository accessibilityRepository;
	private static final Logger log = Logger.getLogger(AccessibilityServiceImpl.class);

	@Override
	public boolean save(AccessibilityDTO dto) throws Exception {
		try{
			Accessibility entity = AccessibilityConverter.toEntity(dto);
			Accessibility savedAccessibility = accessibilityRepository.findOne(dto.getAccessibility());
			if(savedAccessibility != null)
				throw new Exception("Accessibility already exist");
			accessibilityRepository.save(entity);
			return true;
		}catch(Exception e){
			log.error(e);
			return false;
		}		
	}

	@Override
	public boolean update(AccessibilityDTO dto) throws Exception {
		try{
			Accessibility entity = AccessibilityConverter.toEntity(dto);
			Accessibility savedAccessibility = accessibilityRepository.findOne(dto.getAccessibility());
			if(savedAccessibility == null)
				throw new Exception("Accessibility code not found");
			accessibilityRepository.save(entity);
			return true;
		}catch(Exception e){
			log.error(e);
			return false;
		}
	}

	@Override
	public AccessibilityDTO getAccessibilityById(String id) throws Exception {
		try{
			Accessibility entity = accessibilityRepository.findOne(id);			
			return AccessibilityConverter.toDto(entity);
		}catch(Exception e){
			log.error(e);
			return null;
		}		
	}

	@Override
	public List<AccessibilityDTO> getListAccessibility() throws Exception {
		try{
			List<Accessibility> listEntity = accessibilityRepository.findAll();
			return AccessibilityConverter.toDto(listEntity);
		}catch(Exception e){
			log.error(e);
			return null;
		}	
	}

	@Override
	public boolean deleteById(String id) throws Exception {
		try{
			accessibilityRepository.delete(id);
			return true;
		}catch(Exception e){
			log.error(e);
			return false;
		}
	}
}
