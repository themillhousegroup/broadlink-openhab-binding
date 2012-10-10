package com.themillhousegroup.argon.impl;

import static com.themillhousegroup.argon.testhelper.VarargsHelper.DEFAULT_STRING;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.PROVIDED_STRING;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.SECOND_PROVIDED_STRING;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.emptyVarargs;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullFirstVararg;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullVarargs;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.themillhousegroup.argon.InjectableArgon;

@Test(groups={"argon", "unit", "fast", "injectables", "defaults"})
public class InjectableArgonImplDefaultsTest {

	private InjectableArgon testInstance;
	
	@BeforeClass
	public void setup() {
		testInstance = new InjectableArgonImpl();
	}
	
	@Test
	public void shouldDefaultIfNoArgsProvided() {
		assertEquals(testInstance.defaultIfAbsent(DEFAULT_STRING), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNullArgs() {
		assertEquals(testInstance.defaultIfAbsent(DEFAULT_STRING, nullVarargs()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfEmptyArgs() {
		assertEquals(testInstance.defaultIfAbsent(DEFAULT_STRING, emptyVarargs()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNullFirstArg() {
		assertEquals(testInstance.defaultIfAbsent(DEFAULT_STRING, nullFirstVararg()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldNotDefaultIfFirstArgProvided() {
		assertEquals(testInstance.defaultIfAbsent(DEFAULT_STRING, PROVIDED_STRING), PROVIDED_STRING); 
	}
	
	@Test
	public void shouldSelectFirstIfMultipleArgsProvided() {
		assertEquals(testInstance.defaultIfAbsent(DEFAULT_STRING, PROVIDED_STRING, SECOND_PROVIDED_STRING), PROVIDED_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNoArgsProvidedToUseFirst() {
		assertEquals(testInstance.useFirstIfPresent(DEFAULT_STRING), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNullArgsToUseFirst() {
		assertEquals(testInstance.useFirstIfPresent(DEFAULT_STRING, nullVarargs()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfEmptyArgsToUseFirst() {
		assertEquals(testInstance.useFirstIfPresent(DEFAULT_STRING, emptyVarargs()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNullFirstArgToUseFirst() {
		assertEquals(testInstance.useFirstIfPresent(DEFAULT_STRING, nullFirstVararg()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldNotDefaultIfFirstArgProvidedToUseFirst() {
		assertEquals(testInstance.useFirstIfPresent(DEFAULT_STRING, PROVIDED_STRING), PROVIDED_STRING); 
	}
	
	@Test
	public void shouldSelectFirstIfMultipleArgsProvidedToUseFirst() {
		assertEquals(testInstance.useFirstIfPresent(DEFAULT_STRING, PROVIDED_STRING, SECOND_PROVIDED_STRING), PROVIDED_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNoArgsProvidedToUseLast() {
		assertEquals(testInstance.useLastIfPresent(DEFAULT_STRING), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNullArgsToUseLast() {
		assertEquals(testInstance.useLastIfPresent(DEFAULT_STRING, nullVarargs()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfEmptyArgsToUseLast() {
		assertEquals(testInstance.useLastIfPresent(DEFAULT_STRING, emptyVarargs()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNullFirstArgToUseLast() {
		assertEquals(testInstance.useLastIfPresent(DEFAULT_STRING, nullFirstVararg()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldNotDefaultIfFirstArgProvidedToUseLast() {
		assertEquals(testInstance.useLastIfPresent(DEFAULT_STRING, PROVIDED_STRING), PROVIDED_STRING); 
	}
	
	@Test
	public void shouldSelectLastIfMultipleArgsProvidedToUseLast() {
		assertEquals(testInstance.useLastIfPresent(DEFAULT_STRING, PROVIDED_STRING, SECOND_PROVIDED_STRING), SECOND_PROVIDED_STRING); 
	}
}
