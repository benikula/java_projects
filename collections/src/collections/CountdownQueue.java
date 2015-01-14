package collections;

import java.util.*;

public class CountdownQueue {
    public static void main(String[] args) throws InterruptedException {
        int time = 6;
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = time; i >= 0; i--)
            queue.add(i);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
            Thread.sleep(1000);
        }
    }
}
