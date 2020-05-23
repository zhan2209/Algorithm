class Solution {
    int res = Integer.MAX_VALUE;
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] trans : transactions) {
            int x = trans[0];
            int y = trans[1];
            int amount = trans[2];
            map.put(x, map.getOrDefault(x, 0) + amount);
            map.put(y,  map.getOrDefault(y, 0) - amount);
        }
        int[] arr = map.values().stream().filter(v -> v != 0).mapToInt(i -> i).toArray();
        helper(arr, 0, 0);
        return res;
    }

    private void helper(int[] arr, int start, int cnt) {
        int n = arr.length;
        while (start < n && arr[start] == 0) {
            start++;
        }
        if (start == n) {
            res = Math.min(res, cnt);
            return;
        }
        for (int i = start + 1; i < n; i++) {
            if ((arr[start] > 0 && arr[i] < 0) || (arr[start] < 0 && arr[i] > 0)) {
                arr[i] += arr[start];
                helper(arr, start + 1, cnt + 1);
                arr[i] -= arr[start];
            }
        }
    }
}
