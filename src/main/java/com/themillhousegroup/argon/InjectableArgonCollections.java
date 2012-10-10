package com.themillhousegroup.argon;

import java.util.Collection;

/**
 * An interface exposing the {@link ArgonCollections} static methods, allowing
 * for easy injection of an implementation ({@code InjectableArgonCollectionsImpl})
 * by a DI framework, and straightforward mocking of behaviour in your
 * unit tests. 
 */
public interface InjectableArgonCollections {

	/**
	 * Adds each element of <code>others</code> to the given <code>Collection</code>.
	 * <br/><br/>
	 * Null-safe, and will not add <code>null</code> elements to the collection.
	 * 
	 * @return the (possibly-unmodified) <code>collection</code>
	 */
	 <E,C extends Collection<E>> C add(C collection, E... others);
	
	/**
	 * Removes each element of <code>others</code> from the given <code>Collection</code>.
	 * <br/><br/>
	 * Null-safe, and will not attempt to remove <code>null</code> elements from the collection.
	 * 
	 * @return the (possibly-unmodified) <code>collection</code>
	 */
	 <E, C extends Collection<E>> C remove(C collection, E... others);
	
	/**
	 * @return true if <code>collection</code> contains <i>any</i> of the elements in <code>others</code>
	 */
	 <E, C extends Collection<E>> boolean containsAny(C collection, E... others);
	
	/**
	 * @return true if <code>collection</code> contains <i>all</i> of the elements in <code>others</code>
	 */
	 <E, C extends Collection<E>> boolean containsAll(C collection, E... others);
	
	/**
	 * Modifies <code>collection</code>, removing everything except the elements in <code>others</code>.
	 * <br/><br/>
	 * Note that this method is dependent on the provided collection's implementation of <code>retainAll()</code>.
	 * @return true if the collection was modified as a result of this operation
	 * @see Collection#retainAll(Collection)
	 */
	 <E, C extends Collection<E>> boolean retainAll(C collection, E... others);

	/**
	 * Null-safe check to see if given candidate is in the provided set of elements.<br/><br/>
	 * Useful with enums, for example:<br/>
	 * <code>if (<i>in</i>(printJobStatus, JobState.ABORTED, JobState.FAILED)) {<br/>
	 * &nbsp;&nbsp;&nbsp;&nbsp;throw new InitechRuntimeException("LP LOAD LETTER");<br/>
	 * }<br/>
	 *  </code>
	 * @return true iff <code>options</code> contains an element that is equal to (via <code>equals()</code>) the <code>candidate</code>
	 * @see #notIn(Object, Object...)
	 */
	 <E> boolean in(E candidate, E... options);

	/**
	 * Null-safe check to see if given candidate is NOT in the provided set of elements.
	 * @return false iff <code>options</code> contains an element that is equal to (via <code>equals()</code>) the <code>candidate</code>.
	 * @see #in(Object, Object...)
	 */
	 <E> boolean notIn(E candidate, E... options);
}
