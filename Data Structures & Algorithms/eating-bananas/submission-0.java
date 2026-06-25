class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxK = piles[0];
        int minK=1;
        for(int i=1; i<piles.length; i++){
            maxK = Math.max(maxK,piles[i]);
        }
        System.out.println("maxK: "+maxK);
        //using binary search find the min k between 1 and maxK
        while(minK<=maxK){
            int mid = minK+(maxK-minK)/2;
            int t = timeToEat(piles, mid);
            if(t<=h){
                maxK=mid-1;
            }else if(t>h){
                minK=mid+1;
            }
        }
        return minK;
    }

    private int timeToEat(int[] piles, int k){
        double t = 0.0;
        for (int i=0; i<piles.length; i++){
            t=t+Math.ceil(piles[i]/(k*1.0));
            System.out.println("t:"+t);
        }
        System.out.println("time to eat at k/hr:"+k+", hr :"+t);
        return (int)t;
    }

}
