package solution_tutorial9;

public class week9 {
	static boolean finished = false; 	/* found all solutions yet? */
	final static int MAX = 10; 			/* number of candidate */

	public static void main(String[] args) {
		int[] arr = null; 	/* ���ϰ��� �ϴ� ���� �迭 */
		int k = 0; 			/* DFS(���̿켱Ž��)�� ���� */
		int input = 0; 		/* ��. */
		backtrack(arr, k, input);
	}

	public static void backtrack(int[] arr, int k, int input) {
		int[] c = new int[MAX]; 	/* ���� ���� �ĺ��� */
		int ncandidates; 			/* ���� ���� �ĺ��� �� */
		int i; 						/* counter */

		if (is_a_solution(arr, k, input))		/* �ϼ� ���� */
			process_solution(arr, k, input);	/* �ϼ��� ������ ó�� */
		else {
			k = k + 1;
			/* �ĺ��� ����� �Լ� */
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
