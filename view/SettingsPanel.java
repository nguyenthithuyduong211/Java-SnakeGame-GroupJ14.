package view;

import utils.SoundManager;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SettingsPanel extends JPanel {

    private BufferedImage backgroundImage;
    private BufferedImage buttonImage;

    private final Font titleFont = new Font("Arial", Font.BOLD, 42);
    private final Font buttonFont = new Font("Arial", Font.BOLD, 22);

    public SettingsPanel() {
        setLayout(null);
        setBorder(null);
        setPreferredSize(new Dimension(600, 840));   // ← FIX TRÀN VIỀN

        loadImages();

        JLabel title = new JLabel("CÀI ĐẶT", SwingConstants.CENTER);
        title.setFont(titleFont);
        title.setForeground(new Color(40, 25, 10));
        title.setBounds(0, 80, 600, 80);
        add(title);

        JCheckBox musicCheck = new JCheckBox("Nhạc nền", SoundManager.isMusicEnabled());
        musicCheck.setBounds(120, 220, 360, 50);
        musicCheck.setFont(buttonFont);
        musicCheck.setForeground(Color.WHITE);
        musicCheck.setOpaque(false);
        musicCheck.addActionListener(e -> SoundManager.setMusicEnabled(musicCheck.isSelected()));
        add(musicCheck);

        JCheckBox sfxCheck = new JCheckBox("Âm thanh hiệu ứng", SoundManager.isSfxEnabled());
        sfxCheck.setBounds(120, 290, 360, 50);
        sfxCheck.setFont(buttonFont);
        sfxCheck.setForeground(Color.WHITE);
        sfxCheck.setOpaque(false);
        sfxCheck.addActionListener(e -> SoundManager.setSfxEnabled(sfxCheck.isSelected()));
        add(sfxCheck);

        createImageButton("ĐÓNG", 180, 480, e -> closeThisPanel());
    }

    private void loadImages() {
        try {
            backgroundImage = ImageIO.read(new File("images/settings_background.png"));
            buttonImage = ImageIO.read(new File("images/button_normal.png"));
        } catch (IOException e) {
            System.err.println("Không load được ảnh Settings");
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
        btn.addActionListener(listener);
        add(btn);
    }

    private void closeThisPanel() {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) window.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        } else {
            g.setColor(new Color(139, 69, 19));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
