package utils;
// Tiêu chí: Tự định nghĩa ít nhất 1 Custom Exception 
public class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}
