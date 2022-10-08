class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int maxdiff=0;
        int n=prices.length;
        for(int i=0;i<n;i++)
        {
            if(prices[i]<buy)
            {
                buy = prices[i];
            }
            if(maxdiff<prices[i]-buy)
            {
                maxdiff=prices[i]-buy;
            }
        }
        return maxdiff;
    }
}