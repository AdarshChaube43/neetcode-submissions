class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        int l=0, r=heights.length-1;
        while(l<r){
            int area =(r-l)*Math.min(heights[l],heights[r]);
            result = Math.max(area,result);
            if(heights[l] >heights[r]){
                r--;
            }else{
                l++;
            }
        }
        // for(int i=0; i<heights.length; i++){
        //     for(int j=i+1; j<heights.length; j++){
        //         int area = (j-i)*Math.min(heights[i],heights[j]);
        //         result = Math.max(area, result);
        //     }
        // }
        return result;
    }
}
