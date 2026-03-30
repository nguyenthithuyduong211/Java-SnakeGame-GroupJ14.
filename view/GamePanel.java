package view;
import model.*;
import utils.FileHandler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {
    private final int TILE_SIZE = 25; // Kích thước mỗi ô
    private Timer timer;
    private Snake snake;
    private Food food;
    private int score = 0;
    private int highScore;

    public GamePanel() {
        setBackground(Color.BLACK);
        setFocusable(true);
        highScore = FileHandler.readHighScore(); // Đọc điểm cao từ file
        
        snake = new Snake(5, 5);
        food = new Food(10, 10);
        
        // Timer điều khiển tốc độ rắn (150ms di chuyển 1 lần)
        timer = new Timer(150, this);
        timer.start();

        // Lắng nghe phím mũi tên
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_UP && !snake.getDirection().equals("DOWN")) snake.setDirection("UP");
                if (key == KeyEvent.VK_DOWN && !snake.getDirection().equals("UP")) snake.setDirection("DOWN");
                if (key == KeyEvent.VK_LEFT && !snake.getDirection().equals("RIGHT")) snake.setDirection("LEFT");
                if (key == KeyEvent.VK_RIGHT && !snake.getDirection().equals("LEFT")) snake.setDirection("RIGHT");
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Vẽ thức ăn
        g.setColor(Color.RED);
        g.fillOval(food.getX() * TILE_SIZE, food.getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        // Vẽ rắn
        g.setColor(Color.GREEN);
        for (int[] p : snake.getBody()) {
            g.fillRect(p[0] * TILE_SIZE, p[1] * TILE_SIZE, TILE_SIZE - 2, TILE_SIZE - 2);
        }

        // Vẽ điểm số
        g.setColor(Color.WHITE);
        g.drawString("Điểm: " + score + " | Cao nhất: " + highScore, 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (snake.isAlive()) {
            snake.move();
            checkEat();
            checkCollision();
        }
        repaint();
    }

    private void checkEat() {
        int[] head = snake.getBody().get(0);
        if (head[0] == food.getX() && head[1] == food.getY()) {
            snake.grow();
            food.respawn(20, 20); // Tạo mồi mới
            score += 10;
        }
    }

    private void checkCollision() {
        int[] head = snake.getBody().get(0);
        // Va chạm tường (Giới hạn 24x24 ô)
        if (head[0] < 0 || head[0] >= 24 || head[1] < 0 || head[1] >= 24) {
            gameOver();
        }
    }

    private void gameOver() {
        snake.setAlive(false);
        timer.stop();
        if (score > highScore) {
            try {
                FileHandler.saveHighScore(score); // Lưu điểm mới vào file
            } catch (Exception e) { e.printStackTrace(); }
        }
        JOptionPane.showMessageDialog(this, "Game Over! Điểm của bạn: " + score);
    }
}
