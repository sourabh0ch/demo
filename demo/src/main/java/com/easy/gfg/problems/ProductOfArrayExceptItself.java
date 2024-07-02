package com.easy.gfg.problems.array;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

//PROBLEM STATEMENT
/**
 * Given an array arr[] of n integers, construct a Product Array prod[] (of the
 * same size) such that prod[i] is equal to the product of all the elements of
 * arr[] except arr[i].
 * 
 * @author chouhan
 */
public class ProductOfArrayExceptItself {

	public static void main(String[] args) {
		// approach 1 with hashmap
		productOfArrayItself((GenerateArrayWithRandomNo.generateArrayWithRandomeNo()));
		// approach 1 with iterating the array once from right to left and inner loop
		// left to right to get product of array
		productOfArrayItselfApproach2((GenerateArrayWithRandomNo.generateArrayWithRandomeNo()));

	}

	private static void productOfArrayItselfApproach2(int[] nums) {
		long prod = 1L;
		long[] output = new long[nums.length];
		if (nums.length == 1) {
			output[0] = 1L;
		} else {
			for (int i = 0; i < nums.length; i++) {
				for (int j = nums.length - 1; j >= 0; j--) {

					if (i != j) {
						// System.out.println(in
						prod = prod * Long.valueOf(nums[j]);
						output[i] = prod;
					}
				}
				prod = 1L;
			}
		}

		for (long num : output) {
			System.out.println(num + " ");
		}
	}

	private static void productOfArrayItself(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int i = 0;
		// put index and value in map as key and value pair
		for (int num : arr) {
			map.put(i, num);
			i++;
		}
		int l = 0;
		long result[] = new long[arr.length];
		for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
			// get the values from array except current index and multiply them to return
			// product
			Collection<Entry<Integer, Integer>> list = map.entrySet().stream()
					.filter(v -> !v.getKey().equals(mp.getKey())).collect(Collectors.toList());
			int k = 1;
			for (Entry<Integer, Integer> in : list) {
				k = k * in.getValue();
			}
			result[l] = Long.valueOf(k);
			l++;
		}
		// Print the output
		for (long num : result) {
			System.out.println(num + " ");
		}
	}

}
