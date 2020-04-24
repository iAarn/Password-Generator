import javafx.scene.control.CheckBox;

import javax.swing.*;
import java.util.*;

public class AlgorithmHash {
    final static String standard = "qwertyuiopasdfghjklzxcvbnm";
    final static String upper = "QWERTYUIOPASDFGHJKLZXCVBNM";
    final static String digits = "0123456789";
    final static String specSymbols = "!#$%&'()*+,-./:;<=>?@[]^_`{|}";

    private static ArrayList<String> putList(String text){
        ArrayList<String> list = new ArrayList<>();
        for(int j=0;j<text.length();j++){
            char index = text.charAt(j);
            String t = String.valueOf(index);
            list.add(t);
        }
        return list;
    }
    public static Boolean CharsValidator (String text) {

        boolean temp = false;

        if (text.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Error! Text box is empty! Please, try to enter a number");
    }
        if (!isInteger(text)) {
        JOptionPane.showMessageDialog(null, "Error! You entered the letter!  Please, try to enter a number");
    }
        if ((Integer.parseInt(text) > 25) || Integer.parseInt(text) <= 0) {
        JOptionPane.showMessageDialog(null, "Error! Entered number is out of range! Max length of password if 25 numbers.");
    }
        else if (isInteger(text)) temp =true;
        return temp;
    }

    public static String Algorithm (int number, boolean checkBox1, boolean checkBox2, boolean checkBox3){

        ArrayList<String> list = putList(standard);

        if(checkBox1)list.addAll(putList(upper));
        if(checkBox2)list.addAll(putList(digits));
        if(checkBox3)list.addAll(putList(specSymbols));
        String text = "";

        for (int i=0; i<number;i++){
            text=text.concat(list.get((int)(Math.random()*list.size())));
        }
        return text;
    }

    private static boolean isInteger(String s){

        try{
            Integer.parseInt(s);
        }
        catch (NumberFormatException | NullPointerException n){
            return false;
        }
        return true;
    }
}