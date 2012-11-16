package com.themillhousegroup.argon;

import static com.themillhousegroup.argon.Argon.hasVarargs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/** Methods for dealing with varargs in conjunction with various {@code Collection} classes,
 * or treating a varargs-specified list of elements <i>like</i> a collection.
 * See individual method javadocs for more detail.
 * <br/><br/>Contains ONLY static methods. 
 * @see {@link InjectableArgonCollections} for instance-method versions that can be easily mocked.
 */
public class ArgonCollections {
	
	ArgonCollections() {
		// Only instantiated by tests to ensure 100% coverage
	}
	
	/**
	 * Adds each element of <code>others</code> to the given <code>Collection</code>.
	 * <br/><br/>
	 * Null-safe, and will not add <code>null</code> elements to the collection.
	 * 
	 * @return the (possibly-unmodified) <code>collection</code>
	 */
	public static <E,C extends Collection<E>> C add(C collection, E... others) {
		if (hasVarargs(others) && collection != null) {
			for (E e : others) {
				if (e != null) {
					collection.add(e);
				}
			}
		}
		return collection;
	}
	
	/**
	 * Removes each element of <code>others</code> from the given <code>Collection</code>.
	 * <br/><br/>
	 * Null-safe, and will not attempt to remove <code>null</code> elements from the collection.
	 * 
	 * @return the (possibly-unmodified) <code>collection</code>
	 */
	public static <E, C extends Collection<E>> C remove(C collection, E... others) {
		if (hasVarargs(others) && collection != null) {
			for (E e : others) {
				if (e != null) {
					collection.remove(e);
				}
			}
		}
		return collection;
	}
	
	/**
	 * @return true if <code>collection</code> contains <i>any</i> of the elements in <code>others</code>
	 */
	public static <E, C extends Collection<E>> boolean containsAny(C collection, E... others) {
		if (hasVarargs(others) && collection != null) {
			for (E e : others) {
				if (collection.contains(e)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * @return true if <code>collection</code> contains <i>all</i> of the elements in <code>others</code>
	 */
	public static <E, C extends Collection<E>> boolean containsAll(C collection, E... others) {
		boolean hasVarargs = hasVarargs(others);

		if (collection == null || collection.isEmpty()) {
			return !hasVarargs; // The only thing an empty collection can match is a zero-length varargs
		}

		if (hasVarargs) {
			for (E e : others) {
				if (!collection.contains(e)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @return true iff <code>collection</code> contains the same number of elements as <code>others</code> in the <i>exact same order</i>
	 */
	public static <E, C extends Collection<E>> boolean equalInSizeAndOrder(C collection, E... others) {
		boolean hasVarargs = hasVarargs(others);

		if (collection == null || collection.isEmpty()) {
			return !hasVarargs; // The only thing an empty collection can match is a zero-length varargs
		}
			
		List<E> argsAsList = ArgonCollections.asList(others);
		
		if (collection.size() != argsAsList.size()) {
			return false;
		}
		
		List<E> collectionAsList = new ArrayList<E>(collection.size());
		collectionAsList.addAll(collection);
		
		return collectionAsList.equals(argsAsList);
	}
	
	/**
	 * Modifies <code>collection</code>, removing everything except the elements in <code>others</code>.
	 * <br/><br/>
	 * Note that this method is dependent on the provided collection's implementation of <code>retainAll()</code>.
	 * @return true if the collection was modified as a result of this operation
	 * @see Collection#retainAll(Collection)
	 */
	public static <E, C extends Collection<E>> boolean retainAll(C collection, E... others) {
		if (hasVarargs(others) && collection != null) {
			Set<E> setToRetain = new HashSet<E>(others.length);
			for (E e : others) {
				setToRetain.add(e);
			}
			return collection.retainAll(setToRetain);
		}
		return false;
	}

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
	public static <E> boolean in(E candidate, E... options) {
		if (hasVarargs(options) && candidate != null) {
			for (E option : options) {
				if (candidate.equals(option)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Null-safe check to see if given candidate is NOT in the provided set of elements.
	 * @return false iff <code>options</code> contains an element that is equal to (via <code>equals()</code>) the <code>candidate</code>.
	 * @see #in(Object, Object...)
	 */
	public static <E> boolean notIn(E candidate, E... options) {
		return !in(candidate, options);
	}
	
	/**
	 * @return a (possibly-empty) {@link Iterable} that contains {@code elements}. NEVER {@code null}
	 */
	public static <E> Iterable<E> each(E... elements) {
		 return asList(elements);
	}
	
	/**
	 * @return a (possibly-empty) {@link List} that contains {@code elements}. NEVER {@code null}
	 */
	public static <E> List<E> asList(E... elements) {
		 List<E> list = new ArrayList<E>();
		 
		 if (hasVarargs(elements)) {
			 for (E e : elements) {
					list.add(e);
				}
		 }
		 
		 return list;
	}
}
