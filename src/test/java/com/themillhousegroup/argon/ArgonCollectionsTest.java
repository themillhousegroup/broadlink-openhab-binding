package com.themillhousegroup.argon;

import static com.themillhousegroup.argon.testhelper.VarargsHelper.PROVIDED_STRING;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.SECOND_PROVIDED_STRING;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.emptyVarargs;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullFirstVararg;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullVarargs;

import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullCollection;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.emptyCollection;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.collectionOf;

import static com.themillhousegroup.argon.testhelper.VarargsHelper.emptySet;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullSet;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.setOf;

import static com.themillhousegroup.argon.testhelper.VarargsHelper.emptyList;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullList;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.listOf;




import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



@Test(groups={"argon", "unit", "fast", "statics", "collections"})
public class ArgonCollectionsTest {

	@BeforeClass
	public void setup() {
		new ArgonCollections(); // For 100% code coverage only.
	}
	
	@Test
	public void shouldLeaveCollectionAloneWhenNoVarargsAdd() {
		thenCollectionHasSize(ArgonCollections.add(emptyCollection()), 0);
	}
	
	@Test
	public void shouldLeaveCollectionAloneWhenNullVarargsAdd() {
		thenCollectionHasSize(ArgonCollections.add(emptyCollection(), nullVarargs()), 0);
	}	

	@Test
	public void shouldLeaveCollectionAloneWhenEmptyVarargsAdd() {
		thenCollectionHasSize(ArgonCollections.add(emptyCollection(), emptyVarargs()), 0);
	}
	
	@Test
	public void shouldLeaveCollectionAloneWhenNullFirstVarargsAdd() {
		thenCollectionHasSize(ArgonCollections.add(emptyCollection(), nullFirstVararg()), 0);
	}
	
	@Test
	public void shouldAddToCollectionWhenOneVarargAdded() {
		thenCollectionHasSize(ArgonCollections.add(emptyCollection(), PROVIDED_STRING), 1);
	}
	
	@Test
	public void shouldAddToCollectionWhenTwoVarargsAdded() {
		thenCollectionHasSize(ArgonCollections.add(emptyCollection(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 2);
	}
	
	@Test
	public void shouldHandleNullCollectionAdd() {
		thenCollectionHasSize(ArgonCollections.add(nullCollection(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldLeaveSetAloneWhenNullFirstVarargsAdd() {
		thenCollectionHasSize(ArgonCollections.add(emptySet(), nullFirstVararg()), 0);
	}
	
	@Test
	public void shouldAddToSetWhenOneVarargAdded() {
		thenCollectionHasSize(ArgonCollections.add(emptySet(), PROVIDED_STRING), 1);
	}
	
	@Test
	public void shouldAddToSetWhenTwoVarargsAdded() {
		thenCollectionHasSize(ArgonCollections.add(emptySet(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 2);
	}
	
	@Test
	public void shouldHandleNullSetAdd() {
		thenCollectionHasSize(ArgonCollections.add(nullSet(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldLeaveListAloneWhenNullFirstVarargsAdd() {
		thenCollectionHasSize(ArgonCollections.add(emptyList(), nullFirstVararg()), 0);
	}
	
	@Test
	public void shouldAddToListWhenOneVarargAdded() {
		thenCollectionHasSize(ArgonCollections.add(emptyList(), PROVIDED_STRING), 1);
	}
	
	@Test
	public void shouldHandleNullListAdd() {
		thenCollectionHasSize(ArgonCollections.add(nullList(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}
	
	
	///
	
	@Test
	public void shouldLeaveCollectionAloneWhenNoVarargsRemoved() {
		thenCollectionHasSize(ArgonCollections.remove(collectionOf(PROVIDED_STRING)), 1);
	}
	
	@Test
	public void shouldLeaveCollectionAloneWhenNullVarargsRemoved() {
		thenCollectionHasSize(ArgonCollections.remove(collectionOf(PROVIDED_STRING), nullVarargs()), 1);
	}	

	@Test
	public void shouldLeaveCollectionAloneWhenEmptyVarargsRemoved() {
		thenCollectionHasSize(ArgonCollections.remove(collectionOf(PROVIDED_STRING), emptyVarargs()), 1);
	}
	
	@Test
	public void shouldLeaveCollectionAloneWhenNullFirstVarargsRemove() {
		thenCollectionHasSize(ArgonCollections.remove(collectionOf(PROVIDED_STRING), nullFirstVararg()), 1);
	}
	
	@Test
	public void shouldRemoveFromCollectionWhenOneVarargRemoved() {
		thenCollectionHasSize(ArgonCollections.remove(collectionOf(PROVIDED_STRING), PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldRemoveFromCollectionWhenTwoVarargsRemoved() {
		thenCollectionHasSize(ArgonCollections.remove(collectionOf(PROVIDED_STRING, SECOND_PROVIDED_STRING), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldHandleNullCollectionRemove() {
		thenCollectionHasSize(ArgonCollections.remove(nullCollection(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldLeaveSetAloneWhenNullFirstVarargsRemoved() {
		thenCollectionHasSize(ArgonCollections.remove(setOf(PROVIDED_STRING), nullFirstVararg()), 1);
	}
	
	@Test
	public void shouldRemoveFromSetWhenOneVarargRemoved() {
		thenCollectionHasSize(ArgonCollections.remove(setOf(PROVIDED_STRING), PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldRemoveFromSetWhenTwoVarargsRemoved() {
		thenCollectionHasSize(ArgonCollections.remove(setOf(PROVIDED_STRING, SECOND_PROVIDED_STRING), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldHandleNullSetRemove() {
		thenCollectionHasSize(ArgonCollections.remove(nullSet(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldLeaveListAloneWhenNullFirstVarargsRemoved() {
		thenCollectionHasSize(ArgonCollections.remove(listOf(PROVIDED_STRING), nullFirstVararg()), 1);
	}
	
	@Test
	public void shouldRemoveFromListWhenOneVarargRemoved() {
		thenCollectionHasSize(ArgonCollections.remove(listOf(PROVIDED_STRING), PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldHandleNullListRemove() {
		thenCollectionHasSize(ArgonCollections.add(nullList(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}
	
	////
	
	@Test
	public void shouldBeFalseWhenNoVarargsContainsAny() {
		assertFalse(ArgonCollections.containsAny(collectionOf(PROVIDED_STRING)));
	}
	
	@Test
	public void shouldBeFalseWhenNullVarargsContainsAny() {
		assertFalse(ArgonCollections.containsAny(collectionOf(PROVIDED_STRING), nullVarargs()));
	}	

	@Test
	public void shouldBeFalseWhenEmptyVarargsContainsAny() {
		assertFalse(ArgonCollections.containsAny(collectionOf(PROVIDED_STRING), emptyVarargs()));
	}
	
	@Test
	public void shouldBeFalseWhenNullFirstVarargsContainsAny() {
		assertFalse(ArgonCollections.containsAny(collectionOf(PROVIDED_STRING), nullFirstVararg()));
	}
	
	@Test
	public void shouldBeTrueWhenOneVarargContainsAny() {
		assertTrue(ArgonCollections.containsAny(collectionOf(PROVIDED_STRING), PROVIDED_STRING));
	}
	
	@Test
	public void shouldBeTrueWhenTwoVarargsContainsAny() {
		assertTrue(ArgonCollections.containsAny(collectionOf(PROVIDED_STRING, SECOND_PROVIDED_STRING), SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldHandleNullCollectionContainsAny() {
		assertFalse(ArgonCollections.containsAny(nullCollection(), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldBeFalseWhenSetContainsAnyNullFirstVarargs() {
		assertFalse(ArgonCollections.containsAny(setOf(PROVIDED_STRING), nullFirstVararg()));
	}
	
	@Test
	public void shouldBeTrueWhenSetContainsAnyExactMatchVarargs() {
		assertTrue(ArgonCollections.containsAny(setOf(PROVIDED_STRING), PROVIDED_STRING));
	}
	
	@Test
	public void shouldHandleNullSetContainsAny() {
		assertFalse(ArgonCollections.containsAny(nullSet(), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldBeFalseWhenListContainsAnyNullFirstVarargs() {
		assertFalse(ArgonCollections.containsAny(listOf(PROVIDED_STRING), nullFirstVararg()));
	}
	
	@Test
	public void shouldBeTrueWhenListContainsAnyExactMatchVarargs() {
		assertTrue(ArgonCollections.containsAny(listOf(PROVIDED_STRING), PROVIDED_STRING));
	}
	
	@Test
	public void shouldHandleNullListContainsAny() {
		assertFalse(ArgonCollections.containsAny(nullList(), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}
	
	
	private void thenCollectionHasSize(Collection<?> coll, int i) {
		assertEquals((coll == null) ? 0 : coll.size(), i);
	}
}
