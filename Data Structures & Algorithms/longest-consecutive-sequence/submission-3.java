class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0 || nums.length==1) return nums.length;
        //sort the array
        Arrays.sort(nums);
        System.out.print(nums[0]);
        int lcs=1;
        int curSum=1;
        for (int i=1; i<nums.length; i++){
            System.out.print(" "+nums[i]);
            if(nums[i]!=nums[i-1]){
                if(nums[i]-nums[i-1]==1){
                    curSum++;
                }else{
                    if(curSum>lcs){
                        lcs=curSum;
                    }
                    curSum=1;
                }
            }else{System.out.print(nums[i]+"="+nums[i-1]);}
           
        }
        return curSum>lcs?curSum:lcs;
    }
}
