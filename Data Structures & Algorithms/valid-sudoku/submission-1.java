class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValidBlock(board) && isValidRow(board) && isValidColumn(board);
        
    }
    private boolean isValidBlock(char[][] board){
        for(int k=0;k<=6;k+=3){
            System.out.println("k="+k);
            for(int l=0;l<=6;l+=3){
                Map<Character,Integer> fMap=new HashMap<>();
                //checks row by row 3x3 box
                System.out.println("l="+l);
                for (int i=k;i<k+3;i++){
                    for (int j=l;j<l+3;j++){
                        System.out.print(" "+board[i][j]);
                        if(board[i][j]!='.'){
                            if(fMap.get(board[i][j])==null){
                                fMap.put(board[i][j],1);
                            }else{
                                return false;
                            }
                        }
                    }
                    System.out.println("");
                }
            }
        }
        
        return true;
    }
    private boolean isValidRow(char[][] board){
        
        for (int i=0;i<9;i++){
            int arr[]=new int[10];
            for (int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(arr[Integer.parseInt(""+board[i][j])]==0){
                        arr[Integer.parseInt(""+board[i][j])]=1;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean isValidColumn(char[][] board){
         for (int i=0;i<9;i++){
            int arr[]=new int[10];
            for (int j=0;j<9;j++){
                if(board[j][i]!='.'){
                    if(arr[Integer.parseInt(""+board[j][i])]==0){
                        arr[Integer.parseInt(""+board[j][i])]=1;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
}
