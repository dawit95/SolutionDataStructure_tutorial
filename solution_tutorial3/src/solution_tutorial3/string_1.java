package solution_tutorial3;

public class string_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "ddef";
		
		char[][] array = new char[2][10];
		
		array[0] = test.toCharArray();
		
		System.out.println(array[0].length);
		
		for (char a : array[0]) {
			System.out.println(a);
		}
	}

}
