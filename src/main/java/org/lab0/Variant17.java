package org.lab0;

import java.util.*;

public class Variant17 {
	/**
	 *
	 * @param k is an integer
	 * @return hundreds of number
	 */

	public int integerNumbersTask(int k) {
		assert k > 999;
		return k % 1000 / 100;
	}

	/**
	 *
	 * @param number1 given number
	 * @return true, if number is odd and it is bigger than 99
	 */
	public boolean booleanTask(int number1) {
		if(number1 < 0) {
			throw new IllegalArgumentException("Num is not correct");
		}
		return (number1 % 2 == 1) && (number1 > 99);
	}


	/**
	 *If a, b, c is a progression return them * on 2, else with - sign
	 * @param a, b, c are double numbers
	 * @return array of result
	 */
	public double[] ifTask(double a, double b, double c) {
		return (a > b && b > c || a < b && b < c) ? new double[]{2 * a, 2 * b, 2 * c}: new double[]{-a, -b, -c};
	}


	/**
	 *We have to return a correct pronunciation of nums from 10 to 40
	 * @param number1 is a given number
	 * @return text form of given number
	 */
	public String switchTask(int number1) {
		String result = "";
		if(number1 < 10 || number1 > 40) throw new IllegalArgumentException("Number is less than 10 or bigger than 40");
		if(number1 / 10 == 1){
			switch (number1) {
				case 10 -> result += "Десять ";
				case 11 -> result += "Одинадцять ";
				case 12 -> result += "Дванадцять ";
				case 13 -> result += "Тринадцять ";
				case 14 -> result += "Чотирнадцять ";
				case 15 -> result += "П'ятнадцять ";
				case 16 -> result += "Шістнадцять ";
				case 17 -> result += "Сімнадцять ";
				case 18 -> result += "Вісімнадцять ";
				case 19 -> result += "Дев'ятнадцять ";
			}
		}
		else{
			switch (number1 / 10){
				case 2 -> result += "Двадцять ";
				case 3 -> result += "Тридцять ";
				case 4 -> result += "Сорок ";
			}
			switch (number1 % 10) {
				case 1 -> result += "одне ";
				case 2 -> result += "два ";
				case 3 -> result += "три ";
				case 4 -> result += "чотири ";
				case 5 -> result += "п'ять ";
				case 6 -> result += "шість ";
				case 7 -> result += "сім ";
				case 8 -> result += "вісім ";
				case 9 -> result += "дев'ять ";
			}
		}
		switch (number1 % 10) {
			case 1 -> result += "учбове завдання";
			case 2, 3, 4 -> result += "учбових завдання";
			case 5, 6, 7, 8, 9 -> result += "учбових завдань";
		}
		return result;
	}


	/**
	 *We have to sum num A in pow of 0 to n
	 * @param A is integer number
	 * @param n is a given power
	 * @return final sum
	 */
	public double forTask(int A, int n) {
		if(n <= 0) throw new IllegalArgumentException("n <= 0");
		int result = 0;
		for(int i = 0; i < n; i++){
			result += (int) Math.pow(A, i);
		}
		return result;
	}

	/**
	 * Task is to return list of digits of given number in reverse
	 * @param N given number
	 * @return List of reversed digits of N
	 */
	public List<Integer> whileTask(int N) {
		if(N <= 0) throw new IllegalArgumentException("N <= 0");
		List<Integer> result = new ArrayList<>();
		while(N > 0){
			result.add(N % 10);
			N /= 10;
		}
		return result;
	}

	/**
	 * @exception IllegalArgumentException if size of array <= 0
	 * @param A array of N size with type of double
	 * @param N size of array
	 * @return List of elements of given array with this pattern: A1, A2, AN, AN-1, A3 ...
	 */

	public List<Double> arrayTask(double[] A, int N) {
		if(N <= 0) throw new IllegalArgumentException("N <= 0");
		List<Double> result = new ArrayList<>();
		int L = 0;
		int R = N - 1;
		while(L <= R){
			result.addAll(new ArrayList<>(Arrays.asList(A[L], A[L + 1], A[R], A[R - 1])));
			L += 2;
			R -= 2;
		}
		return result;
	}

	/**
	 * @exception IllegalArgumentException if K is not 0 < K < M
	 * @param array given matrix
	 * @param M count of rows
	 * @param N count of columns
	 * @param K given parameter
	 * @return sum and product of K-row elements
	 */
	public List<Integer>  twoDimensionArrayTask(int[][] array, int M, int N, int K) {
		if(K >= M || K <= 0 || N <= 0) throw new IllegalArgumentException("K <= 0 OR K >= M");
		int sum = 0;
		int product = 1;
		for (var elem:array[K - 1]) {
			sum += elem;
			product *= elem;
		}
		return new ArrayList<>(Arrays.asList(sum, product));
	}

	public static void main(String... strings) {
		System.out.println("Start of zero lab");
		System.out.println("Done!!!");
		System.out.println(new Variant17().twoDimensionArrayTask(new int[][]{{1, 2, 3, 4}, {-4, -5, -6, -0}, {-12, 32, 41, 0}, {9, 8, 7, 6}}, 4, 4, 3));
	}
}
