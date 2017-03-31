package blibli.ptp.service;

import java.util.List;

import blibli.ptp.dto.CompanyDTO;

public interface CompanyService {
	public boolean save(CompanyDTO dto) throws Exception;
	public boolean update(CompanyDTO dto) throws Exception;
	public CompanyDTO getCompanyById(String id) throws Exception;
	public List<CompanyDTO> getListCompany() throws Exception;
	public boolean deleteById(String id) throws Exception;
}
