package com.company;

import com.company.domain.Pair;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
		Pair<Pif, SymbolTable> p =LanguageParser.parseFile("C:\\Users\\podar\\workspace\\LFTC\\mini-language\\src\\com\\company\\testfile1.txt");
		System.out.println(p.getElement0().toString());
		System.out.println(p.getElement1().toString());
    }
}
