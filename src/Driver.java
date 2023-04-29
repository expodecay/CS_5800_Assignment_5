import java.util.Iterator;

public class Driver {
    public static void main(String[] args) {
        ChatServer server = new ChatServer();

        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");

        user1.connectToServer(server);
        user2.connectToServer(server);
        user3.connectToServer(server);

        user1.blockUser(user3, server);

        user1.getMessageApp().updateTextArea("Test message 1");
        user1.getMessageApp().userSave();
        user1.getMessageApp().updateTextArea("Test message 2");
        user1.getMessageApp().userUndo();
        user1.getMessageApp().printChatHistory();

        Message user2ToUser1 = new Message(user1);
        user2ToUser1.setMessage_content("hi");

        user1.getMessageApp().updateTextArea("hi1");
        user1.getMessageApp().userSend(1);

        user1.getMessageApp().updateTextArea("hi2");
        user1.getMessageApp().userSend(1);

        user1.getMessageApp().updateTextArea("hi3");
        user1.getMessageApp().userSend(1);

        user3.getMessageApp().updateTextArea("hi4");
        user3.getMessageApp().userSend(1);

        user3.getMessageApp().updateTextArea("hi5");
        user3.getMessageApp().userSend(1);

        user2.getMessageApp().userSave();
        user2.getMessageApp().printChatHistory();

        Iterator test = user2.iterator(user3);


            while(test.hasNext()){
                Message msg = (Message) test.next();
                System.out.println(msg.getMessage_content());
        }
    }
}
