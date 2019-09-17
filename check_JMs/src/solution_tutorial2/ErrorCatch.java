package solution_tutorial2;

import java.util.ArrayList;

public class ErrorCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "P";
		
		ArrayList<Integer> number = new ArrayList<Integer>();
		ArrayList<String> oper = new ArrayList<String>();
		
		int n = input.charAt(0) - 65;
		
		String prev = "";
		String next = "";
		
		try 
		{
			number.add(Integer.parseInt(""));
		}		
		catch (Exception e) 
		{
			System.out.println("Error");
		}
		
	}

}
