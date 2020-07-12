class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        List<Integer>[] map = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        int[] degree = new int[N + 1];
        for (int[] relation : relations) {
            degree[relation[1]]++;
            map[relation[0]].add(relation[1]);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0) queue.offer(i);
        }
        if (queue.isEmpty()) return -1;
        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            while (size-- > 0) {
                Integer poll = queue.poll();
                for (Integer child : map[poll]) {
                    degree[child]--;
                    if (degree[child] == 0) {
                        queue.offer(child);
                    }
                }
            }
        }
        for (int i : degree) if (i > 0) return -1;
        return ans;
    }
}