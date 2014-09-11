package com.mihughes.examples.arraysize;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//Simple class for test what effect pre-sizing an array list have
public class Arraysize {
	
	private static final int TEST_SIZER = 100000;
	private static final char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','w','x','y','z'};
	
	private static List<String> test;
	private static Random random;

	public static void main(String[] args) {
		random = new Random();
		
		List<String> randomStrings = new ArrayList<>(TEST_SIZER);
		for (int i = 0; i < TEST_SIZER; i++) {
			randomStrings.add(generateRandomString());
		}
		
		//tests
		testArrayListFor(TEST_SIZER, false, randomStrings);
		testArrayListFor(TEST_SIZER, true, randomStrings);
		testLinkedListFor(TEST_SIZER, false, randomStrings);
		

	}
	
	
	private static void testArrayListFor(int itr, boolean initSize, List<String> randomStrings) {
		long startTime = System.nanoTime();
		for (int i = 0; i < itr; i++) {
			if (initSize) {
				test = new ArrayList<>(TEST_SIZER);
			} else {
				test = new ArrayList<>();
			}
			for (String string : randomStrings) {
				test.add(string);
			}
		}
		long stopTime = System.nanoTime();
		System.out.printf("Filling array list with size initialization set to %b took %d nanoseconds on average\n"
				, initSize, (stopTime - startTime) / (long)itr);
	}
	
	private static void testLinkedListFor(int itr, boolean initSize, List<String> randomStrings) {
		long startTime = System.nanoTime();
		
		for (int i = 0; i < itr; i++) {
			test = new LinkedList<>();
			for (String string : randomStrings) {
				test.add(string);
			}
		}
		long stopTime = System.nanoTime();
		System.out.printf("Filling linked list with size initialization set to %b took %d nanoseconds on average\n"
				, initSize, (stopTime - startTime) / (long)itr);
	}
	
	private static String generateRandomString() {
		int length = random.nextInt(10);
		int whichChar = random.nextInt(alphabet.length);
		String generatedString;
		if (length > 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < length; i++) {
				sb.append(alphabet[whichChar]);
			}
			
			generatedString = sb.toString();
		} else {
			generatedString = "";
		}
		
		return generatedString;
	}

}
