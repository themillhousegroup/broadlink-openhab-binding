package com.themillhousegroup.argon.impl;

import static com.themillhousegroup.argon.testhelper.VarargsHelper.DEFAULT_APPENDABLE;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.PROVIDED_APPENDABLE;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.SECOND_PROVIDED_APPENDABLE;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.emptyVarargs;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullFirstVararg;
import static com.themillhousegroup.argon.testhelper.VarargsHelper.nullVarargs;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.themillhousegroup.argon.InjectableArgonAppendables;

@Test(groups={"argon", "unit", "fast", "injectables", "appendables"})
public class InjectableArgonAppendablesTest {
	
	private InjectableArgonAppendables testInstance;
	
	@BeforeClass
	public void setup() {
		testInstance = new InjectableArgonAppendablesImpl();
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendFirst() {
		assertEquals(testInstance.appendFirstIfPresent(DEFAULT_APPENDABLE), DEFAULT_APPENDABLE);
	}
	
	@Test(expectedExceptions=RuntimeException.class)
	public void shouldThrowRuntimeExceptionIfIOExceptionWhileAppending() throws IOException {
		Appendable mockAppendable = Mockito.mock(Appendable.class);
		Mockito.when(mockAppendable.append(Mockito.any(CharSequence.class))).thenThrow(new IOException("mock exception"));
		testInstance.appendFirstIfPresent(mockAppendable, PROVIDED_APPENDABLE);
	}
	
	@Test
	public void shouldAppendFirstStringIfProvided() throws IOException {
		assertEquals(
			testInstance.appendFirstIfPresent(DEFAULT_APPENDABLE, PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE,PROVIDED_APPENDABLE));
	}
	
	

	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendSeparatorAndFirst() {
		assertEquals(testInstance.appendSeparatorAndFirstIfPresent(DEFAULT_APPENDABLE, "--"), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldAppendSeparatorAndFirstStringIfProvided() throws IOException {
		assertEquals(
			testInstance.appendSeparatorAndFirstIfPresent(DEFAULT_APPENDABLE, "--", PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE, "--", PROVIDED_APPENDABLE.toString()));
	}


	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendLast() {
		assertEquals(testInstance.appendLastIfPresent(DEFAULT_APPENDABLE), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldAppendLastStringIfProvided() throws IOException {
		assertEquals(
			testInstance.appendLastIfPresent(DEFAULT_APPENDABLE, PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE, PROVIDED_APPENDABLE));
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendSeparatorAndLast() {
		assertEquals(testInstance.appendSeparatorAndLastIfPresent(DEFAULT_APPENDABLE, "--"), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldAppendSeparatorAndLastStringIfProvided() throws IOException {
		assertEquals(
			testInstance.appendSeparatorAndLastIfPresent(DEFAULT_APPENDABLE, "--", PROVIDED_APPENDABLE, SECOND_PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE, "--", SECOND_PROVIDED_APPENDABLE.toString()));
	}
	
	@Test
	public void shouldReturnBaseStringIfNoVarargsProvidedToAppend() {
		assertEquals(testInstance.appendIfPresent(DEFAULT_APPENDABLE), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullVarargsProvidedToAppend() {
		assertEquals(testInstance.appendIfPresent(DEFAULT_APPENDABLE, nullVarargs()), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringIfEmptyVarargsProvidedToAppend() {
		assertEquals(testInstance.appendIfPresent(DEFAULT_APPENDABLE, emptyVarargs()), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullFirstVarargProvidedToAppend() {
		assertEquals(testInstance.appendIfPresent(DEFAULT_APPENDABLE, nullFirstVararg()), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgIfOneVarargProvidedToAppend() throws IOException {
		assertEquals(
			testInstance.appendIfPresent(DEFAULT_APPENDABLE, PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE, PROVIDED_APPENDABLE));
	}
	
	@Test
	public void shouldReturnBaseStringAndArgsIfTwoVarargsProvidedToAppend() throws IOException {
		assertEquals(
			testInstance.appendIfPresent(DEFAULT_APPENDABLE, PROVIDED_APPENDABLE, SECOND_PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE, PROVIDED_APPENDABLE, SECOND_PROVIDED_APPENDABLE));
		
	}
	
	@Test
	public void shouldReturnBaseStringIfNoVarargsProvidedToAppendWithSeparators() {
		assertEquals(testInstance.appendWithSeparatorsIfPresent(DEFAULT_APPENDABLE, "--"), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullVarargsProvidedToAppendWithSeparators() {
		assertEquals(testInstance.appendWithSeparatorsIfPresent(DEFAULT_APPENDABLE, "--", nullVarargs()), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringIfEmptyVarargsProvidedToAppendWithSeparators() {
		assertEquals(testInstance.appendWithSeparatorsIfPresent(DEFAULT_APPENDABLE, "--", emptyVarargs()), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullFirstVarargProvidedToAppendWithSeparators() {
		assertEquals(
				testInstance.appendWithSeparatorsIfPresent(DEFAULT_APPENDABLE, "--", nullFirstVararg()), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgIfOneVarargProvidedToAppendWithSeparators() throws IOException {
		assertEquals(
			testInstance.appendWithSeparatorsIfPresent(DEFAULT_APPENDABLE, "--", PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE,"--", PROVIDED_APPENDABLE.toString()));
	}
	
	@Test
	public void shouldReturnBaseStringAndArgsIfTwoVarargsProvidedToAppendWithSeparators() throws IOException {
		assertEquals(
			testInstance.appendWithSeparatorsIfPresent(DEFAULT_APPENDABLE, "--", PROVIDED_APPENDABLE, SECOND_PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE, "--", PROVIDED_APPENDABLE.toString(), "--", SECOND_PROVIDED_APPENDABLE.toString()));
		
	}
	
	
	@Test
	public void shouldHandleIfNullValuedVarargsProvidedToAppendWithSeparators() throws IOException {
		assertEquals(
			testInstance.appendWithSeparatorsIfPresent(DEFAULT_APPENDABLE, "--", PROVIDED_APPENDABLE, null, SECOND_PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE, "--", PROVIDED_APPENDABLE.toString(), "--","null", "--", SECOND_PROVIDED_APPENDABLE.toString()));
		
	}
	
	// If only there was a library that could do this ...
	private Appendable combine(Appendable base, Appendable... appendables) throws IOException {
		for (Appendable a : appendables) {
			base.append(a.toString());
		}
		return base;
	}
	
	private Object combine(Appendable base, String... strings) throws IOException {
		for (String s : strings) {
			base.append(s.toString());
		}
		return base;
	}
}
