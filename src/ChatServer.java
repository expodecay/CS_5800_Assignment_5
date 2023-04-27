public class ChatServer {

    private String article;

    public void set(String new_article){
        System.out.println("From Originator: Current version of Atricle\n" + new_article + "\n");

        article = new_article;
    }

    public MessageMemento storeInMemento(){
        System.out.println("From Originator: Saving Memento");
        return  new MessageMemento(article);
    }

    public String restoreFromMemento(MessageMemento memento){
        article = memento.getSavedArticle();

        System.out.println("From Originator: Previous Artivle Saved in Memento\n" + "\n");

        return article;
    }
}
