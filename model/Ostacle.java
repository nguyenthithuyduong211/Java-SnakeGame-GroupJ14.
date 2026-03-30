package model;
public class Obstacle extends GameObject {
    public Obstacle(int x, int y) {
        super(x, y);
    }

    @Override
    public void respawn(int maxWidth, int maxHeight) {
        // Vật cản cố định, không respawn ngẫu nhiên như thức ăn
    }
}
