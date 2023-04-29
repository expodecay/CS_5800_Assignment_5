import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MessageApp extends JFrame {
    private JButton saveBut, undoBut, redoBut, user1But, user2But, user3But, chatHist;
    public JTextArea text_area = new JTextArea(35,20);
    User current_user;
    ArrayList<User> recipients;
    Message message;

    public ChatHistory history = new ChatHistory();

    ChatServer originator;

    int save_files = 0, current_article = 0;

    public MessageApp(User user){
        current_user = user;
        message = new Message(user);

        //message = messg;
        this.setSize(900, 350);
        this.setTitle(user.getUserName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel(current_user.getUserName()));
        panel1.add(text_area);

        ButtonListener saveListener = new ButtonListener();
        ButtonListener undoListener = new ButtonListener();
        ButtonListener redoListener = new ButtonListener();
        ButtonListener sendToUser1Listener = new ButtonListener();
        ButtonListener sendToUser2Listener = new ButtonListener();
        ButtonListener sendToUser3Listener = new ButtonListener();
        ButtonListener historyButton = new ButtonListener();

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

        chatHist = new JButton("history");
        chatHist.addActionListener(historyButton);

        panel1.add(saveBut);
        panel1.add(undoBut);
        panel1.add(redoBut);

        panel1.add(user1But);
        panel1.add(user2But);
        panel1.add(user3But);

        panel1.add(chatHist);

        this.add(panel1);
        this.setVisible(true);
    }

    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == chatHist){
                System.out.println(".....................");
                printChatHistory();
                System.out.println(".....................");
            }else
                if(e.getSource() == user1But){
                    userSend(0);

                }else
                    if(e.getSource() == user2But){
                        userSend(1);

                    }else
                        if(e.getSource() == user3But){
                            userSend(2);

                        }else
                            if(e.getSource() == saveBut){
                                userSave();
                            }else
                                if(e.getSource() == undoBut){
                                    userUndo();
                                }else
                                    if(e.getSource() == redoBut){
                                        userRedo();
                                }
        }
    }

    public void connectToServer(ChatServer server, User user){
        originator = server;
        originator.addRecipients(user);
        recipients = server.getRecipients();

    }

    public void userSend(int i){
        Message newMessage = new Message(message.getSender_object());
        newMessage.setMessage_content(text_area.getText());
        history.updateChatHistory(newMessage);
        recipients.get(i).getMessageApp().history.updateChatHistory(newMessage);
        System.out.println(current_user.getUserName() + " Sending message to " + recipients.get(i).getUserName());
        message.setMessage_content(text_area.getText());
        originator.sendMessage(newMessage, recipients.get(i));
    }

    public void userSave(){
        String textInTextArea = text_area.getText();

        originator.set(textInTextArea);

        history.addMemento(originator.storeInMemento());

        save_files+=1;
        current_article+=1;
        System.out.println("Save Files " + save_files);

        undoBut.setEnabled(true);
    }

    public void userUndo(){
        if(current_article >= 1){
            current_article-=1;
            String texBoxString = originator.restoreFromMemento(history.getMemento(current_article));
            text_area.setText(texBoxString);
            redoBut.setEnabled(true);
        }else {
            undoBut.setEnabled(false);
        }
    }

    public void userRedo(){
        if((save_files -1) > current_article){
            current_article+=1;
            String texBoxString = originator.restoreFromMemento(history.getMemento(current_article));
            text_area.setText(texBoxString);
            undoBut.setEnabled(true);
        }else{
            redoBut.setEnabled(false);
        }
    }

    public void updateTextArea(String text){
        text_area.setText(text);
    }

    public void printChatHistory(){
        System.out.println();

        /*System.out.println("History for " + current_user.getUserName());
        for(int i=0; i<history.getSize(); i++){
            System.out.println(history.getMemento(i).getSavedArticle());
        }*/
        System.out.println("History for " + current_user.getUserName());
        history.getMessages();
    }

    public void printChatHistoryByUser(User user){
        System.out.println(history.iterator(user).hasNext());
    }

}
