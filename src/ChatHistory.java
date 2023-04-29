import java.util.ArrayList;

public class ChatHistory {

    ArrayList<MessageMemento> saved_articles = new ArrayList<>();

    public void addMemento(MessageMemento m){
        saved_articles.add(m);
    }

    public MessageMemento getMemento(int index){
        return saved_articles.get(index);
    }

    public int getSize(){
        return saved_articles.size();
    }

}
