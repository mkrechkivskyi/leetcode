package leetcode;

    /*
    I	1
V	5
X	10
L	50
C	100
D	500
M	1000
     */
public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        integerToRoman.intToRoman(3445);

    }

    final static int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    final static String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int N) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; N > 0; i++)
            while (N >= val[i]) {
                ans.append(rom[i]);
                N -= val[i];
            }
        return ans.toString();
    }
}
