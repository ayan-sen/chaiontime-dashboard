package com.dashboard.util;

import java.util.Map;

import org.stringtemplate.v4.ST;

public class ExpressionEvaluator {
	
	private char START_DELIM;
	private char END_DELIM;
	
	public ExpressionEvaluator() {
		super();
		START_DELIM = '{';
		END_DELIM = '}';
	}

	public ExpressionEvaluator(char sTART_DELIM, char eND_DELIM) {
		super();
		START_DELIM = sTART_DELIM;
		END_DELIM = eND_DELIM;
	}
	
	public String evaluate(String expressionString, Map<String, Object> model) {
		ST template = new ST(expressionString, START_DELIM, END_DELIM);
		model.entrySet().forEach(m -> template.add(m.getKey(), m.getValue()));
		return template.render();
	}
}
