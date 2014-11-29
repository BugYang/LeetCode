public class Solution {
	public int findMin(int[] num) {
		// assume num.length > 0
		int min = num[0];
		for (int i = 1; i < num.length; i++)
			min = Math.min(num[i], min);
		return min;
	}
}
