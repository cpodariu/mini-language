package com.company;

import com.company.domain.Pair;
import com.company.rules.Rules;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LanguageParser {
	static Pair<Pif, SymbolTable> parseFile(final String filename) throws FileNotFoundException {
		Pif pif = new Pif();
		SymbolTable symbolTable = new SymbolTable();

		File file = new File(filename);

		Scanner sc = new Scanner(file);

		while (sc.hasNextLine()) {

			String line = sc.nextLine();

			while (line.length() > 0) {
				final String currentLine = line;
				if (line.length() >= 2 && Rules.isOperator(line.substring(0, 2))) {
					parseToken(line.substring(0, 2), pif, symbolTable);
					line = line.substring(2);
				} else if (Rules.isOperator(line.substring(0, 1)) || Rules.isSeparator(line.substring(0, 1))) {
					parseToken(line.substring(0, 1), pif, symbolTable);
					line = line.substring(1);
				} else if (Rules.getKeywords().stream().anyMatch(currentLine::startsWith)) {
					String token = Rules.getKeywords().stream().filter(currentLine::startsWith).findFirst().get();
					parseToken(token, pif, symbolTable);
					line = line.substring(token.length());
				} else {
					int lowestIndex = Stream.concat(Rules.getOperatorss().stream(), Rules.getSeparators().stream())
							.mapToInt(it -> currentLine.contains(it) ? currentLine.indexOf(it) : currentLine.length())
							.min().getAsInt();
					parseToken(line.substring(0, lowestIndex), pif, symbolTable);
					line = line.substring(lowestIndex);
				}
			}
		}
		return new Pair<Pif, SymbolTable>(pif, symbolTable);
	}

	static void parseToken(String token, Pif pif, SymbolTable symbolTable) {
		if (Rules.isOperator(token) || Rules.isSeparator(token) || Rules.isKeyWord(token)) {
			pif.add(Rules.getNumericalTranslation(token), -1);
		} else if (isConstant(token) || isIdentifier(token)) {
			int index = symbolTable.add(token, pif);
//			System.out.println(token);
			if (isConstant(token))
				pif.add(0, index);
			else if (isIdentifier(token))
				pif.add(1, index);
		}
	}

	static boolean isConstant(String token) {
		return token.matches(Rules.NUMBER_REGEX) || token.matches(Rules.CHAR_REGEX) || token.matches(Rules.STRING_REGEX);
	}

	static boolean isIdentifier(String token) {
		return token.matches(Rules.IDENTIFIER_REGEX);
	}
}
