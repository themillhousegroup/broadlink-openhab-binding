package com.themillhousegroup.argon;

import static com.themillhousegroup.argon.testhelper.VarargsHelper.SECOND_PROVIDED_STRING;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.emptyVarargs;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullFirstVararg;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullVarargs;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.DEFAULT_STRING;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.PROVIDED_STRING;

/**
 * Tests for the "defaulting" methods of Argon
 */
@Test(groups={"argon", "unit", "fast", "statics", "defaults"})
public class ArgonDefaultsTest {

	@Test
	public void shouldDefaultIfNoArgsProvided() {
		assertEquals(Argon.defaultIfAbsent(DEFAULT_STRING), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNullArgs() {
		assertEquals(Argon.defaultIfAbsent(DEFAULT_STRING, nullVarargs()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfEmptyArgs() {
		assertEquals(Argon.defaultIfAbsent(DEFAULT_STRING, emptyVarargs()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNullFirstArg() {
		assertEquals(Argon.defaultIfAbsent(DEFAULT_STRING, nullFirstVararg()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldNotDefaultIfFirstArgProvided() {
		assertEquals(Argon.defaultIfAbsent(DEFAULT_STRING, PROVIDED_STRING), PROVIDED_STRING); 
	}
	
	@Test
	public void shouldSelectFirstIfMultipleArgsProvided() {
		assertEquals(Argon.defaultIfAbsent(DEFAULT_STRING, PROVIDED_STRING, SECOND_PROVIDED_STRING), PROVIDED_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNoArgsProvidedToUseFirst() {
		assertEquals(Argon.useFirstIfPresent(DEFAULT_STRING), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNullArgsToUseFirst() {
		assertEquals(Argon.useFirstIfPresent(DEFAULT_STRING, nullVarargs()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfEmptyArgsToUseFirst() {
		assertEquals(Argon.useFirstIfPresent(DEFAULT_STRING, emptyVarargs()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNullFirstArgToUseFirst() {
		assertEquals(Argon.useFirstIfPresent(DEFAULT_STRING, nullFirstVararg()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldNotDefaultIfFirstArgProvidedToUseFirst() {
		assertEquals(Argon.useFirstIfPresent(DEFAULT_STRING, PROVIDED_STRING), PROVIDED_STRING); 
	}
	
	@Test
	public void shouldSelectFirstIfMultipleArgsProvidedToUseFirst() {
		assertEquals(Argon.useFirstIfPresent(DEFAULT_STRING, PROVIDED_STRING, SECOND_PROVIDED_STRING), PROVIDED_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNoArgsProvidedToUseLast() {
		assertEquals(Argon.useLastIfPresent(DEFAULT_STRING), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNullArgsToUseLast() {
		assertEquals(Argon.useLastIfPresent(DEFAULT_STRING, nullVarargs()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfEmptyArgsToUseLast() {
		assertEquals(Argon.useLastIfPresent(DEFAULT_STRING, emptyVarargs()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldDefaultIfNullFirstArgToUseLast() {
		assertEquals(Argon.useLastIfPresent(DEFAULT_STRING, nullFirstVararg()), DEFAULT_STRING); 
	}
	
	@Test
	public void shouldNotDefaultIfFirstArgProvidedToUseLast() {
		assertEquals(Argon.useLastIfPresent(DEFAULT_STRING, PROVIDED_STRING), PROVIDED_STRING); 
	}
	
	@Test
	public void shouldSelectLastIfMultipleArgsProvidedToUseLast() {
		assertEquals(Argon.useLastIfPresent(DEFAULT_STRING, PROVIDED_STRING, SECOND_PROVIDED_STRING), SECOND_PROVIDED_STRING); 
	}
}
