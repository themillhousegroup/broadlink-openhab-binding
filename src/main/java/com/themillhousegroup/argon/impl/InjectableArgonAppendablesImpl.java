package com.themillhousegroup.argon.impl;

import com.themillhousegroup.argon.ArgonAppendables;
import com.themillhousegroup.argon.InjectableArgonAppendables;

public class InjectableArgonAppendablesImpl implements InjectableArgonAppendables {

	public <T> Appendable appendFirstIfPresent(Appendable base, T... varargs) {
		return ArgonAppendables.appendFirstIfPresent(base, varargs);
	}

	public <T> Appendable appendSeparatorAndFirstIfPresent(Appendable base,
			String separator, T... varargs) {
		return ArgonAppendables.appendSeparatorAndFirstIfPresent(base, separator, varargs);
	}

	public <T> Appendable appendLastIfPresent(Appendable base, T... varargs) {
		return ArgonAppendables.appendLastIfPresent(base, varargs);
	}

	public <T> Appendable appendSeparatorAndLastIfPresent(Appendable base,
			String separator, T... varargs) {
		return ArgonAppendables.appendSeparatorAndLastIfPresent(base, separator, varargs);
	}

	public <T> Appendable appendIfPresent(Appendable base, T... varargs) {
		return ArgonAppendables.appendIfPresent(base, varargs);
	}

	public <T> Appendable appendWithSeparatorsIfPresent(Appendable base,
			String separator, T... varargs) {
		return ArgonAppendables.appendWithSeparatorsIfPresent(base, separator, varargs);
	}
}
