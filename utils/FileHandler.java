package utils;
import java.io.*;
public class FileHandler {
    // Tiêu chí: Dữ liệu lưu trữ chính xác xuống File Văn bản 
    private static final String HIGH_SCORE_FILE = "highscore.txt";

    // Tiêu chí: Hoàn thiện chức năng ghi dữ liệu (CRUD: Update/Create)
    public static void saveHighScore(int score) throws InvalidScoreException {
        // Tiêu chí: Bắt lỗi nhập liệu chặt chẽ 
        if (score < 0) {
            throw new InvalidScoreException("Điểm số không được âm: " + score);
        }
        // Tiêu chí: Không xảy ra lỗi rác bộ nhớ (Đã đóng Stream bằng
        // try-with-resources) 
        try (PrintWriter out = new PrintWriter(new FileWriter(HIGH_SCORE_FILE))) {
            out.println(score);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file điểm cao: " + e.getMessage());
        }
    }
    // Tiêu chí: Hoàn thiện chức năng đọc dữ liệu (CRUD: Read) 
    public static int readHighScore() {
        File file = new File(HIGH_SCORE_FILE);
        if (!file.exists()) {
            return 0; // Nếu chưa có file, điểm cao mặc định là 0
        }

        try (BufferedReader in = new BufferedReader(new FileReader(HIGH_SCORE_FILE))) {
            String line = in.readLine();
            if (line != null) {
                return Integer.parseInt(line.trim());
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Lỗi khi đọc file điểm cao: " + e.getMessage());
        }
        return 0;
    }
}
