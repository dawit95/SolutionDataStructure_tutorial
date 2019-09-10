package solution_tutorial1;

import java.util.Scanner;

public class week1_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			String str = input.nextLine();
			
			if(str.charAt(1) == 'x')
				System.out.println(Integer.parseInt(str.substring(2),16));
			else {
				int dec = Integer.parseInt(str);
				String hs = Integer.toHexString(dec);
				System.out.println("0x" + hs.toUpperCase());
			}
		}

		input.close();
	}

}
