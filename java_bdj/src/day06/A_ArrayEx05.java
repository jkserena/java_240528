package day06;

public class A_ArrayEx05 {

	public static void main(String[] args) {
		
		int maxNum = 100;
		// 100이하의 소수를 찾는 예제 : 에라토스테네스의 체
//		int [] arr = new int[maxNum+1];
//		for (int i = 2; i < arr.length; i++) {
//			if (arr[i] == 0) {
//				for (int j = 2; i*j < arr.length; j++) {
//					arr[i * j] = 1;
//				}
//			}
//		}
//		for(int i =2; i< arr.length; i++)
//			System.out.print((arr[i]==1)?"":i+" ");
//		
//		System.out.println();
		
		boolean[] isDecimal = new boolean[maxNum+1];

		for (int i = 2; i < isDecimal.length; i++) {
			if (isDecimal[i] == false) {
				for (int j = 2; i*j < isDecimal.length; j++) {
					isDecimal[i * j] = true;
				}
			}
		}
		for(int i =2; i< isDecimal.length; i++) {
			System.out.print((isDecimal[i])?"":i+" ");
//			if(i%10 == 0)
//				System.out.println();
		}
		

	}

}
