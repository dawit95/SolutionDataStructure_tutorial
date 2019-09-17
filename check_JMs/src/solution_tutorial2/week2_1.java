package solution_tutorial2;

import java.util.Scanner;
import java.util.Stack;

public class week2_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		int[] num = new int[1000];
		String first, result;
		int temp=0;

		while (input.hasNextLine()) {
			first = input.nextLine();
			stack.clear();
			result = null;
			temp=0;
			
			for (int i = 0; i < first.length(); i++) {
				num[i] = (byte) first.charAt(i) - 65;
			}

			for (int i = 0; i < first.length(); i++) {
				if (i == 0 && num[i] >= 0 && num[i] <= 9) {// 첫 자리 확인
					result = Integer.toString(num[i]);
				} else if (i == 0 && ((num[i] == 15) || (num[i] == 18) || (num[i] == 19) || (num[i] == 21))) { // 연산자로
																												// 시작
					System.out.println("Error");
					break;
				} else if (0 == first.length() - 1) {// 첫자리가 숫자로 끝남.
					System.out.println(result);
				}
				if ((num[i]<0||num[i]>9)&&((num[i]!=15)&&(num[i]!=18)&&(num[i]!=19)&&(num[i]!=21))) {
					System.out.println("Error");
					break;
				}

				if (i > 0 && num[i] >= 0 && num[i] <= 9) {// 두번째 부터 확인
					if (result != null) 
						result = result.concat(Integer.toString(num[i]));
					else
						result = Integer.toString(num[i]);
				}
				if (i == first.length() - 1 && stack.isEmpty())// 숫자로 끝남
					System.out.println(result);
				if (i == first.length() - 1 && !stack.isEmpty() && num[i] >= 0 && num[i] <= 9) {// 정상적으로 끝났을때
					if (stack.peek() == 15) {
						stack.pop();
						temp = stack.pop();
						temp += Integer.parseInt(result);
						System.out.println(temp);
					} else if (stack.peek() == 18) {
						stack.pop();
						temp = stack.pop();
						temp -= Integer.parseInt(result);
						System.out.println(temp);
					} else if (stack.peek() == 19) {
						stack.pop();
						temp = stack.pop();
						temp *= Integer.parseInt(result);
						System.out.println(temp);
					} else if (stack.peek() == 21) {
						stack.pop();
						temp = stack.pop();
						temp /= Integer.parseInt(result);
						System.out.println(temp);
					}
				}
				if (i > 0 && ((num[i] == 15) || (num[i] == 18) || (num[i] == 19) || (num[i] == 21))) {// 연산자 처리
					if (((num[i - 1] == 15) || (num[i - 1] == 18) || (num[i - 1] == 19) || (num[i - 1] == 21))
							|| i == first.length() - 1) {// 연산자 중복과 마지막이 연산인 경우
						System.out.println("Error");
						break;
					} else if (result != null && stack.isEmpty()) {// 처음 숫자와 연산
						stack.push(Integer.parseInt(result));
						stack.push(num[i]);
						result = null;
					} else if (result != null && !stack.isEmpty() && i != num.length - 1) {// 숫자와 연산자가 있고 다음 숫자 완성 후 종료가
																							// 아닌 다시 연산자가 나왔을때 즉, 계산할타이밍
						if (stack.peek() == 15) {
							stack.pop();
							temp = stack.pop();
							temp += Integer.parseInt(result);
							stack.push(temp);
							stack.push(num[i]);
							result = null;
						} else if (stack.peek() == 18) {
							stack.pop();
							temp = stack.pop();
							temp -= Integer.parseInt(result);
							stack.push(temp);
							stack.push(num[i]);
							result = null;
						} else if (stack.peek() == 19) {
							stack.pop();
							temp = stack.pop();
							temp *= Integer.parseInt(result);
							stack.push(temp);
							stack.push(num[i]);
							result = null;
						} else if (stack.peek() == 21) {
							stack.pop();
							temp = stack.pop();
							temp /= Integer.parseInt(result);
							stack.push(temp);
							stack.push(num[i]);
							result = null;
						}
					}
				}
				
			}

		}
		input.close();
	}
}
