package com.muran.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  
@Target({ElementType.METHOD})
public @interface ServiceAOP {
	/**
	 * 是否公开的，默认非公开
	 */
	boolean requiredLogin() default false;
}
