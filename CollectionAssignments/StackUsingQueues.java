import java.util.*;

public class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q2.add(x);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) throw new RuntimeException("Stack empty");
        return q1.remove();
    }

    public int top() {
        if (q1.isEmpty()) throw new RuntimeException("Stack empty");
        return q1.peek();
    }

    public static void main(String[] args) {
        StackUsingQueues st = new StackUsingQueues();

        st.push(1);
        st.push(2);
        st.push(3);

        System.out.println("Top element: " + st.top());
        System.out.println("Popped: " + st.pop());
    }
}
