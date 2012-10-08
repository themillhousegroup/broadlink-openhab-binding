package com.themillhousegroup.argon.impl;

import com.themillhousegroup.argon.Argon;
import com.themillhousegroup.argon.InjectableArgon;

public class InjectableArgonImpl implements InjectableArgon {

	public <T> T defaultIfAbsent(T defaultOption, T... varargs) {
		return Argon.defaultIfAbsent(defaultOption, varargs);
	}

	public <T> T useFirstIfPresent(T defaultOption, T... varargs) {
		return Argon.useFirstIfPresent(defaultOption, varargs);
	}

	public <T> T useLastIfPresent(T defaultOption, T... varargs) {
		return Argon.useLastIfPresent(defaultOption, varargs);
	}

	public <T> T firstVararg(T... varargs) {
		return Argon.firstVararg(varargs);
	}

	public <T> T lastVararg(T... varargs) {
		return Argon.lastVararg(varargs);
	}

	public <T> int numVarargs(T... varargs) {
		return Argon.numVarargs(varargs);
	}

	public <T> boolean hasVarargs(T... varargs) {
		return Argon.hasVarargs(varargs);
	}

}
