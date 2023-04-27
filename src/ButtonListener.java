import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonListener implements ActionListener {

    private JButton saveBut, undoBut, redoBut;
    private JTextArea the_Article = new JTextArea(90,40);

    Caretaker caretaker = new Caretaker();

    Originator originator = new Originator();

    int save_files = 0, current_article = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == saveBut){
            String textInTextArea = the_Article.getText();

            originator.set(textInTextArea);

            caretaker.addMemento(originator.storeInMemento());

            save_files++;
            current_article++;
            System.out.println("Save Files " + save_files);

            System.out.println("here 1");
            undoBut.setEnabled(true);
            System.out.println(caretaker.getMemento(0));
            System.out.println("here 2");
        }else
        if(e.getSource() == undoBut){
            if(current_article >= 1){
                current_article--;
                String texBoxString = originator.restoreFromMemento(caretaker.getMemento(current_article));
                the_Article.setText(texBoxString);
                redoBut.setEnabled(true);
            }else {
                undoBut.setEnabled(false);
            }
        }else
        if(e.getSource() == redoBut){
            if((save_files -1) > current_article){
                current_article++;
                String texBoxString = originator.restoreFromMemento(caretaker.getMemento(current_article));
                the_Article.setText(texBoxString);
                undoBut.setEnabled(true);
            }else{
                redoBut.setEnabled(false);
            }
        }
    }

    public void setSaveBut(JButton saveBut) {
        this.saveBut = saveBut;
    }

    public void setUndoBut(JButton undoBut) {
        this.undoBut = undoBut;
    }

    public void setRedoBut(JButton redoBut) {
        this.redoBut = redoBut;
    }

    public JButton getSaveBut(){
        return saveBut;
    }

    public JButton getUndoBut(){
        return undoBut;
    }

    public JButton getRedoBut(){
        return redoBut;
    }

    public void setThe_Article(JTextArea the_Article){
        this.the_Article = the_Article;
    }

    public JTextArea getThe_Article(){
        return the_Article;
    }
}