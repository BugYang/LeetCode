public class Solution {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new LinkedList<List<String>>(), lists;
		List<String> list;
		int len = s.length();
		int size;
		String subl, subr;

		if (len == 0) {
			list = new LinkedList<String>();
			list.add("");
			result.add(list);
		} else if (len == 1) {
			list = new LinkedList<String>();
			list.add(s);
			result.add(list);
		} else {
			for (int i = 1; i < len; i++) {
				subl = s.substring(0, i);
				subr = s.substring(i);

				if (!isPalindrome(subl))
					continue;
				lists = partition(subr);
				size =  lists.size();
				for (int j = 0; j < size; j++) {
					list = lists.get(j);
					list.add(0, subl);
					result.add(list);
				}
			}

			if (isPalindrome(s)) {
				list = new LinkedList<String>();
				list.add(s);
				result.add(list);
			}
		}

		return result;
	}


	public boolean isPalindrome(String s) {
		char[] str = s.toCharArray();
		for (int i = 0; i < str.length; i++)
			if (str[i] != str[str.length - 1 - i])
				return false;
		return true;
	}
}
