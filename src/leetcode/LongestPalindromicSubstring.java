package leetcode;

public class LongestPalindromicSubstring {


    public String longestPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = s.toCharArray();
        if (s.length() < 2) {
            return s;
        }
        for (int i = 1; i < charArray.length; i++) {
            StringBuilder palindromeByCenter = findPalindromeByCenter(i, new StringBuilder().append(charArray[i]), charArray, 1);
            if (stringBuilder.length() < palindromeByCenter.length()) {
                stringBuilder = palindromeByCenter;
            }
            if (charArray[i - 1] == charArray[i]) {
                StringBuilder forPairedCenter = findPalindromeByPairCenter(i, new StringBuilder().append(charArray[i - 1]).append(charArray[i]), charArray, 1);
                if (forPairedCenter != null && stringBuilder.length() < forPairedCenter.length()) {
                    stringBuilder = forPairedCenter;
                }
            }
        }

        return stringBuilder.toString();
    }

    private StringBuilder findPalindromeByPairCenter(int i, StringBuilder res, char[] charArray, int offset) {
        if (i - offset - 1 >= 0 && i + offset < charArray.length) {
            if (charArray[i - offset - 1] == charArray[i + offset]) {
                res.insert(0, charArray[i - offset - 1]);
                res.append(charArray[i + offset]);
                return findPalindromeByPairCenter(i, res, charArray, offset + 1);
            }
        }

        return res;
    }

    private StringBuilder findPalindromeByCenter(int i, StringBuilder res, char[] charArray, int offset) {
        if (i - offset >= 0 && i + offset < charArray.length) {
            if (charArray[i - offset] == charArray[i + offset]) {
                res.insert(0, charArray[i - offset]);
                res.append(charArray[i + offset]);
                return findPalindromeByCenter(i, res, charArray, offset + 1);
            }
        }
        return res;
    }
}
