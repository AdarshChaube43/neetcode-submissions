class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        l,r = 0,len(nums)-1
        while l<=r:
            if nums[l]<=nums[r]:
                return nums[l]
            else:
                mid = l+(r-l)//2
                if nums[mid]>=nums[l]:
                    l=mid+1
                else:
                    r=mid