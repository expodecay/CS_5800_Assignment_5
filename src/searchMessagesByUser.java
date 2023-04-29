import java.util.ArrayList;
import java.util.Iterator;

public class searchMessagesByUser implements Iterator {

    private Iterator iterator;
    private ArrayList<Message> messages;
    User userToSearchFor;

    private int messageCollectionSize;
    private int indexInMessageCollection;

    public searchMessagesByUser(ChatHistory hist, User who){
        this.messages = hist.getMessages();
        this.indexInMessageCollection = 0;
        this.messageCollectionSize = messages.size();
        userToSearchFor = who;

        Iterator stepForward = hist.getMessages().iterator();
        Iterator stepBack = hist.getMessages().iterator();
    }

    @Override
    public boolean hasNext() {
        Message msg = null;
        while (indexInMessageCollection < messageCollectionSize){
            msg = messages.get(indexInMessageCollection);
            if(msg.getSender_object()== userToSearchFor)
                return true;
            else{
                indexInMessageCollection++;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        if(hasNext()){
            int temp=indexInMessageCollection;
            indexInMessageCollection+=1;
            return messages.get(temp);
        }
        return null;
    }
}
