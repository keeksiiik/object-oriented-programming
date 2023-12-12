import java.awt.*;

class WarriorAnt extends Ant {
    public WarriorAnt(int id, int x, int y, int width, int height) {
        super(id, x, y, width, height);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void move() {
        int dx = (int) (Math.random() * 9) - 4;
        int dy = (int) (Math.random() * 9) - 4;

        x += dx;
        y += dy;

        x = Math.max(20, Math.min(x, width - 10));
        y = Math.max(50, Math.min(y, height - 10));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 10, 10);
    }
}