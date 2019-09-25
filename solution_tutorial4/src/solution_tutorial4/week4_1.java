package solution_tutorial4;

import java.util.Scanner;

public class week4_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] origin = new int[26];
		int result =0;
		String str1,str2;
		char[] arr;
		
		str1 = input.nextLine();
		str2 = input.nextLine();
		arr = new char[str1.length()];
		arr = str1.toCharArray();
		
		for(int i=0; i<str1.length();i++){
			origin[arr[i]-'a']++;
		}
		
		arr = new char[str2.length()];
		arr = str2.toCharArray();
		for(int i=0; i<str2.length();i++){
			origin[arr[i]-'a']--;
		}
		
		for(int i=0; i<origin.length;i++){
			result += Math.abs(origin[i]);
		}
		
		System.out.println(result);
		input.close();

	}

}
