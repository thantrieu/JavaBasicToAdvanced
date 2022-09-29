import java.util.Scanner;

public class TestAnnotation {
    public static void main(String[] args) {
        var x = new Scanner(System.in).nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
        System.out.println("Message length: " + message.length());
    }
}
