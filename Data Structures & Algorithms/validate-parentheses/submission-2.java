class Solution {
    public boolean isValid(String s) {
        if(s.length()<2) return false;
        Stack<Character> charStack = new Stack<>();
        for(Character c: s.toCharArray()){
            if(c=='(') charStack.push(')');
            else if (c=='{') charStack.push('}');
            else if (c=='[') charStack.push(']');
            else {
                if (charStack.isEmpty() || charStack.peek()!=c){
                    return false;
                }
                charStack.pop();
            }
        }
        return charStack.isEmpty()?true:false;
    }
}
