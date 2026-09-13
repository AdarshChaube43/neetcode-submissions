class Solution {
    public int findDuplicate(int[] nums) {
        /*Need to think nums array as linked list where each index points to the next index given by it's value, i.e each value in array is telling us that to which other index this node is pinting to. 
        To get the duplicate value, we can think this as a linked list having a cycle and we just need to find the starting point of that cycle/loop we can find it by using slow and fast pointer approach. slow and fast pointer will eventualy meet at some point, and to find the start of the loop, we have to run another loop with another slow pointer(slow2) which will start from 0th index and move both slow and slow2 one step at a time  and the node at which they meet is the index of the duplicate number in array
        */
        
           
           int slow =0, fast=0;
           while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow==fast) break;

           }
           int slow2=0;
           while(true){
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow==slow2) return slow;
           }

    }
}
