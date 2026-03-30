package view;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Rắn Săn Mồi Nâng Cấp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        
        setSize(600, 600); // Kích thước bàn cờ
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        // Chạy Menu đầu tiên
        new MenuGUI().setVisible(true);
    }
}
