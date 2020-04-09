
import java.awt.event.*;
import javax.swing.*;

public class generator extends JFrame {
    JButton button = new JButton("Generate");
    JTextField text= new JTextField(9);
    JTextField area = new JTextField( 12);

    public generator()
    {
        super("Password Generator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        text.setToolTipText("Set password length");
        text.addActionListener(new ListenerInput());
        button.addActionListener(new ListenerAction());
        area.setText("Your Password : ");

        JPanel conteiner = new JPanel();
        conteiner.add(text);
        conteiner.add(area);
        conteiner.add(button);

        setContentPane(conteiner);
        setSize(200, 200);
        setVisible(true);
    }
    class ListenerInput implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            String temp = text.getText();
            int num = Integer.parseInt(temp);
        }
    }
    class ListenerAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            area.setText(generPass(Integer.parseInt(text.getText())));
        }
    }
    public static String generPass(int num){
        String temp ="";
        if(num>0){
            for(int i=0;i<num;i++){
                char index = letters.charAt((int) (Math.random() * letters.length()));
                temp = temp.concat(String.valueOf((char) index));
            }}
        return temp;

    }
    private static final String letters = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789!#$%&'()*+,-./:;<=>?@[]^_`{|}~";


    public static void main (String[]args){
        generator app = new generator();


    }

}

