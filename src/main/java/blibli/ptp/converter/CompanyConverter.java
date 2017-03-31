package blibli.ptp.converter;

import java.util.ArrayList;
import java.util.List;

import blibli.ptp.base.BaseConverter;
import blibli.ptp.dto.CompanyDTO;
import blibli.ptp.entity.Company;
import blibli.ptp.entity.Department;
import ma.glasnost.orika.MapperFacade;

public class CompanyConverter {
	private final static MapperFacade mapperFacade;
	
	static{
		BaseConverter.MAPPER.classMap(Company.class, CompanyDTO.class)
			.field("companyCode", "companyCode")
			.field("companyName", "companyName")
			.byDefault()
			.register();
		mapperFacade = BaseConverter.MAPPER.getMapperFacade();
	}
	
	public static Company toEntity(CompanyDTO dto){
		return mapperFacade.map(dto, Company.class);
	}
	public static CompanyDTO toDto(Company entity){
		return mapperFacade.map(entity, CompanyDTO.class);
	}
	public static List<CompanyDTO> toDto(List<Company> list){
		List<CompanyDTO> listDto = new ArrayList<>();
		for (Company company : list) {
			listDto.add(toDto(company));
		}
		return listDto;
	}
}
