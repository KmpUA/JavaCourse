package org.lab0;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Currency;
import java.util.Locale;

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

	@Test
	public void testInputOutputTask() {
	}

	@Test(dataProvider = "integerProvider")
	public void testIntegerNumbersTask(int k, int l) {
		assertEquals(new Variant17().integerNumbersTask(k), l);
	}

	@Test(expectedExceptions = AssertionError.class)
	public void testIllegalIntTask(){
		new Variant17().integerNumbersTask(999);
	}

	@Test(dataProvider = "booleanProvider")
	public void testBooleanTask(int number1, boolean result) {
		assertEquals(new Variant17().booleanTask(number1), result);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testIllegalBooleanTask(){
		new Variant17().booleanTask(-1);
	}

	@Test(dataProvider = "ifProvider")
	public void testIfTask(double a, double b, double c, double[] result) {
		assertEquals(new Variant17().ifTask(a, b, c), result);
	}


	@Test(dataProvider = "switchProvider")
	public void testSwitchTask(int number1, String result) {
		assertEquals(new Variant17().switchTask(number1), result);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void illegalNumSwitchTest(){
		new Variant17().switchTask(9);
	}

	@Test
	public void testForTask() {
	}

	@Test
	public void testWhileTask() {
	}

	@Test
	public void testArrayTask() {
	}

	@Test
	public void testTwoDimensionArrayTask() {
	}
}