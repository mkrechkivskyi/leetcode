package leetcode;

public class Palindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] charArray = String.valueOf(x).toCharArray();
        int start = 0;
        int end = charArray.length-1;
        for (int i = 0; i < charArray.length; i++) {
            if (start > end) {
                return true;          }
            if (charArray[start] != charArray[end]) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }
}
