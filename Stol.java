import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Stol {
    public BlockingQueue queue = new ArrayBlockingQueue(5);


    public void produce() throws InterruptedException {
        Random rand = new Random();
        Thread.sleep(200);
        queue.put(rand.nextInt(10));
        System.out.println("Ya sdelal " + queue.size()+ "\n");
    }

    public void consume() throws InterruptedException {
            Random rand = new Random();
            Thread.sleep(100);
            queue.take();
            System.out.println("Ya s'el " + queue.size()+ "\n");
    }

    public void stopAllProducersAndConsumers() {
        Thread.currentThread().interrupt();
        System.exit(0);
    }

}
