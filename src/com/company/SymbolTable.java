package com.company;

import com.company.domain.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SymbolTable {
	private ArrayList<String> table = new ArrayList<>();

	public ArrayList<String> getTable() {
		return table;
	}

	public void setTable(ArrayList<String> table) {
		this.table = table;
	}

	public int add(String token) {
		if (!table.contains(token))
			table.add(token);
		return table.indexOf(token);
	}

	public int add(String token, Pif pif) {
		ArrayList<Integer> valuesToIncrease = new ArrayList<>();
		if (table.isEmpty())
			table.add(token);
		else if (!table.contains(token)) {
			boolean added = false;
			for (int i = 0; i < table.size(); i++) {
				if (!added) {
					if (table.get(i).compareTo(token) >= 0) {
						table.add(i, token);
						added = true;
					} else if (i == table.size() - 1) {
						table.add(token);
						added = true;
						i++;
					}
				} else {
					valuesToIncrease.add(i - 1);
				}
			}
		}

		Collections.reverse(valuesToIncrease);
		valuesToIncrease.forEach(x -> pif.replaceValue(x, x + 1));

		return table.indexOf(token);
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("---SymbolTable---\n");
		int pos = 0;
		for (String x : table) {
			res.append(String.valueOf(pos)).append(" - ").append(x).append("\n");
			pos++;
		}
		return res.toString();
	}
}
