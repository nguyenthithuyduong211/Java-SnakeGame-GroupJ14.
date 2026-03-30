# 🎓 🐍 GAME 2D & ỨNG DỤNG ĐỒ HỌA / RẮN SĂN MỒI (SNAKE) NÂNG CẤP
> **Bài tập lớn cuối kỳ môn Lập trình Java**

> **Lớp: 25CNTT1**

> **Thực hiện bởi: Nhóm J14**
## 👥 Thông tin nhóm (Team Members)
| STT | Họ và Tên | Mã Sinh Viên | Vai trò / Nhiệm vụ | Link GitHub Cá Nhân |
|---|---|---|---|---|
| 1 | **Nguyễn Thị Thùy Dương** | 3120225035 | Code Model, File I/O, Exception | [GitHub](https://github.com/nguyenthithuyduong211) |
| 2 | **Đỗ Ngọc Khánh An** | 3120225001 | Code GUI (Giao diện), Vẽ đối tượng | [GitHub](https://github.com/ngockhanhan15-netizen) |
| 3 | **Phạm Khánh Vy** | 3120225180 | Code Controller, Xử lý phím bấm | [GitHub](#) |

## 📝 Giới thiệu dự án (Description)
Đây là trò chơi "Rắn săn mồi" cổ điển được phát triển trên nền tảng Java. Ứng dụng giúp người dùng giải trí và rèn luyện phản xạ, đồng thời áp dụng các nguyên lý lập trình hướng đối tượng (OOP) để quản lý logic di chuyển, va chạm và hệ thống điểm số.

## ✨ Các chức năng chính (Features)
- [x] Điều khiển rắn di chuyển linh hoạt qua các phím mũi tên.
- [x] Lưu trữ điểm cao vĩnh viễn với File I/O (đọc/ghi file .txt).
- [x] Giao diện người dùng (GUI) trực quan, sinh động bằng Java Swing.
- [x] Bắt lỗi nhập liệu và dữ liệu chặt chẽ (Custom Exception Handling).
- [x] Hệ thống vật cản (Obstacles) và thức ăn (Food) xuất hiện ngẫu nhiên.
- [x] Tự động tăng độ dài và tốc độ của rắn khi ăn mồi để tăng độ khó.

## 💻 Công nghệ & Thư viện sử dụng (Technologies)
* **Ngôn ngữ:** Java (JDK 17+)
* **Giao diện:** Java Swing, AWT
* **Cơ sở dữ liệu / Lưu trữ:** File Text (.txt) để lưu Highscore
* **Công cụ khác:** Git, GitHub, VS Code / IntelliJ IDEA

## 📂 Cấu trúc thư mục (Project Structure)
Mã nguồn được tổ chức chặt chẽ theo mô hình **MVC (Model - View - Controller)**:
📦 src
┣ 📂 model       # Chứa các lớp thực thể: Snake, Food, Obstacle, GameObject
┣ 📂 view        # Chứa lớp giao diện đồ họa: GameFrame, GamePanel
┣ 📂 controller  # Chứa logic xử lý phím bấm và kiểm tra va chạm
┣ 📂 utils       # Chứa FileHandler (Đọc/Ghi file) và InvalidScoreException
┗ 📜 TestModel.java # File chạy thử để kiểm tra logic phần Model và File I/O

## 🚀 Hướng dẫn cài đặt và chạy (Installation)
1. **Clone repository này về máy:**
`git clone https://github.com/nguyenthithuyduong211/Java-SnakeGame-GroupJ14.git`
2. **Cấu hình:**
* Dự án sử dụng File I/O nên không cần cài đặt thêm CSDL MySQL.
* Đảm bảo máy đã cài JDK 17+.
3. **Chạy ứng dụng:**
* Mở project bằng IDE.
* Chạy file `Main.java` (hoặc `TestModel.java` để xem logic) để bắt đầu.

## 📸 Ảnh chụp màn hình (Screenshots)
![Màn hình Game](https://via.placeholder.com/600x400?text=Snake+Game+Interface)
![Màn hình Lưu Điểm](https://via.placeholder.com/600x400?text=Highscore+Result)
