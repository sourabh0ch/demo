package com.easy.gfg.problems;

import java.util.HashSet;


public class PairWithGivenSum {

	public static void main(String[] args) {
		int arr[] = { 0, -1, 2, -3, 1 };
		int x = -2;		
		int[] result = findTwoSum(arr, x);
        if (result != null) {
            System.out.println("Numbers found: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No such pair found.");
        }
	}
	
	public static int[] findTwoSum(int[] A, int x) {
        // Create a set to store the elements we have seen so far
        HashSet<Integer> seenNumbers = new HashSet<>();

        // Iterate through the array
        for (int number : A) {
            // Calculate the complement
            int complement = x - number;

            // Check if the complement exists in the set
            if (seenNumbers.contains(complement)) {
                return new int[]{complement, number};
            }

            // Add the current number to the set
            seenNumbers.add(number);
        }

        // If no pair is found, return null
        return null;
    }
}
