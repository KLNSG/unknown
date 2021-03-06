package base;

public class Message<T> {
    private int code;
    private String message;
    private T data;

    public Message(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public Message(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public final static Message SUCCESS() {
        return new Message(1, "成功", 1);
    }

    public final static Message FAIL() {
        return new Message(-1, "失败", null);
    }

    public Message() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
