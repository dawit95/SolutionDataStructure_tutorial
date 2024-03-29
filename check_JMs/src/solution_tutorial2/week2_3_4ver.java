package solution_tutorial2;

import java.util.ArrayList;
import java.util.Scanner;

public class week2_3_4ver {

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
			if (recode[0].equals("E"))
				break;
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
			} else if (recode[0].equals("O") && !food.isEmpty() && guest.size() == 2) { // 기다리는 손님이2명 음식 있음
				if (recode[1].equals("Any")) {// 손님이 2명이지만 아무거나 먹으려함
					if (food.remove(0).equals("Pizza"))
						pi++;
					else
						ham++;
					continue;
				}
			} else if (recode[0].equals("O") && !guest.isEmpty() && guest.size() == 2 && food.isEmpty()) { // 기다리는 손님이2명 음식 없음
				not++;
				continue;
			}
			if (recode[0].equals("F") && !guest.isEmpty()) {// 손님이 있음
				if (!guest.isEmpty() && guest.contains("Any")) {// any 포함.
					if (recode[1].equals("Pizza"))
						pi++;
					else
						ham++;
					guest.remove("Any");
					continue;
				} else if (!guest.isEmpty() && guest.contains(recode[1])) {// 손님 요구와 같아 없어짐.
					if (recode[1].equals("Pizza"))
						pi++;
					else
						ham++;
					guest.remove(recode[1]);
					continue;
				}else {// 요구와 같지 않음
					food.add(recode[1]);
					continue;
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
