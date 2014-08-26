public class Solution {
	public void nextPermutation(int[] num) {
		if (num.length <= 1)
			return;

		int i = num.length - 2;
		while (i >= 0 && num[i] >= num[i + 1])
			i--;

		if (i < 0) {
			Arrays.sort(num);
			return;
		}

		int j = i + 1, k = i + 1;
		while (j < num.length) {
			k = num[j] > num[i] && num[j] < num[k] ? j : k;
			j++;
		}

		j = num[k];
		num[k] = num[i];
		num[i] = j;

		Arrays.sort(num, i + 1, num.length);
	}
}
