package blibli.ptp.converter;

import java.util.ArrayList;
import java.util.List;

import blibli.ptp.base.BaseConverter;
import blibli.ptp.dto.RoleDTO;
import blibli.ptp.entity.Role;
import ma.glasnost.orika.MapperFacade;

public class RoleConverter {
	private final static MapperFacade mapperFacade;
	
	static{
		BaseConverter.MAPPER.classMap(Role.class, RoleDTO.class)
			.field("code", "role")
			.field("description", "description")
			.byDefault()
			.register();
		mapperFacade = BaseConverter.MAPPER.getMapperFacade();
	}
	
	public static Role toEntity(RoleDTO dto){
		return mapperFacade.map(dto, Role.class);
	}
	
	public static RoleDTO toDto(Role entity){
		return mapperFacade.map(entity, RoleDTO.class);
	}
	
	public static List<RoleDTO> toDto(List<Role> listRole){
		List<RoleDTO> listDto = new ArrayList<>(); 
		for (Role role : listRole) {
			RoleDTO dto = toDto(role);
			listDto.add(dto);
		}
		return listDto;
	}
}
