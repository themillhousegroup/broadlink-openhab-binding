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

import com.themillhousegroup.argon.InjectableArgonStringAppenders;

@Test(groups={"argon", "unit", "fast", "injectables", "appenders"})
public class ArgonStringAppendersTest {
	
	private InjectableArgonStringAppenders testInstance;
	
	@BeforeClass
	public void setup() {
		testInstance = new InjectableArgonStringAppendersImpl();
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendFirst() {
		assertEquals(testInstance.appendFirstIfPresent(DEFAULT_STRING), DEFAULT_STRING);
	}
	
	@Test
	public void shouldAppendFirstStringIfProvided() {
		assertEquals(testInstance.appendFirstIfPresent(DEFAULT_STRING, PROVIDED_STRING), DEFAULT_STRING + PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendSeparatorAndFirst() {
		assertEquals(testInstance.appendSeparatorAndFirstIfPresent(DEFAULT_STRING, "--"), DEFAULT_STRING);
	}
	
	@Test
	public void shouldAppendSeparatorAndFirstStringIfProvided() {
		assertEquals(testInstance.appendSeparatorAndFirstIfPresent(DEFAULT_STRING, "--", PROVIDED_STRING), DEFAULT_STRING + "--" + PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendLast() {
		assertEquals(testInstance.appendLastIfPresent(DEFAULT_STRING), DEFAULT_STRING);
	}
	
	@Test
	public void shouldAppendLastStringIfProvided() {
		assertEquals(testInstance.appendLastIfPresent(DEFAULT_STRING, PROVIDED_STRING), DEFAULT_STRING + PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendSeparatorAndLast() {
		assertEquals(testInstance.appendSeparatorAndLastIfPresent(DEFAULT_STRING, "--"), DEFAULT_STRING);
	}
	
	@Test
	public void shouldAppendSeparatorAndLastStringIfProvided() {
		assertEquals(
				testInstance.appendSeparatorAndLastIfPresent(DEFAULT_STRING, "--", PROVIDED_STRING, SECOND_PROVIDED_STRING), 
			DEFAULT_STRING + "--" + SECOND_PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNoVarargsProvidedToAppend() {
		assertEquals(testInstance.appendIfPresent(DEFAULT_STRING), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullVarargsProvidedToAppend() {
		assertEquals(testInstance.appendIfPresent(DEFAULT_STRING, nullVarargs()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfEmptyVarargsProvidedToAppend() {
		assertEquals(testInstance.appendIfPresent(DEFAULT_STRING, emptyVarargs()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullFirstVarargProvidedToAppend() {
		assertEquals(testInstance.appendIfPresent(DEFAULT_STRING, nullFirstVararg()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgIfOneVarargProvidedToAppend() {
		assertEquals(testInstance.appendIfPresent(DEFAULT_STRING, PROVIDED_STRING), DEFAULT_STRING + PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgsIfTwoVarargsProvidedToAppend() {
		assertEquals(
			testInstance.appendIfPresent(DEFAULT_STRING, PROVIDED_STRING, SECOND_PROVIDED_STRING), 
			DEFAULT_STRING + PROVIDED_STRING + SECOND_PROVIDED_STRING);
		
	}
	
	@Test
	public void shouldReturnBaseStringIfNoVarargsProvidedToAppendWithSeparators() {
		assertEquals(testInstance.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--"), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullVarargsProvidedToAppendWithSeparators() {
		assertEquals(testInstance.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", nullVarargs()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfEmptyVarargsProvidedToAppendWithSeparators() {
		assertEquals(testInstance.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", emptyVarargs()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullFirstVarargProvidedToAppendWithSeparators() {
		assertEquals(
			testInstance.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", nullFirstVararg()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgIfOneVarargProvidedToAppendWithSeparators() {
		assertEquals(
			testInstance.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", PROVIDED_STRING), 
			DEFAULT_STRING + "--" +PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgsIfTwoVarargsProvidedToAppendWithSeparators() {
		assertEquals(
			testInstance.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", PROVIDED_STRING, SECOND_PROVIDED_STRING), 
			DEFAULT_STRING + "--" + PROVIDED_STRING + "--" + SECOND_PROVIDED_STRING);
		
	}
	
	
	@Test
	public void shouldHandleIfNullValuedVarargsProvidedToAppendWithSeparators() {
		assertEquals(
			testInstance.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", PROVIDED_STRING, null, SECOND_PROVIDED_STRING), 
			DEFAULT_STRING + "--" + PROVIDED_STRING + "--" + "null" + "--" + SECOND_PROVIDED_STRING);
		
	}
}
