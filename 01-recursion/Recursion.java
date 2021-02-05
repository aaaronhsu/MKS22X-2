public class Recursion {
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
}