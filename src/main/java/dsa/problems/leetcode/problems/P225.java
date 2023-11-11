/*
225. Implement Stack using Queues

Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you
use only a queue's standard operations.


Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False


Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, top, and empty.
All the calls to pop and top are valid.
 */

package dsa.problems.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class P225 {

    private static class MyStackUsingTwoQueues {
        Queue<Integer> q1,q2;
        public MyStackUsingTwoQueues() {
            q1 =  new LinkedList<>();
            q2 =  new LinkedList<>();
        }

        public void push(int x) {
            q1.add(x);
        }

        public int pop() {
            int popper = -1;
            while(!q1.isEmpty()) {
                popper = q1.poll();
                if(!q1.isEmpty()) {
                    q2.add(popper);
                }
            }
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
            return popper;
        }

        public int top() {
            int topper = -1;
            while(!q1.isEmpty()) {
                topper = q1.poll();
                q2.add(topper);
            }
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
            return topper;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

    private static class MyStackUsingOneQueue {
        Queue<Integer> q;

        public MyStackUsingOneQueue() {
            q = new LinkedList<>();
        }

        public void push(int x) {
            q.add(x);
            for (int i = 0; i <= q.size() - 2; i++) {
                q.add(q.poll());
            }
        }

        public int pop() {
            return q.isEmpty() ? -1 : q.poll();
        }

        public int top() {
            return q.isEmpty() ? -1 : q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }


}
