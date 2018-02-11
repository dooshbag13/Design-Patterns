# Main Design Patterns in JAVA

Examples of some of the most widely used design patterns written in Java



public static int strategy(int[][] arr, int row, int col, int sum) {
		
		if(row == arr.length) return sum;
		
		int a = strategy(arr, row+1, col, sum+arr[row][col]);
		int b = strategy(arr, row+1, col+1, sum+arr[row][col]);
		int c = col == 0 ? 0 : strategy(arr, row+1, col-1, sum+arr[row][col]);
		
		return a>b? (a>c? a: c) : (b>c?b:c);
	}
