class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> anagramMap=new HashMap<>();
        for(String s: strs){
            String key=getKey(s);
            List<String>anagrams=anagramMap.get(key);
            if(anagrams==null){
                anagrams=new ArrayList<>();
            }
            anagrams.add(s);
            anagramMap.put(key,anagrams);
        }
        List<List<String>> result = new ArrayList<>(anagramMap.values());
        return result;
    }
    private String getKey(String str){
        int key=0;
        for (int i=0; i<str.length();i++){
            key=key+str.charAt(i);
        }
        return String.valueOf(key);
    }
}
