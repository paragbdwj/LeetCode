/*
You are playing a video game where you are defending your city from a group of n monsters. You are given a 0-indexed integer array dist of
size n, where dist[i] is the initial distance in kilometers of the ith monster from the city.

The monsters walk toward the city at a constant speed. The speed of each monster is given to you in an integer array speed of size n,
where speed[i] is the speed of the ith monster in kilometers per minute.

You have a weapon that, once fully charged, can eliminate a single monster. However, the weapon takes one minute to charge. The weapon is
fully charged at the very start.

You lose when any monster reaches your city. If a monster reaches the city at the exact moment the weapon is fully charged, it counts as a
loss, and the game ends before you can use your weapon.

Return the maximum number of monsters that you can eliminate before you lose, or n if you can eliminate all the monsters before they reach the city.



Example 1:

Input: dist = [1,3,4], speed = [1,1,1]
Output: 3
Explanation:
In the beginning, the distances of the monsters are [1,3,4]. You eliminate the first monster.
After a minute, the distances of the monsters are [X,2,3]. You eliminate the second monster.
After a minute, the distances of the monsters are [X,X,2]. You eliminate the third monster.
All 3 monsters can be eliminated.

Example 2:

Input: dist = [1,1,2,3], speed = [1,1,1,1]
Output: 1
Explanation:
In the beginning, the distances of the monsters are [1,1,2,3]. You eliminate the first monster.
After a minute, the distances of the monsters are [X,0,1,2], so you lose.
You can only eliminate 1 monster.
Example 3:

Input: dist = [3,2,4], speed = [5,3,2]
Output: 1
Explanation:
In the beginning, the distances of the monsters are [3,2,4]. You eliminate the first monster.
After a minute, the distances of the monsters are [X,0,2], so you lose.
You can only eliminate 1 monster.


Constraints:

n == dist.length == speed.length
1 <= n <= 105
1 <= dist[i], speed[i] <= 105
*/

package dsa.problems.leetcode.daily_problems;

import java.util.*;

public class P071123_1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        List<Integer> times = new ArrayList<>();
        int siz = dist.length;
        if (siz == 1) {
            boolean b = (dist[0] != 0);
            if (b) return 1;
            return 0;
        }
        int maxTime = 0;
        assert speed.length == siz;
        for (int i = 0; i < siz; i++) {
            times.add(ceil(dist[i], speed[i]));
            maxTime = Math.max(maxTime, times.get(i));
        }
        Collections.sort(times);
        int ctr = 0;
        for (int time = 0; time <= maxTime; time++) {
            if (times.get(ctr) <= time) {
                return ctr;
            }
            ctr++;
            if (ctr == times.size()) {
                break;
            }
        }
        return siz;
    }

    private Integer ceil(int x, int y) {
        return (x + y - 1) / y;
    }
}



/*
    Brainstorming :
    time = ceil (distance / speed)
    ceil (a/b) = floor ((a+b-1)/b)
 */