package com.easy.gfg.problems;

import java.util.Random;

//PROBLEM STATEMENT
/**
 * Given an array prices[] of length N, representing the prices of the stocks on different days, 
 * the task is to find the maximum profit possible by buying and selling the stocks on different days when 
 * at most one transaction is allowed.

   Note: Stock must be bought before being sold.
 * @author chouhan
 *
 */
public class BestTimeToBuyAndSellStocks {

	public static void main(String[] args) {
		int arr[] = generateArrayWithRandomeNo();
		maxProfit(arr);
	}

	private static int[] generateArrayWithRandomeNo() {
		// Size of the array
        int size = 10;
        
        // Create an array to hold the random numbers
        int[] randomNumbers = new int[size];
        
        // Create an instance of Random class
        Random random = new Random();
        
        // Fill the array with random numbers from 1 to 100
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = random.nextInt(100) + 1;
        }
        
        // Print the random numbers
        for (int num : randomNumbers) {
            System.out.print(num + " ");
        }
        return randomNumbers;
	}

	private static void maxProfit(int[] arr) {
		//assign 0th index no from array as min
		int min =arr[0];
		//assign 0th index no from array as max
		int max =arr[0];
		for(int stockPrice : arr) {
			if(stockPrice == min || stockPrice < min) {
				//once found min no from array reassign min to ith index no.
				min =stockPrice;
				//after finding min will reassign max as min to found the max no from array from ith index
				max = stockPrice;
			}else if(stockPrice > min && stockPrice > max) {
				max = stockPrice;
			}
		}
		int[] result = new int[] {min, max} ;
		if (result != null && result[0] < result[1]) {
            System.out.println("Numbers found: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No such pair found.");
        }
	}

}
