package com.themillhousegroup.argon;


/** The core class for dealing with varargs. See individual method javadocs for more detail.
 * <br/><br/>Contains ONLY static methods. 
 * @see {@code InjectableArgon*} for instance-method versions that can be easily mocked.
 * @see {@link ArgonAppendables} for methods that work with {@code Appendable}s.
 * @see {@link ArgonCollections} for methods that work with collections
 * @see {@link ArgonStringAppenders} for methods that append to Strings
 */
public class Argon {

	Argon() {
		// Only instantiated by tests to ensure 100% coverage
	}
	
	/** 
	 * A synonym for {@link #useFirstIfPresent(Object, Object...)}.
	 * 
	 * @return <code>defaultOption</code> if no varargs. 
	 * Otherwise the first vararg provided.
	 */
	public static <T> T defaultIfAbsent(T defaultOption, T... varargs) {
		return useFirstIfPresent(defaultOption, varargs);
	}
	
	/** 
	 * @return <code>defaultOption</code> if no varargs. 
	 * Otherwise the first vararg provided.
	 */
	public static <T> T useFirstIfPresent(T defaultOption, T... varargs) {
		return hasVarargs(varargs) ? varargs[0] : defaultOption;
	}
	
	/** 
	 * @return <code>defaultOption</code> if no varargs. 
	 * Otherwise the last vararg provided.
	 */
	public static <T> T useLastIfPresent(T defaultOption, T... varargs) {
		return hasVarargs(varargs) ? lastVararg(varargs) : defaultOption;
	}
	
	/**
	 * @return the first vararg provided, otherwise <code>null</code>
	 */
	public static <T> T firstVararg(T... varargs) {
		return (numVarargs(varargs) > 0) ? varargs[0] : null;
	}
	
	/**
	 * @return the last vararg provided, otherwise <code>null</code>
	 */
	public static <T> T lastVararg(T... varargs) {
		int numVarargs = numVarargs(varargs);
		return (numVarargs > 0) ? varargs[(numVarargs -1)] : null;
	}
	
	/**
	 * @return the number of varargs, or 0 if the supplied parameter is null, empty, or the first element is null
	 * @see #hasVarargs(T...)
	 */
	public static <T> int numVarargs(T... varargs) {
		return hasVarargs(varargs) ? varargs.length : 0;
	}
	
	/**
	 * @return true iff <code>varargs</code> is not null, not empty AND the first element is not null
	 */
	public static <T> boolean hasVarargs(T... varargs) {
		return (varargs != null)
			&& (varargs.length > 0)
			&& (varargs[0] != null);
	}
}
