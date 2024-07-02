package com.easy.gfg.problems.string;

import java.util.ArrayList;
import java.util.List;

//problem statement
/**
 * Given a string str, find the length of the longest substring without repeating characters. 
 * @author chouh
 *
 */
public class LongestSubstring {

	public static void main(String[] args) {
		String str = "qwertyuioplkjh";

		findLongestSubstringWithoutRepeatingChar(str);

	}

	private static void findLongestSubstringWithoutRepeatingChar(String str) {
		// convert string to character array to iterate over each char
		char[] charArray = str.toCharArray();

		// list to check for each iteration that current char is already present or not
		List<Character> set = new ArrayList<Character>();

		// to return the length of max substring
		int subStringLengh = 0;
		for (int i = 0; i < charArray.length - 1; i++) {
			// ad ith element at 0th position for each new substring
			set.add(charArray[i]);
			for (int k = i + 1; k < charArray.length; k++) {
				// if element does not present in list then add it to list else break
				if (!set.contains(charArray[k])) {
					set.add(charArray[k]);
				} else {
					break;
				}
			}
			//check the length for each substring
			if (subStringLengh < set.size()) {
				subStringLengh = set.size();
			}
			//clear list after each substring creation;
			set.clear();
		}

		//print the maximum length of substring without repeating char
		System.out.println(subStringLengh);

	}

}
