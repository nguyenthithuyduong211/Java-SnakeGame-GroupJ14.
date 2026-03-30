package view;
import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Game Rắn Săn Mồi Nâng Cao");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Sử dụng BorderLayout để chia vùng

        // Tạo 2 Panel
        ScorePanel scorePanel = new ScorePanel();
        GamePanel gamePanel = new GamePanel(scorePanel);

        // Thêm vào Khung
        add(scorePanel, BorderLayout.NORTH); // Bảng điểm ở trên
        add(gamePanel, BorderLayout.CENTER); // Bàn cờ ở giữa

        pack(); // Tự động co giãn theo nội dung
        setSize(615, 680); // Chỉnh kích thước phù hợp
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        // Chạy game
        SwingUtilities.invokeLater(() -> {
            new GameFrame().setVisible(true);
        });
    }
}
