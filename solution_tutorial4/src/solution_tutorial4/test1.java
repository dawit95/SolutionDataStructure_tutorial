package solution_tutorial4;

import java.util.Scanner;
import java.util.regex.Pattern;

public class test1 {

	public static void main(String[] args) {
		String a = "^[abcde]*$";
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		boolean bool = Pattern.matches(a, str);

		System.out.println(bool);
		in.close();
	}

}
