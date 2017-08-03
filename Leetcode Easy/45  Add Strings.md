# 415. Add Strings
## Description
```
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

```
## Background

* <b><u>Convert char to int </b>
  * char c = '7' ;
  * int number = c - '0'; // this will return int 7


* <b><u>Convert int to  char </b>
  * int number = 7 ;
  * char c = number + '0'; // this will return char '7'


* Convert <b><u>vector<int></b> v into <b><u>string</b>
  * stringstream ss;
  * copy( v.begin() , v.end() , ostream_iterator<int>(ss, ""));
  * string s = ss.str();
  * s = s.substr(0, s.length());
  * return s;                  // this will return string s
  *

## Code

```c++
class Solution {
public:
    string addStrings(string num1, string num2) {
        int s1 = num1.size()-1;
        int s2 = num2.size() -1;
        int flag = 0;
        vector<int> v;
        for(int i = s1, j = s2; i>=0 && j>=0 ;i--, j--){
            int a = num1[i], b = num2[j];
            int res = flag + (num1[i] -'0' )+ (num2[j] - '0') ;
            flag = res/10;
            v.push_back(res%10);
        }

        if(s1 > s2){
            for(int i = s1-s2-1; i >=0 ; i--){
               v.push_back((num1[i] -'0' + flag)%10 );
                flag = (num1[i] -'0' + flag)/10 ;
            }
            cout<<endl;
        }
         if(s1 < s2){
            for(int i = s2-s1-1; i >=0 ; i--){
               v.push_back((num2[i] -'0' + flag)%10 );
                flag = (num2[i] -'0' + flag)/10 ;
            }
            cout<<endl;
        }

        if(flag ==1){
            v.push_back(flag);
        }
        for(int i = 0; i < v.size()/2; i++){
            swap(v[i],v[v.size()-i-1]);
        }

        stringstream ss;
        copy( v.begin() , v.end() , ostream_iterator<int>(ss, ""));
        string s = ss.str();
        s = s.substr(0, s.length());

        return s;
    }
};
```
###### Second better solution
```c++

class Solution {
public:
    string addStrings(string num1, string num2) {
        int s1 = num1.size() -1 ;
        int s2 = num2.size() -1 ;
        int flag = 0;
        string res = "";
        for( int i = s1, j = s2; i >=0 || j>= 0; j--,i--){
            int a = i >= 0 ? num1[i]- '0' : 0;
            int b = j >= 0 ? num2[j]- '0' : 0;
            res.insert(res.begin(), (a + b + flag) % 10 + '0');
            flag = (a + b + flag)/10;
        }
        return flag ? "1" + res : res;
    }
};

```
