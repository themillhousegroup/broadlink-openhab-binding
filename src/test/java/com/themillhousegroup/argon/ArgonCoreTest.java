package com.themillhousegroup.argon;

import static com.themillhousegroup.argon.testhelper.VarargsHelper.PROVIDED_STRING;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.SECOND_PROVIDED_STRING;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.emptyVarargs;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullFirstVararg;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullVarargs;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Tests for the most basic parts of Argon - null checking, size checking, etc
 */
@Test(groups={"argon", "unit", "fast", "statics", "core"})
public class ArgonCoreTest {

	@BeforeClass
	public void setup() {
		new Argon(); // For 100% code coverage only.
	}
	
	@Test
	public void shouldNotHaveVarargsIfNotProvided() {
		assertFalse(Argon.hasVarargs()); 
	}
	
	@Test
	public void shouldNotHaveVarargsIfNull() {
		assertFalse(Argon.hasVarargs(nullVarargs())); 
	}
	
	@Test
	public void shouldNotHaveVarargsIfEmpty() {
		assertFalse(Argon.hasVarargs(emptyVarargs())); 
	}
	
	@Test
	public void shouldNotHaveVarargsIfSizeOneButFirstItemNullTest1() {
		assertFalse(Argon.hasVarargs(nullFirstVararg())); 
	}
	
	@Test
	public void shouldCountNumVarargsCorrectlyIfVarargsNotProvided() {
		assertEquals(Argon.numVarargs(), 0);
	}
	
	@Test
	public void shouldCountNumVarargsCorrectlyIfNullVarargsNotProvided() {
		assertEquals(Argon.numVarargs(nullVarargs()), 0);
	}
	
	@Test
	public void shouldCountNumVarargsCorrectlyIfNullVarargsProvided() {
		assertEquals(Argon.numVarargs(nullVarargs()), 0);
	}
	
	@Test
	public void shouldCountNumVarargsCorrectlyIfEmptyVarargsProvided() {
		assertEquals(Argon.numVarargs(emptyVarargs()), 0);
	}
	
	@Test
	public void shouldCountNumVarargsCorrectlyIfNullFirstVarargProvided() {
		assertEquals(Argon.numVarargs(nullFirstVararg()), 0);
	}
	
	@Test
	public void shouldCountNumVarargsCorrectlyIfOneVarargProvided() {
		assertEquals(Argon.numVarargs(PROVIDED_STRING), 1);
	}
	
	@Test
	public void shouldCountNumVarargsCorrectlyIfTwoVarargProvided() {
		assertEquals(Argon.numVarargs(PROVIDED_STRING, SECOND_PROVIDED_STRING), 2);
	}
	
	@Test
	public void shouldReturnNullForFirstVarargWhenNoVarargsProvided() {
		assertNull(Argon.firstVararg());
	}
	
	@Test
	public void shouldReturnNullForFirstVarargWhenNullVarargsProvided() {
		assertNull(Argon.firstVararg(nullVarargs()));
	}
	
	@Test
	public void shouldReturnNullForFirstVarargWhenEmptyVarargsProvided() {
		assertNull(Argon.firstVararg(emptyVarargs()));
	}
	
	@Test
	public void shouldReturnNullForFirstVarargWhenNullFirstVarargProvided() {
		assertNull(Argon.firstVararg(nullFirstVararg()));
	}
	
	@Test
	public void shouldReturnCorrectlyForFirstVarargWhenNonNullFirstVarargProvided() {
		assertEquals(Argon.firstVararg(PROVIDED_STRING), PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnCorrectlyForFirstVarargWhenMultipleVarargsProvided() {
		assertEquals(Argon.firstVararg(PROVIDED_STRING, SECOND_PROVIDED_STRING), PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnNullForLastVarargWhenNoVarargsProvided() {
		assertNull(Argon.lastVararg());
	}
	
	@Test
	public void shouldReturnNullForLastVarargWhenNullVarargsProvided() {
		assertNull(Argon.lastVararg(nullVarargs()));
	}
	
	@Test
	public void shouldReturnNullForLastVarargWhenEmptyVarargsProvided() {
		assertNull(Argon.lastVararg(emptyVarargs()));
	}
	
	@Test
	public void shouldReturnNullForLastVarargWhenNullFirstVarargProvided() {
		assertNull(Argon.lastVararg(nullFirstVararg()));
	}
	
	@Test
	public void shouldReturnCorrectlyForLastVarargWhenNonNullFirstVarargProvided() {
		assertEquals(Argon.lastVararg(PROVIDED_STRING), PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnCorrectlyForLastVarargWhenMultipleVarargsProvided() {
		assertEquals(Argon.lastVararg(PROVIDED_STRING, SECOND_PROVIDED_STRING), SECOND_PROVIDED_STRING);
	}
}
