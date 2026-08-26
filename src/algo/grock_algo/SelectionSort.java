package algo.grock_algo;

import java.util.concurrent.ThreadLocalRandom;

public class SelectionSort<T> {
    public static void main(String[] args) {
        int testElementCount = 10;

        SelectionSort<Integer> integerSelectionSort = new SelectionSort<>();
        Integer[] toSort = new Integer[testElementCount];
        for (int i = 0; i < testElementCount; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt(0, 100);
            toSort[i] = randomInt;
        }
        integerSelectionSort.selectionSort(toSort);}

    void selectionSort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Integer t = arr[i];
            int indexOfMaxElement = findIndexOfMaxElement(arr, i);
            if (indexOfMaxElement != i) {
                Integer max = arr[indexOfMaxElement];
                arr[i] = max;
                arr[indexOfMaxElement] = t;
            }
        }
    }

    private int findIndexOfMaxElement(Integer[] arr, int i) {
        Integer curMax = arr[i];
        int currMaxIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
            Integer cur = arr[j];
            if (cur > curMax) {
                curMax = cur;
                currMaxIndex = j;
            }
        }
        return currMaxIndex;
    }
}
