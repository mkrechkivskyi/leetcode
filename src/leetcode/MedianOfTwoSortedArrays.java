package leetcode;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] ints = {1, 2};
        int[] ints1 = {3, 4};
        double medianSortedArrays = new MedianOfTwoSortedArrays().findMedianSortedArrays(ints, ints1);
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = nums1.length + nums2.length;
        //todo process if left or right is empty
        int requiredIndex = i / 2;
        int index = 0;
        int leftPos = 0;
        int rightPos = 0;
        int[] ints = new int[1000];
        for (int j = 0; j < 1000; j++) {
            int left = nums1.length > leftPos ? nums1[leftPos] : 999999999;
            int right = nums2.length > rightPos ? nums2[rightPos] : 999999999;
            if (left < right) {
                ints[index] = left;
                leftPos++;
            } else {
                rightPos++;
                ints[index] = right;
            }
            if (index == requiredIndex) {
                if (i % 2 != 0) {
                    if (left < right) {
                        return left;
                    } else {
                        return right;
                    }
                } else {
                    double first = 0.0;
                    if (left < right) {
                        first = left;
                        left = nums1[j + 1];
                        if (left < right) {
                            double res = (first + left) / 2;
                            return res;
                        } else {
                            double res = (first + right) / 2;
                            return res;
                        }
                    } else {
                        first = right;
                        right = nums2[leftPos + 1];
                        if (left < right) {
                            double res = (first + left) / 2;
                            return res;
                        } else {
                            double res = (first + right) / 2;
                            return res;
                        }
                    }
                }
            }
            index++;
        }
        return 0.0;
    }
}
