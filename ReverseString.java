//Michelle Sallard 
//Chpt2 PA 
import java.util.Scanner;

public class ReverseString {
   /* TODO: Write recursive reverseString() method here. */
   public static String reverseString(String input) {
	 if (input.length() >=1) { // will reverse string if array of input is bigger than 1
		 return reverseString(input.substring(1)) + input.charAt(0);   //recursive method; will take first letter in index 0 
																									//then will reverse string until last letter is reached 
   }
   else {
		 return input; //returns nothing  if user did not input string and does not reverse string 
		 
	 }
   }
   
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String input, result;
		
		System.out.print("Enter the string to be reversed: ");
		input = scnr.nextLine();
		
		result = reverseString(input);
		
		System.out.printf("Reversed: %s\n", result);
		}
	}

