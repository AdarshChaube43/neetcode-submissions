class Solution {
    public List<String> generateParenthesis(int n) {
        // can only add n open parantheses i.e openN<=n
        // can only add closed parantheses if it's count is less than open parantheses closedN<openN
        // valid id openN==n and closedN==n
        Stack<String> stack = new Stack<>();
        List<String> res = new ArrayList<>();
        backTrack(stack, res, 0, 0, n);
        return res;
        
    }

    private void backTrack(Stack<String> stack, List<String> res, int openN, int closedN, int n){
        if(openN==closedN && openN ==n){
            res.add(String.join("",stack));
            return;
        }

        if(openN<n){
            stack.push("(");
            backTrack(stack, res, openN+1,closedN, n);
            stack.pop();
        }
        if(closedN<openN){
            stack.push(")");
            backTrack(stack, res, openN, closedN+1, n);
            stack.pop();
        }
    }
}
