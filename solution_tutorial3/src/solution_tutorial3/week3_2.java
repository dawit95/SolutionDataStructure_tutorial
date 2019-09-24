package solution_tutorial3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class week3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(200, Collections.reverseOrder());

		while (input.hasNext()) {
			String temp = input.nextLine();
			if (temp.equalsIgnoreCase("*") && !pq.isEmpty()) {
				pq.poll();
			} else {
				int num = Integer.parseInt(temp);
				pq.add(num);
			}
		}
		int num = pq.size();
		for (int i = 0; i < num; i++)
			System.out.println(pq.poll());
		input.close();

	}

}
