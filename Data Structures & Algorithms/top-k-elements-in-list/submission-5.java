class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>f=new HashMap<>();
        for (Integer i:nums){
            Integer j=f.get(i);
            if(j==null) f.put(i,1);
            else{f.put(i,++j);}
        }
        Map<Integer,List<Integer>> sortedMap=new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : f.entrySet()){

            List<Integer> keyList = sortedMap.get(entry.getValue());
            if(keyList==null) keyList= new LinkedList<>();
            keyList.add(entry.getKey());

            sortedMap.put(entry.getValue(),keyList);
        }
        int[]result=new int[k];
        List<List<Integer>>values=new ArrayList<>(sortedMap.values());
        int i=0,c=0;
        while(c!=k){
            List<Integer> freqElemList=values.get(values.size()-1-i);
            for (int j=0;j<freqElemList.size() && j<k;j++){
                result[c]=freqElemList.get(j);
                c=c+1;
            }
            i=i+1;
        }
        return result;
    }
}
