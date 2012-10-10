package com.themillhousegroup.argon;

/**
 * An interface exposing the {@link ArgonAppendables} static methods, allowing
 * for easy injection of an implementation (
 * {@code InjectableArgonAppendablesImpl}) by a DI framework, and
 * straightforward mocking of behaviour in your unit tests.
 */
public interface InjectableArgonAppendables {

	<T> Appendable appendFirstIfPresent(Appendable base, T... varargs);

	/**
	 * @return <code>base</code> if no varargs. Otherwise the first vararg is
	 *         appended to <code>base</code>, using <code>separator</code>
	 *         between the elements.
	 * @throws RuntimeException
	 *             if there is a problem with appending to <code>base</code>
	 */
	<T> Appendable appendSeparatorAndFirstIfPresent(Appendable base,
			String separator, T... varargs);

	/**
	 * @return <code>base</code> if no varargs. Otherwise the last vararg's
	 *         <code>toString()</code> representation is appended to
	 *         <code>base</code> and returned.
	 * @throws RuntimeException
	 *             if there is a problem with appending to <code>base</code>
	 */
	<T> Appendable appendLastIfPresent(Appendable base, T... varargs);

	/**
	 * @return <code>base</code> if no varargs. Otherwise the last vararg is
	 *         appended to <code>base</code>, using <code>separator</code>
	 *         between the elements.
	 * @throws RuntimeException
	 *             if there is a problem with appending to <code>base</code>
	 */
	<T> Appendable appendSeparatorAndLastIfPresent(Appendable base,
			String separator, T... varargs);

	/**
	 * @return <code>base</code> if no varargs. Otherwise each vararg's
	 *         <code>toString()</code> representation is appended to
	 *         <code>base</code> and returned.
	 * @throws RuntimeException
	 *             if there is a problem with appending to <code>base</code>
	 */
	<T> Appendable appendIfPresent(Appendable base, T... varargs);

	/**
	 * @return <code>base</code> if no varargs. Otherwise each vararg's
	 *         <code>toString()</code> representation is appended to
	 *         <code>base</code>, using <code>separator</code> between each
	 *         element.
	 * @throws RuntimeException
	 *             if there is a problem with appending to <code>base</code>
	 */
	<T> Appendable appendWithSeparatorsIfPresent(Appendable base,
			String separator, T... varargs);
}
