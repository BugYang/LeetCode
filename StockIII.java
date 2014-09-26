public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
            
        int[] maxL = new int[prices.length];
        int[] maxR = new int[prices.length];
        int max = prices[prices.length-1];
        int min = prices[0];
        int maxProfit = 0;
        maxL[0] = 0;
        maxR[maxR.length-1] = 0;

        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            maxL[i] = Math.max(prices[i] - min, maxProfit);
            maxProfit = maxL[i];
        }
        maxProfit = 0;
        for (int i = prices.length-2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            maxR[i] = Math.max(max - prices[i], maxProfit);
            maxProfit = maxR[i];
        }
        
        maxProfit = 0;
        for (int i = 0; i < prices.length; i++)
            maxProfit = Math.max(maxProfit, maxL[i]+maxR[i]);
        
        return maxProfit;
    }
}