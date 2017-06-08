# 557. Reverse Words in a String III

Question desctiption:

```javascript
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.

test case: "Let's take LeetCode contest"
```

* Self Explanation
  * can not use new space
  * set two pointer: start and end
  * if end is ' ', start swap
      * set start to new value at the end of swap
  * else keep end++

## Things need to know
* #### C++
  * Get the length of a string
    * s.length( )
    * s.size( )
  * Swap char in string
    * swap( s[a], s[b] )
    * [reverse( first, last)](http://www.cplusplus.com/reference/algorithm/reverse/)
  * ++i ,  i++ and i+1
    * ++i is add 1 first, then use the new value
    * i++ is use the old value, then add 1
    * i+1 is slower than both above

* #### Java
  * can not change String directly  
    * String do not have index
  * Get the size of char[]
    * <u> int length = s.length; </u>
  * Change String to char[] first
    * Char[] is a char array, which has index can be changed based on the index address
    * char[] a = s.toCharArray();
  * Set return value as String
     * return new String(ca);

## code!
### C++
`````c++
class Solution {
public:
    string reverseWords(string s) {
        int len = s.size() , start = 0, end = 0;
        while( end < len){
            if ( end < len && s[end] != ' ')
            {
                end++;
            }
            else{
                for(int i = start, j = end - 1; i < j; i++,j--){
                    swap(s[i],s[j]);
                }

                start = ++end;
            }
        }
        return s;
    }
};
`````

### Java
``` javascript
public class Solution {
    public String reverseWords(String s) {

        char[] ss = s.toCharArray();
        int len = ss.length;
        int start = 0, end = 0;
        while (start <= end && end < len){
            while(end < len && ss[end] != ' ') {
                end++;
            }
            reverse(ss, start, end-1);
            start = ++end;
        }
        return new String(ss);
    }

    public void reverse(char[] a, int i, int j){
        for(; i < j; i++, j--){
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
// if reverse return a char[] or String, it won't work...
```
# Someother Questions

1. What's the difference between  "a+1" and "a++" in terms of time cost ?
2. in the Jave code, why it won't work if add return value in reverse() ?
3. Why we change String to Char[] in Java but do not need to make changes when we use C++
