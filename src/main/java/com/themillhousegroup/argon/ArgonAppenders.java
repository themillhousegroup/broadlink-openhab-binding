package com.themillhousegroup.argon;

import static com.themillhousegroup.argon.Argon.hasVarargs;
import static com.themillhousegroup.argon.Argon.lastVararg;

import java.io.IOException;

/**
 * Helper methods that use varargs to append content to a base <code>String</code>
 *
 */
public class ArgonAppenders {
	
	ArgonAppenders() {
		// Only instantiated by tests to ensure 100% coverage
	}
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise the first vararg's <code>toString()</code> representation
	 * is appended to <code>base</code> and returned.
	 */
	public static <T> String appendFirstIfPresent(String base, T... varargs) {
		return hasVarargs(varargs) ? base + (varargs[0]).toString() : base;
	}
	

	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise the first vararg is appended to <code>base</code>, using <code>separator</code> between the elements.
	 */
	@SuppressWarnings("unchecked")
	public static <T> String appendSeparatorAndFirstIfPresent(String base, String separator, T... varargs) {
		return hasVarargs(varargs) ? appendAll(base, separator, varargs[0]) : base;
	}
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise the last vararg's <code>toString()</code> representation is appended to <code>base</code> and returned.
	 */
	@SuppressWarnings("unchecked")
	public static <T> String appendLastIfPresent(String base, T... varargs) {
		return hasVarargs(varargs) ? appendAll(base, "", lastVararg(varargs)) : base;
	}
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise the last vararg is appended to <code>base</code>, using <code>separator</code> between the elements.
	 */
	public static String appendSeparatorAndLastIfPresent(String base, String separator, String... varargs) {
		return hasVarargs(varargs) ? appendAll(base, separator, lastVararg(varargs)) : base;
	}
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise each vararg's <code>toString()</code> representation
	 * is appended to <code>base</code> and returned.
	 */
	public static <T> String appendIfPresent(String base, T... varargs) {
		return hasVarargs(varargs) ? appendAll(base, "", varargs) : base;
	}
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise each vararg's <code>toString()</code> representation
	 * is appended to <code>base</code>, using <code>separator</code> between each element.
	 */
	public static <T> String appendWithSeparatorsIfPresent(String base, String separator, T... varargs) {
		return hasVarargs(varargs) ? appendAll(base, separator, varargs) : base;
	}
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise the first vararg is appended to <code>base</code> and returned.
	 */
	public static <A extends Appendable, C extends CharSequence> Appendable appendIfPresent(A base, C... varargs) {
		try {
			return hasVarargs(varargs) ? base.append(varargs[0]) : base;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static <T> String appendAll(String base, String separator, T... nonNullVarargs) {
		StringBuffer sb = new StringBuffer(base);
		for (T vararg : nonNullVarargs) {
			sb.append(separator);
			sb.append(vararg == null ? "null" : vararg.toString());
		}
		return sb.toString();
	}
}
