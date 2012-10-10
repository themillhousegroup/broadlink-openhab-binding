package com.themillhousegroup.argon.impl;

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

import com.themillhousegroup.argon.InjectableArgon;

@Test(groups={"argon", "unit", "fast", "injectables", "core"})
public class InjectableArgonImplCoreTest {

	private InjectableArgon testInstance;
	
	@BeforeClass
	public void setup() {
		testInstance = new InjectableArgonImpl();
	}
	
	@Test
	public void shouldNotHaveVarargsIfNotProvided() {
		assertFalse(testInstance.hasVarargs()); 
	}
	
	@Test
	public void shouldNotHaveVarargsIfNull() {
		assertFalse(testInstance.hasVarargs(nullVarargs())); 
	}
	
	@Test
	public void shouldNotHaveVarargsIfEmpty() {
		assertFalse(testInstance.hasVarargs(emptyVarargs())); 
	}
	
	@Test
	public void shouldNotHaveVarargsIfSizeOneButFirstItemNullTest1() {
		assertFalse(testInstance.hasVarargs(nullFirstVararg())); 
	}
	
	@Test
	public void shouldCountNumVarargsCorrectlyIfVarargsNotProvided() {
		assertEquals(testInstance.numVarargs(), 0);
	}
	
	@Test
	public void shouldCountNumVarargsCorrectlyIfNullVarargsNotProvided() {
		assertEquals(testInstance.numVarargs(nullVarargs()), 0);
	}
	
	@Test
	public void shouldCountNumVarargsCorrectlyIfNullVarargsProvided() {
		assertEquals(testInstance.numVarargs(nullVarargs()), 0);
	}
	
	@Test
	public void shouldCountNumVarargsCorrectlyIfEmptyVarargsProvided() {
		assertEquals(testInstance.numVarargs(emptyVarargs()), 0);
	}
	
	@Test
	public void shouldCountNumVarargsCorrectlyIfNullFirstVarargProvided() {
		assertEquals(testInstance.numVarargs(nullFirstVararg()), 0);
	}
	
	@Test
	public void shouldCountNumVarargsCorrectlyIfOneVarargProvided() {
		assertEquals(testInstance.numVarargs(PROVIDED_STRING), 1);
	}
	
	@Test
	public void shouldCountNumVarargsCorrectlyIfTwoVarargProvided() {
		assertEquals(testInstance.numVarargs(PROVIDED_STRING, SECOND_PROVIDED_STRING), 2);
	}
	
	@Test
	public void shouldReturnNullForFirstVarargWhenNoVarargsProvided() {
		assertNull(testInstance.firstVararg());
	}
	
	@Test
	public void shouldReturnNullForFirstVarargWhenNullVarargsProvided() {
		assertNull(testInstance.firstVararg(nullVarargs()));
	}
	
	@Test
	public void shouldReturnNullForFirstVarargWhenEmptyVarargsProvided() {
		assertNull(testInstance.firstVararg(emptyVarargs()));
	}
	
	@Test
	public void shouldReturnNullForFirstVarargWhenNullFirstVarargProvided() {
		assertNull(testInstance.firstVararg(nullFirstVararg()));
	}
	
	@Test
	public void shouldReturnCorrectlyForFirstVarargWhenNonNullFirstVarargProvided() {
		assertEquals(testInstance.firstVararg(PROVIDED_STRING), PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnCorrectlyForFirstVarargWhenMultipleVarargsProvided() {
		assertEquals(testInstance.firstVararg(PROVIDED_STRING, SECOND_PROVIDED_STRING), PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnNullForLastVarargWhenNoVarargsProvided() {
		assertNull(testInstance.lastVararg());
	}
	
	@Test
	public void shouldReturnNullForLastVarargWhenNullVarargsProvided() {
		assertNull(testInstance.lastVararg(nullVarargs()));
	}
	
	@Test
	public void shouldReturnNullForLastVarargWhenEmptyVarargsProvided() {
		assertNull(testInstance.lastVararg(emptyVarargs()));
	}
	
	@Test
	public void shouldReturnNullForLastVarargWhenNullFirstVarargProvided() {
		assertNull(testInstance.lastVararg(nullFirstVararg()));
	}
	
	@Test
	public void shouldReturnCorrectlyForLastVarargWhenNonNullFirstVarargProvided() {
		assertEquals(testInstance.lastVararg(PROVIDED_STRING), PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnCorrectlyForLastVarargWhenMultipleVarargsProvided() {
		assertEquals(testInstance.lastVararg(PROVIDED_STRING, SECOND_PROVIDED_STRING), SECOND_PROVIDED_STRING);
	}
}
