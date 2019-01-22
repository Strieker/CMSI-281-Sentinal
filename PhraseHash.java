package sentinal;

public class PhraseHash implements PhraseHashInterface {

	private final static int BUCKET_START = 1000;
	private final static double LOAD_MAX = 0.7;
	private int size, longest;
	private String[] buckets;

	PhraseHash() {
		longest = 0;
		size = 0;
		buckets = new String[BUCKET_START];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void put(String s) {
		int index;
		if (isEmpty()) {
			index = 0;
		} else {
			index = hash(s);
		}
		if (buckets[index] != null) {
			if (buckets[index].equals(s)) {
				return;
			} else {
				index = searchUntilFindNullSpotOrSameValue(s, index + 1);
			}
		}
		insertAt(s, index);
	}

	public String get(String s) {
		int index = 0;
		if (isEmpty()) {
			return null;
		}
		while (buckets[index] != null && (index <= size - 1)) {
			if (buckets[index].equals(s)) {
				return s;
			}
			index++;
		}
		return null;
	}

	public int longestLength() {
		int index = 0;
		if (isEmpty()) {
			return 0;
		} else {
			longest = lengthOfPhrase(buckets[0]);
		}
		while (buckets[index] != null && (index <= size - 1)) {
			if (lengthOfPhrase(buckets[index]) > longest) {
				longest = lengthOfPhrase(buckets[index]);
			}
			index++;
		}
		return longest;
	}

	private int lengthOfPhrase(String s) {
		int countSpaces = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				countSpaces++;
			}
		}
		return countSpaces + 1;
	}

	private int searchUntilFindNullSpotOrSameValue(String s, int index) {
		if (buckets[index] == s) {
			return index;
		}
		if (buckets[index] == null) {
			return index;
		}
		return searchUntilFindNullSpotOrSameValue(s, index + 1);
	}

	private int hash(String s) {
		return s.length() % size;
	}

	private void checkAndGrow() {
		if (isEmpty()) {
			return;
		} else if ((size < buckets.length) && (size / buckets.length <= LOAD_MAX)) {
			return;
		}
		String[] newItems = new String[buckets.length * 2];
		for (int i = 0; i < buckets.length; i++) {
			newItems[i] = buckets[i];
		}
		buckets = newItems;
	}

	private void shiftRight(int index) {
		for (int i = size - 1; i >= index; i--) {
			buckets[i + 1] = buckets[i];
		}
	}

	private void insertAt(String toAdd, int index) {
		checkAndGrow();
		shiftRight(index);
		buckets[index] = toAdd;
		size++;
	}

}
