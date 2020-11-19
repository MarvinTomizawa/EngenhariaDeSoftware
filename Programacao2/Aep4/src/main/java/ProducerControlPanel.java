import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProducerControlPanel extends JDialog {
    private JobQueue jobs = new JobQueue();
    private List<Consumer> consumers = new ArrayList<>();
    private List<Producer> producers = new ArrayList<>();

    public  ProducerControlPanel(){
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.add(createPanel());
    }

    private JPanel createPanel() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createRaisedBevelBorder());

        configureProducerPanel(panel);
        configureConsumerPanel(panel);
        configureJobPanel(panel);

        return panel;
    }

    private void configureJobPanel(JPanel panel) {
        final JPanel thirdRowPanel = new JPanel();
        thirdRowPanel.setLayout(new BoxLayout(thirdRowPanel, BoxLayout.X_AXIS));
        thirdRowPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        thirdRowPanel.add(new JLabel("Job count:    "));
        final JTextField fieldJobCount = new JTextField(20);
        fieldJobCount.setEnabled(false);
        fieldJobCount.setMaximumSize(fieldJobCount.getPreferredSize());
        thirdRowPanel.add(fieldJobCount);
        thirdRowPanel.add(Box.createHorizontalGlue());

        this.jobs.addJobQueueListener(jobCount -> {
            fieldJobCount.setText(String.valueOf(jobCount));
        });

        panel.add(thirdRowPanel);
    }

    private void configureConsumerPanel(JPanel panel) {
        final JPanel secondRowPanel = new JPanel();
        secondRowPanel.setLayout(new BoxLayout(secondRowPanel, BoxLayout.X_AXIS));
        secondRowPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        secondRowPanel.add(new JLabel("Consumers: "));
        final JTextField fieldConsumerCount = new JTextField(20);
        final JButton btnAddConsumer = new JButton(" + ");
        btnAddConsumer.addActionListener(e -> {
            Consumer newConsumer = new Consumer(jobs);
            consumers.add(newConsumer);
            fieldConsumerCount.setText(String.valueOf(consumers.size()));
            newConsumer.start();
        });
        fieldConsumerCount.setEnabled(false);
        fieldConsumerCount.setMaximumSize(fieldConsumerCount.getPreferredSize());
        btnAddConsumer.setMaximumSize(btnAddConsumer.getPreferredSize());
        secondRowPanel.add(fieldConsumerCount);
        secondRowPanel.add(btnAddConsumer);
        secondRowPanel.add(Box.createHorizontalGlue());

        panel.add(secondRowPanel);
    }

    private void configureProducerPanel(JPanel panel) {
        final JPanel firstRowPanel = new JPanel();
        firstRowPanel.setLayout(new BoxLayout(firstRowPanel, BoxLayout.X_AXIS));
        firstRowPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        firstRowPanel.add(new JLabel("Producers:   "));
        final JTextField fieldProducerCount = new JTextField(20);
        final JButton btnAddProducer = new JButton(" + ");
        btnAddProducer.addActionListener(e -> {
            Producer newProducer = new Producer(jobs);
            producers.add(newProducer);
            fieldProducerCount.setText(String.valueOf(producers.size()));
            newProducer.start();
        });
        fieldProducerCount.setEnabled(false);
        fieldProducerCount.setMaximumSize(fieldProducerCount.getPreferredSize());
        btnAddProducer.setMaximumSize(btnAddProducer.getPreferredSize());
        firstRowPanel.add(fieldProducerCount);
        firstRowPanel.add(btnAddProducer);
        firstRowPanel.add(Box.createHorizontalGlue());
        panel.add(firstRowPanel);
    }
}
