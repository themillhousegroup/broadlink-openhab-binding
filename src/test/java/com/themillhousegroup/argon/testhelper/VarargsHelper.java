package com.themillhousegroup.argon.testhelper;

public class VarargsHelper {
	
	public static final String DEFAULT_STRING = "default";
	public static final String PROVIDED_STRING = "first";
	public static final String SECOND_PROVIDED_STRING = "second";
	
	public static final Appendable DEFAULT_APPENDABLE = new StringBuffer(DEFAULT_STRING);
	public static final Appendable PROVIDED_APPENDABLE = new StringBuffer(PROVIDED_STRING);
	public static final Appendable SECOND_PROVIDED_APPENDABLE = new StringBuffer(SECOND_PROVIDED_STRING);
	
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
