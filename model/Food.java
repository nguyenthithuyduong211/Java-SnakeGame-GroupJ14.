package model;

import java.awt.Color;
import java.util.List;
import java.util.Random;

public class Food extends GameObject {
    private Random random = new Random();
    private Color color = Color.RED;

    public Food(int x, int y) {
        super(x, y);
    }

    public Color getColor() { return color; }
    public void setColor(Color c) { if (c != null) color = c; }

    @Override
    public void respawn(int maxW, int maxH) {
        setX(random.nextInt(maxW));
        setY(random.nextInt(maxH));
    }

    public void respawn(int maxW, int maxH, List<Obstacle> obstacles) {
        do {
            respawn(maxW, maxH);
        } while (collidesWithObstacles(obstacles));
    }

    private boolean collidesWithObstacles(List<Obstacle> obstacles) {
        for (Obstacle o : obstacles) {
            if (o.getX() == getX() && o.getY() == getY()) return true;
        }
        return false;
    }
}
