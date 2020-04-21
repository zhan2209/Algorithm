class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
       
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i < N; i++){
            graph.put(i, new HashSet<>());
        }
        
        for(int[] path : paths){
            graph.get(path[0] - 1).add(path[1] - 1);
            graph.get(path[1] - 1).add(path[0] - 1);
        }
        
        int[] res = new int[N];
        
        for(int i = 0; i < N; i++){
            boolean[] used = new boolean[5];
            for(int adj: graph.get(i)){
                used[res[adj]] = true;
            }
            
            for(int j = 1 ; j <= 4 ; j++){
                if(!used[j]){
                    res[i] = j ;
                }
            }
        }
        return res;
    }
}