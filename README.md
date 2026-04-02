# 🎓 🐍 GAME 2D & ỨNG DỤNG ĐỒ HỌA / RẮN SĂN MỒI (SNAKE) NÂNG CẤP
> **Bài tập lớn cuối kỳ môn Lập trình Java**

> **Nhóm thực hiện:** Nhóm J14

> **Lớp:** 25CNTT1 - Khoa Toán Tin - ĐHSP Đà Nẵng
## 👥 Thông tin nhóm (Team Members)
| STT | Họ và Tên | Mã Sinh Viên | Vai trò / Nhiệm vụ | Link GitHub Cá Nhân |
|---|---|---|---|---|
| 1 | **Nguyễn Thị Thùy Dương** | 3120225035 | Model & Utils, Xây dựng Class thực thể, I/O File & Exception, Quản lý GitHub & Documentation | [GitHub](https://github.com/nguyenthithuyduong211) |
| 2 | **Đỗ Ngọc Khánh An** | 3120225001 | View, Đồ họa Game, Thiết kế Giao diện (Swing/Layout) | [GitHub](https://github.com/ngockhanhan15-netizen) |
| 3 | **Phạm Khánh Vy** | 3120225180 | Controller, Game Loop, Xử lý sự kiện & Va chạm | [GitHub](https://github.com/kzylazy) |

## 📝 Giới thiệu dự án (Description)
 
**Snake Game J14** là trò chơi Rắn Săn Mồi được phát triển hoàn chỉnh bằng **Java Swing**, thuộc đề tài số 17 trong nhóm *Game 2D & Ứng dụng Đồ họa*. Game cung cấp hai chế độ chơi: theo màn (5 màn với độ khó tăng dần và chướng ngại vật) và vô tận (tùy chỉnh độ khó, chế độ, kích thước map). Ứng dụng được xây dựng theo mô hình **MVC**, áp dụng đầy đủ OOP, File I/O và xử lý ngoại lệ theo đúng yêu cầu môn học.
 
---

## ✨ Các chức năng chính (Features)
 
- [x] **Chế độ theo màn** – 5 màn chơi, tốc độ và chướng ngại vật tăng dần (160ms → 80ms)
- [x] **Chế độ vô tận** – Chọn độ khó (Dễ / Bình thường / Khó), chế độ Cổ điển / Xuyên tường, kích thước map 10×10 / 15×15 / 20×20
- [x] **Đồ họa nâng cao** – Vẽ bằng `Graphics2D` + anti-aliasing, rắn bo tròn, táo đỏ, thùng gỗ, nền cờ ca-rô
- [x] **Hệ thống âm thanh** – Nhạc nền loop + 5 SFX (ăn mồi, va chạm, thắng, thua, click)
- [x] **Lưu Highscore** – Đọc/ghi điểm cao nhất xuống `highscore.txt` bằng File I/O
- [x] **Lưu cài đặt màu sắc** – Đọc/ghi `settings.txt` định dạng `key=R,G,B`
- [x] **Giao diện đẹp** – Ảnh nền, custom button PNG, hiệu ứng bounce tiêu đề, CardLayout
- [x] **Tạm dừng / Tiếp tục** – Nhấn P hoặc nút Pause
- [x] **Custom Exception** – `InvalidScoreException` tự định nghĩa
- [x] **Xử lý ngoại lệ** – `try-with-resources` cho tất cả File I/O, không bao giờ crash
 
---

## 💻 Công nghệ & Thư viện sử dụng (Technologies)
 
| Công nghệ | Chi tiết |
|-----------|----------|
| **Ngôn ngữ** | Java SE (JDK 17+) |
| **Giao diện** | Java Swing, AWT – `JFrame`, `JPanel`, `JDialog`, `CardLayout` |
| **Đồ họa game** | `Graphics2D`, `paintComponent`, `RenderingHints`, `RoundRectangle2D` |
| **Vòng lặp game** | `javax.swing.Timer` |
| **Âm thanh** | `javax.sound.sampled` – `Clip`, `AudioSystem`, `FloatControl` |
| **Lưu trữ** | File I/O – `BufferedReader`, `PrintWriter` (`.txt`) |
| **Xử lý sự kiện** | `KeyListener`, `ActionListener` |
| **Quản lý mã nguồn** | Git, GitHub |
| **IDE** | IntelliJ IDEA / Eclipse |
 
---

## 📂 Cấu trúc thư mục (Project Structure)
 
Mã nguồn tổ chức theo mô hình **MVC (Model – View – Controller)**:
 
```
📦 src
 ┣ 📂 model               # Lớp thực thể – dữ liệu game
 ┃ ┣ 📜 GameObject.java   # Abstract base class (x, y, respawn)
 ┃ ┣ 📜 Snake.java        # Logic di chuyển, phát triển rắn
 ┃ ┣ 📜 Food.java         # Vị trí và màu sắc thức ăn
 ┃ ┗ 📜 Obstacle.java     # Chướng ngại vật cố định
 ┣ 📂 controller          # Logic nghiệp vụ
 ┃ ┣ 📜 GameController.java  # Điều phối toàn bộ game
 ┃ ┗ 📜 GameLoop.java        # Vòng lặp Timer
 ┣ 📂 view                # Giao diện người dùng
 ┃ ┣ 📜 MainFrame.java        # JFrame chính, CardLayout
 ┃ ┣ 📜 GamePanel.java        # paintComponent – vẽ game
 ┃ ┣ 📜 MainMenuPanel.java    # Menu chính + bounce effect
 ┃ ┣ 📜 LevelSelectPanel.java # Chọn màn chơi
 ┃ ┣ 📜 EndlessModePanel.java # Cài đặt chế độ vô tận
 ┃ ┣ 📜 GameOverPanel.java    # Màn hình thua cuộc
 ┃ ┣ 📜 LevelWinPanel.java    # Màn hình thắng màn
 ┃ ┣ 📜 SettingsPanel.java    # Cài đặt âm thanh
 ┃ ┗ 📜 SettingsDialog.java   # Dialog cài đặt âm lượng
 ┣ 📂 utils               # Tiện ích dùng chung
 ┃ ┣ 📜 Difficulty.java           # Enum độ khó (EASY/MEDIUM/HARD)
 ┃ ┣ 📜 GameMode.java             # Enum chế độ chơi
 ┃ ┣ 📜 LevelConfig.java          # Cấu hình từng màn
 ┃ ┣ 📜 FileHandler.java          # Đọc/ghi highscore.txt
 ┃ ┣ 📜 Settings.java             # Đọc/ghi settings.txt
 ┃ ┣ 📜 SoundManager.java         # Quản lý âm thanh
 ┃ ┗ 📜 InvalidScoreException.java # Custom Exception
 ┣ 📂 images              # Ảnh nền & button PNG
 ┣ 📂 sounds              # File âm thanh .wav
 ┗ 📜 Main.java           # Entry-point khởi động ứng dụng
```
 
---

## 🏗️ Kiến trúc MVC
 
```
┌─────────────────┐     cập nhật     ┌─────────────────┐
│      MODEL      │ ◄──────────────  │   CONTROLLER    │
│  Snake, Food,   │                  │ GameController  │
│  Obstacle,      │  ──────────────► │  GameLoop       │
│  GameObject     │   đọc trạng thái │                 │
└─────────────────┘                  └────────┬────────┘
                                              │ gọi repaint()
                                     ┌────────▼────────┐
                                     │      VIEW        │
                                     │  GamePanel       │
                                     │  MainFrame       │
                                     │  ...Panels       │
                                     └─────────────────┘
```
 
---

 ## 🎮 Hướng dẫn chơi
 
| Phím | Hành động |
|------|-----------|
| `W` / `↑` | Di chuyển lên |
| `S` / `↓` | Di chuyển xuống |
| `A` / `←` | Di chuyển trái |
| `D` / `→` | Di chuyển phải |
| `P` | Tạm dừng / Tiếp tục |
 
---

 ## 🚀 Hướng dẫn cài đặt và chạy (Installation)
 
### Yêu cầu
- **JDK 17** trở lên
- IDE: IntelliJ IDEA, Eclipse, hoặc VS Code với Java Extension
 
### Các bước chạy
 
**1. Clone repository về máy:**
```bash
<img width="99" height="99" alt="image" src="https://github.com/user-attachments/assets/f3c95ffc-ace2-46b3-8bda-6920ddaae836" />

```
 
**2. Đảm bảo cấu trúc thư mục:**
```
project-root/
 ├── src/          ← Mã nguồn Java
 ├── images/       ← Ảnh nền, button PNG
 ├── sounds/       ← File .wav âm thanh
 └── Main.java
```
 
**3. Biên dịch và chạy:**
```bash
# Biên dịch
javac -d out -sourcepath src src/Main.java
 
# Chạy
java -cp out Main
```
 
**Hoặc dùng IDE:** Mở project → chạy `Main.java`
 
> ⚠️ **Lưu ý:** Thư mục `images/` và `sounds/` phải nằm cùng cấp với nơi chạy chương trình (working directory).
 
---

## 📸 Ảnh chụp màn hình (Screenshots)
<p align="center">
  <img src="https://github.com/user-attachments/assets/e32034ea-4cde-4c07-acbc-b43c386044ba" width="30%" alt="Màn hình Đăng Nhập">
  <img src="https://github.com/user-attachments/assets/ff099487-c729-4015-9478-4b7112faa623" width="30%" alt="Màn hình Game Chơi">
  <img src="https://github.com/user-attachments/assets/8708c5e3-5069-4848-a7dd-b8d134d0096d" width="30%" alt="Màn hình Kết Thúc">
</p>
