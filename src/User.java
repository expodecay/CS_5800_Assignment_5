public class User {
    private String name;

    public User(String current_user){
        name = current_user;
    }

    public void sendMessage(String message, User recipient){

    }

    public void receiveMessage(String message, User sender){

    }

    public void undoLastMessage(){

    }

    public String getName(){
        return name;
    }
}
