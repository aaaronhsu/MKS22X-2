public class Testing {
	public static void main(String[] args) {
		partialSum(new int[] {1, 5, 10});
	}

	public static void partialSum(int[] potN) {
		partialSum(0, 0, potN);
	}

	public static void partialSum(int i, int cSum, int[] potN) {
		if (i == potN.length) System.out.println(cSum);
		else {
			partialSum(i + 1, cSum + potN[i], potN);
			partialSum(i + 1, cSum, potN);
		}
	}
}