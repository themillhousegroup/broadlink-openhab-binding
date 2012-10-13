package com.themillhousegroup.argon.impl;

import java.util.Collection;
import java.util.List;

import com.themillhousegroup.argon.ArgonCollections;
import com.themillhousegroup.argon.InjectableArgonCollections;

public class InjectableArgonCollectionsImpl implements InjectableArgonCollections {

	public <E, C extends Collection<E>> C add(C collection, E... others) {
		return ArgonCollections.add(collection, others);
	}

	public <E, C extends Collection<E>> C remove(C collection, E... others) {
		return ArgonCollections.remove(collection, others);
	}

	public <E, C extends Collection<E>> boolean containsAny(C collection,
			E... others) {
		return ArgonCollections.containsAny(collection, others);
	}

	public <E, C extends Collection<E>> boolean containsAll(C collection,
			E... others) {
		return ArgonCollections.containsAll(collection, others);
	}

	public <E, C extends Collection<E>> boolean retainAll(C collection,
			E... others) {
		return ArgonCollections.retainAll(collection, others);
	}

	public <E> boolean in(E candidate, E... options) {
		return ArgonCollections.in(candidate, options);
	}

	public <E> boolean notIn(E candidate, E... options) {
		return ArgonCollections.notIn(candidate, options);
	}
	
	public <E> Iterable<E> each(E... elements) {
		return ArgonCollections.each(elements);
	}
	
	public <E> List<E> asList(E... elements) {
		return ArgonCollections.asList(elements);
	}
}
