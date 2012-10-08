package com.themillhousegroup.argon;

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

@Test(groups={"argon", "unit", "fast", "statics", "appenders"})
public class ArgonAppendablesTest {
	
	@BeforeClass
	public void setup() {
		new ArgonAppendables(); // For 100% code coverage only.
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendFirst() {
		assertEquals(ArgonAppendables.appendFirstIfPresent(DEFAULT_APPENDABLE), DEFAULT_APPENDABLE);
	}
	
	@Test(expectedExceptions=RuntimeException.class)
	public void shouldThrowRuntimeExceptionIfIOExceptionWhileAppending() throws IOException {
		Appendable mockAppendable = Mockito.mock(Appendable.class);
		Mockito.when(mockAppendable.append(Mockito.any(CharSequence.class))).thenThrow(new IOException("mock exception"));
		ArgonAppendables.appendFirstIfPresent(mockAppendable, PROVIDED_APPENDABLE);
	}
	
	@Test
	public void shouldAppendFirstStringIfProvided() throws IOException {
		assertEquals(
			ArgonAppendables.appendFirstIfPresent(DEFAULT_APPENDABLE, PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE,PROVIDED_APPENDABLE));
	}
	
	

	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendSeparatorAndFirst() {
		assertEquals(ArgonAppendables.appendSeparatorAndFirstIfPresent(DEFAULT_APPENDABLE, "--"), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldAppendSeparatorAndFirstStringIfProvided() throws IOException {
		assertEquals(
			ArgonAppendables.appendSeparatorAndFirstIfPresent(DEFAULT_APPENDABLE, "--", PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE, "--", PROVIDED_APPENDABLE.toString()));
	}


	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendLast() {
		assertEquals(ArgonAppendables.appendLastIfPresent(DEFAULT_APPENDABLE), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldAppendLastStringIfProvided() throws IOException {
		assertEquals(
			ArgonAppendables.appendLastIfPresent(DEFAULT_APPENDABLE, PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE, PROVIDED_APPENDABLE));
	}
	
	@Test
	public void shouldReturnBaseStringIfNoArgsProvidedToAppendSeparatorAndLast() {
		assertEquals(ArgonAppendables.appendSeparatorAndLastIfPresent(DEFAULT_APPENDABLE, "--"), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldAppendSeparatorAndLastStringIfProvided() throws IOException {
		assertEquals(
			ArgonAppendables.appendSeparatorAndLastIfPresent(DEFAULT_APPENDABLE, "--", PROVIDED_APPENDABLE, SECOND_PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE, "--", SECOND_PROVIDED_APPENDABLE.toString()));
	}
	
	@Test
	public void shouldReturnBaseStringIfNoVarargsProvidedToAppend() {
		assertEquals(ArgonAppendables.appendIfPresent(DEFAULT_APPENDABLE), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullVarargsProvidedToAppend() {
		assertEquals(ArgonAppendables.appendIfPresent(DEFAULT_APPENDABLE, nullVarargs()), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringIfEmptyVarargsProvidedToAppend() {
		assertEquals(ArgonAppendables.appendIfPresent(DEFAULT_APPENDABLE, emptyVarargs()), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullFirstVarargProvidedToAppend() {
		assertEquals(ArgonAppendables.appendIfPresent(DEFAULT_APPENDABLE, nullFirstVararg()), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgIfOneVarargProvidedToAppend() throws IOException {
		assertEquals(
			ArgonAppendables.appendIfPresent(DEFAULT_APPENDABLE, PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE, PROVIDED_APPENDABLE));
	}
	
	@Test
	public void shouldReturnBaseStringAndArgsIfTwoVarargsProvidedToAppend() throws IOException {
		assertEquals(
			ArgonAppendables.appendIfPresent(DEFAULT_APPENDABLE, PROVIDED_APPENDABLE, SECOND_PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE, PROVIDED_APPENDABLE, SECOND_PROVIDED_APPENDABLE));
		
	}
	
	@Test
	public void shouldReturnBaseStringIfNoVarargsProvidedToAppendWithSeparators() {
		assertEquals(ArgonAppendables.appendWithSeparatorsIfPresent(DEFAULT_APPENDABLE, "--"), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullVarargsProvidedToAppendWithSeparators() {
		assertEquals(ArgonAppendables.appendWithSeparatorsIfPresent(DEFAULT_APPENDABLE, "--", nullVarargs()), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringIfEmptyVarargsProvidedToAppendWithSeparators() {
		assertEquals(ArgonAppendables.appendWithSeparatorsIfPresent(DEFAULT_APPENDABLE, "--", emptyVarargs()), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringIfNullFirstVarargProvidedToAppendWithSeparators() {
		assertEquals(
				ArgonAppendables.appendWithSeparatorsIfPresent(DEFAULT_APPENDABLE, "--", nullFirstVararg()), DEFAULT_APPENDABLE);
	}
	
	@Test
	public void shouldReturnBaseStringAndArgIfOneVarargProvidedToAppendWithSeparators() throws IOException {
		assertEquals(
			ArgonAppendables.appendWithSeparatorsIfPresent(DEFAULT_APPENDABLE, "--", PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE,"--", PROVIDED_APPENDABLE.toString()));
	}
	
	@Test
	public void shouldReturnBaseStringAndArgsIfTwoVarargsProvidedToAppendWithSeparators() throws IOException {
		assertEquals(
			ArgonAppendables.appendWithSeparatorsIfPresent(DEFAULT_APPENDABLE, "--", PROVIDED_APPENDABLE, SECOND_PROVIDED_APPENDABLE), 
			combine(DEFAULT_APPENDABLE, "--", PROVIDED_APPENDABLE.toString(), "--", SECOND_PROVIDED_APPENDABLE.toString()));
		
	}
	
	
	@Test
	public void shouldHandleIfNullValuedVarargsProvidedToAppendWithSeparators() throws IOException {
		assertEquals(
			ArgonAppendables.appendWithSeparatorsIfPresent(DEFAULT_APPENDABLE, "--", PROVIDED_APPENDABLE, null, SECOND_PROVIDED_APPENDABLE), 
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
