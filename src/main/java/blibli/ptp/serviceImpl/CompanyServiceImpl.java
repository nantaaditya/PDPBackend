package blibli.ptp.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blibli.ptp.converter.CompanyConverter;
import blibli.ptp.dto.CompanyDTO;
import blibli.ptp.entity.Company;
import blibli.ptp.repository.CompanyRepository;
import blibli.ptp.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	@Autowired
	private CompanyRepository companyRepository;
	private static final Logger log = Logger.getLogger(CompanyServiceImpl.class);
	
	@Override
	public boolean save(CompanyDTO dto) throws Exception {
		try {
			Company entity = CompanyConverter.toEntity(dto);
			Company savedCompany = companyRepository.findOne(entity.getCompanyCode());
			if(savedCompany != null)
				throw new Exception("Company code already exist");
			companyRepository.save(entity);
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}		
	}

	@Override
	public boolean update(CompanyDTO dto) throws Exception {
		try {
			Company entity = CompanyConverter.toEntity(dto);
			Company savedCompany = companyRepository.findOne(entity.getCompanyCode());
			if(savedCompany == null)
				throw new Exception("Company code not found");
			companyRepository.save(entity);
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}

	@Override
	public CompanyDTO getCompanyById(String id) throws Exception {
		try {
			Company entity = companyRepository.findOne(id);
			return CompanyConverter.toDto(entity);
		} catch (Exception e) {
			log.error(e);
			return null;
		}		
	}

	@Override
	public List<CompanyDTO> getListCompany() throws Exception {
		try {
			List<Company> list = (List<Company>) companyRepository.findAll();
			return CompanyConverter.toDto(list);
		} catch (Exception e) {
			log.error(e);
			return null;
		}		
	}

	@Override
	public boolean deleteById(String id) throws Exception {
		try {
			companyRepository.delete(id);
			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}		
	}

}
