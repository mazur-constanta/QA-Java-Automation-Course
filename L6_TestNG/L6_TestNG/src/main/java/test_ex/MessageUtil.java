package test_ex;

public class MessageUtil {
    private String message;

    public MessageUtil() {
    }

    public MessageUtil(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        MessageUtil messageUtil = new MessageUtil();
        System.out.println(printMessage());
    }

    public static String printMessage() {
        return "Constanta";
    }

    public static String printMessage2() {
        return "Hi, " + "Constanta!";
    }
}
