class Solution {
    
    public int confusingNumberII(int N) {
        int sum = 0;
        for (long i = 2; i <= N; i++) {
            String value = String.valueOf(i);
            int index = value.lastIndexOf("2");
            if (index != -1) {
                index = value.length() - index - 1;
                long exp = (long) Math.pow(10, index) * 4;
                if (exp + i > Integer.MAX_VALUE) {
                    break;
                }
                i = i + exp - 1;
                continue;
            }
            index = value.lastIndexOf("7");
            if (index != -1) {
                index = value.length() - index - 1;
                long exp = (long) Math.pow(10, index);
                if (exp + i > Integer.MAX_VALUE) {
                    break;
                }
                i = i + exp - 1;
                continue;
            }
            StringBuffer sb = new StringBuffer();
            for (int j = value.length() - 1; j >= 0; j--) {
                char c = value.charAt(j);
                if (c == '6') {
                    sb.append('9');
                } else if (c == '9') {
                    sb.append('6');
                } else {
                    sb.append(c);
                }
            }
            if (value.equals(sb.toString())) {
                continue;
            }
            sum++;
        }
        return sum;
    }

}