class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix[0].length;
        int n=matrix.length;
        int row=0;
        if (n!=1){
            row = binSearchRows(matrix,0,n-1,target);
            System.out.println("row: "+row);
            if (row==n) return false;
            if (matrix[row][m-1]==target) return true;
            
        }
        return binSearchColumns(matrix,row,0,m-1,target);
                
    }
    private int binSearchRows(int[][] matrix,int li,int ri,int target){
        if (li>ri) return li;
        int mid = li+(ri-li)/2;
        int ce=matrix[0].length-1;
        if(matrix[mid][ce]==target) return mid;
        else if(matrix[mid][ce]>target) ri=mid-1;
        else li=mid+1;
        return binSearchRows(matrix,li,ri,target);
    }
    private boolean binSearchColumns(int[][] matrix,int row, int li,int ri,int target){
        if(li>ri) return false;
        int mid = li+(ri-li)/2;
        if(matrix[row][mid]==target) return true;
        else if(matrix[row][mid]>=target) ri=mid-1;
        else li=mid+1;
        return binSearchColumns(matrix,row,li,ri,target);
    }
}
