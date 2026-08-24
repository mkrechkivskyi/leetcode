package algo;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BinarySearch {
    public static void main(String[] args) {
        int elementCount = 1000;
        int stringMaxSize = 15;
//
//
//        List<Integer> db = new ArrayList<>();
//        for (int i = 0; i < elementCount; i++) {
//            int randomInt = ThreadLocalRandom.current().nextInt(0, elementCount);
//            db.add(randomInt);
//        }
//        Collections.sort(db);
//        BinarySearch binarySearch = new BinarySearch();
//        int randomInt = ThreadLocalRandom.current().nextInt(0, elementCount);
//        boolean integerBinary = binarySearch.findIntegerBinary(db.get(randomInt), db);


        BinarySearch binarySearch = new BinarySearch();
        List<String> db = new ArrayList<>();
        for (int i = 0; i < elementCount; i++) {
            String reqString = UUID.randomUUID().toString().replace("-", "");
            reqString = reqString.substring(0, stringMaxSize);
            db.add(reqString);
        }
        db.sort(Comparator.naturalOrder());
        int randomInt = ThreadLocalRandom.current().nextInt(0, elementCount - 1);
        String toFind = db.get(randomInt);
        binarySearch.findStringBinary(toFind, db);

    }

    public boolean findIntegerBinary(int toSearch, List<Integer> db) {
        int iterationCount = 0;
        boolean found = false;
        int left = 0;
        int right = db.size() - 1; // Індекси йдуть від 0 до size - 1
        while (!found && left <= right) {
            int middle = left + ((right - left) / 2);
            Integer i = db.get(middle);
            if (i == toSearch) {
                System.out.println("Found " + toSearch);
                found = true;
            } else if (i < toSearch) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
            iterationCount++;
        }
        System.out.println("Iteration count " + iterationCount);
        return found;
    }

    public boolean findStringBinary(String toSearch, List<String> db) {
        boolean found = false;
        int left = 0;
        int right = db.size() - 1;

        while (!found && left <= right) {
            int middle =left + (right - left) / 2;
            String middleElement = db.get(middle);
            if (middleElement.equals(toSearch)) {
                System.out.println("Found element at index " + middle);
                return true;
            } else if (middleElement.compareTo(toSearch) < 0) {
                left = middle +1;
            } else {
                right = middle -1;
            }
        }
        return found;
    }
}
