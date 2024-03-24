package dsa.leetcode.daily_problems;


import lombok.val;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class P101123_1743 {
    public int[] restoreArray(int[][] a) {
        int siz = a.length;
        Map<Integer, Set<Integer>> elementToIndicesMap = new HashMap<>();
        for (int i = 0; i < siz; i++) {
            for (int j = 0; j < a[i].length; j++) {
                Set<Integer> indices = elementToIndicesMap.getOrDefault(a[i][j], new HashSet<>());
                indices.add(i);
                elementToIndicesMap.put(a[i][j], indices);
            }
        }
        Integer extremum = -1;
        for (Integer element : elementToIndicesMap.keySet()) {
            if ((elementToIndicesMap.get(element).size() & 1) == 1) {
                extremum = element;
            }
        }
        assert extremum != -1;
        int val = extremum;
        int[] ans = new int[siz + 1];
        int ctr = 0;
        while (ctr < (siz + 1)) {
            ans[ctr++] = val;
            Set<Integer> indices = elementToIndicesMap.getOrDefault(val, new HashSet<>());
            if (indices.isEmpty()) {
                break;
            }
            Integer index = indices.iterator().next();
            indices.remove(index);
            elementToIndicesMap.put(val, indices);
            assert Objects.nonNull(index);
            val = ((a[index][0] == val) ? a[index][1] : a[index][0]);
            Set<Integer> indicesOther = elementToIndicesMap.get(val);
            indicesOther.remove(index);
            elementToIndicesMap.put(val, indicesOther);
        }
        return ans;
    }
}

/*
Brainstorming :-
1. Elements having odd number of occurrences will be at polar ends.
2. Actual ordering doesn't matter.
 */