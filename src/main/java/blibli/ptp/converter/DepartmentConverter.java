package blibli.ptp.converter;

import java.util.ArrayList;
import java.util.List;

import blibli.ptp.base.BaseConverter;
import blibli.ptp.dto.DepartmentDTO;
import blibli.ptp.entity.Department;
import ma.glasnost.orika.MapperFacade;

public class DepartmentConverter {
	private final static MapperFacade mapperFacade;
	
	static{
		BaseConverter.MAPPER.classMap(Department.class, DepartmentDTO.class)
			.field("departmentCode", "departmentCode")
			.field("departmentName", "departmentName")
			.byDefault()
			.register();
		mapperFacade = BaseConverter.MAPPER.getMapperFacade();
	}
	
	public static Department toEntity(DepartmentDTO dto){
		return mapperFacade.map(dto, Department.class);
	}
	public static DepartmentDTO toDto(Department entity){
		return mapperFacade.map(entity, DepartmentDTO.class);
	}
	public static List<DepartmentDTO> toDto(List<Department> list){
		List<DepartmentDTO> listDto = new ArrayList<>();
		for (Department department : list) {
			listDto.add(toDto(department));
		}
		return listDto;
	}
}
