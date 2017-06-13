# 412. Fizz Buzz
## Description
```
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example: n = 15,
Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

```

## Background
* Convert int to string
  * Three steps
    *   stringstream ss;
    *   ss << i;
    *   string k = ss.str();
  * One step
    * std::string k = std::to_string(i);

## Code
```c++
class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<string> res;
        for(int i = 1; i <= n; i++){
            if(i%3 != 0 && i%5 == 0){
                res.push_back("Buzz");
            }
            else if(i%3 == 0 && i%5 != 0){
                res.push_back("Fizz");
            }
            else if(i%3 == 0 && i%5 == 0){
                res.push_back("FizzBuzz");
            }
            else{
                // stringstream ss;
                // ss << i;
                // string k = ss.str();
                std::string k = std::to_string(i);
                res.push_back(k);
            }
        }
        return res;
    }
};

```
