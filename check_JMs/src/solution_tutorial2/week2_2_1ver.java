package solution_tutorial2;

import java.util.Scanner;

public class week2_2_1ver {
	public static int cardOrder(String[] str) {
		int pocard=0, triple=0, tupair=0, Draw =0;
		int[] alp = new int[26];

		for (int i = 0; i < alp.length; i++)
			alp[i] = 0;

		for (int i = 0; i < str.length; i++) {
			alp[str[i].compareTo("A")]++;
		}
		
		for(int i = alp.length-1; i>=0; i--) {
			if(alp[i]==4&&pocard==0)
				return pocard=(i+1)*10000;
			else if(alp[i]==3&&triple==0)
				return triple=(i+1)*100;
			else if(alp[i]==2&&tupair==0)
				return tupair=(i+1);
		}
		return Draw;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String table = null;
		String[] card = new String[11];
		String[] tom = new String[5], jerry = new String[5];

		while (input.hasNext()) {
			table = input.nextLine();
			card = table.trim().split("");
			for (int i = 0; i < 5; i++) {
				tom[i] = card[i];
				jerry[i] = card[i + 6];
			}
			
			if(cardOrder(tom) > cardOrder(jerry))
				System.out.println("Tom");
			else if(cardOrder(tom) == cardOrder(jerry))
				System.out.println("Draw");
			else
				System.out.println("Jerry");
		}
		input.close();
	}

}
