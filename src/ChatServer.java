import java.util.ArrayList;

public class ChatServer {

    private String article;
    ArrayList<User> recipients = new ArrayList<>();

    public void set(String new_article){
        System.out.println("From Chat Server: Current version of Atricle\n" + new_article + "\n");
        article = new_article;
    }

    public MessageMemento storeInMemento(){
        System.out.println("From Chat Server: Saving Memento");
        return  new MessageMemento(article);
    }

    public String restoreFromMemento(MessageMemento memento){
        article = memento.getSavedArticle();
        System.out.println("From Chat Server: Previous Article Saved in Memento\n" + "\n");
        return article;
    }

    public void sendMessage(Message message, User recipient){
        if(isBlocked(message, recipient)) {
            System.out.println("Blocked");
        }else{
            String textInTextArea = message.getMessage_content();
            recipient.getMessageApp().updateTextArea(textInTextArea + "\n");
        }
    }

    public void addRecipients(User recipient){
        recipients.add(recipient);
    }

    public ArrayList<User> getRecipients(){
        return recipients;
    }

    private boolean isBlocked(Message message, User recipient){
        boolean blocked = false;
        for(User blockedUser : recipient.getBlockedUsers())
            if(message.getSender().equals(blockedUser.getUserName()))
                blocked = true;
            return blocked;
    }
}
