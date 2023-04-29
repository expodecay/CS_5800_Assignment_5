import java.util.ArrayList;
import java.util.Iterator;

public class ChatHistory implements IterableByUser{

    ArrayList<MessageMemento> saved_articles = new ArrayList<>();
    ArrayList<Message> saved_messages = new ArrayList<>();

    public void addMemento(MessageMemento m){
        saved_articles.add(m);
    }

    public MessageMemento getMemento(int index){
        return saved_articles.get(index);
    }

    public int getSize(){
        return saved_articles.size();
    }

    public void updateChatHistory(Message message){
        saved_messages.add(message);
    }

    public ArrayList<Message> getMessages(){
        /*for (int i=0; i<saved_messages.size(); i++){
            System.out.println("From " + saved_messages.get(i).getSender() + " : "+ saved_messages.get(i).getMessage_content());
        }*/
        return saved_messages;
    }

    @Override
    public Iterator iterator(User userToSearchWith) {
        return new searchMessagesByUser(this, userToSearchWith);
    }

}
