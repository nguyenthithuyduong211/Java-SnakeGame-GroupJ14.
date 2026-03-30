package model;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<int[]> body; // Đóng gói dữ liệu thân rắn
    private String direction;
    private boolean isAlive;

    public Snake(int startX, int startY) {
        body = new ArrayList<>();
        body.add(new int[] { startX, startY }); // Đầu rắn
        direction = "RIGHT";
        isAlive = true;
    }

    // Getter/Setter cho các thuộc tính private
    public List<int[]> getBody() {
        return body;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    // Logic di chuyển
    public void move() {
        int[] head = body.get(0);
        int[] newHead = new int[] { head[0], head[1] };

        switch (direction) {
            case "UP":
                newHead[1]--;
                break;
            case "DOWN":
                newHead[1]++;
                break;
            case "LEFT":
                newHead[0]--;
                break;
            case "RIGHT":
                newHead[0]++;
                break;
        }
        body.add(0, newHead); // Thêm đầu mới
        body.remove(body.size() - 1); // Xóa đuôi cũ
    }

    public void grow() {
        int[] tail = body.get(body.size() - 1);
        body.add(new int[] { tail[0], tail[1] }); // Thêm một đốt vào đuôi
    }
}
