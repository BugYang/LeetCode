public class Solution {
	public int atoi(String str) {
		// null or empty
		if (str == null || str.length() == 0)
			return 0;

		// pass whitespace
		int start = 0;
		for (start = 0; start < str.length() && Character.isWhitespace(str.charAt(start)); start++);

		//  sign
		int sign = 1;
		if (str.charAt(start) == '+' || str.charAt(start) == '-') {
			sign = str.charAt(start) == '+' ? 1 : -1;
			start++;
		}

		// digit part without prefix 0
		while (start < str.length() && str.charAt(start) == '0')
			start++;
		int end = start;
		while (end < str.length() && Character.isDigit(str.charAt(end)))
			end++;

		// abs
		long abs = 0;
		long scale = 1;
		for (int i = end-1; i >= start; i--) {
			abs += scale * (int)(str.charAt(i)-'0');
			if (sign > 0 && abs >= (long)Integer.MAX_VALUE) {
				abs = Integer.MAX_VALUE;
				break;
			}
			if (sign < 0 && abs >= -(long)Integer.MIN_VALUE) {
				abs = -(long)Integer.MIN_VALUE;
				break;
			}
			scale *= 10;
		}

		return (int)(sign * abs);
	}
}
