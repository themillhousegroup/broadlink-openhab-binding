package com.themillhousegroup.argon;

import static com.themillhousegroup.argon.Argon.hasVarargs;
import static com.themillhousegroup.argon.Argon.lastVararg;

import java.io.IOException;

/**
 * Helper methods that use varargs to append content to a base {@link Appendable} instance
 */
public class ArgonAppendables {
	
	ArgonAppendables() {
		// Only instantiated by tests to ensure 100% coverage
	}
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise the first vararg's <code>toString()</code> representation
	 * is appended to <code>base</code> and returned.
	 * @throws RuntimeException if there is a problem with appending to <code>base</code>
	 */
	public static <T> Appendable appendFirstIfPresent(Appendable base, T... varargs) {
		return hasVarargs(varargs) ? appendAll(base, "", (varargs[0].toString())) : base;
	}
	

	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise the first vararg is appended to <code>base</code>, using <code>separator</code> between the elements.
	 * @throws RuntimeException if there is a problem with appending to <code>base</code>
	 */
	@SuppressWarnings("unchecked")
	public static <T> Appendable appendSeparatorAndFirstIfPresent(Appendable base, String separator, T... varargs) {
		return hasVarargs(varargs) ? appendAll(base, separator, varargs[0]) : base;
	}
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise the last vararg's <code>toString()</code> representation is appended to <code>base</code> and returned.
	 * @throws RuntimeException if there is a problem with appending to <code>base</code>
	 */
	@SuppressWarnings("unchecked")
	public static <T> Appendable appendLastIfPresent(Appendable base, T... varargs) {
		return hasVarargs(varargs) ? appendAll(base, "", lastVararg(varargs)) : base;
	}
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise the last vararg is appended to <code>base</code>, using <code>separator</code> between the elements.
	 * @throws RuntimeException if there is a problem with appending to <code>base</code>
	 */
	@SuppressWarnings("unchecked")
	public static <T> Appendable appendSeparatorAndLastIfPresent(Appendable base, String separator, T... varargs) {
		return hasVarargs(varargs) ? appendAll(base, separator, lastVararg(varargs)) : base;
	}
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise each vararg's <code>toString()</code> representation
	 * is appended to <code>base</code> and returned.
	 * @throws RuntimeException if there is a problem with appending to <code>base</code>
	 */
	public static <T> Appendable appendIfPresent(Appendable base, T... varargs) {
		return hasVarargs(varargs) ? appendAll(base, "", varargs) : base;
	}
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise each vararg's <code>toString()</code> representation
	 * is appended to <code>base</code>, using <code>separator</code> between each element.
	 * @throws RuntimeException if there is a problem with appending to <code>base</code>
	 */
	public static <T> Appendable appendWithSeparatorsIfPresent(Appendable base, String separator, T... varargs) {
		return hasVarargs(varargs) ? appendAll(base, separator, varargs) : base;
	}
		
	private static <T> Appendable appendAll(Appendable base, String separator, T... nonNullVarargs) {
		try {		
			for (T vararg : nonNullVarargs) {			
				base.append(separator);				
				base.append(vararg == null ? "null" : vararg.toString());
			}
			return base;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
