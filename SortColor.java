public class Solution {
    public void sortColors(int[] A) {
        int[] cnt = new int[3];
        for (int i : A) {
            cnt[i]++;
        }
        int i = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < cnt[j]; k++) {
                A[i++] = j;
            }
        }
    }
}+
