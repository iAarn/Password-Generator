import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;


public class AppUI extends JFrame {
    private int box1;
    private int box2;
    private int box3;

    JButton button = new JButton("Generate");

    JButton copy = new JButton("Copy");

    JTextField text= new JTextField( 6);
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
        copy.addActionListener(actionEvent -> {
            String ctc = area.getText();
            StringSelection stringSelection = new StringSelection(ctc);
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);
        });
        text.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
               if(e.getKeyCode() == KeyEvent.VK_ENTER){ new AlgorithmHash(text.getText(), box1, box2, box3);
               area.setText(AlgorithmHash.getText());}
            }
        });
        checkBox1.addActionListener(new ListenerCheckBox1());
        checkBox2.addActionListener(new ListenerCheckBox2());
        checkBox3.addActionListener(new ListenerCheckBox3());
        area.setText("Your Password : ");

        JPanel container = new JPanel();

        container.add(text);
        container.add(area);
        container.add(button);
        container.add(copy);
        container.add(checkBox1);
        container.add(checkBox2);
        container.add(checkBox3);
        setResizable(false);
    getRootPane().setDefaultButton(button);
        setContentPane(container);
        setSize(200, 200);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private class ListenerCheckBox1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent a) {
            if(checkBox1.isSelected()){
                box1=1;
            }else {
                box1=0;
            }
        }
    }
    private class ListenerCheckBox2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            if(checkBox2.isSelected()){
                box2=1;
            }else{
               box2=0;
            }
        }
    }
    private class ListenerCheckBox3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            if(checkBox3.isSelected()){
               box3=1;
            }else{
              box3=0;
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
          new AlgorithmHash(text.getText(), box1, box2, box3);
          area.setText(AlgorithmHash.getText());
        }
    }
    private static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException | NullPointerException n){
            return false;
        }
    return true;
}
    public static void main (String[]args){
        new AppUI();
    }
}