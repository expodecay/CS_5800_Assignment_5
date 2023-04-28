import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MessageApp extends JFrame {
    private JButton saveBut, undoBut, redoBut, user1But, user2But, user3But;
    public JTextArea text_area = new JTextArea(90,20);
    User current_user;
    ArrayList<MessageApp> recipients = new ArrayList<>();
    Message message;

    ChatHistory caretaker = new ChatHistory();

    ChatServer originator = new ChatServer();

    int save_files = 0, current_article = 0;

    public MessageApp(User user){
        current_user = user;
        message = new Message(user);
        //message = messg;
        this.setSize(750, 780);
        this.setTitle(user.getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Article"));
        panel1.add(text_area);

        ButtonListener saveListener = new ButtonListener();
        ButtonListener undoListener = new ButtonListener();
        ButtonListener redoListener = new ButtonListener();
        ButtonListener sendToUser1Listener = new ButtonListener();
        ButtonListener sendToUser2Listener = new ButtonListener();
        ButtonListener sendToUser3Listener = new ButtonListener();

        saveBut = new JButton("Save");
        saveBut.addActionListener(saveListener);

        undoBut = new JButton("Undo");
        undoBut.addActionListener(undoListener);

        redoBut = new JButton("Redo");
        redoBut.addActionListener(redoListener);

        user1But = new JButton("sndTo1");
        user1But.addActionListener(sendToUser1Listener);
        user2But = new JButton("sndTo2");
        user2But.addActionListener(sendToUser2Listener);
        user3But = new JButton("sndTo3");
        user3But.addActionListener(sendToUser3Listener);

        panel1.add(saveBut);
        panel1.add(undoBut);
        panel1.add(redoBut);

        panel1.add(user1But);
        panel1.add(user2But);
        panel1.add(user3But);

        this.add(panel1);
        this.setVisible(true);
    }

    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == user1But){
                System.out.println(current_user.getName());
                System.out.println(recipients.get(0));
                message.setMessage_content(text_area.getText());
                current_user.sendMessage(message, recipients.get(0));

            }else
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

    public void addRecipients(MessageApp recipient){
        System.out.println("here");
        recipients.add(recipient);
    }
}
