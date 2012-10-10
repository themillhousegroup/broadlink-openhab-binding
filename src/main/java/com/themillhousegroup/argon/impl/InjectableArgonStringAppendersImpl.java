package com.themillhousegroup.argon.impl;

import com.themillhousegroup.argon.ArgonStringAppenders;
import com.themillhousegroup.argon.InjectableArgonStringAppenders;

public class InjectableArgonStringAppendersImpl implements InjectableArgonStringAppenders {

	public <T> String appendFirstIfPresent(String base, T... varargs) {
		return ArgonStringAppenders.appendFirstIfPresent(base, varargs);
	}

	public <T> String appendSeparatorAndFirstIfPresent(String base,
			String separator, T... varargs) {
		return ArgonStringAppenders.appendSeparatorAndFirstIfPresent(base, separator, varargs);
	}

	public <T> String appendLastIfPresent(String base, T... varargs) {
		return ArgonStringAppenders.appendLastIfPresent(base, varargs);
	}

	public <T> String appendSeparatorAndLastIfPresent(String base,
			String separator, T... varargs) {
		return ArgonStringAppenders.appendSeparatorAndLastIfPresent(base, separator, varargs);
	}

	public <T> String appendIfPresent(String base, T... varargs) {
		return ArgonStringAppenders.appendIfPresent(base, varargs);
	}

	public <T> String appendWithSeparatorsIfPresent(String base,
			String separator, T... varargs) {
		return ArgonStringAppenders.appendWithSeparatorsIfPresent(base, separator, varargs);
	}
}
