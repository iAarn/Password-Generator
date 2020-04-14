import java.awt.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AlgoritmHash {
    private static String standard = "qwertyuiopasdfghjklzxcvbnm";
    private static String upper = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static String digits = "0123456789";
    private static String specSymbols = "!#$%&'()*+,-./:;<=>?@[]^_`{|}";
    private static int box1 =0;
    private static int box2=0;
    private static int box3=0;

    public static String gPass (int num){
        String temp ="";

        if (num>0){

            if (box1 == 0 && box2 == 0 && box3 == 0) {
                String text = standard;
                Map<Integer, String> map = putMap(text);
                for (int i = 0; i < num; i++) {
                    int r = (int) (Math.random()*map.size());
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));                }
            }else if (box1 == 1 && box2 == 0 && box3 == 0) {
                String text = standard + upper;
                Map<Integer, String> map = putMap(text);
                for (int i = 0; i < num; i++) {
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));                }
            }
            else if (box1 == 1 && box2 == 1 && box3 == 0) {
                String text = standard + upper + digits;
                Map<Integer, String> map = putMap(text);
                for (int i = 0; i < num; i++) {
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));                }
            } else if (box1 == 1 && box2 == 1 && box3 == 1) {
                String text = standard + upper + digits + specSymbols;
                Map<Integer, String> map = putMap(text);
                for (int i = 0; i < num; i++) {
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));                }
            }else if (box1 == 0 && box2 == 1 && box3 == 1) {
                String text = standard + digits + specSymbols;
                Map<Integer, String> map = putMap(text);
                for (int i = 0; i < num; i++) {
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));                }
            }else if (box1 == 1 && box2 == 0 && box3 == 1) {
                String text = standard + upper + specSymbols;
                Map<Integer, String> map = putMap(text);
                for (int i = 0; i < num; i++) {
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));                }
            }else if (box1 == 0 && box2 == 0 && box3 == 1) {
                String text = standard + specSymbols;
                Map<Integer, String> map = putMap(text);
                for (int i = 0; i < num; i++) {
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));
                }
            }else if (box1 == 0 && box2 == 1 && box3 == 0) {
                String text = standard + digits;
                Map<Integer, String> map = putMap(text);
                for (int i = 0; i < num; i++) {
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));
                }
            }
        }
        return temp;
    }
    private static Map<Integer, String> putMap(String text){
        Map<Integer, String> map = new LinkedHashMap<>();
        for(int j=0;j<text.length();j++){
            char index = text.charAt(j);
            String t = text.valueOf(index);
            map.put(j, t);
        }
        return map;
    }

    public static void setBox1(int box1) {
        AlgoritmHash.box1 = box1;
    }

    public static void setBox2(int box2) {
        AlgoritmHash.box2 = box2;
    }

    public static void setBox3(int box3) {
        AlgoritmHash.box3 = box3;
    }

}
