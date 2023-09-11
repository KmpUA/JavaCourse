package org.lab0;

import java.lang.reflect.Array;
import java.util.Locale;

public class Variant17 {
	/**
	 *
	 * @param k is square side
	 * @return perimeter
	 */
	public int inputOutputTask(int k) {
		return 0;
	}

	/**
	 *
	 * @param k is distance in cm
	 * @return distance in m
	 */

	public int integerNumbersTask(int k) {
		assert k > 999;
		return k % 1000 / 100;
	}

	/**
	 *
	 * @param number1
	 * @return true, if number is possitive
	 */
	public boolean booleanTask(int number1) {
		if(number1 < 0) {
			throw new IllegalArgumentException("Num is not correct");
		}
		return (number1 % 2 == 1) && (number1 > 99);
	}


	/**
	 *
	 * @param a, b, c are integer number
	 * @return transformed number
	 */
	public double[] ifTask(double a, double b, double c) {
		return (a > b && b > c || a < b && b < c) ? new double[]{2 * a, 2 * b, 2 * c}: new double[]{-a, -b, -c};
	}


	/**
	 *
	 * @param number1
	 * @return day of week day represented number1
	 */
	public String switchTask(int number1) {
		String result = "";
		if(number1 < 10 || number1 > 40){
			throw  new IllegalArgumentException("Number is less than 10 or bigger than 40");
		}
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
	 *
	 * @param n is integer number
	 * @return approximated value of exp(1)
	 */
	public double forTask(int n) {
		assert n >0: "Argument should be more than zero";
		return 0;
	}


	public int whileTask(int a, int b) {
		assert (a >0 && b > 0): "Argument should be more than zero";
		return 0;
	}

	public double arrayTask(double[] array) {
		return 0;
	}

	/**
	 *
	 * @param array
	 * @param k1
	 * @param k2
	 * @return transformed array where row with indexes k1 and k2 was changed
	 */
	public int[][]  twoDimensionArrayTask(int[][] array, int k1, int k2) {
		//return null;
		return array;
	}

	public static void main(String... strings) {
		System.out.println("Start of zero lab");
		System.out.println("Done!!!");
		System.out.println(new Variant17().switchTask(15));
	}
}
