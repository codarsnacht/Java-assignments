import java.io.*;
public class chatMessage implements Serializable {
    protected static final long serialVersionUID = 1112122200L;

    static final int WHOISIN = 0, MESSAGE = 1, LOGOUT = 2;
    private int type;
    private String message;

    // constructor
    chatMessage(int type, String message) {
        this.type = type;
        this.message = message;
    }
    // gets type and message
    String getMessage() {
        return message;
    }
    int getType() {
        return type;
    }}//end of class