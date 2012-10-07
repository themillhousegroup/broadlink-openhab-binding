package com.themillhousegroup.argon;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/** Methods for dealing with varargs in conjunction with various <code>Iterable</code> and <code>Collection</code> classes. 
 * See individual method javadocs for more detail.
 * <br/><br/>Contains ONLY static methods. 
 * @see <code>InjectableArgonIterables</code> for instance-method versions that can be easily mocked.
 */
public class ArgonIterables {
	public static <T> Iterable<T> appendTo(Iterable<T> iterable, T... others) {
		return iterable;		
	}
	
	public static <T> Collection<T> appendTo(Collection<T> collection, T... others) {
		return collection;		
	}
	
	public static <T> List<T> appendTo(List<T> list, T... others) {
		return list;		
	}
	
	public static <T> Set<T> appendTo(Set<T> set, T... others) {
		return set;		
	}
}
