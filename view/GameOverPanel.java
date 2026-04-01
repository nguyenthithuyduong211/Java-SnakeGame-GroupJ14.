package view;

import controller.GameController;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameOverPanel extends JPanel {

    private final MainFrame frame;
    private final GameController controller;

    private BufferedImage backgroundImage;
    private BufferedImage buttonImage;

    private final Font titleFont = new Font("Arial", Font.BOLD, 48);
    private final Font buttonFont = new Font("Arial", Font.BOLD, 22);

    public GameOverPanel(MainFrame frame, GameController controller, boolean isLevelMode, int scoreOrLevel) {
        this.frame = frame;
        this.controller = controller;

        setLayout(null);
        setPreferredSize(new Dimension(550, 550));
        setOpaque(true);

        loadImages();

        JLabel title = new JLabel("GAME OVER", SwingConstants.CENTER);
        title.setFont(titleFont);
        title.setForeground(new Color(180, 20, 20));
        title.setBounds(0, 80, 550, 90);
        add(title);

        String message = isLevelMode ? 
            "Bạn thua ở Màn " + scoreOrLevel : 
            "Điểm của bạn: " + scoreOrLevel;

        JLabel msgLabel = new JLabel(message, SwingConstants.CENTER);
        msgLabel.setFont(new Font("Arial", Font.BOLD, 26));
        msgLabel.setForeground(new Color(60, 40, 20));
        msgLabel.setBounds(0, 180, 550, 60);
        add(msgLabel);

        createImageButton("Chơi lại", 155, 270, e -> replay());
        createImageButton("Quay về Menu", 155, 340, e -> backToMenu());
    }

    private void loadImages() {
        try {
            backgroundImage = ImageIO.read(new File("images/gameover_background.png"));
            buttonImage = ImageIO.read(new File("images/button_normal.png"));
        } catch (IOException e) {
            System.err.println("Không load được ảnh Game Over");
        }
    }

    private void createImageButton(String text, int x, int y, java.awt.event.ActionListener listener) {
        JButton btn = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                if (buttonImage != null) {
                    g.drawImage(buttonImage, 0, 0, getWidth(), getHeight(), null);
                }
                Graphics2D g2 = (Graphics2D) g;
                g2.setFont(buttonFont);
                g2.setColor(new Color(40, 25, 10));
                FontMetrics fm = g2.getFontMetrics();
                int tx = (getWidth() - fm.stringWidth(getText())) / 2;
                int ty = (getHeight() + fm.getAscent()) / 2 - 3;
                g2.drawString(getText(), tx, ty);
            }
        };
        btn.setBounds(x, y, 240, 68);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setOpaque(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addActionListener(listener);
        add(btn);
    }

    private void replay() {
        closeThisPanel();
        controller.restartCurrentLevel();
    }

    private void backToMenu() {
        closeThisPanel();
        frame.showMenu();
    }

    private void closeThisPanel() {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) window.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, 550, 550, null);
        }
    }
}
