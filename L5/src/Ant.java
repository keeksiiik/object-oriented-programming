import java.awt.*;

abstract class Ant implements IBehaviour{
    protected int id;
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public Ant(int id, int x, int y, int width, int height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public abstract int getX();
    public abstract int getY();

    public abstract void move();

    public abstract void draw(Graphics g);
}