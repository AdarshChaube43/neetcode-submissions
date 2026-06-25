class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Integer a;
        Integer b;
        for (String s: tokens){
            if(s.equals("+")){
                b=Integer.parseInt(stack.pop());
                a=Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a+b));
            }else if(s.equals("-")){
                b=Integer.parseInt(stack.pop());
                a=Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a-b));
            }else if(s.equals("*")){
                b=Integer.parseInt(stack.pop());
                a=Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a*b));
            }else if(s.equals("/")){
                b=Integer.parseInt(stack.pop());
                a=Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a/b));
            }else stack.push(s);
        }
        return Integer.parseInt(stack.pop());
    }
}
