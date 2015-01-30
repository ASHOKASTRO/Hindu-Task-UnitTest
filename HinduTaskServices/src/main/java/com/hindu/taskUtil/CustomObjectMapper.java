package com.hindu.taskUtil;

import java.math.BigDecimal;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.map.ser.StdSerializerProvider;
import org.codehaus.jackson.map.ser.ToStringSerializer;


public class CustomObjectMapper extends ObjectMapper{
	 public CustomObjectMapper(){
	        StdSerializerProvider sp = new StdSerializerProvider();
	        sp.setNullValueSerializer(new NullSerializer());
	        this.setSerializerProvider(sp);
	         
	        SimpleModule module = new SimpleModule("HinduBigIntToString", new Version(1, 0, 0, null));
	        module.addSerializer(BigDecimal.class, new ToStringSerializer());
	        module.addSerializer(BigDecimal.class, new ToStringSerializer());
	        
	        registerModule(module);
	    }
}
