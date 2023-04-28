public class Main {
    public static void main(String[] args) {

        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");


       // Message user1_message = new Message(user1);
       // user1_message.setMessage_content("User 1 Test Message");

       // Message user2_message = new Message(user1);
       // user2_message.setMessage_content("User 2 Test Message");

      //  System.out.println("here: " + user2_message.getMessage_content());

        MessageApp test1 = new MessageApp(user1);
        MessageApp test2 = new MessageApp(user2);

        test1.addRecipients(test2);
        test2.addRecipients(test1);

        test1.text_area.setText("helloooo");
        test2.text_area.setText("hi");

    }
}
