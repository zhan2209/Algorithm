class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        List<Pair> datas = new ArrayList<>();
        for(int i = 0; i < n; i++){
            datas.add(new Pair(username[i], timestamp[i], website[i]));
        }

        Collections.sort(datas, (a, b) -> a.time - b.time);
        HashMap<String, List<String>> userToWebs = new HashMap<>();
        for(Pair data : datas){
            userToWebs.putIfAbsent(data.user, new ArrayList<String>());
            userToWebs.get(data.user).add(data.web);
        }

        HashMap<String, Integer> seqToCount = new HashMap<>();

        int maxCount = 0;
        String maxSeq = "";
        for(Map.Entry<String, List<String>> entry : userToWebs.entrySet()){
            Set<String> seqCom = getCom(entry.getValue());
            for(String seq : seqCom){
                seqToCount.put(seq, seqToCount.getOrDefault(seq, 0) + 1);
                if(seqToCount.get(seq) > maxCount){
                    maxCount = seqToCount.get(seq);
                    maxSeq = seq;
                }else if(seqToCount.get(seq) == maxCount && seq.compareTo(maxSeq) < 0){
                    maxSeq = seq;
                }
            }
        }

        List<String> res = new ArrayList<>();
        String [] webs = maxSeq.split(",");
        for(String w : webs){
            res.add(w);
        }

        return res;
    }

    private HashSet<String> getCom(List<String> webs){
        HashSet<String> res = new HashSet<>();
        int n = webs.size();
        for(int i = 0; i < n - 2; i++){
            for(int j = i + 1; j < n - 1; j++){
                for(int k = j + 1; k < n; k++){
                    res.add(webs.get(i) + "," + webs.get(j) + "," + webs.get(k));
                }
            }
        }

        return res;
    }
}

class Pair{
    String user;
    int time;
    String web;
    public Pair(String user, int time, String web){
        this.user = user;
        this.time = time;
        this.web = web;
    }
}