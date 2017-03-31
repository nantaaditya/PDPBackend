package blibli.ptp.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blibli.ptp.converter.CompanyConverter;
import blibli.ptp.converter.DepartmentConverter;
import blibli.ptp.dto.DepartmentDTO;
import blibli.ptp.entity.Department;
import blibli.ptp.repository.DepartmentRepository;
import blibli.ptp.service.DepartmentService;
import groovy.util.logging.Log;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentRepository departmentRepository;
	private static final Logger log = Logger.getLogger(DepartmentServiceImpl.class);

	@Override
	public boolean save(DepartmentDTO dto) throws Exception {
		try {
			Department entity = DepartmentConverter.toEntity(dto);
			Department result = departmentRepository.findOne(dto.getDepartmentCode());
			if(result != null)
				throw new Exception("Department already exist");			
			departmentRepository.save(entity);
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}		
	}

	@Override
	public boolean update(DepartmentDTO dto) throws Exception {
		try {
			Department entity = DepartmentConverter.toEntity(dto);
			Department result = departmentRepository.findOne(dto.getDepartmentCode());
			if(result == null)
				throw new Exception("Department code not found");			
			departmentRepository.save(entity);
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}

	@Override
	public DepartmentDTO getDepartmentById(String id) throws Exception {
		try {
			Department entity = departmentRepository.findOne(id);
			return DepartmentConverter.toDto(entity);			
		} catch (Exception e) {
			log.error(e);
			return null;
		}		
	}

	@Override
	public List<DepartmentDTO> getListDepartment() throws Exception {
		try {
			List<Department> list = (List<Department>) departmentRepository.findAll();
			return DepartmentConverter.toDto(list);
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

	@Override
	public boolean deleteById(String id) throws Exception {
		try {
			departmentRepository.delete(id);		
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}
}
