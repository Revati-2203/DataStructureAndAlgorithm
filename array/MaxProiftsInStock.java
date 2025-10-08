package array;

public class MaxProiftsInStock {
    public int maxProfit(int[] prices)
    {
        int maxProfit = 0;
        int buyPrice = prices[0];
        int sellingPrice ;
        for(int i=1; i<prices.length; i++){
            sellingPrice=prices[i];
            maxProfit = Math.max(maxProfit, sellingPrice-buyPrice);
            buyPrice = Math.min(buyPrice, prices[i]);
        }
        return maxProfit;
    }
}
