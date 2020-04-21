import java.util.LinkedHashMap;
import java.util.Map;

public class AlgorithmHash {
    final static String standard = "qwertyuiopasdfghjklzxcvbnm";
    final static String upper = "QWERTYUIOPASDFGHJKLZXCVBNM";
    final static String digits = "0123456789";
    final static String specSymbols = "!#$%&'()*+,-./:;<=>?@[]^_`{|}";
    private static int box1 =0;
    private static int box2=0;
    private static int box3=0;

    public static String gPass (int num){
       String temp ="";

        if (num>0){

            if (box1 == 0 && box2 == 0 && box3 == 0) {
                Map<Integer, String> map = putMap(standard);
                for (int i = 0; i < num; i++) {
                    int r = (int) (Math.random()*map.size());
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));                }
            }else if (box1 == 1 && box2 == 0 && box3 == 0) {
                Map<Integer, String> map = putMap(standard + upper);
                for (int i = 0; i < num; i++) {
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));                }
            }else if (box1 == 1 && box2 == 1 && box3 == 0) {
                Map<Integer, String> map = putMap(standard + upper + digits);
                for (int i = 0; i < num; i++) {
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));                }
            }else if (box1 == 1 && box2 == 1 && box3 == 1) {
                Map<Integer, String> map = putMap(standard + upper + digits + specSymbols);
                for (int i = 0; i < num; i++) {
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));                }
            }else if (box1 == 0 && box2 == 1 && box3 == 1) {
                Map<Integer, String> map = putMap(standard + digits + specSymbols);
                for (int i = 0; i < num; i++) {
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));                }
            }else if (box1 == 1 && box2 == 0 && box3 == 1) {
                Map<Integer, String> map = putMap(standard + upper + specSymbols);
                for (int i = 0; i < num; i++) {
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));                }
            }else if (box1 == 0 && box2 == 0 && box3 == 1) {
                Map<Integer, String> map = putMap(standard + specSymbols);
                for (int i = 0; i < num; i++) {
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));                }
            }else if (box1 == 0 && box2 == 1 && box3 == 0) {
                Map<Integer, String> map = putMap(standard + digits);
                for (int i = 0; i < num; i++) {
                    temp=temp.concat(map.get(((int)(Math.random()*map.size()))));                }
            }

        }
        return temp;
    }
    private static Map<Integer, String> putMap(String text){
        Map<Integer, String> map = new LinkedHashMap<>();
        for(int j=0;j<text.length();j++){
            char index = text.charAt(j);
            String t = String.valueOf(index);
            map.put(j, t);
        }
        return map;
    }

    public static void setBox1(int box1) {
        AlgorithmHash.box1 = box1;
    }

    public static void setBox2(int box2) {
        AlgorithmHash.box2 = box2;
    }

    public static void setBox3(int box3) {
        AlgorithmHash.box3 = box3;
    }

}
