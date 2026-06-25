class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols= matrix[0].length;

        int li=0;
        int ri=(rows*cols)-1;
        while(li<=ri){
           int m=li+(ri-li)/2;
            int row =m/cols;
            int col=m%cols;
            if(matrix[row][col]>target) ri= m-1;
            else if(matrix[row][col]<target) li=m+1;
            else return true;
        }
        return false;


    }
}