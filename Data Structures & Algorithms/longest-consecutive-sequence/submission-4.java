class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0 || nums.length==1) return nums.length;
        //sort the array
        Arrays.sort(nums);
        int lcs=1;
        int curSum=1;
        for (int i=1; i<nums.length; i++){
            if(nums[i]!=nums[i-1]){
                if(nums[i]-nums[i-1]==1){
                    curSum++;
                }else{
                    if(curSum>lcs){
                        lcs=curSum;
                    }
                    curSum=1;
                }
            }
           
        }
        return curSum>lcs?curSum:lcs;
    }
}
