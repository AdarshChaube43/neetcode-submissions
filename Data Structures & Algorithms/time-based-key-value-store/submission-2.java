class TimeMap {
    HashMap<String, TimeValue> timeValueMap;

    public TimeMap() {
        this.timeValueMap = new HashMap<String, TimeValue>();
    }
    
    public void set(String key, String value, int timestamp) {
        TimeValue timeValueObj = this.timeValueMap.get(key);
        if(timeValueObj==null){
            timeValueObj= new TimeValue();
        } 
        timeValueObj.addData(timestamp,value);
        this.timeValueMap.put(key,timeValueObj);
    }
    
    public String get(String key, int timestamp) {
        TimeValue timeValueObj = this.timeValueMap.get(key);
        if (timeValueObj==null) return "";

        List<Integer> timeStamps = timeValueObj.getTimeStamps();
        int timeStampIndex = binarySearchTimestampIndex(timeStamps,timestamp);
        if (timeStampIndex==-1) return "";

        return timeValueObj.getTimeStampValues().get(timeStampIndex);
    }

    public int binarySearchTimestampIndex(List<Integer>timestampList, int timeStamp){
        int l=0;
        int r=timestampList.size()-1;
        int ans=-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if (timestampList.get(mid)<=timeStamp){
                ans=mid;
                l=mid+1;
            }else {
                r=mid-1;
            } 
        }
        return ans;
    }

    private class TimeValue{
        private List<Integer> timeStamps;
        private List<String> timeStampValues;

        TimeValue(){
            this.timeStamps = new ArrayList<Integer>();
            this.timeStampValues = new ArrayList<String>();
        }
        public List<Integer> getTimeStamps(){
            return this.timeStamps;
        }
        public List<String> getTimeStampValues(){
            return this.timeStampValues;
        }
        public void addData(Integer timeStamp, String timeStampValue){
            this.timeStamps.add(timeStamp);
            this.timeStampValues.add(timeStampValue);
        }
        public String getTimeStampValueAtIdx(int index){
            return this.timeStampValues.get(index);
        }
    }

}
