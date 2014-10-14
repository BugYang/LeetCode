public class Solution {
    public int candy(int[] ratings) {
        // leftMost i means the left most element reachable from i by decrement
        int[] leftMost = new int[ratings.length];
        // rightMost i means the right most element reachable from i by decrement
        int[] rightMost = new int[ratings.length];
        
        // compute leftMost
        leftMost[0] = 0;
        for (int i = 1; i < ratings.length; i++)
            leftMost[i] = ratings[i] > ratings[i-1] ? leftMost[i-1] : i;

        // compute rightMost
        rightMost[ratings.length-1] = ratings.length-1;
        for (int i = ratings.length-2; i >= 0; i--)
            rightMost[i] = ratings[i] > ratings[i+1] ? rightMost[i+1] : i;
        
        int cnt = ratings.length;
        for (int i = 0; i < ratings.length; i++)
            cnt += Math.max(i-leftMost[i], rightMost[i]-i);
        return cnt;
    }
}