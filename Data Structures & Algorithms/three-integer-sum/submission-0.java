class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String,List<Integer>> resultMap = new HashMap<>();
        for (int i=0; i<nums.length;i++){
            for(int j=i+1; j<nums.length;j++){
                for(int k=j+1; k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        int[] temp = {nums[i],nums[j],nums[k]};
                        Arrays.sort(temp);
                        String key = String.join("#",List.of(temp[0]+"",temp[1]+"",temp[2]+""));
                        
                        if(resultMap.get(key)==null){
                            result.add(List.of(nums[i],nums[j],nums[k]));
                            resultMap.put(key,List.of(nums[i],nums[j],nums[k]));
                        }

                        
                    }
                }
            }
        }

        return result;
        
    }
}
