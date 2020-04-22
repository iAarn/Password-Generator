import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class AlgorithmHash {
    final static String standard = "qwertyuiopasdfghjklzxcvbnm";
    final static String upper = "QWERTYUIOPASDFGHJKLZXCVBNM";
    final static String digits = "0123456789";
    final static String specSymbols = "!#$%&'()*+,-./:;<=>?@[]^_`{|}";
    private static String text = "";

    private static Map<Integer, String> putMap(String text){
        Map<Integer, String> map = new LinkedHashMap<>();
        for(int j=0;j<text.length();j++){
            char index = text.charAt(j);
            String t = String.valueOf(index);
            map.put(j, t);
        }
        return map;
    }

    public AlgorithmHash(String temp, int box1, int box2, int box3) {
        if (temp.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error! Text box is empty! Please, try to enter a number");
        } else if (!isInteger(temp)) {
            JOptionPane.showMessageDialog(null, "Error! You entered the letter!  Please, try to enter a number");
        } else if ((Integer.parseInt(temp) > 25) || Integer.parseInt(temp) <= 0) {
            JOptionPane.showMessageDialog(null, "Error! Entered number is out of range! Max length of password if 25 numbers.");
        } else {
                int num = Integer.parseInt(temp);
                 text = "";
                if (box1 == 0 && box2 == 0 && box3 == 0) {
                    Map<Integer, String> map = putMap(standard);
                    for (int i = 0; i < num; i++) {
                        int r = (int) (Math.random()*map.size());
                        text=text.concat(map.get(((int)(Math.random()*map.size()))));                }
                }else if (box1 == 1 && box2 == 0 && box3 == 0) {
                    Map<Integer, String> map = putMap(standard + upper);
                    for (int i = 0; i < num; i++) {
                        text=text.concat(map.get(((int)(Math.random()*map.size()))));                }
                }else if (box1 == 1 && box2 == 1 && box3 == 0) {
                    Map<Integer, String> map = putMap(standard + upper + digits);
                    for (int i = 0; i < num; i++) {
                        text=text.concat(map.get(((int)(Math.random()*map.size()))));                }
                }else if (box1 == 1 && box2 == 1 && box3 == 1) {
                    Map<Integer, String> map = putMap(standard + upper + digits + specSymbols);
                    for (int i = 0; i < num; i++) {
                        text=text.concat(map.get(((int)(Math.random()*map.size()))));                }
                }else if (box1 == 0 && box2 == 1 && box3 == 1) {
                    Map<Integer, String> map = putMap(standard + digits + specSymbols);
                    for (int i = 0; i < num; i++) {
                        text=text.concat(map.get(((int)(Math.random()*map.size()))));                }
                }else if (box1 == 1 && box2 == 0 && box3 == 1) {
                    Map<Integer, String> map = putMap(standard + upper + specSymbols);
                    for (int i = 0; i < num; i++) {
                        text=text.concat(map.get(((int)(Math.random()*map.size()))));                }
                }else if (box1 == 0 && box2 == 0 && box3 == 1) {
                    Map<Integer, String> map = putMap(standard + specSymbols);
                    for (int i = 0; i < num; i++) {
                        text=text.concat(map.get(((int)(Math.random()*map.size()))));                }
                }else if (box1 == 0 && box2 == 1 && box3 == 0) {
                    Map<Integer, String> map = putMap(standard + digits);
                    for (int i = 0; i < num; i++) {
                        text=text.concat(map.get(((int)(Math.random()*map.size()))));                }
                }
        }
    }

    public static String getText() {
        return text;
    }

    private static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException | NullPointerException n){
            return false;
        }
        return true;
    }
}