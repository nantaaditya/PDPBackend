package blibli.ptp.converter;

import java.util.ArrayList;
import java.util.List;

import blibli.ptp.base.BaseConverter;
import blibli.ptp.dto.AccessibilityDTO;
import blibli.ptp.entity.Accessibility;
import ma.glasnost.orika.MapperFacade;

public class AccessibilityConverter {
	private final static MapperFacade mapperFacade;
	
	static{
		BaseConverter.MAPPER.classMap(Accessibility.class, AccessibilityDTO.class)
			.field("code", "accessibility")
			.field("description", "description")
			.byDefault()
			.register();
		mapperFacade = BaseConverter.MAPPER.getMapperFacade();
	}
	
	public static Accessibility toEntity(AccessibilityDTO dto){
		return mapperFacade.map(dto, Accessibility.class);
	}
	
	public static AccessibilityDTO toDto(Accessibility entity){
		return mapperFacade.map(entity, AccessibilityDTO.class);
	}
	
	public static List<AccessibilityDTO> toDto(List<Accessibility> listAccessibility){
		List<AccessibilityDTO> listDto = new ArrayList<AccessibilityDTO>(); 
		for (Accessibility accessibility: listAccessibility) {
			AccessibilityDTO dto = toDto(accessibility);
			listDto.add(dto);
		}
		return listDto;
	}
}
