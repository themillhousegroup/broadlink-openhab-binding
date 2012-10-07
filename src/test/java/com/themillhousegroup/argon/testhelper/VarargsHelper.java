package com.themillhousegroup.argon.testhelper;

public class VarargsHelper {
	
	public static final String DEFAULT_STRING = "default";
	public static final String PROVIDED_STRING = "first";
	public static final String SECOND_PROVIDED_STRING = "second";
	
	public static Object[] nullVarargs() {
		return null;
	}
	
	public static Object[] emptyVarargs() {
		return new Object[0];
	}
	
	public static Object[] nullFirstVararg() {
		Object[] args = {null};
		return args;
	}
}
