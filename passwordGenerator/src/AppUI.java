import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppUI extends JFrame {
    JButton button = new JButton("Generate");

    JTextField text= new JTextField( 12);
    JTextField area = new JTextField( 12);
    JCheckBox checkBox1 = new JCheckBox("Upper Case", false);
    JCheckBox checkBox2 = new JCheckBox("Digits", false);
    JCheckBox checkBox3 = new JCheckBox("Special chars", false);



    private AppUI()
    {
        super("Password Generator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        text.setToolTipText("Set password length");
        text.addActionListener(new ListenerInput());
        button.addActionListener(new ListenerAction());
        checkBox1.addActionListener(new ListenerCheckBox1());
        checkBox2.addActionListener(new ListenerCheckBox2());
        checkBox3.addActionListener(new ListenerCheckBox3());
        area.setText("Your Password : ");

        JPanel conteiner = new JPanel();
        conteiner.add(text);
        conteiner.add(area);
        conteiner.add(button);
        conteiner.add(checkBox1);
        conteiner.add(checkBox2);
        conteiner.add(checkBox3);

        setContentPane(conteiner);
        setSize(200, 200);
        setVisible(true);
    }
    private class ListenerCheckBox1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            if(checkBox1.isSelected()){

                AlgoritmHash.setBox1(1);

            }
        }
    }private class ListenerCheckBox2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            if(checkBox2.isSelected()){

                AlgoritmHash.setBox2(1);


            }

        }
    }private class ListenerCheckBox3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            if(checkBox3.isSelected()){
               AlgoritmHash.setBox3(1);


            }
        }
    }
    private class ListenerInput implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            String temp = text.getText();
            int num = Integer.parseInt(temp);
        }
    }
    private class ListenerAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {

           area.setText(AlgoritmHash.gPass(Integer.parseInt(text.getText())));

        }
    }



    public static void main (String[]args){
        AppUI app = new AppUI();


    }

}

