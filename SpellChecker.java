
public class SpellChecker {


	public static void main(String[] args) {
		//String word = args[0];
		//int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		int checker = levenshtein("hello", "hell");
		System.out.println(checker);
		//String correction = spellChecker(word, threshold, dictionary);
		//System.out.println(correction);
	}

	public static String tail(String str) {
		String tail = str.substring(1);
		return tail;
	}

	public static int levenshtein(String word1, String word2) {
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		
		int lenWord1 = word1.length();
		int lenWord2 = word2.length();

		// Base cases: if either of the strings is empty, return the length of the other string
        if (word1.length() == 0) {
			return word2.length();
		}
		
		if (word2.length() == 0) {
			return word1.length();
		}

		if(word1.charAt(0)==word2.charAt(0)){
			return levenshtein(tail(word1), tail(word2));
		}

		int addition = levenshtein(tail(word1), word2);
		int deletion = levenshtein(word1, tail(word2));
		int substitution = levenshtein(tail(word1), tail(word2));
		int min = Math.min(addition, Math.min(deletion, substitution));

		return min+1;
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);

		for(int i=0;i<dictionary.length;i++){
			String word = in.readLine();
			dictionary[i]= word;
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here
		return null;
	}

}

