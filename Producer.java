import javax.swing.*;
import java.awt.*;

public class Producer extends Thread{
    private final Stol queue;
    private final Panel panel;


    public Producer(Stol queue, Panel panel) {
        this.queue = queue;
        this.panel = panel;
    }


    @Override
    public void run() {
        while (true) {
            try {
                panel.setBackground(Color.RED);
                queue.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            panel.setBackground(Color.BLUE);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
