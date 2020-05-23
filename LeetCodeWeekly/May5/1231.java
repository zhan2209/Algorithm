class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        int low = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : sweetness) {
            low = Math.min(low, num);
            sum += num;
        }
        if (K == 0) return sum;
        int high = sum / (K + 1);
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (check(sweetness, K + 1, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low - 1;
    }

    private boolean check(int[] sweetness, int k, int bound) {
        int sum = 0;
        for (int num : sweetness) {
            sum += num;
            if (sum >= bound) {
                if (--k == 0) return true;
                sum = 0;
            }
        }
        return k <= 0;
    }
}