package com.themillhousegroup.argon;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.themillhousegroup.argon.Argon.hasVarargs;

/** Methods for dealing with varargs in conjunction with various <code>Collection</code> classes. 
 * See individual method javadocs for more detail.
 * <br/><br/>Contains ONLY static methods. 
 * @see <code>InjectableArgonCollections</code> for instance-method versions that can be easily mocked.
 */
public class ArgonCollections {
	
	ArgonCollections() {
		// Only instantiated by tests to ensure 100% coverage
	}
	
	public static <E,C extends Collection<E>> C add(C collection, E... others) {
		if (hasVarargs(others) && collection != null) {
			for (E e : others) {
				collection.add(e);
			}
		}
		return collection;
	}
	
	public static <E, C extends Collection<E>> C remove(C collection, E... others) {
		if (hasVarargs(others) && collection != null) {
			for (E e : others) {
				collection.remove(e);
			}
		}
		return collection;
	}
	
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
	
	public static <E, C extends Collection<E>> boolean containsAll(C collection, E... others) {
		if (hasVarargs(others) && collection != null) {
			for (E e : others) {
				if (!collection.contains(e)) {
					return false;
				}
			}
		}
		return true;
	}
	
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

	public static <E> boolean in(E candidate, E... options) {
		if (hasVarargs(options) && candidate != null) {
			Set<E> setToCheck = new HashSet<E>(options.length);
			for (E e : options) {
				setToCheck.add(e);
			}
			return setToCheck.contains(candidate);
		}
		return false;
	}

	public static <E> boolean notIn(E candidate, E... options) {
		return !in(candidate, options);
	}
}
