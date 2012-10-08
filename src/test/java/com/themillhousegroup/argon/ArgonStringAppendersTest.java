package com.themillhousegroup.argon;

import static com.themillhousegroup.argon.testhelper.VarargsHelper.DEFAULT_STRING;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.PROVIDED_STRING;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.SECOND_PROVIDED_STRING;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.emptyVarargs;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullFirstVararg;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullVarargs;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups={"argon", "unit", "fast", "statics", "appenders"})
public class ArgonStringAppendersTest {
	
	@BeforeClass
	public void setup() {
		new ArgonStringAppenders(); // For 100% code coverage only.
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendFirst() {
		assertEquals(ArgonStringAppenders.appendFirstIfPresent(DEFAULT_STRING), DEFAULT_STRING);
	}
	
	@Test
	public void shouldAppendFirstStringIfProvided() {
		assertEquals(ArgonStringAppenders.appendFirstIfPresent(DEFAULT_STRING, PROVIDED_STRING), DEFAULT_STRING + PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendSeparatorAndFirst() {
		assertEquals(ArgonStringAppenders.appendSeparatorAndFirstIfPresent(DEFAULT_STRING, "--"), DEFAULT_STRING);
	}
	
	@Test
	public void shouldAppendSeparatorAndFirstStringIfProvided() {
		assertEquals(ArgonStringAppenders.appendSeparatorAndFirstIfPresent(DEFAULT_STRING, "--", PROVIDED_STRING), DEFAULT_STRING + "--" + PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendLast() {
		assertEquals(ArgonStringAppenders.appendLastIfPresent(DEFAULT_STRING), DEFAULT_STRING);
	}
	
	@Test
	public void shouldAppendLastStringIfProvided() {
		assertEquals(ArgonStringAppenders.appendLastIfPresent(DEFAULT_STRING, PROVIDED_STRING), DEFAULT_STRING + PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendSeparatorAndLast() {
		assertEquals(ArgonStringAppenders.appendSeparatorAndLastIfPresent(DEFAULT_STRING, "--"), DEFAULT_STRING);
	}
	
	@Test
	public void shouldAppendSeparatorAndLastStringIfProvided() {
		assertEquals(
				ArgonStringAppenders.appendSeparatorAndLastIfPresent(DEFAULT_STRING, "--", PROVIDED_STRING, SECOND_PROVIDED_STRING), 
			DEFAULT_STRING + "--" + SECOND_PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNoVarargsProvidedToAppend() {
		assertEquals(ArgonStringAppenders.appendIfPresent(DEFAULT_STRING), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullVarargsProvidedToAppend() {
		assertEquals(ArgonStringAppenders.appendIfPresent(DEFAULT_STRING, nullVarargs()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfEmptyVarargsProvidedToAppend() {
		assertEquals(ArgonStringAppenders.appendIfPresent(DEFAULT_STRING, emptyVarargs()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullFirstVarargProvidedToAppend() {
		assertEquals(ArgonStringAppenders.appendIfPresent(DEFAULT_STRING, nullFirstVararg()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgIfOneVarargProvidedToAppend() {
		assertEquals(ArgonStringAppenders.appendIfPresent(DEFAULT_STRING, PROVIDED_STRING), DEFAULT_STRING + PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgsIfTwoVarargsProvidedToAppend() {
		assertEquals(
			ArgonStringAppenders.appendIfPresent(DEFAULT_STRING, PROVIDED_STRING, SECOND_PROVIDED_STRING), 
			DEFAULT_STRING + PROVIDED_STRING + SECOND_PROVIDED_STRING);
		
	}
	
	@Test
	public void shouldReturnBaseStringIfNoVarargsProvidedToAppendWithSeparators() {
		assertEquals(ArgonStringAppenders.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--"), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullVarargsProvidedToAppendWithSeparators() {
		assertEquals(ArgonStringAppenders.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", nullVarargs()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfEmptyVarargsProvidedToAppendWithSeparators() {
		assertEquals(ArgonStringAppenders.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", emptyVarargs()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullFirstVarargProvidedToAppendWithSeparators() {
		assertEquals(
			ArgonStringAppenders.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", nullFirstVararg()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgIfOneVarargProvidedToAppendWithSeparators() {
		assertEquals(
			ArgonStringAppenders.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", PROVIDED_STRING), 
			DEFAULT_STRING + "--" +PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgsIfTwoVarargsProvidedToAppendWithSeparators() {
		assertEquals(
			ArgonStringAppenders.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", PROVIDED_STRING, SECOND_PROVIDED_STRING), 
			DEFAULT_STRING + "--" + PROVIDED_STRING + "--" + SECOND_PROVIDED_STRING);
		
	}
	
	
	@Test
	public void shouldHandleIfNullValuedVarargsProvidedToAppendWithSeparators() {
		assertEquals(
			ArgonStringAppenders.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", PROVIDED_STRING, null, SECOND_PROVIDED_STRING), 
			DEFAULT_STRING + "--" + PROVIDED_STRING + "--" + "null" + "--" + SECOND_PROVIDED_STRING);
		
	}
}
