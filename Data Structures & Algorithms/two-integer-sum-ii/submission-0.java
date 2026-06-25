class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int l=0, r=numbers.length-1;
        int[] result = new int[2];
        while(l<r){
        
            int curSum=numbers[l]+numbers[r];
            if(curSum>target){r--;}
            else if(curSum<target){l++;}
            else{
                result[0]=l+1;
                result[1]=r+1;
                return result; 
            }
        }
        return result;
    }
}
