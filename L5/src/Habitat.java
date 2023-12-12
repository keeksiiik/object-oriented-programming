import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class Habitat {
    private int width;
    private int height;
    private ArrayList<Ant> ants;
    private Set<Integer> idSet;
    private TreeMap<Integer, Ant> bornMap;

    public Habitat(int width, int height) {
        this.width = width;
        this.height = height;
        this.ants = new ArrayList<>();
        this.idSet = new HashSet<>();
        this.bornMap = new TreeMap<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getAntCount() {
        return ants.size();
    }

    public int getWorkerCount() {
        int count = 0;
        for (Ant ant : ants) {
            if (ant instanceof WorkerAnt) {
                count++;
            }
        }
        return count;
    }

    public int getWarriorCount() {
        int count = 0;
        for (Ant ant : ants) {
            if (ant instanceof WarriorAnt) {
                count++;
            }
        }
        return count;
    }

    public TreeMap<Integer, Ant> getBornMap() {
        return bornMap;
    }

    public void update(int time) {
        int workerPeriod = 1;
        double workerProb = 0.5;
        int warriorPeriod = 3;
        double warriorProb = 0.3;

        if (time % workerPeriod == 0 && Math.random() < workerProb && getAntCount() < 500) {
            createWorkerAnt(time);
        }

        if (time % warriorPeriod == 0 && Math.random() < warriorProb && getAntCount() < 500) {
            createWarriorAnt(time);
        }

        for (Ant ant : ants) {
            ant.move();
        }
    }

    private void createWorkerAnt(int time) {
        int id = generateId();
        int x = (int) (Math.random() * (width + 20) - 10);
        int y = (int) (Math.random() * height);

        WorkerAnt workerAnt = new WorkerAnt(id, x, y, width, height);
        ants.add(workerAnt);
        bornMap.put(time, workerAnt);
    }

    private void createWarriorAnt(int time) {
        int id = generateId();
        int x = (int) (Math.random() * (width + 20) - 10);
        int y = (int) (Math.random() * height);

        WarriorAnt warriorAnt = new WarriorAnt(id, x, y, width, height);
        ants.add(warriorAnt);
        bornMap.put(time, warriorAnt);
    }


    private int generateId() {
        int id = (int) (Math.random() * 1000);
        while (idSet.contains(id)) {
            id = (int) (Math.random() * 1000);
        }
        idSet.add(id);
        return id;
    }

    public void draw(Graphics g) {
        int paddingX = 10;
        int paddingY = 25;
        Image img = Toolkit.getDefaultToolkit().getImage("src/resources/patern.jpg");

        int fieldWidth = getWidth() - 2 * paddingX;
        int fieldHeight = getHeight() - 2 * paddingY;

        // g.fillRect(20, 50, fieldWidth, fieldHeight);
        g.drawImage(img, 20, 50, fieldWidth, fieldHeight, null);

        for (Ant ant : ants) {
            ant.draw(g);
        }
    }

}