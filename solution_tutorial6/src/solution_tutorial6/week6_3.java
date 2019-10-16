package solution_tutorial6;

import java.util.Arrays;
import java.util.Scanner;

public class week6_3 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int count = Integer.parseInt(input.nextLine());
		Team[] Team = new Team[count];
		for (int i = 0; i < count; i++) {
			Team[i] = new Team(input.nextLine());
		}
		
		while (input.hasNext()) {
			String str = input.nextLine();
			String[] strarr = str.split(" ");
			String[] temp = strarr[1].split(":");
			
			int front = Integer.parseInt(temp[0]);
			int end = Integer.parseInt(temp[1]);
			boolean bl = (front-end)>0;
			
			for(int i=0; i<count; i++) {
				if(strarr[0].equals(Team[i].getName())) {
					if(bl) {
						Team[i].setWin();
						Team[i].addLoseCheck(strarr[2]);
					}
					else
						Team[i].setLose();
					Team[i].setWinSet(front);
					Team[i].setLoseSet(end);
				}
			}
			for(int i=0; i<count; i++) {
				if(strarr[2].equals(Team[i].getName())) {
					if(!bl) {
						Team[i].setWin();
						Team[i].addLoseCheck(strarr[0]);
					}
					else
						Team[i].setLose();
					Team[i].setWinSet(end);
					Team[i].setLoseSet(front);
				}
			}
		}
		Arrays.sort(Team);
		 for(int i =0; i< Team.length; i++)
             System.out.println((i+1)+") "+Team[i].toString());
		input.close();

	}

}
