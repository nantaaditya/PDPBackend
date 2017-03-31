package blibli.ptp.service;

import java.util.List;

import blibli.ptp.dto.DepartmentDTO;

public interface DepartmentService {
	public boolean save(DepartmentDTO dto) throws Exception;
	public boolean update(DepartmentDTO dto) throws Exception;
	public DepartmentDTO getDepartmentById(String id) throws Exception;
	public List<DepartmentDTO> getListDepartment() throws Exception;
	public boolean deleteById(String id) throws Exception;
}
