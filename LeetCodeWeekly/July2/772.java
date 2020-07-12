class Solution {
    
    public int calculate(String s) {
        //s = s+"$";
        char cs[] = s.toCharArray();
        int i=0,size=0;
        long[] stack=new long[cs.length];
        boolean[] stack2=new boolean[cs.length];
        while (i<cs.length) {
            char ch=cs[i];
            if (ch==')' && stack[size-2]==-5) {
                stack2[size-2]=false;
                stack[size-2]=stack[size-1];
                size--;
                i++;
                continue;
            }
            if (ch=='-' && cs[i+1]>='0' && cs[i+1]<='9' && (i==0 || stack2[size-1])) {
                i++;
                int start=i;
                while (i<cs.length && cs[i]>='0' && cs[i]<='9') {
                    i++;
                }
                long num=-Long.parseLong(s.substring(start, i));
                stack2[size]=false;
                stack[size++]=num;
                continue;
            } 

            if (ch=='+' || ch=='-' || ch==')') {
                if (size>=3 && !stack2[size-3] && !stack2[size-1]) {
                    long res=comp(stack[size-3], stack[size-1], (int)stack[size-2]);
                    size-=3;
                    stack2[size]=false;
                    stack[size++]=res;
                    continue;
                }
                if (ch!=')') {
                    stack2[size]=true;
                    stack[size++]=char2Int(ch);
                }
            } else if (ch=='*' || ch=='/') {
                if (size>=3 && !stack2[size-3] && !stack2[size-1] && 
                (stack[size-2]==-3 || stack[size-2]==-4)) {
                    long res=comp(stack[size-3], stack[size-1], (int)stack[size-2]);
                    size-=3;
                    stack2[size]=false;
                    stack[size++]=res;
                }
                stack2[size]=true;
                stack[size++]=char2Int(ch);
            } else if (ch=='(') {
                stack2[size]=true;
                stack[size++]=char2Int(ch);
            } else if (ch>='0' && ch<='9') {
                int start=i;
                while (i<cs.length && cs[i]>='0' && cs[i]<='9') {
                    i++;
                }
                long num=Long.parseLong(s.substring(start, i));
                stack2[size]=false;
                stack[size++]=num;
                i--;
            }
            i++;
        }
        if (size>3) {
            return (int)comp(stack[0], comp(stack[2], stack[4], (int)stack[3]), (int)stack[1]);
        }
        if (size>1) {
            return (int)comp(stack[0], stack[2], (int)stack[1]);
        }
        return (int)stack[0];
    }

    public long comp(long n1, long n2, int op) {
        switch (op) {
            case -1:
                return n1+n2;
            case -2:
                return n1-n2;
            case -3:
                return n1*n2;
            case -4:
                return n1/n2;
        }
        return 0;
    }

    // -1:+, -2:-, -3:*, -4:/, -5:(, -6:)
    public int char2Int(char c) {
        switch (c) {
            case '+':
                return -1;
            case '-':
                return -2;
            case '*':
                return -3;
            case '/':
                return -4;
            case '(':
                return -5;
            case ')':
                return -6;
        }
        return 0;
    }
}

// if all the number are positive:
/*
public class Solution {
    public int calculate(String s) {
        // Write your code here
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> nums = new Stack<>();   
        Stack<Character> ops = new Stack<>(); 
        if(s.charAt(0) == '-'){
            nums.push(0);
        }
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' '){
                continue;
            }
            if (Character.isDigit(c)) {	
                num = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                nums.push(num);			
                num = 0; 
            } else if (c == '(') {		
                ops.push(c);
            } else if (c == ')') {		
                while (ops.peek() != '('){		
                    nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop(); 
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {   
                while (!ops.isEmpty() && precedence(c, ops.peek())){	
                    nums.push(operation(ops.pop(), nums.pop(),nums.pop()));
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {    
            nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }

    private static int operation(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;   //加法
            case '-': return a - b;	  //减法
            case '*': return a * b;   //乘法
            case '/': return a / b;   //除法
        }
        return 0;
    }
    private static boolean precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')'){
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')){
            return false;
        }
        return true;
    }
}
*/