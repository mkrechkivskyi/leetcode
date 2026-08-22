package leetcode;

public class ReverseInteger {

    public static void main(String[] args) {
        int i = 432;
        int reverse = new ReverseInteger().reverse(123);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        long reversed = 0;

        while (x != 0) {
            reversed = reversed * 10 + (x % 10);
            x /= 10;
        }

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) reversed;
    }

}
