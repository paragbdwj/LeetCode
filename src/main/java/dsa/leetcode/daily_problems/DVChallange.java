package dsa.leetcode.daily_problems;

public class DVChallange {

    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer x = 1000000000;
        Integer y = 1000000000;
        assert a == b;
        assert x == y;
    }
}

/*

DV :-

 you're given an array A = {1, 2, 3, 4}
 i = 1 => tap next 1 element with cost of A[i-1]
 i = 2 => tap next 2 elements with cost of A[i-1]
 you've to tap all elements with min cost
 ex cost = 1 + 2 = 3
 [1, 20, 2, 40, 7]


 ^
 index

 f(index) = A[index - 1] + min(f(index + 1) , f(index + 2) ...f(index + index))
 if(index ==  n) {
        return 0;
    }

// dp + segment tree

PB :-

                        a
                      /   \
                     b      c
                   /  \    /  \
                  d    e


                  f(TreeNode node) {
                    while(left != null) { leftctr++; left = node.left}
                    while(right != null) { rightctr++; right = node.right}

                    if(left == right)
                        return (rightctr - leftctr)<<1;

                     return 
                  }
 */


