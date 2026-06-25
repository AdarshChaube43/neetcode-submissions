class Solution {
    public int maxArea(int[] heights) {

        int result=0;
        // brute force
        // for (int i=0; i<heights.length; i++){
        //     for (int j=i+1; j<heights.length;j++){
        //         int area = (j-i)*Math.min(heights[i],heights[j]);
        //         result = Math.max(area,result);
        //     }
        // }

        //linear time solution
        int l=0, r=heights.length-1;
        while (l<r){
            int area = (r-l)*Math.min(heights[l],heights[r]);
            result = Math.max(area,result);
            if(heights[l]<heights[r]){
                l = l+1;
            }else{
                r=r-1;
            }
        }
        return result;
    }
}
