import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestMemento extends JFrame {
    private JButton saveBut, undoBut, redoBut;
    private JTextArea the_Article = new JTextArea(90,40);

    Caretaker caretaker = new Caretaker();

    Originator originator = new Originator();

    int save_files = 0, current_article = 0;

    public TestMemento(String name){
        this.setSize(750, 780);
        this.setTitle(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Article"));
        panel1.add(the_Article);

        ButtonListener saveListener = new ButtonListener();
        ButtonListener undoListener = new ButtonListener();
        ButtonListener redoListener = new ButtonListener();

        saveBut = new JButton("Save");
        saveBut.addActionListener(saveListener);

        undoBut = new JButton("Undo");
        undoBut.addActionListener(undoListener);

        redoBut = new JButton("Redo");
        redoBut.addActionListener(redoListener);

        panel1.add(saveBut);
        panel1.add(undoBut);
        panel1.add(redoBut);

        this.add(panel1);
        this.setVisible(true);
    }

    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == saveBut){
                String textInTextArea = the_Article.getText();

                originator.set(textInTextArea);

                caretaker.addMemento(originator.storeInMemento());

                save_files++;
                current_article++;
                System.out.println("Save Files " + save_files);

                undoBut.setEnabled(true);
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
    }
}
