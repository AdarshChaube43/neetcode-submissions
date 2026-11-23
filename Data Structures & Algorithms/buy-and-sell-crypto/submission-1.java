class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int l=0;
        int r=prices.length-1;
        while(r>=1){
            while(l<r){
                System.out.println(maxProfit);
                maxProfit = Math.max(maxProfit,(prices[r]-prices[l]));
                l++;
            }
            l=0;
            r=r-1;
        }
        return maxProfit;

    }
}
