package leetcode;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] test = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        removeDuplicatesFromSortedArray.removeDuplicates(test);
    }

    public int removeDuplicates(int[] nums) {
        int k = 1; // Initialize the count of unique elements to 1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i]; // Overwrite the next unique element
                k++;
            }
        }

        return k;
    }
}
