import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyAWTApp {
    public static void showForm(Stol stol) {
        Frame frame = new Frame("Producer-Consumer Lab");
        frame.setLayout(new FlowLayout());
        frame.setSize(new Dimension(700,800));

        Label producerLabel1 = new Label("Количество Producer'ов:");
        TextField producerTextField = new TextField(10);

        Label consumerLabel1 = new Label("Количество Consumer'ов:");
        TextField consumerTextField = new TextField(10);

//CUNSOMER
        Label label1 = new Label("Consumer:");

        Panel consumerPanel = new Panel();
        consumerPanel.setPreferredSize(new Dimension(180,100));
        consumerPanel.setBackground(Color.RED);
//PRODUCER
        Label label2 = new Label("Producer:");

        Panel producerPanel = new Panel();
        producerPanel.setPreferredSize(new Dimension(180, 100));
        producerPanel.setBackground(Color.RED);

        Button startButton = new Button("Start");

        Button stopButton = new Button("Stop");

        frame.add(producerLabel1);
        frame.add(producerTextField);
        frame.add(consumerLabel1);
        frame.add(consumerTextField);
        frame.add(stopButton);
        frame.add(startButton);
        frame.add(label1);
        frame.add(consumerPanel);
        frame.add(label2);
        frame.add(producerPanel);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int prod = Integer.parseInt(producerTextField.getText());
                int cons = Integer.parseInt(consumerTextField.getText());

                for (int i = 0; i < cons; i++) {
                    Consumer consumer = new Consumer(stol, consumerPanel);
                    consumer.start();
                }

                for (int i = 0; i < prod; i++) {
                    Producer producer = new Producer(stol, producerPanel);
                    producer.start();
                }

            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stol.stopAllProducersAndConsumers();
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
