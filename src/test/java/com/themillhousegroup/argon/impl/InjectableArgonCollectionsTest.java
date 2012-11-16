package com.themillhousegroup.argon.impl;

import static com.themillhousegroup.argon.testhelper.VarargsHelper.PROVIDED_STRING;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.SECOND_PROVIDED_STRING;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.collectionOf;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.emptyCollection;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.emptyList;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.emptySet;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.emptyVarargs;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.listOf;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullCollection;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullFirstVararg;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullList;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullSet;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullVarargs;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.setOf;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.themillhousegroup.argon.InjectableArgonCollections;



@Test(groups={"argon", "unit", "fast", "injectables", "collections"})
public class InjectableArgonCollectionsTest {

	private InjectableArgonCollections testInstance;
	
	@BeforeClass
	public void setup() {
		testInstance = new InjectableArgonCollectionsImpl(); // For 100% code coverage only.
	}

	// Tests for add()
	
	@Test
	public void shouldLeaveCollectionAloneWhenNoVarargsAdd() {
		thenCollectionHasSize(testInstance.add(emptyCollection()), 0);
	}
	
	@Test
	public void shouldLeaveCollectionAloneWhenNullVarargsAdd() {
		thenCollectionHasSize(testInstance.add(emptyCollection(), nullVarargs()), 0);
	}	

	@Test
	public void shouldLeaveCollectionAloneWhenEmptyVarargsAdd() {
		thenCollectionHasSize(testInstance.add(emptyCollection(), emptyVarargs()), 0);
	}
	
	@Test
	public void shouldLeaveCollectionAloneWhenNullFirstVarargsAdd() {
		thenCollectionHasSize(testInstance.add(emptyCollection(), nullFirstVararg()), 0);
	}
	
	@Test
	public void shouldAddToCollectionWhenOneVarargAdded() {
		thenCollectionHasSize(testInstance.add(emptyCollection(), PROVIDED_STRING), 1);
	}
	
	@Test
	public void shouldAddToCollectionWhenTwoVarargsAdded() {
		thenCollectionHasSize(testInstance.add(emptyCollection(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 2);
	}
	
	@Test
	public void shouldHandleNullCollectionAdd() {
		thenCollectionHasSize(testInstance.add(nullCollection(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldLeaveSetAloneWhenNullFirstVarargsAdd() {
		thenCollectionHasSize(testInstance.add(emptySet(), nullFirstVararg()), 0);
	}
	
	@Test
	public void shouldAddToSetWhenOneVarargAdded() {
		thenCollectionHasSize(testInstance.add(emptySet(), PROVIDED_STRING), 1);
	}

	@Test
	public void shouldAddToSetWhenTwoVarargsAdded() {
		thenCollectionHasSize(testInstance.add(emptySet(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 2);
	}

	@Test
	public void shouldAddOneToSetWhenTwoVarargsAddedButSecondIsNull() {
		thenCollectionHasSize(testInstance.add(emptySet(), PROVIDED_STRING, null), 1);
	}
	
	@Test
	public void shouldHandleNullSetAdd() {
		thenCollectionHasSize(testInstance.add(nullSet(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldLeaveListAloneWhenNullFirstVarargsAdd() {
		thenCollectionHasSize(testInstance.add(emptyList(), nullFirstVararg()), 0);
	}
	
	@Test
	public void shouldAddToListWhenOneVarargAdded() {
		thenCollectionHasSize(testInstance.add(emptyList(), PROVIDED_STRING), 1);
	}
	
	@Test
	public void shouldHandleNullListAdd() {
		thenCollectionHasSize(testInstance.add(nullList(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}
	
	
	// Tests for remove()
	
	@Test
	public void shouldLeaveCollectionAloneWhenNoVarargsRemoved() {
		thenCollectionHasSize(testInstance.remove(collectionOf(PROVIDED_STRING)), 1);
	}
	
	@Test
	public void shouldLeaveCollectionAloneWhenNullVarargsRemoved() {
		thenCollectionHasSize(testInstance.remove(collectionOf(PROVIDED_STRING), nullVarargs()), 1);
	}	

	@Test
	public void shouldLeaveCollectionAloneWhenEmptyVarargsRemoved() {
		thenCollectionHasSize(testInstance.remove(collectionOf(PROVIDED_STRING), emptyVarargs()), 1);
	}
	
	@Test
	public void shouldLeaveCollectionAloneWhenNullFirstVarargsRemove() {
		thenCollectionHasSize(testInstance.remove(collectionOf(PROVIDED_STRING), nullFirstVararg()), 1);
	}
	
	@Test
	public void shouldRemoveFromCollectionWhenOneVarargRemoved() {
		thenCollectionHasSize(testInstance.remove(collectionOf(PROVIDED_STRING), PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldRemoveFromCollectionWhenTwoVarargsRemoved() {
		thenCollectionHasSize(testInstance.remove(collectionOf(PROVIDED_STRING, SECOND_PROVIDED_STRING), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldHandleNullCollectionRemove() {
		thenCollectionHasSize(testInstance.remove(nullCollection(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldLeaveSetAloneWhenNullFirstVarargsRemoved() {
		thenCollectionHasSize(testInstance.remove(setOf(PROVIDED_STRING), nullFirstVararg()), 1);
	}
	
	@Test
	public void shouldRemoveFromSetWhenOneVarargRemoved() {
		thenCollectionHasSize(testInstance.remove(setOf(PROVIDED_STRING), PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldRemoveFromSetWhenTwoVarargsRemoved() {
		thenCollectionHasSize(testInstance.remove(setOf(PROVIDED_STRING, SECOND_PROVIDED_STRING), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}

	@Test
	public void shouldRemoveOneFromSetWhenTwoVarargsRemovedButSecondIsNull() {
		thenCollectionHasSize(testInstance.remove(setOf(PROVIDED_STRING, SECOND_PROVIDED_STRING), PROVIDED_STRING, null), 1);
	}
	
	@Test
	public void shouldHandleNullSetRemove() {
		thenCollectionHasSize(testInstance.remove(nullSet(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldLeaveListAloneWhenNullFirstVarargsRemoved() {
		thenCollectionHasSize(testInstance.remove(listOf(PROVIDED_STRING), nullFirstVararg()), 1);
	}
	
	@Test
	public void shouldRemoveFromListWhenOneVarargRemoved() {
		thenCollectionHasSize(testInstance.remove(listOf(PROVIDED_STRING), PROVIDED_STRING), 0);
	}
	
	@Test
	public void shouldHandleNullListRemove() {
		thenCollectionHasSize(testInstance.add(nullList(), PROVIDED_STRING, SECOND_PROVIDED_STRING), 0);
	}
	
	// Tests for containsAny()
	
	@Test
	public void shouldBeFalseWhenNoVarargsContainsAny() {
		assertFalse(testInstance.containsAny(collectionOf(PROVIDED_STRING)));
	}
	
	@Test
	public void shouldBeFalseWhenNullVarargsContainsAny() {
		assertFalse(testInstance.containsAny(collectionOf(PROVIDED_STRING), nullVarargs()));
	}	

	@Test
	public void shouldBeFalseWhenEmptyVarargsContainsAny() {
		assertFalse(testInstance.containsAny(collectionOf(PROVIDED_STRING), emptyVarargs()));
	}
	
	@Test
	public void shouldBeFalseWhenNullFirstVarargsContainsAny() {
		assertFalse(testInstance.containsAny(collectionOf(PROVIDED_STRING), nullFirstVararg()));
	}
	
	@Test
	public void shouldBeTrueWhenOneVarargContainsAny() {
		assertTrue(testInstance.containsAny(collectionOf(PROVIDED_STRING), PROVIDED_STRING));
	}
	
	@Test
	public void shouldBeTrueWhenTwoVarargsContainsAny() {
		assertTrue(testInstance.containsAny(collectionOf(PROVIDED_STRING, SECOND_PROVIDED_STRING), SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldHandleNullCollectionContainsAny() {
		assertFalse(testInstance.containsAny(nullCollection(), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldBeFalseWhenSetContainsAnyNullFirstVarargs() {
		assertFalse(testInstance.containsAny(setOf(PROVIDED_STRING), nullFirstVararg()));
	}
	
	@Test
	public void shouldBeTrueWhenSetContainsAnyExactMatchVarargs() {
		assertTrue(testInstance.containsAny(setOf(PROVIDED_STRING), PROVIDED_STRING));
	}

	@Test
	public void shouldBeFalseWhenSetDoesNotContainAnyValidVarargs() {
		assertFalse(testInstance.containsAny(setOf(PROVIDED_STRING), SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldHandleNullSetContainsAny() {
		assertFalse(testInstance.containsAny(nullSet(), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldBeFalseWhenListContainsAnyNullFirstVarargs() {
		assertFalse(testInstance.containsAny(listOf(PROVIDED_STRING), nullFirstVararg()));
	}
	
	@Test
	public void shouldBeTrueWhenListContainsAnyExactMatchVarargs() {
		assertTrue(testInstance.containsAny(listOf(PROVIDED_STRING), PROVIDED_STRING));
	}
	
	@Test
	public void shouldHandleNullListContainsAny() {
		assertFalse(testInstance.containsAny(nullList(), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}

	// Tests for containsAll()

	@Test
	public void shouldBeTrueWhenNoVarargsContainsAll() {
		assertTrue(testInstance.containsAll(collectionOf(PROVIDED_STRING)));
	}
	
	@Test
	public void shouldBeTrueWhenNullVarargsContainsAll() {
		assertTrue(testInstance.containsAll(collectionOf(PROVIDED_STRING), nullVarargs()));
	}	

	@Test
	public void shouldBeTrueWhenEmptyVarargsContainsAll() {
		assertTrue(testInstance.containsAll(collectionOf(PROVIDED_STRING), emptyVarargs()));
	}
	
	@Test
	public void shouldBeTrueWhenNullFirstVarargsContainsAll() {
		assertTrue(testInstance.containsAll(collectionOf(PROVIDED_STRING), nullFirstVararg()));
	}
	
	@Test
	public void shouldBeTrueWhenOneVarargContainsAll() {
		assertTrue(testInstance.containsAll(collectionOf(PROVIDED_STRING), PROVIDED_STRING));
	}
	
	@Test
	public void shouldBeFalseWhenOneVarargsContainsAllWithTwoElements() {
		assertFalse(testInstance.containsAll(collectionOf(SECOND_PROVIDED_STRING), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}

	@Test
	public void shouldBeTrueWhenTwoVarargsContainsAll() {
		assertTrue(testInstance.containsAll(collectionOf(PROVIDED_STRING, SECOND_PROVIDED_STRING), SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldHandleNullCollectionContainsAll() {
		assertFalse(testInstance.containsAll(nullCollection(), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldBeTrueWhenSetContainsAllNullFirstVarargs() {
		assertTrue(testInstance.containsAll(setOf(PROVIDED_STRING), nullFirstVararg()));
	}
	
	@Test
	public void shouldBeTrueWhenSetContainsAllExactMatchVarargs() {
		assertTrue(testInstance.containsAll(setOf(PROVIDED_STRING), PROVIDED_STRING));
	}

	@Test
	public void shouldBeFalseWhenSetDoesNotContainAllValidVarargs() {
		assertFalse(testInstance.containsAll(setOf(PROVIDED_STRING), SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldHandleNullSetContainsAll() {
		assertFalse(testInstance.containsAll(nullSet(), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}

	@Test
	public void shouldBeTrueWhenContainsAllBetweenNullSetAndEmptyVarargs() {
		assertTrue(testInstance.containsAll(nullSet()));
	}
	
	@Test
	public void shouldBeTrueWhenListContainsAllNullFirstVarargs() {
		assertTrue(testInstance.containsAll(listOf(PROVIDED_STRING), nullFirstVararg()));
	}
	
	@Test
	public void shouldBeTrueWhenListContainsAllExactMatchVarargs() {
		assertTrue(testInstance.containsAll(listOf(PROVIDED_STRING), PROVIDED_STRING));
	}
	
	@Test
	public void shouldHandleNullListContainsAll() {
		assertFalse(testInstance.containsAll(nullList(), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}

	// Tests for equalInSizeAndOrder()

	@Test
	public void shouldBeFalseWhenNoVarargsEqualInSizeAndOrder() {
		assertFalse(testInstance.equalInSizeAndOrder(collectionOf(PROVIDED_STRING)));
	}
	
	@Test
	public void shouldBeFalseWhenNullVarargsEqualInSizeAndOrder() {
		assertFalse(testInstance.equalInSizeAndOrder(collectionOf(PROVIDED_STRING), nullVarargs()));
	}
	
	@Test
	public void shouldBeFalseWhenNullFirstVarargsEqualInSizeAndOrder() {
		assertFalse(testInstance.equalInSizeAndOrder(collectionOf(PROVIDED_STRING), nullFirstVararg()));
	}
	
	@Test
	public void shouldBeTrueWhenOneVarargEqualInSizeAndOrder() {
		assertTrue(testInstance.equalInSizeAndOrder(collectionOf(PROVIDED_STRING), PROVIDED_STRING));
	}
	
	@Test
	public void shouldBeFalseWhenOneVarargsEqualInSizeAndOrderWithTwoElements() {
		assertFalse(testInstance.equalInSizeAndOrder(collectionOf(SECOND_PROVIDED_STRING), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}

	@Test
	public void shouldBeFalseWhenTwoVarargsEqualInSizeAndOrderNotSameSize() {
		assertFalse(testInstance.equalInSizeAndOrder(collectionOf(PROVIDED_STRING, SECOND_PROVIDED_STRING), SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldBeFalseWhenTwoVarargsEqualInSizeAndOrderSameSizeWrongOrder() {
		assertFalse(testInstance.equalInSizeAndOrder(collectionOf(PROVIDED_STRING, SECOND_PROVIDED_STRING), SECOND_PROVIDED_STRING, PROVIDED_STRING));
	}
	
	@Test
	public void shouldBeTrueWhenTwoVarargsEqualInSizeAndOrderSameSizeAndOrder() {
		assertTrue(testInstance.equalInSizeAndOrder(collectionOf(PROVIDED_STRING, SECOND_PROVIDED_STRING), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldHandleNullCollectionEqualInSizeAndOrder() {
		assertFalse(testInstance.equalInSizeAndOrder(nullCollection(), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldBeFalseWhenSetEqualInSizeAndOrderNullFirstVarargs() {
		assertFalse(testInstance.equalInSizeAndOrder(setOf(PROVIDED_STRING), nullFirstVararg()));
	}
	
	@Test
	public void shouldBeTrueWhenSetEqualInSizeAndOrderExactMatchVarargs() {
		assertTrue(testInstance.equalInSizeAndOrder(setOf(PROVIDED_STRING), PROVIDED_STRING));
	}

	@Test
	public void shouldBeFalseWhenSetDoesNotEqualInSizeAndOrderValidVarargs() {
		assertFalse(testInstance.equalInSizeAndOrder(setOf(PROVIDED_STRING), SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldHandleNullSetEqualInSizeAndOrder() {
		assertFalse(testInstance.equalInSizeAndOrder(nullSet(), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}

	@Test
	public void shouldBeTrueWhenEqualInSizeAndOrderBetweenNullSetAndEmptyVarargs() {
		assertTrue(testInstance.equalInSizeAndOrder(nullSet()));
	}
	
	@Test
	public void shouldBeTrueWhenEqualInSizeAndOrderBetweenEmptySetAndEmptyVarargs() {
		assertTrue(testInstance.equalInSizeAndOrder(emptySet()));
	}
	
	@Test
	public void shouldBeFalseWhenListEqualInSizeAndOrderNullFirstVarargs() {
		assertFalse(testInstance.equalInSizeAndOrder(listOf(PROVIDED_STRING), nullFirstVararg()));
	}
	
	@Test
	public void shouldBeTrueWhenListEqualInSizeAndOrderExactMatchVarargs() {
		assertTrue(testInstance.equalInSizeAndOrder(listOf(PROVIDED_STRING), PROVIDED_STRING));
	}
	
	@Test
	public void shouldHandleNullListEqualInSizeAndOrder() {
		assertFalse(testInstance.equalInSizeAndOrder(nullList(), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}
	
	// Tests for retainAll()
	
	@Test
	public void shouldLeaveCollectionAloneWhenNoVarargsRetainAll() {
		assertFalse(testInstance.retainAll(emptyCollection()));
	}
	
	@Test
	public void shouldLeaveCollectionAloneWhenNullVarargsRetainAll() {
		assertFalse(testInstance.retainAll(emptyCollection(), nullVarargs()));
	}	

	@Test
	public void shouldLeaveCollectionAloneWhenEmptyVarargsRetainAll() {
		assertFalse(testInstance.retainAll(emptyCollection(), emptyVarargs()));
	}
	
	@Test
	public void shouldLeaveCollectionAloneWhenNullFirstVarargsRetainAll() {
		assertFalse(testInstance.retainAll(emptyCollection(), nullFirstVararg()));
	}
	
	@Test
	public void shouldLeaveCollectionAloneWhenEmptyCollectionWithOneVarargToRetain() {
		assertFalse(testInstance.retainAll(emptyCollection(), PROVIDED_STRING));
	}
	
	
	@Test
	public void shouldHandleNullCollectionRetainAll() {
		assertFalse(testInstance.retainAll(nullCollection(), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldLeaveSetAloneWhenNullFirstVarargsRetainAll() {
		assertFalse(testInstance.retainAll(emptySet(), nullFirstVararg()));
	}
	
	@Test
	public void shouldRetainOneInSetWhenOneVarargMatchesSetOfTwo() {
		Set<String> testSet = setOf(PROVIDED_STRING, SECOND_PROVIDED_STRING);
		assertTrue(testInstance.retainAll(testSet, PROVIDED_STRING));
		assertEquals(testSet.size(), 1);
	}

	@Test
	public void shouldLeaveSetAloneWhenRetainAllToEmptySetWhenTwoVarargsSpecified() {
		assertFalse(testInstance.retainAll(emptySet(), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}

	@Test
	public void shouldHandleNullSetRetainAll() {
		assertFalse(testInstance.retainAll(nullSet(), PROVIDED_STRING, SECOND_PROVIDED_STRING));
	}
	
	@Test
	public void shouldLeaveListAloneWhenNullFirstVarargsRetainAll() {
		assertFalse(testInstance.retainAll(emptyList(), nullFirstVararg()));
	}

	@Test
	public void shouldLeaveListAloneWhenNullFirstVarargsRetainAllPopulatedList() {
		assertFalse(testInstance.retainAll(listOf(PROVIDED_STRING), nullFirstVararg()));
	}

	// Tests for in()

	@Test
	public void shouldFindNothingInUnspecifiedVarargs() {
		assertFalse(testInstance.in(PROVIDED_STRING));
	}

	@Test
	public void shouldFindNothingInNullVarargs() {
		assertFalse(testInstance.in(PROVIDED_STRING, nullVarargs()));
	}

	@Test
	public void shouldFindNothingInEmptyVarargs() {
		assertFalse(testInstance.in(PROVIDED_STRING, emptyVarargs()));
	}
	
	@Test
	public void shouldFindNothingInNullFirstVarargs() {
		assertFalse(testInstance.in(PROVIDED_STRING, nullFirstVararg()));
	}

	@Test
	public void shouldFindObjectInSingleVarargThatContainsObject() {
		assertTrue(testInstance.in(PROVIDED_STRING, PROVIDED_STRING));
	}

	@Test
	public void shouldFindObjectInMultipleVarargsThatContainsObject() {
		assertTrue(testInstance.in(PROVIDED_STRING, SECOND_PROVIDED_STRING, PROVIDED_STRING));
	}

	@Test
	public void shouldNotFindNullObjectInMultipleVarargsThatContainsObject() {
		assertFalse(testInstance.in(null, SECOND_PROVIDED_STRING, PROVIDED_STRING));
	}

	@Test
	public void shouldNotFindObjectInMultipleVarargsThatDoesNotContainObject() {
		assertFalse(testInstance.in("sdfs", SECOND_PROVIDED_STRING, PROVIDED_STRING));
	}
	
	// Tests for notIn()

	@Test
	public void shouldConsiderSuppliedObjectToBeNotInUnspecifiedVarargs() {
		assertTrue(testInstance.notIn(PROVIDED_STRING));
	}

	@Test
	public void shouldConsiderSuppliedObjectToBeNotInNullVarargs() {
		assertTrue(testInstance.notIn(PROVIDED_STRING, nullVarargs()));
	}

	@Test
	public void shouldConsiderSuppliedObjectToBeNotInEmptyVarargs() {
		assertTrue(testInstance.notIn(PROVIDED_STRING, emptyVarargs()));
	}
	
	@Test
	public void shouldConsiderSuppliedObjectToBeNotInNullFirstVarargs() {
		assertTrue(testInstance.notIn(PROVIDED_STRING, nullFirstVararg()));
	}

	@Test
	public void notInShouldBeFalseWhenFindObjectInSingleVarargThatContainsObject() {
		assertFalse(testInstance.notIn(PROVIDED_STRING, PROVIDED_STRING));
	}

	@Test
	public void notInShouldBeFalseWhenFindObjectInMultipleVarargsThatContainsObject() {
		assertFalse(testInstance.notIn(PROVIDED_STRING, SECOND_PROVIDED_STRING, PROVIDED_STRING));
	}

	@Test
	public void notInShouldBeTrueWhenNullObjectInMultipleVarargs() {
		assertTrue(testInstance.notIn(null, SECOND_PROVIDED_STRING, PROVIDED_STRING));
	}

	@Test
	public void notInShouldBeTrueWhenMultipleVarargsThatDoesNotContainObject() {
		assertTrue(testInstance.notIn("sdfs", SECOND_PROVIDED_STRING, PROVIDED_STRING));
	}	
	
	// Tests for each()
	
	@Test
	public void shouldReturnEmptyIterableForNonExistentVarargs() {
		assertFalse(testInstance.each().iterator().hasNext());
	}
	
	@Test
	public void shouldReturnEmptyIterableForNullVarargs() {
		assertFalse(testInstance.each(nullVarargs()).iterator().hasNext());
	}
	
	@Test
	public void shouldReturnEmptyIterableForEmptyVarargs() {
		assertFalse(testInstance.each(emptyVarargs()).iterator().hasNext());
	}
	
	@Test
	public void shouldReturnEmptyIterableForNullFirstVarargs() {
		assertFalse(testInstance.each(nullFirstVararg()).iterator().hasNext());
	}
	
	@Test
	public void shouldReturnNonEmptyIterableForSingleVarargs() {
		Iterator<String> it = testInstance.each(PROVIDED_STRING).iterator();
		assertTrue(it.hasNext());
		it.next();
		assertFalse(it.hasNext());
	}
	
	@Test
	public void shouldReturnNonEmptyIterableForMultipleVarargs() {
		Iterator<String> it = testInstance.each(PROVIDED_STRING, SECOND_PROVIDED_STRING).iterator();
		assertTrue(it.hasNext());
		it.next();
		assertTrue(it.hasNext());
		it.next();
		assertFalse(it.hasNext());
	}
	
	// Tests for asList()
	
	@Test
	public void shouldReturnEmptyIterableForNonExistentVarargsAsList() {
		assertTrue(testInstance.asList().isEmpty());
	}
	
	@Test
	public void shouldReturnEmptyIterableForNullVarargsAsList() {
		assertTrue(testInstance.asList(nullVarargs()).isEmpty());
	}
	
	@Test
	public void shouldReturnEmptyIterableForEmptyVarargsAsList() {
		assertTrue(testInstance.asList(emptyVarargs()).isEmpty());
	}
	
	@Test
	public void shouldReturnEmptyIterableForNullFirstVarargsAsList() {
		assertTrue(testInstance.asList(nullFirstVararg()).isEmpty());
	}
	
	@Test
	public void shouldReturnNonEmptyIterableForSingleVarargsAsList() {
		assertEquals(testInstance.asList(PROVIDED_STRING).size(), 1);
	}
	
	@Test
	public void shouldReturnNonEmptyIterableForMultipleVarargsAsList() {
		assertEquals(testInstance.asList(PROVIDED_STRING, SECOND_PROVIDED_STRING).size(), 2);
	}

	private void thenCollectionHasSize(Collection<?> coll, int i) {
		assertEquals((coll == null) ? 0 : coll.size(), i);
	}
}
