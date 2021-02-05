public class Recursion {
	public static void main(String[] args) {
		System.out.println(sqrt(100));	
	}

	public static String reverse(String s) {
		if (s.length() <= 1) return s;
		return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
	}

	public static long countNoDoubleLetterWords(int length, String word) {
		if (length == 0) return 1;

		long ret = 0;

		for (char i = 'a'; i <= 'z'; i++) {
			if (word.length() == 0 || word.charAt(word.length() - 1) != i) {
				ret += countNoDoubleLetterWords(length - 1, word + i);
			}
		}

		for (char i = 'A'; i <= 'Z'; i++) {
			if (word.length() == 0 || word.charAt(word.length() - 1) != i) {
				ret += countNoDoubleLetterWords(length - 1, word + i);
			}
		}

		return ret;
	}

	public static double sqrt(double n) {
		return sqrt(n, n / 2);
	}

	public static double sqrt(double n, double guess) {
		if ((n - (n * 0.00001) <= Math.pow(guess, 2) && Math.pow(guess, 2) <= n + (n * 0.00001))) return guess;

		double newGuess = ((n / guess) + guess) / 2;
		return sqrt(n, newGuess);
	}
}