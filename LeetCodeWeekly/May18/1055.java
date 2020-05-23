class Solution {
    public int shortestWay(String source, String target) {
        int index=0,output=0;

        while (index!=target.length()){
            output++;
            int lastindex=index;

            for (int i=0;i<source.length();i++){
                if (source.charAt(i)==target.charAt(index)){
                    if (++index==target.length()){
                        break;
                    }
                }
            }
            if (index==lastindex){
                return -1;
            }
        }
        return output;
    }
}