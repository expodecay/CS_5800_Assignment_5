public class Main {
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
        user1.getMessageApp().userSave();
        user1.getMessageApp().printChatHistory();



    }
}
