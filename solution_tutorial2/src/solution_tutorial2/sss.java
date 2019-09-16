package solution_tutorial2;

import java.util.ArrayList;
import java.util.Scanner;

public class sss {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = null;
		String[] recode = new String[2];
		ArrayList<String> guest = new ArrayList<String>();
		ArrayList<String> food = new ArrayList<String>();

		int pi = 0, ham = 0, not = 0;

		while (input.hasNext()) {
			str = input.nextLine();
			recode = str.trim().split(" ");
			if (recode[0].equals("E")) {
				not+=guest.size();
				break;
			}
			if (recode[0].equals("O") && !food.isEmpty()&& guest.size() < 2) {// food있음
				if (food.contains(recode[1])) {// 요구에 맞는 food가 있음
					food.remove(recode[1]);
					if (recode[1].equals("Pizza"))
						pi++;
					else
						ham++;
					continue;
				} else if (recode[1].equals("Any")) {
					if (food.remove(0).equals("Pizza"))
						pi++;
					else
						ham++;
					continue;
				} else {
					guest.add(recode[1]);
					continue;
				}
			} else if (recode[0].equals("O") && food.isEmpty()&& guest.size() < 2) {// food 없음
				guest.add(recode[1]);
				continue;
			} else if (recode[0].equals("O") && !guest.isEmpty() && guest.size() == 2) { // 기다리는 손님이2명
				not++;
				continue;
			}
			if (recode[0].equals("F") && !guest.isEmpty()) {// 손님이 있음
				for (int i = 0; i < guest.size(); i++) {
					if (guest.get(i).equals(recode[1])) {// 손님 요구와 같아 없어짐.
						if (recode[1].equals("Pizza"))
							pi++;
						else
							ham++;
						guest.remove(i);
						break;
					} else if (guest.get(i).equals("Any")) {// any 포함.
						if (recode[1].equals("Pizza"))
							pi++;
						else
							ham++;
						guest.remove(i);
						break;
					}
					if (i == guest.size() - 1) {// 요구와 같지 않음
						food.add(recode[1]);
					}
				}
			} else if (recode[0].equals("F") && guest.isEmpty()) { // 손님 없음
				food.add(recode[1]);
				continue;
			}
		}
		System.out.print("Pizza: " + pi + "\nHamburger: " + ham + "\nNothing: " + not);
		input.close();

	}

}
