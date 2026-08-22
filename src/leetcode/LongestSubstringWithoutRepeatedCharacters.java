package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatedCharacters {

    public static void main(String[] args) {
        String test = "1R1T7  ";
        int i = new LongestSubstringWithoutRepeatedCharacters().lengthOfLongestSubstring(test);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);

            } else {
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
                set.add(s.charAt(right));
            }

        }
        return maxLength;
    }
//    public int lengthOfLongestSubstring(String s) {
//        if (s.isEmpty()) {
//            return 0;
//        }
//        int res = 0;
//        int repCount = 0;
//        char[] charArray = s.toCharArray();
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < charArray.length; i++) {
//            char c = charArray[i];
//            if (map.containsKey(c)) {
//                if (repCount == 0) {
//                    res = i;
//                    repCount ++;
//                }
//                Integer indexExisted = map.get(c);
//                if (res <= i - indexExisted) {
//                    res = i - indexExisted;
//                }
//                map.put(c, i);
//            } else {
//                map.put(c, i);
//            }
//        }
//        return res;
//
//    }


    //todo worked by very bad(first try)


//    public int lengthOfLongestSubstring(String s) {
//        if (s.isEmpty()) {
//            return 0;
//        }
//        int res = 1;
//
//        char[] charArray = s.toCharArray();
//        char firstChar = charArray[0];
//        StringBuilder curStr = new StringBuilder();
//        curStr.append(firstChar);
//        HashSet<Character> charSet = new HashSet<>();
//        charSet.add(firstChar);
//
//        for (int i = 1; i < charArray.length; i++) {
//            char c = charArray[i];
//            if (!charSet.contains(c)) {
//                charSet.add(c);
//                curStr.append(c);
//            } else {
//                int i1 = curStr.indexOf(String.valueOf(c));
//                int curSize = curStr.length() - i1;
//                if (curSize > res) {
//                    res = curSize;
//                }
//                String substring = curStr.substring(i1 + 1, curStr.length());
////                normalizeHashSet(substring, charSet);
//                if (charSet.size() > res ) {
//                    res = charSet.size();
//                }
//                curStr = new StringBuilder(substring).append(c);
//                //                if (charSet.size() > res) {
////                    res = charSet.size();
////                }
//                charSet.clear();
//                curStr.chars().forEach(v -> charSet.add((char) v ));
//
//                charSet.add(c);
//            }
//        }
//        if (charSet.size() > res) {
//            res = curStr.length();
//        }
//        return res;
//    }


}
