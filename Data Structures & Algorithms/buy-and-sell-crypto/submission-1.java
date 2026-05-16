class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;

        int result = 0;
        while (right < prices.length){
            int maxProfit = prices[right] - prices[left];
            result = Math.max(result, maxProfit);

            if (prices[left] <= prices[right]){
                right++;

            }else if (prices[left] > prices[right]){
                left = right;
                right++;
            }
        }

        return result;
    }
}
