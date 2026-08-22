package leetcode;
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder res =  new StringBuilder();
        for (int i = 0; i < 200; i++) {
            boolean isConditionCorrect = true;
            char curCharValid = 0;
            for (int j = 0; j < strs.length; j++) {
                String str = strs[j];
                if (str.length() <= i) {
                    isConditionCorrect = false;
                    break;
                }
                char ch = str.charAt(i);
                if (curCharValid == 0) {
                    curCharValid = ch;
                } else {
                    if (curCharValid != ch) {
                        isConditionCorrect = false;
                    }
                }
            }
            if (isConditionCorrect) {
                res = res.append(curCharValid);
            } else {
                break;
            }
        }
        return res.toString();
    }
}
