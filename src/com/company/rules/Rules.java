package com.company.rules;

import com.company.SymbolTable;
import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class Rules {
	private static final List<String> SEPARATORS = List.of("(", ")", "[", "]", "{", "}", ":", ";", " ", "\n");
	private static final List<String> KEYWORDS = List.of("char", "else", "if", "int", "main", "read", "while", "write", "string",
			"float", "true", "false", "boolean", "not", "and", "or");
	private static final List<String> OPERATORS = List.of("+", "-", "*", "/", "==", "<", "<=", "=", ">=");

	public static final String NUMBER_REGEX = "([-]?[1-9][0-9]*)|[0]"; // matches any number
	public static final String IDENTIFIER_REGEX = "^[a-z][a-zA-Z0-9]{0,248}"; // sequence of characters of at most 250 characters starting with a small letter
	public static final String STRING_REGEX = "\"\\w*\"";
	public static final String CHAR_REGEX = "'\\w?\'";

	static final Map<String, Integer> CODES_MAP = ImmutableMap.<String, Integer>builder()
			.put("main", 2)
			.put("char", 3)
			.put("if", 4)
			.put("else", 5)
			.put("int", 6)
			.put("float", 7)
			.put("boolean", 8)
			.put("read", 9)
			.put("write", 10)
			.put("while", 11)
			.put("string", 12)
			.put("true", 13)
			.put("false", 14)
			.put("and", 15)
			.put("or", 16)
			.put(":", 17)
			.put(";", 18)
			.put(",", 19)
			.put(".", 20)
			.put("+", 21)
			.put("*", 22)
			.put("/", 23)
			.put("(", 24)
			.put(")", 25)
			.put("[", 26)
			.put("]", 27)
			.put("{", 28)
			.put("}", 29)
			.put("-", 30)
			.put("<", 31)
			.put(">", 32)
			.put("=", 33)
			.put("<=", 34)
			.put(">=", 35)
			.put(" ", 36)
			.build();

	public static int getNumericalTranslation(String s){
		return CODES_MAP.get(s);
	}

	public static List<String> getSeparators() {
		return SEPARATORS;
	}

	 public static boolean isSeparator(String sep) {
		return SEPARATORS.contains(sep);
	}

	public static List<String> getKeywords(){
		return KEYWORDS;
	}

	public static boolean isKeyWord(String key){
		return KEYWORDS.contains(key);
	}

	public static List<String> getOperatorss(){
		return OPERATORS;
	}

	public static boolean isOperator(String key){
		return OPERATORS.contains(key);
	}
}
