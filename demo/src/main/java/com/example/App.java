package com.example;

/**
 * Hello world!
 *
 */
public class App {

	public static boolean evenOddNumber(int n) {
		if (n % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean numberInInterval(int n) {
		if (n > 24 && n < 101)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");

		// int task01 = 2;
		// boolean task01Result = evenOddNumber(task01);

		// int task02 = 99;
		// boolean task02Result = numberInInterval(task02);
	}
}
