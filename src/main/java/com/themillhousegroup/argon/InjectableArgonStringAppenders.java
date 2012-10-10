package com.themillhousegroup.argon;

/**
 * An interface exposing the {@link ArgonStringAppenders} static methods, allowing
 * for easy injection of an implementation ({@code InjectableArgonStringAppendersImpl})
 * by a DI framework, and straightforward mocking of behaviour in your
 * unit tests. 
 */
public interface InjectableArgonStringAppenders {
	<T> String appendFirstIfPresent(String base, T... varargs);
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise the first vararg is appended to <code>base</code>, using <code>separator</code> between the elements.
	 */
	<T> String appendSeparatorAndFirstIfPresent(String base, String separator, T... varargs);
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise the last vararg's <code>toString()</code> representation is appended to <code>base</code> and returned.
	 */
	<T> String appendLastIfPresent(String base, T... varargs);
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise the last vararg is appended to <code>base</code>, using <code>separator</code> between the elements.
	 */
	<T> String appendSeparatorAndLastIfPresent(String base, String separator, T... varargs);
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise each vararg's <code>toString()</code> representation
	 * is appended to <code>base</code> and returned.
	 */
	<T> String appendIfPresent(String base, T... varargs);
	
	/**
	 * @return <code>base</code> if no varargs. 
	 * Otherwise each vararg's <code>toString()</code> representation
	 * is appended to <code>base</code>, using <code>separator</code> between each element.
	 */
	<T> String appendWithSeparatorsIfPresent(String base, String separator, T... varargs);
}
