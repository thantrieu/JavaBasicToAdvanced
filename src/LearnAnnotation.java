public class LearnAnnotation {
    /**
     * @deprecated
     * This method is no longer supported next year.
     * @param message the message to print on screen
     */
    @Deprecated
    public void printMessage(String message) {
        System.out.println("Message: " + message);
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        Thread thread = new Thread("My Thread");
        thread.start();
        thread.suspend(); // call to deprecated method of thread object
    }
}

interface Calculable {
    @SuppressWarnings("unused")
    int add(int a, int b);
}

class Calculator implements Calculable {
    @Override
    public int add(int a, int b) { // triển khai interface Calculable
        return a + b;
    }
}

@SuppressWarnings("unused")
class ChildCalculator extends Calculator {
    @Override
    public int add(int a, int b) { // ghi đè phương thức của lớp cha
        return super.add(a, b) + 1;
    }
}