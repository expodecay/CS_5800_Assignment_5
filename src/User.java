import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    private String name;
    MessageApp app;
    ArrayList<User> blockedUsers;


    public User(String current_user){
        name = current_user;
        app = new MessageApp(this);
        blockedUsers = new ArrayList<>();
    }

    public void sendMessage(Message message, MessageApp recipient){

    }

    public void receiveMessage(String message, User sender){

    }

    public void undoLastMessage(){

    }

    public String getUserName(){
        return name;
    }

    public void connectToServer(ChatServer server){
        app.connectToServer(server, this);
    }

    public MessageApp getMessageApp(){
        return app;
    }

    public void blockUser(User blockedUser, ChatServer server){
        blockedUsers.add(blockedUser);
        System.out.println( name + " has blocked " + blockedUser.getUserName());
    }

    public ArrayList<User> getBlockedUsers(){
        return blockedUsers;
    }

    public void printChatHistory(){
        app.printChatHistory();
    }
}
