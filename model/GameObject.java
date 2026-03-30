package model;
// Tiêu chí: Sử dụng tốt Kế thừa để giảm lặp code 
public abstract class GameObject {
    // Tiêu chí: Áp dụng triệt để tính Đóng gói (private) 
    private int x;
    private int y;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // Getter và Setter
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    // Phương thức trừu tượng (Đa hình)
    public abstract void respawn(int maxWidth, int maxHeight);
}
