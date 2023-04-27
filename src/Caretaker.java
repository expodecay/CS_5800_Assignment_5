import java.util.ArrayList;

public class Caretaker {

    ArrayList<Memento> saved_articles = new ArrayList<>();

    public void addMemento(Memento m){
        saved_articles.add(m);
    }

    public Memento getMemento(int index){
        return saved_articles.get(index);
    }
}
