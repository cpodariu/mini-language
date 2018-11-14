package com.company;

import com.company.domain.Pair;

import java.util.ArrayList;

public class Pif extends ArrayList<Pair<Integer, Integer>> {

	public void add(Integer int1, Integer int2) {
		this.add(new Pair<Integer, Integer>(int1, int2));
	}

	public void replaceValue(Integer v1, Integer v2) {
		for (Pair<Integer, Integer> i : this) {
			if (i.getElement1().equals(v1))
				i.setElement1(v2);
		}
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("---Pif---\n");
		for (Pair<Integer, Integer> x : this) {
			res.append(x.getElement0().toString()).append(" - ").append(x.getElement1().toString()).append("\n");
		}
		return res.toString();
	}
}
