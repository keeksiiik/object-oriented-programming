import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

public class SimulationFrame extends JFrame {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private boolean isRunning = false;
    private boolean isPaused = false;
    private int time = 0;
    private Timer timer = null;
    private Habitat habitat = null;

    private JButton startButton;
    private JButton stopButton;
    private JButton pauseButton;
    private JTextArea infoTextArea;
    private JCheckBox showInfoCheckBox;
    private JPanel spawnPanel;
    private  JPanel infoPanel;

    public SimulationFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ant Simulation");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());

        spawnPanel = new JPanel();
        spawnPanel.setBackground(Color.WHITE);
        spawnPanel.setLayout(new BorderLayout());
        spawnPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(spawnPanel, BorderLayout.CENTER);


        infoTextArea = new JTextArea(10, 20);
        infoTextArea.setEditable(false);
        infoTextArea.setBackground(Color.LIGHT_GRAY);

        JTextField workerPeriod = new JTextField(20);
        workerPeriod.setText("1");
        JTextField warriorPeriod = new JTextField(20);
        warriorPeriod.setText("3");
        Integer[] probability = {1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        JComboBox workerProbability = new JComboBox(probability);
        workerProbability.setToolTipText("Вероятность рождения рабочего муравья");
        JComboBox warriorProbability = new JComboBox(probability);
        workerProbability.setToolTipText("Вероятность рождения муравья война");

        infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setSize(50,100);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        infoPanel.add(infoTextArea, BorderLayout.NORTH);
        infoPanel.add(workerPeriod);
        infoPanel.add(workerProbability);
        infoPanel.add(warriorPeriod);
        infoPanel.add(warriorProbability);


        getContentPane().add(infoPanel, BorderLayout.EAST);

        JPanel controlPanel = new JPanel(new FlowLayout());
        getContentPane().add(controlPanel, BorderLayout.SOUTH);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        stopButton.setEnabled(false);
        pauseButton = new JButton("Pause/Resume");
        pauseButton.setEnabled(false);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                startSimulation();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                stopSimulation();
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                pauseSimulation();
            }
        });

        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(pauseButton);

        showInfoCheckBox = new JCheckBox("Show Information");
        showInfoCheckBox.setSelected(true);
        infoTextArea.setText("Time: \n" +
                "Ants: \n" +
                "Workers: \n" +
                "Warriors: \n" +
                "Last Born: \n");
        showInfoCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if (showInfoCheckBox.isSelected()) {
                    infoTextArea.setText("Time: \n" +
                            "Ants: \n" +
                            "Workers: \n" +
                            "Warriors: \n" +
                            "Last Born: \n");
                } else {
                    infoTextArea.setText("");
                }
            }
        });
        controlPanel.add(showInfoCheckBox);
    }

    private void startSimulation() {
        if (!isRunning) {
            isRunning = true;
            time = 0;
            habitat = new Habitat(675, 500);
            timer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    if (!isPaused) {
                        time++;
                        habitat.update(time);
                        repaint();
                    }
                }
            });
            timer.start();
            showInfoCheckBox.setEnabled(false);
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
            pauseButton.setEnabled(true);

            System.out.println("Simulation started");
        }
    }

    private void stopSimulation() {
        if (isRunning) {
            isRunning = false;
            isPaused = false;
            time = 0;
            habitat = null;
            timer.stop();
            showInfoCheckBox.setEnabled(true);
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            pauseButton.setEnabled(false);

            System.out.println("Simulation stopped");
        }
    }

    private void pauseSimulation() {
        isPaused = !isPaused;
        System.out.println(isPaused ? "Simulation paused" : "Simulation resumed");
    }

    public void paint(Graphics g) {
        super.paint(g);

        if (isRunning && habitat != null) {
            habitat.draw(g);

            if (showInfoCheckBox.isSelected()) {
                infoTextArea.setText(getSimulationInfo());
            }
        }
    }

    private String getSimulationInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Time: ").append(time).append("\n");
        info.append("Ants: ").append(habitat != null ? habitat.getAntCount() : 0).append("\n");
        info.append("Workers: ").append(habitat != null ? habitat.getWorkerCount() : 0).append("\n");
        info.append("Warriors: ").append(habitat != null ? habitat.getWarriorCount() : 0).append("\n");
        info.append("Last Born:\n").append(getLastBornAntInfo()).append("\n");
        System.out.println(habitat.getAntCount());
        return info.toString();
    }

    private String getLastBornAntInfo() {
        StringBuilder info = new StringBuilder();

        TreeMap<Integer, Ant> bornMap = habitat.getBornMap();
        for (Map.Entry<Integer, Ant> entry : bornMap.descendingMap().entrySet()) {
            int time = entry.getKey();
            Ant ant = entry.getValue();
            String antType = (ant instanceof WorkerAnt) ? "Worker" : "Warrior";
            info.append(antType).append(" Ant - ID: ").append(ant.getId()).append(", Time: ").append(time).append("\n");
        }

        return info.toString();
    }
}
