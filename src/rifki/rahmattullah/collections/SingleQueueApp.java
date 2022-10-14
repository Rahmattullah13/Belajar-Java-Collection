package rifki.rahmattullah.collections;

import rifki.rahmattullah.collections.collections.SingleQueue;

import java.util.Queue;

public class SingleQueueApp {
    public static void main(String[] args) {

        Queue<String> queue = new SingleQueue<>();
        System.out.println(queue.size());

        System.out.println(queue.offer("Rifki"));
        System.out.println(queue.offer("Hasby"));
        System.out.println(queue.offer("Agifa"));

        System.out.println(queue.size());

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue.size());
    }
}
