package code;

import java.util.*;

public class driver {
	/**
	 * TODO 
	 * update printing the truth tables so they say whatever the output variable name was for the input function not just "F"
	 * NEXT
	 * k-maps functionality
	 */
	static String function="";
	static ArrayList<Character> inputVars=new ArrayList<Character>();
	static ArrayList<Integer> whereOnesAre = new ArrayList<Integer>();
	static boolean whichFuncType=false;//true if we are using SOP
	static int howManyInputVar = 0;
	
	public static void printTTOutput(Integer i) {
		if(whereOnesAre.contains(i)) {
			System.out.println(" " + 1 + " |");
		}
		else {
			System.out.println(" " + 0 + " |");
		}
	}//helper method for printing out function column of truth tables
	
	public static void truthTable(String func) {
		String stringToWorkWith = func;
		//see is function is POS or SOP
		String[] array1 = stringToWorkWith.split("=");
		String[] array2 = array1[1].split(" ");
		if(array2[0].equals("SOP")){
			whichFuncType = true;
		}
		else if(array2[0].equals("POS")){
			whichFuncType = false;
		}
		//need to find input variable names (inputVars)
		String funcLeftOfEquals = array1[0];
		ArrayList<Character> temp = new ArrayList<Character>();
		for(int i=2;i<funcLeftOfEquals.length();i++) {
			temp.add(funcLeftOfEquals.charAt(i));
		}
		for(int j=0;j<temp.size();j++) {
			if(temp.get(j).equals('F')||temp.get(j).equals(',')||temp.get(j).equals('(')||temp.get(j).equals(')')) {
				temp.remove(j);
			}
		}
		for(Character c:temp) {
			inputVars.add(c);
		}
		//need to find which values have 1s	
		String ones = array2[2];
		char[] onesAsArray = ones.toCharArray();
		ArrayList<Character> tempChars = new ArrayList<Character>();
		for(int j=0;j<onesAsArray.length;j++) {
			tempChars.add(onesAsArray[j]);
		}
		for(int z=0;z<tempChars.size();z++) {
			if(tempChars.get(z)=='('||tempChars.get(z)==')'){
				tempChars.remove(z);
			}
		}
		String concat = "";
		
		System.out.println(concat);
		
		for(int w=0;w<tempChars.size();w++) {
			concat = concat + tempChars.get(w);
		}
		String[] correctStrings = concat.split(",");
		for(int x=0;x<correctStrings.length;x++) {
			whereOnesAre.add(Integer.parseInt(correctStrings[x]));
		}
		//how many input variables do we have 
		howManyInputVar = inputVars.size();
		//printing the truth tables 
		if(howManyInputVar==3) {
			//what to print if there are 3 input variables
				System.out.println("| " + inputVars.get(0) + " | " + inputVars.get(1) + " | " + inputVars.get(2) + " | F |");
				System.out.print("| 0 | 0 | 0 |");
				printTTOutput(0);
				System.out.print("| 0 | 0 | 1 |");
				printTTOutput(1);
				System.out.print("| 0 | 1 | 0 |");
				printTTOutput(2);
				System.out.print("| 0 | 1 | 1 |");
				printTTOutput(3);
				System.out.print("| 1 | 0 | 0 |");
				printTTOutput(4);
				System.out.print("| 1 | 0 | 1 |");
				printTTOutput(5);
				System.out.print("| 1 | 1 | 0 |");
				printTTOutput(6);
				System.out.print("| 1 | 1 | 1 |");
				printTTOutput(7);
		}
		else if(howManyInputVar==4) {
			//what to print if there are 4 input variables
			System.out.println("| " + inputVars.get(0) + " | " + inputVars.get(1) + " | " + inputVars.get(2) + " | " + inputVars.get(3) + " | F |");
			System.out.print("| 0 | 0 | 0 | 0 |");
			printTTOutput(0);
			System.out.print("| 0 | 0 | 0 | 1 |");
			printTTOutput(1);
			System.out.print("| 0 | 0 | 1 | 0 |");
			printTTOutput(2);
			System.out.print("| 0 | 0 | 1 | 1 |");
			printTTOutput(3);
			System.out.print("| 0 | 1 | 0 | 0 |");
			printTTOutput(4);
			System.out.print("| 0 | 1 | 0 | 1 |");
			printTTOutput(5);
			System.out.print("| 0 | 1 | 1 | 0 |");
			printTTOutput(6);
			System.out.print("| 0 | 1 | 1 | 1 |");
			printTTOutput(7);
			System.out.print("| 1 | 0 | 0 | 0 |");
			printTTOutput(8);
			System.out.print("| 1 | 0 | 0 | 1 |");
			printTTOutput(9);
			System.out.print("| 1 | 0 | 1 | 0 |");
			printTTOutput(10);
			System.out.print("| 1 | 0 | 1 | 1 |");
			printTTOutput(11);
			System.out.print("| 1 | 1 | 0 | 0 |");
			printTTOutput(12);
			System.out.print("| 1 | 1 | 0 | 1 |");
			printTTOutput(13);
			System.out.print("| 1 | 1 | 1 | 0 |");
			printTTOutput(14);
			System.out.print("| 1 | 1 | 1 | 1 |");
			printTTOutput(15);
		}
	}
	public static void canonicalFunction(String func) {
		//finding all possible canonical terms for 3 input functions 
		if(howManyInputVar==3) {
			ArrayList<String> possible3inputSOPCanTerms = new ArrayList<String>();
			possible3inputSOPCanTerms.add(inputVars.get(0) + "'" + inputVars.get(1) + "'" + inputVars.get(2) + "'");//000
			possible3inputSOPCanTerms.add(inputVars.get(0) + "'" + inputVars.get(1) + "'" + inputVars.get(2));//001
			possible3inputSOPCanTerms.add(inputVars.get(0) + "'" + inputVars.get(1) + "" + inputVars.get(2) + "'");//010
			possible3inputSOPCanTerms.add(inputVars.get(0) + "'" + inputVars.get(1) + "" + inputVars.get(2));//011
			possible3inputSOPCanTerms.add(inputVars.get(0) + "" + inputVars.get(1) + "'" + inputVars.get(2) + "'");//100
			possible3inputSOPCanTerms.add(inputVars.get(0) + "" + inputVars.get(1) + "'" + inputVars.get(2));//101
			possible3inputSOPCanTerms.add(inputVars.get(0) + "" + inputVars.get(1) + "" + inputVars.get(2) + "'");//110
			possible3inputSOPCanTerms.add(inputVars.get(0) + "" + inputVars.get(1) + "" + inputVars.get(2) + "");//111
			ArrayList<String> possible3inputPOSCanTerms = new ArrayList<String>();
			possible3inputPOSCanTerms.add(inputVars.get(0) + "+" + inputVars.get(1) + "+" + inputVars.get(2));//000
			possible3inputPOSCanTerms.add(inputVars.get(0) + "+" + inputVars.get(1) + "+" + inputVars.get(2) + "'");//001
			possible3inputPOSCanTerms.add(inputVars.get(0) + "+" + inputVars.get(1) + "'" + "+" + inputVars.get(2));//010
			possible3inputPOSCanTerms.add(inputVars.get(0) + "+" + inputVars.get(1) + "'" + "+" + inputVars.get(2) + "'");//011
			possible3inputPOSCanTerms.add(inputVars.get(0) + "'" + "+" + inputVars.get(1) + "+" + inputVars.get(2));//100
			possible3inputPOSCanTerms.add(inputVars.get(0) + "'" + "+" + inputVars.get(1) + "+" + inputVars.get(2) + "'");//101
			possible3inputPOSCanTerms.add(inputVars.get(0) + "'" + "+" + inputVars.get(1) + "'" + "+" + inputVars.get(2));//110
			possible3inputPOSCanTerms.add(inputVars.get(0) + "'" + "+" + inputVars.get(1) + "'" + "+" + inputVars.get(2) + "'");//111
			
			if(whichFuncType) {
				boolean firstPrint=true;
				for(int range=0;range<8;range++) {
					if(whereOnesAre.contains(range)) {
						if(firstPrint) {
							System.out.print(possible3inputSOPCanTerms.get(range));
							firstPrint=false;
						}
						else {
							System.out.print(" + " + possible3inputSOPCanTerms.get(range));
						}
					}
				}
			}
			else {
				boolean firstPrint=true;
				for(int range=0;range<8;range++) {
					if(whereOnesAre.contains(range)) {
						if(firstPrint) {
							System.out.print(possible3inputPOSCanTerms.get(range));
							firstPrint=false;
						}
						else {
							System.out.print(" * " + possible3inputPOSCanTerms.get(range));
						}
					}
				}
			}
		}
		
		else if(howManyInputVar==4) {
			//find all possible canonical terms for 4 input functions
			ArrayList<String> poss4InputSOPTerms = new ArrayList<String>();
			poss4InputSOPTerms.add(inputVars.get(0) + "'" + inputVars.get(1) + "'" + inputVars.get(2) + "'" + inputVars.get(3) + "'");//0000
			poss4InputSOPTerms.add(inputVars.get(0) + "'" + inputVars.get(1) + "'" + inputVars.get(2) + "'" + inputVars.get(3));//0001
			poss4InputSOPTerms.add(inputVars.get(0) + "'" + inputVars.get(1) + "'" + inputVars.get(2) + "" + inputVars.get(3) + "'");//0010
			poss4InputSOPTerms.add(inputVars.get(0) + "'" + inputVars.get(1) + "'" + inputVars.get(2) + "" + inputVars.get(3));//0011
			poss4InputSOPTerms.add(inputVars.get(0) + "'" + inputVars.get(1) + "" + inputVars.get(2) + "'" + inputVars.get(3) + "'");//0100
			poss4InputSOPTerms.add(inputVars.get(0) + "'" + inputVars.get(1) + "" + inputVars.get(2) + "'" + inputVars.get(3));//0101
			poss4InputSOPTerms.add(inputVars.get(0) + "'" + inputVars.get(1) + "" + inputVars.get(2) + "" + inputVars.get(3) + "'");//0110
			poss4InputSOPTerms.add(inputVars.get(0) + "'" + inputVars.get(1) + "" + inputVars.get(2) + "" + inputVars.get(3));//0111
			poss4InputSOPTerms.add(inputVars.get(0) + "" + inputVars.get(1) + "'" + inputVars.get(2) + "'" + inputVars.get(3) + "'");//1000
			poss4InputSOPTerms.add(inputVars.get(0) + "" + inputVars.get(1) + "'" + inputVars.get(2) + "'" + inputVars.get(3));//1001
			poss4InputSOPTerms.add(inputVars.get(0) + "" + inputVars.get(1) + "'" + inputVars.get(2) + "" + inputVars.get(3) + "'");//1010
			poss4InputSOPTerms.add(inputVars.get(0) + "" + inputVars.get(1) + "'" + inputVars.get(2) + "" + inputVars.get(3));//1011
			poss4InputSOPTerms.add(inputVars.get(0) + "" + inputVars.get(1) + "" + inputVars.get(2) + "'" + inputVars.get(3) + "'");//1100
			poss4InputSOPTerms.add(inputVars.get(0) + "" + inputVars.get(1) + "" + inputVars.get(2) + "'" + inputVars.get(3));//1101
			poss4InputSOPTerms.add(inputVars.get(0) + "" + inputVars.get(1) + "" + inputVars.get(2) + "" + inputVars.get(3) + "'");//1110
			poss4InputSOPTerms.add(inputVars.get(0) + "" + inputVars.get(1) + "" + inputVars.get(2) + "" + inputVars.get(3));//1111
			ArrayList<String> poss4InputPOSTerms = new ArrayList<String>();
			poss4InputPOSTerms.add(inputVars.get(0) + "+" + inputVars.get(1) + "+" + inputVars.get(2) + "+" + inputVars.get(3));//0000
			poss4InputPOSTerms.add(inputVars.get(0) + "+" + inputVars.get(1) + "+" + inputVars.get(2) + "+" + inputVars.get(3) + "'");//0001
			poss4InputPOSTerms.add(inputVars.get(0) + "+" + inputVars.get(1) + "+" + inputVars.get(2) + "'" + "+" + inputVars.get(3));//0010
			poss4InputPOSTerms.add(inputVars.get(0) + "+" + inputVars.get(1) + "+" + inputVars.get(2) + "'" + "+" + inputVars.get(3) + "'");//0011
			poss4InputPOSTerms.add(inputVars.get(0) + "+" + inputVars.get(1) + "'" + "+" + inputVars.get(2) + "+" + inputVars.get(3));//0100
			poss4InputPOSTerms.add(inputVars.get(0) + "+" + inputVars.get(1) + "'" + "+" + inputVars.get(2) + "+" + inputVars.get(3) + "'");//0101
			poss4InputPOSTerms.add(inputVars.get(0) + "+" + inputVars.get(1) + "'" + "+" + inputVars.get(2) + "'" + "+" + inputVars.get(3));//0110
			poss4InputPOSTerms.add(inputVars.get(0) + "+" + inputVars.get(1) + "'" + "+" + inputVars.get(2) + "'" + "+" + inputVars.get(3) + "'");//0111
			poss4InputPOSTerms.add(inputVars.get(0) + "'" + "+" + inputVars.get(1) + "+" + inputVars.get(2) + "+" + inputVars.get(3));//1000
			poss4InputPOSTerms.add(inputVars.get(0) + "'" + "+" + inputVars.get(1) + "+" + inputVars.get(2) + "+" + inputVars.get(3) + "'");//1001
			poss4InputPOSTerms.add(inputVars.get(0) + "'" + "+" + inputVars.get(1) + "+" + inputVars.get(2) + "'" + "+" + inputVars.get(3));//1010
			poss4InputPOSTerms.add(inputVars.get(0) + "'" + "+" + inputVars.get(1) + "+" + inputVars.get(2) + "'" + "+" + inputVars.get(3) + "'");//1011
			poss4InputPOSTerms.add(inputVars.get(0) + "'" + "+" + inputVars.get(1) + "'" + "+" + inputVars.get(2) + "+" + inputVars.get(3));//1100
			poss4InputPOSTerms.add(inputVars.get(0) + "'" + "+" + inputVars.get(1) + "'" + "+" + inputVars.get(2) + "+" + inputVars.get(3) + "'");//1101
			poss4InputPOSTerms.add(inputVars.get(0) + "'" + "+" + inputVars.get(1) + "'" + "+" + inputVars.get(2) + "'" + "+" + inputVars.get(3));//1110
			poss4InputPOSTerms.add(inputVars.get(0) + "'" + "+" + inputVars.get(1) + "'" + "+" + inputVars.get(2) + "'" + "+" + inputVars.get(3) + "'");//1111
			
			if(whichFuncType) {
				boolean firstPrint=true;
				for(int range=0;range<16;range++) {
					if(whereOnesAre.contains(range)) {
						if(firstPrint) {
							System.out.print(poss4InputSOPTerms.get(range));
							firstPrint=false;
						}
						else {
							System.out.print(" + " + poss4InputSOPTerms.get(range));
						}
					}
				}
			}
			else {
				boolean firstPrint=true;
				for(int range=0;range<16;range++) {
					if(whereOnesAre.contains(range)) {
						if(firstPrint) {
							System.out.print(poss4InputPOSTerms.get(range));
							firstPrint=false;
						}
						else {
							System.out.print(" * " + poss4InputPOSTerms.get(range));
						}
					}
				}
			}
		}
	}
	
	public static void kmap(String func) {
		if(howManyInputVar==3) {
		}
		else if(howManyInputVar==4) {
		}
	}
	
	public static void main(String[] args) {
		Scanner kbWelcome = new Scanner(System.in);
		System.out.println("This program can generate you a:");
		System.out.println("  1. Truth Table");
		System.out.println("  2. Canonical SOP or POS function");
		System.out.println("  3. K-map");
		System.out.println("  3. Simplified SOP or POS function");
		System.out.println("  4. Logic Diagram");
		System.out.println("based on an input function of 3 or 4 variables.");
		System.out.println("Do you wish to continue? (y) or (n)");
		String continueString = kbWelcome.nextLine();
		
		if(continueString.equals("y")) {
			Scanner kb = new Scanner(System.in);
			System.out.println("TRUTH TABLE");
			System.out.println("Please enter your function.");
			System.out.println("Function should be entered in the form:");
			System.out.println("F(A,B,C...)=SOP of (0,1,2,3,4,5,6...) for SOP (∑)");
			System.out.println("or");
			System.out.println("F(A,B,C...)=POS of (0,1,2,3,4,5,6...) for POS (∏)");
			String function = kb.nextLine();
			truthTable(function);
			System.out.println("CANONICAL FUNCTION");
			System.out.println("Would you like to see the canonical function? (y) or (n)");
			String canonicalOrNot = kb.nextLine();
			if(canonicalOrNot.equals("y")) {
				canonicalFunction(function);
				System.out.println();
				System.out.println();
				System.out.println("K-MAP");
				System.out.println("Would you like to see the k-map generated for your function? (y) or (n)");
				String kmapDecision=kb.nextLine();
				if(kmapDecision.equals("y")) {
					kmap(function);
					System.out.println("THIS FEATURE IS UNDER CONSTRUCTION");//temporary print out DELETE ONCE FUNCTIONALITY ADDED
				}
				else {
					System.out.println("Okay have a nice day.");
				}
			}
			else {
				System.out.println("Okay have a nice day.");
			}
		}
		else {
			System.out.println("Okay have a nice day.");
		}
	}
}
