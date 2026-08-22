package leetcode;

public class RemoveElement {

    public static void main(String[] args) {
        int[] first = {0, 1, 2, 2, 3, 0, 4, 2};
        int i = new RemoveElement().removeElement(first, 2);
        System.out.println(i);
    }

    // число 2
// 1,3,2,4
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        boolean needToMove = false;
        int repeatCount = 0;
        int needToUpdateIndex = -1;
        if (nums[0] == val) {
            nums[0] = 0;
            repeatCount = 1;
            needToUpdateIndex = 0;
            needToMove = true;
        }
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == val) {
                nums[i] = 0;
                needToMove = true;
                repeatCount++;
                if (needToUpdateIndex == -1) {
                    needToUpdateIndex = i;
                }
            } else if (needToMove) {
                nums[needToUpdateIndex] = num;
                nums[i] = 0;
                needToUpdateIndex++;
            }
        }
        return nums.length -repeatCount;
    }
}
