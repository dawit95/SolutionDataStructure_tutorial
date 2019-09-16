package solution_tutorial2;

import java.util.Scanner;

public class week2_2_3ver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String table = null;
		
		while (input.hasNext()) {
			int pocard = 0, triple = 0, tupair = 0, tomResult = 0,jerryResult=0;
			table = input.nextLine();
			int[] alp = new int[26];
			for (int i = 0; i < alp.length; i++)
				alp[i] = 0;
			
			for (int i = 0; i < 5; i++) {
				alp[-('A'-table.charAt(i))]++;
			}
			
			for (int i = alp.length - 1; i >= 0; i--) {
				if (alp[i] == 4 && pocard == 0) {
					pocard = (i + 1) * 10000;
				} else if (alp[i] == 3 && triple == 0) {
					triple = (i + 1) * 100;
				} else if (alp[i] == 2 && tupair == 0) {
					tupair = (i + 1);
				}
			}
			if(pocard>0)
				tomResult=pocard;
			else if (triple >0)
				tomResult=triple;
			else if(tupair>0)
				tomResult=tupair;

			pocard = 0;
			triple = 0;
			tupair = 0;
			
			for (int i = 0; i < alp.length; i++)
				alp[i] = 0;

			for (int i = 6; i < table.length(); i++) {
				alp[-('A'-table.charAt(i))]++;
			}
			
			for (int i = alp.length - 1; i >= 0; i--) {
				if (alp[i] == 4 && pocard == 0) {
					pocard = (i + 1) * 10000;
				} else if (alp[i] == 3 && triple == 0) {
					triple = (i + 1) * 100;
				} else if (alp[i] == 2 && tupair == 0) {
					tupair = (i + 1);
				}
			}

			if(pocard>0)
				jerryResult=pocard;
			else if (triple >0)
				jerryResult=triple;
			else if(tupair>0)
				jerryResult=tupair;

			if (tomResult > jerryResult)
				System.out.println("Tom");
			else if (tomResult == jerryResult)
				System.out.println("Draw");
			else
				System.out.println("Jerry");
		}
		input.close();

	}

}