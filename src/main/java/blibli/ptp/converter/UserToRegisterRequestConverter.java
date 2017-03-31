package blibli.ptp.converter;

import java.util.ArrayList;
import java.util.List;

import blibli.ptp.base.BaseConverter;
import blibli.ptp.dto.RegisterRequest;
import blibli.ptp.entity.User;
import ma.glasnost.orika.MapperFacade;


public class UserToRegisterRequestConverter {
//	INSTANCE;
	private final static MapperFacade mapperFacade;
	
	static{
		BaseConverter.MAPPER.classMap(User.class, RegisterRequest.class)
			.field("listRole{code}", "listRole{}")
			.field("listAccessibility{code}", "listAccessibility{}")
			.field("directSuperior.id", "directSuperior")
			.field("company.companyCode", "company")
			.field("department.departmentCode", "department")
			.byDefault()
			.register();
		mapperFacade	= BaseConverter.MAPPER.getMapperFacade();
	}
	
	public static User toEntity(RegisterRequest dto){
		return mapperFacade.map(dto, User.class);
	}
	public static RegisterRequest toDto(User entity){
		return mapperFacade.map(entity, RegisterRequest.class);
	}
}
