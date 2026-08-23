package leetcode;

import java.util.*;

public class ThreeSum {


    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 0};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(ints);
        System.out.println(lists);

    }
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i])) {
            for (int j = i + 1; j < nums.length; ++j) {
                int complement = -nums[i] - nums[j];
                if (seen.containsKey(complement) && seen.get(complement) == i) {
                    List<Integer> triplet = Arrays.asList(
                            nums[i],
                            nums[j],
                            complement
                    );
                    Collections.sort(triplet);
                    res.add(triplet);
                }
                seen.put(nums[j], i);
            }
        }
        return new ArrayList(res);
    }


//    //todo my solution good for space but terrible for speed
//    public List<List<Integer>> threeSum(int[] nums) {
//        Set<List<Integer>> result = new HashSet<>();
//        Map<Integer, Integer> db = new HashMap<>();
//        for (int num : nums) {
//            if (db.containsKey(num)) {
//                db.put(num, db.get(num) + 1);
//            } else {
//                db.put(num, 1);
//            }
//        }
//        ArrayList<Integer> integers = new ArrayList<>(db.keySet());
//        if (integers.size() < 2 && db.containsKey(0) && db.get(0) > 2) {
//            result.add(List.of(0, 0, 0));
//        } else {
//            for (int i = 0; i < integers.size(); i++) {
//                int first = integers.get(i);
//                for (int j = 1; j < integers.size(); j++) {
//                    int second = integers.get(j);
//                    int required = -(first + second);
//                    if (required == 0) {
//                        Integer get = db.get(0);
//                        if (get != null && get > 2) {
//                            result.add(List.of(0, 0, 0));
//                        }
//                    } else if (required == first || required == second) {
//                        if (db.get(required) > 1 && db.containsKey(required)) {
//                            fill(first, second, required, result);
//                        }
//                    } else if (first == second) {
//                        if (db.get(first) > 1 && db.containsKey(required)) {
//                            fill(first, second, required, result);
//                        }
//                    } else if (db.containsKey(required)) {
//                        fill(first, second, required, result);
//                    }
//                }
//            }
//        }
//        if (db.get(0) != null && db.get(0) > 2) {
//            result.add(List.of(0, 0, 0));
//        }
//        return new ArrayList<>(result);
//    }
//
//    private static void fill(int first, int second, int required, Set<List<Integer>> result) {
//        List<Integer> first1 = new ArrayList<>(List.of(first, second, required));
//        first1.sort(Comparator.naturalOrder());
//        result.add(first1);
//    }
}
