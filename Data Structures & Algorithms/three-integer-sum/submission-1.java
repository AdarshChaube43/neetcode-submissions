class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if(!(i>0 && nums[i]==nums[i-1])){
                int l=i+1;
                int r=nums.length-1;
                while(l<r){
                    int sum=nums[i]+nums[l]+nums[r];
                    if(sum>0) r=r-1;
                    else if(sum<0) l=l+1;
                    else {
                        result.add(List.of(nums[i],nums[l],nums[r]));
                        l=l+1;
                        while(nums[l]==nums[l-1] && l<r){
                            l=l+1;
                        }
                    }

                }
            }
        }
        return result;
        
    }
}
