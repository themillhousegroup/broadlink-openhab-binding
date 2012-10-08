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
	
	public static <E> Collection<E> add(Collection<E> collection, E... others) {
		return hasVarargs(others) ? addElements(collection, others) : collection;		
	}
	
	public static <E> List<E> add(List<E> list, E... others) {
		return hasVarargs(others) ? addElements(list, others) : list;			
	}
	
	public static <E> Set<E> add(Set<E> set, E... others) {
		return hasVarargs(others) ? addElements(set, others) : set;	
	}
	
	private static <E, C extends Collection<E>> C addElements(C collection, E... others) {
		if (collection != null) {
			for (E e : others) {
				collection.add(e);
			}
		}
		return collection;
	}
	
	public static <E> Collection<E> remove(Collection<E> collection, E... others) {
		return hasVarargs(others) ? removeElements(collection, others) : collection;		
	}
	
	public static <E> List<E> remove(List<E> list, E... others) {
		return hasVarargs(others) ? removeElements(list, others) : list;			
	}
	
	public static <E> Set<E> remove(Set<E> set, E... others) {
		return hasVarargs(others) ? removeElements(set, others) : set;	
	}
	
	private static <E, C extends Collection<E>> C removeElements(C collection, E... others) {
		if (collection != null) {
			for (E e : others) {
				collection.remove(e);
			}
		}
		return collection;
	}
	
	public static <E> boolean containsAny(Collection<E> collection, E... others) {
		return hasVarargs(others) ? containsAnyElements(collection, others) : false;		
	}
	
	public static <E> boolean containsAny(List<E> list, E... others) {
		return hasVarargs(others) ? containsAnyElements(list, others) : false;			
	}
	
	public static <E> boolean containsAny(Set<E> set, E... others) {
		return hasVarargs(others) ? containsAnyElements(set, others) : false;	
	}
	
	private static <E, C extends Collection<E>> boolean containsAnyElements(C collection, E... others) {
		if (collection != null) {
			for (E e : others) {
				if (collection.contains(e)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static <E> boolean containsAll(Collection<E> collection, E... others) {
		return hasVarargs(others) ? containsAllElements(collection, others) : true;		
	}
	
	public static <E> boolean containsAll(List<E> list, E... others) {
		return hasVarargs(others) ? containsAllElements(list, others) : true;			
	}
	
	public static <E> boolean containsAll(Set<E> set, E... others) {
		return hasVarargs(others) ? containsAllElements(set, others) : true;	
	}
	
	private static <E, C extends Collection<E>> boolean containsAllElements(C collection, E... others) {
		for (E e : others) {
			if (!collection.contains(e)) {
				return false;
			}
		}
		return true;
	}
	
	public static <E> boolean retainAll(Collection<E> collection, E... others) {
		return hasVarargs(others) ? retainElements(collection, others) : false;		
	}
	
	public static <E> boolean retainAll(List<E> list, E... others) {
		return hasVarargs(others) ? retainElements(list, others) : false;			
	}
	
	public static <E> boolean retainAll(Set<E> set, E... others) {
		return hasVarargs(others) ? retainElements(set, others) : false;	
	}
	
	private static <E, C extends Collection<E>> boolean retainElements(C collection, E... others) {
		Set<E> setToRetain = new HashSet<E>(others.length);
		for (E e : others) {
			setToRetain.add(e);
		}
		return collection.retainAll(setToRetain);
	}
}
