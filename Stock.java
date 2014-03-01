public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = prices[i] - min > profit ? prices[i] - min : profit;
            min = prices[i] < min ? prices[i] : min;
        }
        return profit;
    }
}
