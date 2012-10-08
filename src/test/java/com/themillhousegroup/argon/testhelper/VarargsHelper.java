package com.themillhousegroup.argon.testhelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
	
	public static Collection<Object> nullCollection() {
		return null;
	}
	
	public static Collection<Object> emptyCollection() {
		return new ArrayList<Object>();
	}
	
	public static Collection<Object> collectionOf(Object... objects) {
		List<Object> list = new ArrayList<Object>();
		for (Object o : objects) {
			list.add(o);
		}
		return list;
	}
	
	public static Set<Object> emptySet() {
		return new HashSet<Object>();
	}
	
	public static Set<Object> nullSet() {
		return null;
	}
	
	public static Set<Object> setOf(Object... objects) {
		Set<Object> set = new LinkedHashSet<Object>();
		for (Object o : objects) {
			set.add(o);
		}
		return set;
	}
	
	public static List<Object> emptyList() {
		return new ArrayList<Object>();
	}
	
	public static List<Object> nullList() {
		return null;
	}
	
	public static List<Object> listOf(Object... objects) {
		List<Object> list = new ArrayList<Object>();
		for (Object o : objects) {
			list.add(o);
		}
		return list;
	}
}
