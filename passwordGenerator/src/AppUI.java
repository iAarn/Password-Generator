import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;


public class AppUI extends JFrame {

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
        button.addActionListener(new ListenerAction());
        copy.addActionListener(actionEvent -> {
            String ctc = area.getText();
            StringSelection stringSelection = new StringSelection(ctc);
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);
        });
        text.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (AlgorithmHash.CharsValidator(text.getText()) == true) {
                        area.setText(AlgorithmHash.Algorithm(Integer.parseInt(text.getText()), checkBox1.isSelected(), checkBox2.isSelected(), checkBox3.isSelected()));
                    }
                }
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
        setContentPane(container);
        setSize(200, 200);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private class ListenerCheckBox1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent a) {

        }
    }
    private class ListenerCheckBox2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {

        }
    }
    private class ListenerCheckBox3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {

        }
    }
    private class ListenerAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            if (AlgorithmHash.CharsValidator(text.getText()) == true) {
                area.setText(AlgorithmHash.Algorithm(Integer.parseInt(text.getText()), checkBox1.isSelected(), checkBox2.isSelected(), checkBox3.isSelected()));
            }    }
    }
    public static void main (String[]args){
        new AppUI();
    }
}