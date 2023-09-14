package org.lab0;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Variant17Test {

	@DataProvider
	public static Object[][] integerProvider() {
		return new Object[][]{
				{1000, 0},
				{1001, 0},
				{12345, 3}};
	}

	@DataProvider
	public static Object[][] booleanProvider() {
		return new Object[][]{
				{101, true},
				{99, false},
				{102, false}
		};
	}

	@DataProvider
	public static Object[][] ifProvider() {
		return new Object[][]{
				{1, 2, 3, new double[]{2, 4, 6}},
				{1, 3, 2, new double[]{-1, -3, -2}},
				{1983, 12, -1230, new double[]{3966, 24, -2460}}
		};
	}

	@DataProvider
	public static Object[][] switchProvider() {
		return new Object[][]{
				{21, "Двадцять одне учбове завдання"},
				{15, "П'ятнадцять учбових завдань"},
				{39, "Тридцять дев'ять учбових завдань"}
		};
	}

	@DataProvider
	public static Object[][] forProvider() {
		return new Object[][]{
				{10, 4, 1111},
				{5, 12, 61035156},
				{2, 5, 31}
		};
	}

	@DataProvider
	public static Object[][] whileProvider() {
		return new Object[][]{
				{1234, new ArrayList<>(Arrays.asList(4, 3, 2, 1))},
				{901, new ArrayList<>(Arrays.asList(1, 0, 9))},
				{92781034, new ArrayList<>(Arrays.asList(4, 3, 0, 1, 8, 7, 2, 9))}
		};
	}

	@DataProvider
	public static Object[][] arrayProvider() {
		return new Object[][]{
				{new double[]{1, 2, 3, 4, 5}, 5, new ArrayList<>(Arrays.asList(1d, 2d, 5d, 4d, 3d, 4d, 3d, 2d))},
				{new double[]{9, 0, -1, 12}, 4, new ArrayList<>(Arrays.asList(9d, 0d, 12d, -1d))},
				{new double[]{1234, -567, 12}, 3, new ArrayList<>(Arrays.asList(1234d, -567d, 12d, -567d))}
		};
	}

	@DataProvider
	public static Object[][] matrixProvider() {
		return new Object[][]{
				{new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 3, 3, 2, new ArrayList<>(Arrays.asList(15, 120))},
				{new int[][]{{1, 2, 3, 4}, {-4, -5, -6, -0}, {-12, 32, 41, 0}, {9, 8, 7, 6}}, 4, 4, 3, new ArrayList<>(Arrays.asList(61, 0))}
		};
	}

	@Test(expectedExceptions = AssertionError.class)
	public void testIllegalIntTask(){
		new Variant17().integerNumbersTask(999);
	}

	@Test(dataProvider = "integerProvider")
	public void testIntegerNumbersTask(int k, int l) {
		assertEquals(new Variant17().integerNumbersTask(k), l);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testIllegalBooleanTask(){
		new Variant17().booleanTask(-1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void illegalNumSwitchTest(){
		new Variant17().switchTask(9);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testIllegalForTask(){
		new Variant17().forTask(5, 0);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testIllegalWhileTask(){
		new Variant17().whileTask(0);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testIllegalArrayTask(){
		new Variant17().arrayTask(new double[]{1, 2, 3, 4, 5}, -1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testIllegalMatrixTask(){
		new Variant17().twoDimensionArrayTask(new int[][]{}, 0, 5, -1);
	}

	@Test(dataProvider = "booleanProvider")
	public void testBooleanTask(int number1, boolean result) {
		assertEquals(new Variant17().booleanTask(number1), result);
	}



	@Test(dataProvider = "ifProvider")
	public void testIfTask(double a, double b, double c, double[] result) {
		assertEquals(new Variant17().ifTask(a, b, c), result);
	}


	@Test(dataProvider = "switchProvider")
	public void testSwitchTask(int number1, String result) {
		assertEquals(new Variant17().switchTask(number1), result);
	}



	@Test(dataProvider = "forProvider")
	public void testForTask(int A, int n, int result) {
		assertEquals(new Variant17().forTask(A, n), result);
	}



	@Test(dataProvider = "whileProvider")
	public void testWhileTask(int N, List<Integer> result) {
		assertEquals(new Variant17().whileTask(N), result);
	}



	@Test(dataProvider = "arrayProvider")
	public void testArrayTask(double[] A, int N, List<Double> result) {
		assertEquals(new Variant17().arrayTask(A, N), result);
	}



	@Test(dataProvider = "matrixProvider")
	public void testTwoDimensionArrayTask(int[][] array, int M, int N, int K, List<Integer> result) {
		assertEquals(new Variant17().twoDimensionArrayTask(array, M, N, K), result);
	}
}
