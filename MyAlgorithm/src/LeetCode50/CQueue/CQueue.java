package LeetCode50.CQueue;

import java.util.Deque;
import java.util.LinkedList;

public class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        if (stack1.isEmpty())
            stack1.push(value);
        else {
            while (!stack1.isEmpty()) {
                int tmp = stack1.pop();
                stack2.push(tmp);
            }
            stack1.add(value);
            while (!stack2.isEmpty()) {
                int tmp = stack2.pop();
                stack1.push(tmp);
            }
        }
    }

    public int deleteHead() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.pop();
    }
}
