import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageApp extends JFrame {
    private JButton saveBut, undoBut, redoBut;
    private JTextArea text_area = new JTextArea(90,40);

    ChatHistory caretaker = new ChatHistory();

    ChatServer originator = new ChatServer();

    int save_files = 0, current_article = 0;

    public MessageApp(User user){
        this.setSize(750, 780);
        this.setTitle(user.getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Article"));
        panel1.add(text_area);

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
                String textInTextArea = text_area.getText();

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
                        text_area.setText(texBoxString);
                        redoBut.setEnabled(true);
                    }else {
                        undoBut.setEnabled(false);
                    }
                }else
                if(e.getSource() == redoBut){
                    if((save_files -1) > current_article){
                        current_article++;
                        String texBoxString = originator.restoreFromMemento(caretaker.getMemento(current_article));
                        text_area.setText(texBoxString);
                        undoBut.setEnabled(true);
                    }else{
                        redoBut.setEnabled(false);
                    }
                }
        }
    }
}
