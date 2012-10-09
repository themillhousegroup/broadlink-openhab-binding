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
	
	public static String[] nullVarargs() {
		return null;
	}
	
	public static String[] emptyVarargs() {
		return new String[0];
	}
	
	public static String[] nullFirstVararg() {
		String[] args = new String[1];
		args[0] = null;
		return args;
	}
	
	public static Collection<String> nullCollection() {
		return null;
	}
	
	public static Collection<String> emptyCollection() {
		return new ArrayList<String>();
	}
	
	public static <T> Collection<T> collectionOf(T... objects) {
		List<T> list = new ArrayList<T>();
		for (T o : objects) {
			list.add(o);
		}
		return list;
	}
	
	public static Set<String> emptySet() {
		return new HashSet<String>();
	}
	
	public static Set<String> nullSet() {
		return null;
	}
	
	public static Set<String> setOf(String... objects) {
		Set<String> set = new LinkedHashSet<String>();
		for (String o : objects) {
			set.add(o);
		}
		return set;
	}
	
	public static List<String> emptyList() {
		return new ArrayList<String>();
	}
	
	public static List<String> nullList() {
		return null;
	}
	
	public static List<String> listOf(String... objects) {
		List<String> list = new ArrayList<String>();
		for (String o : objects) {
			list.add(o);
		}
		return list;
	}
}
