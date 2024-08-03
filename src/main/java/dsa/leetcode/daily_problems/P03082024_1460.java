package dsa.leetcode.daily_problems;

import dsa.leetcode.helper.FastReader;
import dsa.leetcode.helper.FastWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class P03082024_1460 {

    public boolean canBeEqual(int[] target, int[] arr) {
        assert target.length == arr.length;
        List<Integer> sortedArr = Arrays.stream(arr).boxed().sorted().toList();
        List<Integer> sortedTarget = Arrays.stream(target).boxed().sorted().toList();
        for(int index = 0; index < sortedTarget.size(); index++) {
            if(!sortedArr.get(index).equals(sortedTarget.get(index)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
            FastReader reader = new FastReader();
            FastWriter writer = new FastWriter();
            int testCases = reader.nextInt();
            while (testCases-- > 0) {
                // write output commands here

            }
            writer.close();
        }
}
