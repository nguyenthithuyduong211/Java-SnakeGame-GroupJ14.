package view;

import controller.GameController;
import model.Obstacle;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.List;

public class GamePanel extends JPanel {
    private final GameController controller;
    private int gridSize = 15;
    private static final int HEADER_HEIGHT = 80;

    public GamePanel(GameController c) {
        this.controller = c;
        setLayout(null);
        setFocusable(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                controller.handleKeyPress(e.getKeyCode());
            }
        });

        JButton pauseBtn = new JButton("(P) Tạm dừng");
        pauseBtn.setBounds(420, 15, 150, 40);
        pauseBtn.setBackground(new Color(0, 86, 150));
        pauseBtn.setForeground(Color.WHITE);
        pauseBtn.setFont(new Font("Arial", Font.BOLD, 14));
        pauseBtn.addActionListener(e -> controller.togglePause());
        add(pauseBtn);
    }

    public void updateGridSize(int newSize) {
        this.gridSize = newSize;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics raw) {
        super.paintComponent(raw);
        Graphics2D g = (Graphics2D) raw;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int availableHeight = getHeight() - HEADER_HEIGHT;

        int side = Math.min(w, availableHeight);
        int tile = side / gridSize;
        int offsetX = (w - tile * gridSize) / 2;
        int offsetY = HEADER_HEIGHT + (availableHeight - tile * gridSize) / 2;

        // Header
        g.setColor(new Color(0, 86, 150));
        g.fillRect(0, 0, w, HEADER_HEIGHT);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 26));

        String levelText = controller.isLevelMode() ? "Màn " + controller.getCurrentLevel() : "Vô tận";
        g.drawString(levelText, 30, 55);

        String foodText = "Mồi: " + controller.getEatenFood() + "/" + 
                         (controller.isLevelMode() ? controller.getRequiredFood() : "∞");
        g.drawString(foodText, 220, 55);

        // Nền map
        for (int r = 0; r < gridSize; r++) {
            for (int c = 0; c < gridSize; c++) {
                g.setColor((r + c) % 2 == 0 ? new Color(170, 215, 81) : new Color(155, 200, 70));
                g.fillRect(offsetX + c * tile, offsetY + r * tile, tile, tile);
            }
        }

        // ==================== VẬT CẢN (Thùng gỗ đồng bộ) ====================
        for (Obstacle o : controller.getObstacles()) {
            int x = offsetX + o.getX() * tile;
            int y = offsetY + o.getY() * tile;

            // Thân thùng gỗ
            g.setColor(new Color(139, 69, 19));
            g.fillRoundRect(x + 4, y + 4, tile - 8, tile - 8, 10, 10);

            // Viền sáng
            g.setColor(new Color(180, 100, 40));
            g.drawRoundRect(x + 6, y + 6, tile - 12, tile - 12, 8, 8);

            // Dấu X
            g.setColor(new Color(80, 40, 10));
            g.setStroke(new BasicStroke(3.5f));
            g.drawLine(x + 10, y + 10, x + tile - 10, y + tile - 10);
            g.drawLine(x + 10, y + tile - 10, x + tile - 10, y + 10);
        }

        // ==================== QUẢ TÁO ĐƠN GIẢN (Chỉ tròn đỏ + cuống + lá) ====================
        int fx = offsetX + controller.getFood().getX() * tile;
        int fy = offsetY + controller.getFood().getY() * tile;

        // Thân táo đỏ
        g.setColor(new Color(220, 20, 60));
        g.fillOval(fx + 4, fy + 4, tile - 8, tile - 8);

        // Cuống
        g.setColor(new Color(34, 100, 34));
        g.fillRect(fx + tile/2 - 3, fy + 4, 6, tile/4);

        // Lá
        g.setColor(new Color(34, 139, 34));
        g.fillOval(fx + tile/2, fy + 6, tile/3, tile/4);

        // ==================== RẮN LIỀN MẠCH, BO TRÒN ====================
        List<int[]> body = controller.getSnake().getBody();

        for (int i = 0; i < body.size(); i++) {
            int x = offsetX + body.get(i)[0] * tile;
            int y = offsetY + body.get(i)[1] * tile;

            if (i == 0) {
                // Đầu rắn
                g.setColor(new Color(30, 144, 255));
                g.fillRoundRect(x + 3, y + 3, tile - 6, tile - 6, 28, 28);

                // Mắt
                g.setColor(Color.WHITE);
                g.fillOval(x + tile/4 + 2, y + tile/5 + 2, tile/3, tile/3);
                g.fillOval(x + tile*2/3 - 6, y + tile/5 + 2, tile/3, tile/3);

                g.setColor(Color.BLACK);
                g.fillOval(x + tile/4 + 8, y + tile/5 + 8, tile/6, tile/6);
                g.fillOval(x + tile*2/3 - 2, y + tile/5 + 8, tile/6, tile/6);

            } else {
                // Thân rắn liền mạch, bo tròn
                g.setColor(new Color(30, 144, 255));
                RoundRectangle2D rect = new RoundRectangle2D.Float(
                    x + 3, y + 3, tile - 6, tile - 6, 22, 22);
                g.fill(rect);

                // Viền sáng nhẹ cho thân
                g.setColor(new Color(80, 170, 255));
                g.setStroke(new BasicStroke(2.5f));
                g.drawRoundRect(x + 5, y + 5, tile - 10, tile - 10, 20, 20);
            }
        }
    }
}
