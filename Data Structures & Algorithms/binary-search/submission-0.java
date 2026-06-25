class Solution {
    public int search(int[] nums, int target) {
     return binSearch(nums,target,0,nums.length-1);

    }
    private int binSearch(int[]nums, int target, int li, int ri){
        if(li>ri) return -1;
        int m= li+(ri-li)/2;
        if(target==nums[m]) return m;
        else if(target>nums[m]) li=m+1;
        else ri=m-1;
        return binSearch(nums,target,li,ri);
    }
}
