package com.in28minutes.unit.testing.lab;

public class StringHelper {

	public String replaceAInFirst2Positions(String str) {

		if (str.length() < 2)
			return str.replaceAll("A", "");

		String first2Characters = str.substring(0, 2);

		String first2CharactersUpdated = first2Characters.replaceAll("A", "");

		String restOfTheString = str.substring(2);

		return first2CharactersUpdated + restOfTheString;
	}

	public boolean areFirstTwoAndLastTwoCharsTheSame(String str) {

		int length = str.length();

		if (length < 2)
			return false;

		String first2Chars = str.substring(0, 2);
		String last2Chars = str.substring(length - 2);

		return first2Chars.equals(last2Chars);
	}

}