class Solution {
    public int connectSticks(int[] sticks) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int s : sticks) 
        {
            q.offer(s);
        }
        
        int res=0;

        while(q.size()>1){
            int cost=q.poll()+q.poll();
            res+=cost;
            q.offer(cost);
        }
        return res;
    }
}