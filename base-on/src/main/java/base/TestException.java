package base;

public class TestException extends Exception {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public TestException(String message){
        this.message = message;
    }

    public static void main(String[] args) {
        try {
            throw new TestException("移除");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
