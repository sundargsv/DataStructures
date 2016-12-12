package com.sundar.stack;

import java.util.Scanner;

public class BalancedParenthesis {

	public char findOpening(char closing){
		char open;
		switch (closing) {
		case '}':
			open = '{';
			break;
		case ']':
			open = '[';
			break;
		default:
			// Default - ')'
			open = '(';
			break;
		}
		return open;
	}
	public static void main(String[] args) {
		System.out.println("Balance Checker !!!");
		Scanner scan = new Scanner(System.in);
		BalancedParenthesis obj = new BalancedParenthesis();
		System.out.println("Enter the expression :");
		System.out.println("Valid expression should have only the following,"
				+ "1. Alphabets 2. Parenthesis - (), [], {} " );
		StringBuilder exp  = new StringBuilder(scan.nextLine()); 
		int size = exp.length(), i = 0;
		ArrayStackModel stack = new ArrayStackModel(size);
		System.out.println("Verify the given Expression : " +exp);
		System.out.println("Started checking");
		
		while(i<size){
			if(exp.charAt(i) == '(' || exp.charAt(i) == '[' || exp.charAt(i) == '{'){
				//Check for any opening
				stack.push(exp.charAt(i));
				
			}else if(exp.charAt(i) == ')' || exp.charAt(i) == ']' || exp.charAt(i) == '}'){
				/*check for any closing
				1 - check if top of the stack and chartAt(i) is equal
				2 - If yes - balanced, then pop that top element
				3 - else not balanced*/
				
				if(obj.findOpening(exp.charAt(i)) == stack.peek()){
					System.out.println("Found the match");
					stack.pop();
					stack.display();
				}else{
					System.out.println("Not balanced");
					return;
				}
				
			}else{
				//It might be an Alphabets
				//Do nothing
			}
			i++;
		}
		//End of LOOP
		
		if(stack.isEmpty())
			System.out.println("Expression is Balanced !!!");
		else
			System.out.println("Expression is not Balanced !!!");

		
	}

}
