public class Memento {

    private String article;

    public Memento(String article_save){
        article = article_save;
    }

    public String getSavedArticle(){
        return article;
    }
}