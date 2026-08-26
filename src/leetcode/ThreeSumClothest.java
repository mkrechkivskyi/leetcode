package leetcode;

import java.util.Arrays;

public class ThreeSumClothest {

    public static void main(String[] args) {
        int[] testCase = new int[]{-1, 2, 1, -4};
        int target = 1;
        ThreeSumClothest threeSumClothest = new ThreeSumClothest();
        System.out.println(threeSumClothest.threeSumClosest(testCase, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2]; // Initial best guess

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }

                if (sum == target) return target;
                else if (sum < target) left++;
                else right--;
            }
        }

        return result;
    }
//    public int threeSumClosest(int[] nums, int target) {
//        int res = target + 9999999;
//        for (int i = 0; i < nums.length; i++) {
//            int left = 0;
//            int right = nums.length - 1;
//            while (right > left) {
//                if (left != i && right != i) {
//                    int first = nums[left];
//                    int second = nums[i];
//                    int third = nums[right];
//                    int sum = first + second +third;
//                    if (Math.abs(sum - target) < Math.abs(res - target)) {
//                        res = sum;
//                    }
//                    left++;
//                    right--;
//                } else if (left == i){
//                    left++;
//                } else if (right == i) {
//                    right--;
//                }
//            }
//        }
//        return res;
//    }
    // 1,2,3,4,5,6
    //1,2,6,
    //2,3,5

}
