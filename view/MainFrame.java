package view;

import controller.GameController;
import utils.*;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private GameController controller = new GameController();
    private GamePanel gamePanel = new GamePanel(controller);

    public MainFrame() {
        setTitle("Snake Game J14 – Dọc");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 840);
        setResizable(false);
        setLocationRelativeTo(null);

        controller.setGamePanel(gamePanel);

        // === ĐÃ XÓA DÒNG GÂY LỖI ===
        // controller.setGameOverCallbacks(this::restartGame, this::showMenu);

        // SỬA Ở ĐÂY: truyền thêm controller
        MainMenuPanel menu = new MainMenuPanel(this, controller);
        LevelSelectPanel levelSelect = new LevelSelectPanel(this, controller);

        mainPanel.add(menu, "MENU");
        mainPanel.add(levelSelect, "LEVEL");
        mainPanel.add(gamePanel, "GAME");

        add(mainPanel);
        showMenu();

        // KHỞI ĐỘNG NHẠC NỀN
        SoundManager.playBackgroundMusic();
    }

    public void showMenu() { 
        cardLayout.show(mainPanel, "MENU"); 
    }

    public void showLevelSelect() { 
        cardLayout.show(mainPanel, "LEVEL"); 
    }

    public void startLevel(LevelConfig cfg) {
        controller.startLevel(cfg);
        cardLayout.show(mainPanel, "GAME");
        gamePanel.requestFocusInWindow();
    }

    public void startEndless(Difficulty d, GameMode m, int size) {
        controller.startEndless(d, m, size);
        cardLayout.show(mainPanel, "GAME");
        gamePanel.requestFocusInWindow();
    }

    // === ĐÃ XÓA PHƯƠNG THỨC KHÔNG CÒN DÙNG ===
    // private void restartGame() { ... }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
