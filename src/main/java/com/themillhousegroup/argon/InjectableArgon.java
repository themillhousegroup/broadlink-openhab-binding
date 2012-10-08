package com.themillhousegroup.argon;

/**
 * An interface exposing the Argon static methods, allowing
 * for easy injection of an implementation (<code>InjectableArgonImpl</code>)
 * by a DI framework, and straightforward mocking of behaviour in your
 * unit tests. 
 */
public interface InjectableArgon {

	/** 
	 * A synonym for {@link #useFirstIfPresent(Object, Object...)}.
	 * 
	 * @return <code>defaultOption</code> if no varargs. 
	 * Otherwise the first vararg provided.
	 */
	<T> T defaultIfAbsent(T defaultOption, T... varargs);
	
	/** 
	 * @return <code>defaultOption</code> if no varargs. 
	 * Otherwise the first vararg provided.
	 */
	<T> T useFirstIfPresent(T defaultOption, T... varargs);
	
	/** 
	 * @return <code>defaultOption</code> if no varargs. 
	 * Otherwise the last vararg provided.
	 */
	<T> T useLastIfPresent(T defaultOption, T... varargs);
	
	/**
	 * @return the first vararg provided, otherwise <code>null</code>
	 */
	<T> T firstVararg(T... varargs);
	
	/**
	 * @return the last vararg provided, otherwise <code>null</code>
	 */
	<T> T lastVararg(T... varargs);
	
	/**
	 * @return the number of varargs, or 0 if the supplied parameter is null, empty, or the first element is null
	 * @see #hasVarargs(T...)
	 */
	<T> int numVarargs(T... varargs);
	
	/**
	 * @return true iff <code>varargs</code> is not null, not empty AND the first element is not null
	 */
	<T> boolean hasVarargs(T... varargs);
}
