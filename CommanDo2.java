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
		System.out.println("Source available at https://github.com/ShravanJ/CommanDo-2");
		String input = "";
		/*The following loop controls the command line interface. Setting the boolean value it validates to false will break the loop and thus exit the program*/
		while(validInput)
		{
			System.out.print(">");
			if(scan.hasNext())
			{
				input = scan.nextLine();
				inputHandler(input);
			}
		}

	}

	/**The inputHandler method checks the input from System.in and calls the function that it correlates to
	*@param input the input from System.in
	*/
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

	/**The exit command quits the CommanDo 2 interface by breaking the loop it runs in*/
	public static void exit()
	{
		validInput = false;
		
	}

	/**The print function allows the user to print a string by typing in a desired string and calling println(). It currently does not support any other System.out functions such as printf()
	*@param input the input from System.in
	*/
	public static void printFunction(String input)
	{
		String output = input;
		String regex = "\\s*\\bprint\\b\\s*"; /*using some regex (regular experssion) magic to clean up the output because the input would be print hi and the output would be print hi, but this regex string will remove it*/
		/*This if-else statement was added because "print" gets stripped out from the input so print print becomes a blank string. To fix this we validate where "print" is located and decide if we
		 *need to add it back or not.
		 */
		if(output.indexOf(" print") > 0)
		{
			output = output.replaceAll(regex, ""); /*replaces print with a blank string*/
			output += "print"; /*adds it back in because it was not at the first index*/
		}
		else
		{
			output = output.replaceAll(regex, ""); /*replaces print and will proceed to printing the string*/
		}
		System.out.println(output);
	}

	/**The clear function clears the screen by using a for-loop to println()
	*/
	public static void clear()
	{
		for(int x = 0; x < 30; x++)
		{
			System.out.println();
		}
		System.out.println("CommanDo2 -  a command line interpreter fo Java, reborn.");
		System.out.println("Source available at https://github.com/ShravanJ/CommanDo-2");
	}

	/**The loopCount function allows you to see the output using a while loop to perform an increment or decrement operation based on different operators comparing integers
	*The method is structured like so
	* -loopCount()
	*  	-get starting integer, operator, and arguement integer
	*  	-using input from System.in, decide which method to call
	*		-method call correlating to each operator
	*	 		-runs the loop and prints the results
	*/
	public static void loopCount()
	{
		Scanner scan = new Scanner(System.in); /*Re-instanstiates a Scanner because we cannot call it from the main method since this is a static method*/
		System.out.print("Define starting value (integer): "); 
		int startInt = scan.nextInt(); /*Grab the starting value*/
		System.out.print("Define operator (>, <, =, >=, <=): ");
		String input = scan.next(); /*Grab the operator*/
		System.out.print("Define arguement (integer): ");
		int argInt = scan.nextInt(); /*Grab the value that we are going to compare it against*/
		/*The if statements act as a switch to call the appropriate method */
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

	/*Runs a while loop when comparing startInt > argInt*/
	public static void loopOperatorGreaterThan(int startInt, int argInt)
	{
		while(startInt > argInt)
		{
			argInt++;
			System.out.println(argInt - 1);
		}
	}

	/*Runs a while loop when comparting startInt < argint*/
	public static void loopOperatorLessThan(int startInt, int argInt)
	{
		while(startInt < argInt)
		{
			argInt--;
			System.out.println(argInt - 1);
		}
	}

	/*This is an infinite loop. Not really sure why this is even here*/
	public static void loopOperatorEqualTo(int startInt, int argInt)
	{
		while(startInt == argInt)
		{
			argInt++;
			System.out.println(argInt);
		}
	}

	/*Runs a while loop when comparing startInt >= argInt*/
	public static void loopOperatorGreaterThanEqualTo(int startInt, int argInt)
	{
		while(startInt >= argInt)
		{
			argInt++;
			System.out.println(argInt - 1);
		}
	}

	/*Runs a while loop when comparing startInt <= argInt*/
	public static void loopOperatorLessThanEqualTo(int startInt, int argInt)
	{
		while(startInt <= argInt)
		{
			argInt++;
			System.out.println(argInt - 1);
		}
	}

	/*The commandList function displays the available commands.*/
	public static void commandlist()
	{
		System.out.println("Current list of commands");
		System.out.println("Check the source on GitHub for new commands");
		System.out.println("print - prints using System.out.println()");
		System.out.println("clear - clears the screen");
		System.out.println("loopcount++ - prints output from a looped count++ scenario");
		System.out.println("exit - exits the program");
		System.out.println("commandlist - displays the list of available commands");

	}

}
