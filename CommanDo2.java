/**CommanDo 2 -  a command line interpreter for Java, reborn
*@author Shravan Jambukesan
*Copyright 2015 Shravan Jambukesan
*/

import java.util.Scanner;

public class CommanDo2{

	public static boolean validInput = true;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("CommanDo 2 -  a command line interpreter for Java, reborn.");
		System.out.println("Source available at https://github.com/ShravanJ/CommanDo2");
		String input = "";

		while(validInput)
		{
			System.out.print(">");
			if(scan.hasNext())
			{
				input = scan.nextLine();
				inputHandler(input);
			}
			else
			{
				System.out.print(">");
			}

		}

	}

	public static void inputHandler(String input)
	{
		if(input.indexOf("exit") == 0)
		{
			exit();
		}
		if(input.indexOf("print") == 0)
		{
			printFunction(input);
		}
		if(input.indexOf("clear") == 0)
		{
			clear();
		}
		if(input.indexOf("loopcount++") == 0)
		{
			loopCount();
		}
		if(input.indexOf("commandlist") == 0)
		{
			commandlist();
		}

	}

	public static void exit()
	{
		validInput = false;
		
	}

	public static void printFunction(String input)
	{
		String output = input;
		String regex = "\\s*\\bprint\\b\\s*";
		if(output.indexOf(" print") > 0)
		{
			output = output.replaceAll(regex, " ");
			output += "print";
		}
		else
		{
			output = output.replaceAll(regex, " ");
		}
		System.out.println(output);
	}

	public static void clear()
	{
		for(int x = 0; x < 30; x++)
		{
			System.out.println();
		}
		System.out.println("CommanDo2 -  a command line interpreter fo Java, reborn.");
		System.out.println("Source available at https://github.com/ShravanJ/CommanDo2");
	}

	public static void loopCount()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Define starting value (integer): ");
		int startInt = scan.nextInt();
		System.out.print("Define operator (>, <, =, >=, <=): ");
		String input = scan.next();
		System.out.print("Define arguement (integer): ");
		int argInt = scan.nextInt();
		if(input.indexOf(">") == 0)
		{
			loopOperatorGreaterThan(startInt, argInt);
		}
		if(input.indexOf("<") == 0)
		{
			loopOperatorLessThan(startInt, argInt);
		}
		if(input.indexOf("=") == 0)
		{
			loopOperatorEqualTo(startInt, argInt);
		}
		if(input.indexOf(">=") == 0)
		{
			loopOperatorGreaterThanEqualTo(startInt, argInt);
		}
		if(input.indexOf("<=") == 0)
		{
			loopOperatorLessThanEqualTo(startInt, argInt);
		}
	}

	public static void loopOperatorGreaterThan(int startInt, int argInt)
	{
		while(startInt > argInt)
		{
			argInt++;
			System.out.println(argInt - 1);
		}
	}

	public static void loopOperatorLessThan(int startInt, int argInt)
	{
		while(startInt < argInt)
		{
			argInt--;
			System.out.println(argInt - 1);
		}
	}

	public static void loopOperatorEqualTo(int startInt, int argInt)
	{
		while(startInt == argInt)
		{
			argInt++;
			System.out.println(argInt);
		}
	}

	public static void loopOperatorGreaterThanEqualTo(int startInt, int argInt)
	{
		while(startInt >= argInt)
		{
			argInt++;
			System.out.println(argInt - 1);
		}
	}

	public static void loopOperatorLessThanEqualTo(int startInt, int argInt)
	{
		while(startInt <= argInt)
		{
			argInt++;
			System.out.println(argInt - 1);
		}
	}

	public static void commandlist()
	{
		System.out.println("Current list of commands");
		System.out.println("Newer versions of Commando 2 may have more commands. Check the GitHub source for the latest version.");
		System.out.println("print - prints using System.out.println()");
		System.out.println("clear - clears the screen");
		System.out.println("loopcount++ - prints output from a looped count++ scenario");
		System.out.println("exit - exits the program");
		System.out.println("commandlist - displays the list of available commands");

	}

}