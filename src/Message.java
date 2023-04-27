import java.util.ArrayList;

public class Message {

    private String sender;
    private ArrayList<String> recipients;
    private double time_stamp;
    private String message_content;

    private void setSender(String current_sender){
        sender = current_sender;
    }

    private String getSender(){
        return sender;
    }

    private void setTime_stamp(double time){
        time_stamp = time;
    }

    private double getTime_stamp(){
        return time_stamp;
    }

    private void setMessage_content(String content){
        message_content = content;
    }

    private String getMessage_content(){
        return message_content;
    }

    private void addRecipient(String name){
        recipients.add(name);
    }
}
