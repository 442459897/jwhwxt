package com.muran.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  
@Target({ElementType.METHOD})
public @interface BussAnnotation {
	
	/**
	 * 
	 * @return 业务逻辑名称
	 */
	String bussName() default "未命名业务";
	/**
	 * 
	 * @return 是否需要登陆
	 */
	boolean login() default true;
	/**
	 * 
	 * @return 业务逻辑需要的权限
	 */
	String role() default "";
	/**
	 * 权限组
	 * @return
	 */
	String group() default "";
	
	/**
	 * 是否公开的，默认非公开
	 */
	boolean opened() default false;
}
