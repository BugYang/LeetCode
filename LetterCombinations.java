public class Solution {
	private String[] mappings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		char[] digit = digits.toCharArray();
		Queue<Character> queue = new LinkedList<Character>();
		List<String> list = new LinkedList<String>();

		for (int i = 0; i < digit.length; i++)
			queue.add(digit[i]);
		list.add("");
		return letterCombinationHelper(queue, list);
	}

	public List<String> letterCombinationHelper(Queue<Character> digits, List<String> list) {
		int size = list.size();
		Character digit = digits.poll();
		String str;
		char[] mapping;

		if (digit == null)
			return list;
		mapping = mappings[digit - '0'].toCharArray();
		while (size-- > 0) {
			str = list.remove(0);
			for (int i = 0; i < mapping.length; i++)
				list.add(str + mapping[i]);
		}
		letterCombinationHelper(digits, list);
		return list;
	}
}
