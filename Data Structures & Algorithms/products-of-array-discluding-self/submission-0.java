class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int leftM=1, rightM=1;
        //store all the multiplication of elements before i excluding i
        for(int i=0; i<nums.length;i++){
            arr[i]=leftM;
            leftM=leftM*nums[i];
        }
        //Calculate all the multiplications of elements after i excluding i and multiply by stored prefix multiplication values
        for(int i=nums.length-1; i>=0;i--){
            arr[i]=arr[i]*rightM;
            rightM=rightM*nums[i];
        }
        return arr;
    }
}  
