package com.muran.api.config;

import com.muran.api.JacksonJsonProvider;
import com.muran.api.exception.handler.ExceptionMapperSupport;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

public class RestRegisterApplication extends ResourceConfig {
	public RestRegisterApplication() {

		// System.out.println("---------------ddddddd-----------------");
		// register resouce package
		packages("com.muran.api");

		// jar包中的必须指明
//		register(TestResource.class);

		// register(GroupResource.class);
		// register(GroupRoleResource.class);
		// register(RoleResource.class);
		// register(UserGroupResource.class);

		register(JacksonJsonProvider.class);

		// register filters
		register(RequestContextFilter.class);

		// 异常拦截
		register(ExceptionMapperSupport.class);
		// 上传文件特性
		//register(MultiPartFeature.class);
	}
}
