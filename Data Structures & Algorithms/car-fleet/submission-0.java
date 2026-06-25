class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        for (int i=0; i<position.length;i++){
            pairs[i][0] = speed[i];
            pairs[i][1] = position[i];
        } 
        Arrays.sort(pairs, (a,b)->Integer.compare(b[1],a[1]));

        Stack<Double> stack = new Stack<>();
        for (int[] pair: pairs){
            Double time =(double)(target-pair[1])/pair[0];
            stack.push(time);
            if(stack.size() >= 2 && stack.peek()<=stack.get(stack.size()-2)){
                stack.pop();
            }
        }
        return stack.size();
    }
}
