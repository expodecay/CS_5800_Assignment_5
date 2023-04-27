public class MessageMemento {

    private String article;

    public MessageMemento(String article_save){
        article = article_save;
    }

    public String getSavedArticle(){
        return article;
    }
}
