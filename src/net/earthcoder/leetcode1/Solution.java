package net.earthcoder.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    final private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> a2L(final int[] array) {
        return Collections.unmodifiableList(Arrays.stream(array).boxed().collect(Collectors.toList()));
    }

    private void swap(int[] array, int px, int py) {
        final int temp = array[px];
        array[px] = array[py];
        array[py] = temp;
    }

    private void perm(int[] array, int p, int q) {
        if (p == q) {
            final List<Integer> list = a2L(array);
            if (!result.contains(list)) {
                result.add(list);
            }
        } else {
            for (int i = p; i <= q; i++) {
                swap(array, p, i);
                perm(array, p + 1, q);
                swap(array, p, i);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        perm(nums, 0, nums.length - 1);
        return result;
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();

        final int[] nums4 = {1, 1, 2};
        System.out.println(solution.permuteUnique(nums4));
    }
}