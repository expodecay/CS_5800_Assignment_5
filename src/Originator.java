public class Originator {

    private String article;

    public void set(String new_article){
        System.out.println("From Originator: Current version of Atricle\n" + new_article + "\n");

        article = new_article;
    }

    public Memento storeInMemento(){
        System.out.println("From Originator: Saving Memento");
        return  new Memento(article);
    }

    public String restoreFromMemento(Memento memento){
        article = memento.getSavedArticle();

        System.out.println("From Originator: Previous Artivle Saved in Memento\n" + "\n");

        return article;
    }
}
