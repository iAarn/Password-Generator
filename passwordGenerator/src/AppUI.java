import javax.swing.*;
import java.awt.*;
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

        JPanel container = new JPanel();
        container.add(text);
        container.add(area);
        container.add(button);
        container.add(checkBox1);
        container.add(checkBox2);
        container.add(checkBox3);

        setContentPane(container);
        setSize(200, 200);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private class ListenerCheckBox1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            if(checkBox1.isSelected()){
                AlgoritmHash.setBox1(1);
            }else {
                AlgoritmHash.setBox1(0);
            }
        }
    }private class ListenerCheckBox2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            if(checkBox2.isSelected()){
                AlgoritmHash.setBox2(1);
            }else{
                AlgoritmHash.setBox2(0);
            }
        }
    }private class ListenerCheckBox3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            if(checkBox3.isSelected()){
               AlgoritmHash.setBox3(1);
            }else{
                AlgoritmHash.setBox3(0);
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
if(text.getText().isEmpty()){
    setLocationRelativeTo(null);
    JOptionPane.showMessageDialog(null,"Error! Text box is empty! Please, try to enter a number" );
    setVisible(true);
}else if(isInteger(text.getText()) == false){
    setLocationRelativeTo(null);
    JOptionPane.showMessageDialog(null,"Error! You entered the letter  Please, try to enter a number" );
    setVisible(true);
}
else {
    area.setText(AlgoritmHash.gPass(Integer.parseInt(text.getText())));
}
        }
    }
private static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException n){
            return false;
        }catch (NullPointerException nu){
            return false;
        }
        return true;
}



    public static void main (String[]args){
        AppUI app = new AppUI();


    }

}

