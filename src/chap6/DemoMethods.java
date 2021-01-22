package chap6;
/* Westley W Williams
*  CIS 2212-800 Java I FlexPace
*  Assignment 05 - CALCULATOR METHODS
*  Started January 21st, 2021
*/
import java.util.Scanner;

public class DemoMethods {

	public static void main(String[] args) {
		int userEntry;
		do {
			// let's call the getMenuOption method here in the main method.
			// getMenuOption will return an integer which we will store in a variable
			// (scoped to the main function).
			userEntry = getMenuOption();
				double num1, num2;
				
			switch (userEntry) {
			case 1:
				// let's get our operands
				num1 = getOperand("What is the first number?");
				num2 = getOperand("What is the second number?");
				double addedValue = add(num1, num2);
				System.out.println("Answer: " + addedValue);
				break;
			case 2:
				num1 = getOperand("What is the first number?");
				num2 = getOperand("What is the second number?");
				double subtractedValue = subtract(num1, num2);
				System.out.println("Answer: " + subtractedValue);
				break;
			case 3:
				num1 = getOperand("What is the first number?");
				num2 = getOperand("What is the second number?");
				double multipliedValue = multiply(num1, num2);
				System.out.println("Answer: " + multipliedValue);
				break;
			case 4:
				num1 = getOperand("What is the first number?");
				num2 = getOperand("What is the second number?");
				double dividedValue = divide(num1, num2);
				System.out.println("Answer: " + dividedValue);
				//per the assignment requirement, we will not give the
				//user another opportunity to enter a valid number.
				//I interpret this as we should exit the program
				//therefore, I set userEntry to 6 and the loop quits.
				if (dividedValue == Double.NaN) {
					userEntry = 6;
				}
				break;
			case 5:
				num1 = getOperand("What is the first number?");
				num2 = getOperand("What is the second number?");
				double randomValue = random(num1, num2);
				System.out.println("Answer: " + randomValue);
				break;
			case 6:
				System.out.println("Goodbye!");
			}
		} while (userEntry != 6);
	}

	public static int getMenuOption() {
		// I'm simply declaring and initializing the menu variable.
		// this will be printed but the variable is scoped only to this method
		String menu = "Menu" + "\n\t" + "1. Add" + "\n\t" + "2. Subtract" + "\n\t" + "3. Multiply" + "\n\t"
				+ "4. Divide" + "\n\t" + "5. Generate Random Number" + "\n\t" + "6. Quit";

		int userEntry = 0;

		// let's show the menu string here
		System.out.println(menu);
		// we will create a new scanner for input
		Scanner theScanner = new Scanner(System.in);
		// let's ask the user what operand they want to execute.
		System.out.println("What would you like to do?");
		// and let's read the user input here
		userEntry = theScanner.nextInt();

		while (userEntry > 6 || userEntry < 1) {
			System.out.println("I'm sorry, " + userEntry + " wasn't one of the options.");
			// let's show the menu string here
			System.out.println(menu);
			// we will create a new scanner for input
			Scanner newScanner = new Scanner(System.in);
			// let's ask the user what operator they want to execute.
			System.out.println("What would you like to do?");
			// and let's read the user input here
			userEntry = newScanner.nextInt();
		}

		// and we will return the entry of the user
		return userEntry;
	}

	public static double getOperand(String prompt) {
		// ask the user what number they want.
		System.out.print(prompt);
		// create a new scanner for this method
		Scanner getOperandScanner = new Scanner(System.in);
		// user inputs the number they want to execute on
		double operandNumber = getOperandScanner.nextDouble();
		// return this number as a double to the main method.
		return operandNumber;
	}

	public static double add(double num1, double num2) {
		double addedValue = num1 + num2;
		return addedValue;
	}

	public static double subtract(double num1, double num2) {
		double subtractedValue = num2 - num1;
		return subtractedValue;
	}

	public static double multiply(double num1, double num2) {
		double multipliedValue = num1 * num2;
		return multipliedValue;
	}

	public static double divide(double num1, double num2) {
		// we assume num1 is the divisor, and we want to make sure it's not zero
		if (num1 == 0) {
			//I did rely on the following web page for a brief on Double.NaN.
			//https://www.baeldung.com/java-not-a-number
			double dividedValue = Double.NaN;
			return dividedValue;
		} else {
			double dividedValue = num2 / num1;
			return dividedValue;
		}
	}

	public static double random(double lowerLimit, double upperLimit) {
		double randomValue = lowerLimit + Math.random() * (upperLimit - lowerLimit);
		;
		return randomValue;
	}

}
