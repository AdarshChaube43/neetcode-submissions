class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return null;
        return String.join("#d#",strs);
    }

    public List<String> decode(String str) {
        if(str==null) return new ArrayList<>();
        if(str.isEmpty())return Arrays.asList("");
        return Arrays.asList(str.split("#d#"));
    }
}
