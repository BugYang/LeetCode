public class Solution {
    public int findMin(int[] num) {
        int minIdx = 0;
        for (int i = 1; i < num.length; i++)
            minIdx = num[minIdx] > num[i] ? i : minIdx;
        return num[minIdx];
    }
}