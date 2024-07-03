package com.in28minutes.unit.testing.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringHelperTest {

	StringHelper helper = new StringHelper();

	@Test
	void testReplaceAInFirst2Positions() {
		
		//Length equal or less than 2
		assertEquals("", helper.replaceAInFirst2Positions(""));
		assertEquals("", helper.replaceAInFirst2Positions("A"));
		assertEquals("", helper.replaceAInFirst2Positions("AA"));
		
		//Letter 'A' on different positions
		assertEquals("BCD", helper.replaceAInFirst2Positions("AABCD"));
		assertEquals("BCD", helper.replaceAInFirst2Positions("ABCD"));
		assertEquals("BCD", helper.replaceAInFirst2Positions("BACD"));
		assertEquals("BCD", helper.replaceAInFirst2Positions("BCD"));
		
		//Text valid
		assertEquals("BCAD", helper.replaceAInFirst2Positions("BCAD"));
		assertEquals("BCDA", helper.replaceAInFirst2Positions("BCDA"));
		
		//Validation of exception when it's Null		
		Exception exception = assertThrows(NullPointerException.class, () -> helper.replaceAInFirst2Positions(null));
	    assertTrue(exception.getMessage().contains("Cannot invoke \"String.length()\" because \"str\" is null"));

	}
	
	@Test
	void testAreFirstTwoAndLastTwoCharsTheSame() {
		//Length less than 2
		assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame(""));
		assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame("A"));
		
		//Letter 'A' on different positions
		assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame("ABA"));
		assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame("ABBA"));
		assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame("ABAC"));
		assertFalse(helper.areFirstTwoAndLastTwoCharsTheSame("ABCBA"));
		
		//Text valid
		assertTrue(helper.areFirstTwoAndLastTwoCharsTheSame("AA"));
		assertTrue(helper.areFirstTwoAndLastTwoCharsTheSame("AAA"));
		assertTrue(helper.areFirstTwoAndLastTwoCharsTheSame("ABAB"));
		assertTrue(helper.areFirstTwoAndLastTwoCharsTheSame("ABCAB"));
		
		//Validation of exception when it's Null		
		Exception exception = assertThrows(NullPointerException.class, () -> helper.areFirstTwoAndLastTwoCharsTheSame(null));
	    assertTrue(exception.getMessage().contains("Cannot invoke \"String.length()\" because \"str\" is null"));

	}
}