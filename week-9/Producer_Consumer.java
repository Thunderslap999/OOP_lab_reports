import java.util.LinkedList;

public class Producer_Consumer {
    public static void main(String[] args) throws InterruptedException {
        // Create the shared object that holds the list and the methods
        final Processor processor = new Processor();

        // Create the Producer thread
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    System.out.println("Producer interrupted.");
                }
            }
        });

        // Create the Consumer thread
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    System.out.println("Consumer interrupted.");
                }
            }
        });

        // Start both threads at the exact same time
        producerThread.start();
        consumerThread.start();

        // Keep the main thread alive until both are done (which is never, in this loop!)
        producerThread.join();
        consumerThread.join();
    }

    // This class handles the shared data and the synchronized methods
    public static class Processor {
        // A shared list to act as our "buffer"
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 2;

        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    // If the list is full, the producer must wait
                    while (list.size() == capacity) {
                        wait();
                    }

                    System.out.println("Producer produced: " + value);
                    list.add(value++); // Add item to the list

                    // Notify the consumer that there is now data to take
                    notify();

                    // Sleep for a second to make the terminal output readable
                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    // If the list is empty, the consumer must wait
                    while (list.size() == 0) {
                        wait();
                    }

                    // Retrieve and remove the first job in the list
                    int val = list.removeFirst();
                    System.out.println("Consumer consumed: " + val);

                    // Notify the producer that there is now space in the list
                    notify();

                    // Sleep for a second to make the terminal output readable
                    Thread.sleep(1000);
                }
            }
        }
    }
}