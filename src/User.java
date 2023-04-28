public class User {
    private String name;

    public User(String current_user){
        name = current_user;
    }

    public void sendMessage(Message message, MessageApp recipient){
        ChatServer originator = new ChatServer();
        String textInTextArea = message.getMessage_content();
        originator.set(textInTextArea);
        recipient.text_area.setText(textInTextArea + "\n");

    }

    public void receiveMessage(String message, User sender){

    }

    public void undoLastMessage(){

    }

    public String getName(){
        return name;
    }
}
