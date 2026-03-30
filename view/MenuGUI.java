package view;
import javax.swing.*;
import java.awt.*;

public class MenuGUI extends JFrame {
    public MenuGUI() {
        setTitle("Menu Game Rắn Săn Mồi");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        JButton btnStart = new JButton("Bắt đầu chơi");
        btnStart.setFont(new Font("Arial", Font.BOLD, 20));
        
        // Khi nhấn nút sẽ mở màn hình Game chính
        btnStart.addActionListener(e -> {
            new MainFrame().setVisible(true);
            dispose(); // Đóng menu
        });

        add(btnStart);
    }
}
