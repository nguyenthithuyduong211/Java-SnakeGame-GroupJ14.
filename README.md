# 🎓 🐍 GAME 2D & ỨNG DỤNG ĐỒ HỌA / RẮN SĂN MỒI (SNAKE) NÂNG CẤP
> **Bài tập lớn cuối kỳ môn Lập trình Java**

> **Nhóm thực hiện:** Nhóm J14

> **Lớp:** 25CNTT1 - Khoa Toán Tin - ĐHSP Đà Nẵng
## 👥 Thông tin nhóm (Team Members)
| STT | Họ và Tên | Mã Sinh Viên | Vai trò / Nhiệm vụ | Link GitHub Cá Nhân |
|---|---|---|---|---|
| 1 | **Nguyễn Thị Thùy Dương** | 3120225035 | Model & Utils, Xây dựng Class thực thể, I/O File & Exception, Quản lý GitHub & Documentation | [GitHub](https://github.com/nguyenthithuyduong211) |
| 2 | **Đỗ Ngọc Khánh An** | 3120225001 | View, Đồ họa Game, Thiết kế Giao diện (Swing/Layout) | [GitHub](https://github.com/ngockhanhan15-netizen) |
| 3 | **Phạm Khánh Vy** | 3120225180 | Controller, Game Loop, Xử lý sự kiện & Va chạm | [GitHub](https://github.com/kzylazyy) |

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

📦 **src**

┣ 📂 **model**  # Chứa các lớp thực thể: Snake, Food, Obstacle, GameObject  
┣ 📂 **view**   # Chứa lớp giao diện đồ họa: GameFrame, GamePanel  
┣ 📂 **controller**   # Chứa logic xử lý phím bấm và kiểm tra va chạm  
┣ 📂 **utils**   # Chứa FileHandler (Đọc/Ghi file) và InvalidScoreException  
┗ 📜 **TestModel.java**   # File chạy thử để kiểm tra logic phần Model và File I/O

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
![Màn hình Đăng Nhập](https://via.placeholder.com/600x400?text=Snake+Game+Login+Screen)
![Màn hình Game Chơi](https://via.placeholder.com/600x400?text=Snake+Game+Interface)
![Màn hình Kết Thúc và Lưu Điểm](https://via.placeholder.com/600x400?text=Game+Over+and+Highscore+Result)
