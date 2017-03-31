package blibli.ptp.base;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class BaseConverter {
	public final static MapperFactory MAPPER	= new DefaultMapperFactory.Builder().build();
}
