package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/120875
public class parallel {

	public static int solution() {
		int X =0, Y=1;
		int[][] dots = new int[4][2];
		dots[0][X] = 1;
		dots[0][Y] = 4;
		dots[1][X] = 9;
		dots[1][Y] = 2;
		dots[2][X] = 3;
		dots[2][Y] = 8;
		dots[3][X] = 11;
		dots[3][Y] = 6;
		
		if(dots[3][Y]-dots[1][Y] == dots[3][X]-dots[1][X] 
				&& dots[2][Y]-dots[0][Y] == dots[2][X]-dots[0][X])
			return 1;
		if(dots[3][Y]-dots[1][Y] == dots[3][X]-dots[1][X] 
				&& dots[2][Y]-dots[0][Y] == dots[2][X]-dots[0][X])
			return 1;

		
		return 0;
	}
	public static void main(String[] args) {
		System.out.println(solution());
		// 
		

	}

}
