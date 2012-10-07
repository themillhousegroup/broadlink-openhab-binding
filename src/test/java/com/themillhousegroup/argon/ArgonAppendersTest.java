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
public class ArgonAppendersTest {
	
	@BeforeClass
	public void setup() {
		new ArgonAppenders(); // For 100% code coverage only.
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendFirst() {
		assertEquals(ArgonAppenders.appendFirstIfPresent(DEFAULT_STRING), DEFAULT_STRING);
	}
	
	@Test
	public void shouldAppendFirstStringIfProvided() {
		assertEquals(ArgonAppenders.appendFirstIfPresent(DEFAULT_STRING, PROVIDED_STRING), DEFAULT_STRING + PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendSeparatorAndFirst() {
		assertEquals(ArgonAppenders.appendSeparatorAndFirstIfPresent(DEFAULT_STRING, "--"), DEFAULT_STRING);
	}
	
	@Test
	public void shouldAppendSeparatorAndFirstStringIfProvided() {
		assertEquals(ArgonAppenders.appendSeparatorAndFirstIfPresent(DEFAULT_STRING, "--", PROVIDED_STRING), DEFAULT_STRING + "--" + PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendLast() {
		assertEquals(ArgonAppenders.appendLastIfPresent(DEFAULT_STRING), DEFAULT_STRING);
	}
	
	@Test
	public void shouldAppendLastStringIfProvided() {
		assertEquals(ArgonAppenders.appendLastIfPresent(DEFAULT_STRING, PROVIDED_STRING), DEFAULT_STRING + PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendSeparatorAndLast() {
		assertEquals(ArgonAppenders.appendSeparatorAndLastIfPresent(DEFAULT_STRING, "--"), DEFAULT_STRING);
	}
	
	@Test
	public void shouldAppendSeparatorAndLastStringIfProvided() {
		assertEquals(
				ArgonAppenders.appendSeparatorAndLastIfPresent(DEFAULT_STRING, "--", PROVIDED_STRING, SECOND_PROVIDED_STRING), 
			DEFAULT_STRING + "--" + SECOND_PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNoVarargsProvidedToAppend() {
		assertEquals(ArgonAppenders.appendIfPresent(DEFAULT_STRING), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullVarargsProvidedToAppend() {
		assertEquals(ArgonAppenders.appendIfPresent(DEFAULT_STRING, nullVarargs()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfEmptyVarargsProvidedToAppend() {
		assertEquals(ArgonAppenders.appendIfPresent(DEFAULT_STRING, emptyVarargs()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullFirstVarargProvidedToAppend() {
		assertEquals(ArgonAppenders.appendIfPresent(DEFAULT_STRING, nullFirstVararg()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgIfOneVarargProvidedToAppend() {
		assertEquals(ArgonAppenders.appendIfPresent(DEFAULT_STRING, PROVIDED_STRING), DEFAULT_STRING + PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgsIfTwoVarargsProvidedToAppend() {
		assertEquals(
			ArgonAppenders.appendIfPresent(DEFAULT_STRING, PROVIDED_STRING, SECOND_PROVIDED_STRING), 
			DEFAULT_STRING + PROVIDED_STRING + SECOND_PROVIDED_STRING);
		
	}
	
	@Test
	public void shouldReturnBaseStringIfNoVarargsProvidedToAppendWithSeparators() {
		assertEquals(ArgonAppenders.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--"), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullVarargsProvidedToAppendWithSeparators() {
		assertEquals(ArgonAppenders.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", nullVarargs()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfEmptyVarargsProvidedToAppendWithSeparators() {
		assertEquals(ArgonAppenders.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", emptyVarargs()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullFirstVarargProvidedToAppendWithSeparators() {
		assertEquals(
			ArgonAppenders.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", nullFirstVararg()), DEFAULT_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgIfOneVarargProvidedToAppendWithSeparators() {
		assertEquals(
			ArgonAppenders.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", PROVIDED_STRING), 
			DEFAULT_STRING + "--" +PROVIDED_STRING);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgsIfTwoVarargsProvidedToAppendWithSeparators() {
		assertEquals(
			ArgonAppenders.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", PROVIDED_STRING, SECOND_PROVIDED_STRING), 
			DEFAULT_STRING + "--" + PROVIDED_STRING + "--" + SECOND_PROVIDED_STRING);
		
	}
	
	
	@Test
	public void shouldHandleIfNullValuedVarargsProvidedToAppendWithSeparators() {
		assertEquals(
			ArgonAppenders.appendWithSeparatorsIfPresent(DEFAULT_STRING, "--", PROVIDED_STRING, null, SECOND_PROVIDED_STRING), 
			DEFAULT_STRING + "--" + PROVIDED_STRING + "--" + "null" + "--" + SECOND_PROVIDED_STRING);
		
	}
}
