public class Solution {
	public int findPeakElement(int[] num) {
		// head
		if (num.length == 1 || num[0] > num[1])
			return 0;
		// body
		for (int i = 1; i < num.length-1; i++)
			if (num[i] > num[i-1] && num[i] > num[i+1])
				return i;
		// tail
		if (num[num.length-1] > num[num.length-2])
			return num.length-1;

		// shouldn't reach here
		return -1;
	}

	public int findPeakElement(int[] num) {
		return findPeakElementHelper(num, 0, num.length-1);
	}

	private int findPeakElementHelper(int[] num, int low, int high) {
		int mid = (low + high)/2;

		if (mid == low) {
			// two or one element
			return num[low] > num[high] ? low : high;
		} else {
			// more than two
			if (num[mid] > num[mid-1] && num[mid] > num[mid+1])
				return mid;
			else if (num[mid] > num[mid-1] && num[mid] < num[mid+1])
				return findPeakElementHelper(num, mid+1, high);
			else
				return findPeakElementHelper(num, low, mid-1);
		}
	}
}
