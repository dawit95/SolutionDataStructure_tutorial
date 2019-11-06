package solution_tutorial9;

public class week9 {
	static boolean finished = false; 	/* found all solutions yet? */
	final static int MAX = 10; 			/* number of candidate */

	public static void main(String[] args) {
		int[] arr = null; 	/* 구하고자 하는 값의 배열 */
		int k = 0; 			/* DFS(깊이우선탐색)의 깊이 */
		int input = 0; 		/* 값. */
		backtrack(arr, k, input);
	}

	public static void backtrack(int[] arr, int k, int input) {
		int[] c = new int[MAX]; 	/* 다음 상태 후보군 */
		int ncandidates; 			/* 다음 상태 후보의 수 */
		int i; 						/* counter */

		if (is_a_solution(arr, k, input))		/* 완성 상태 */
			process_solution(arr, k, input);	/* 완성된 데이터 처리 */
		else {
			k = k + 1;
			/* 후보를 만드는 함수 */
			construct_candidates(arr, k, input, &c, &ncandidates);
			for (i = 0; i < ncandidates; i++) {
				arr[k] = c[i];
				backtrack(arr, k, input);
				if (finished)
					return; /* terminate early */
			}
		}
	}

}
