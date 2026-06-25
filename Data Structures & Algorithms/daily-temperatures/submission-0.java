class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //create a res[] array of size same of temperatures, initialized with 0s
        //create a stack
        //iterate temperatures and check if temperatures[i] is greater than element at stack top
        // if false then push an array of size 2 containing the temperature and its index i.e [temperatures[i],i]
        //else while current temperature >temperature of top element of stack and stack is not empty
        // take the differnce of current index of temperature and the index from the top element of stack and store it in res[] array at the index of top element of stack and pop the elemnt
        //return the res[] array

        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i]>stack.peek()[0]){
                int[] top = stack.peek();
                res[top[1]]=i-top[1];
                stack.pop();
            }
            int[] elem = new int[2];
            elem[0]=temperatures[i];
            elem[1]=i; 
            stack.push(elem);
        }
        return res;
    }
}
