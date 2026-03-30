package model;
import java.util.Random;
public class Food extends GameObject {
    private Random random;

    public Food(int startX, int startY) {
        super(startX, startY); // Gọi Constructor lớp cha
        random = new Random();
    }
    // Tiêu chí: Sử dụng tốt Đa hình 
    @Override
    public void respawn(int maxWidth, int maxHeight) {
        setX(random.nextInt(maxWidth));
        setY(random.nextInt(maxHeight));
    }
}
