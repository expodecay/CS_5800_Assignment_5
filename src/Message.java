import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Message {

    private String sender;
    private User sender_object;
    private User recipient;
    private String time_stamp;
    private String message_content;

    public Message(User user){
        sender = user.getUserName();
        sender_object = user;
        time_stamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());;
    }

    public String getSender(){
        return sender;
    }

    public User getSender_object(){
        return sender_object;
    }

    public String getTime_stamp(){

        return time_stamp;
    }

    public void setMessage_content(String content){
        message_content = content;
    }

    public String getMessage_content(){
        return message_content;
    }

    public void setRecipients(User name){
        recipient = name;
    }
}
