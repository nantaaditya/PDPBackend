package blibli.ptp.service;

import java.util.List;

import blibli.ptp.dto.RoleDTO;

public interface RoleService {
	public boolean save(RoleDTO dto) throws Exception;
	public boolean update(RoleDTO dto) throws Exception;
	public RoleDTO getRoleById(String id) throws Exception;
	public List<RoleDTO> getListRole() throws Exception;
	public boolean deleteById(String id) throws Exception;
}
