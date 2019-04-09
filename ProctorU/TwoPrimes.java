/*
 * Goldbach's conjecture : Every even integer greater than 2 can be expressed as the sum of two primes. 
 * Write a function which takes a number as input, verify if is an even number greater than 2 and also print at least 
 * one pair of prime numbers.
 */

import java.util.*;

public class TwoPrimes {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> rst = twoPrimes(100);
		System.out.println(rst);
	}
	
	public static List<String> twoPrimes(int num) {
		List<String> rst = new ArrayList<>();
		if (num <= 2 || num % 2 == 1)
			return rst;
		
		boolean[] isPrime = new boolean[num];
		Arrays.fill(isPrime, true);
		
		for (int i = 2; i * i < num; i++) {
			if (!isPrime[i])
				continue;
			for (int j = i * i; j < num; j += i) 
				isPrime[j] = false;
		}
		 
		for (int i = 3; i <= num / 2; i += 2) {
			if (isPrime[i] && isPrime[num - i]) {
				rst.add(i + " " + (num - i));
			}
		}
		return rst;
	}
}
