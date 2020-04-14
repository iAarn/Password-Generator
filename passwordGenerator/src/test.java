import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashMap;

public class test {
    private static String standard = "qwertyuiopasdfghjklzxcvbnm";
    private static String upper = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static String digits = "0123456789";
    private static String specSymbols = "!#$%&'()*+,-./:;<=>?@[]^_`{|}";
    private static int box1 = 0;
    private static int box2 = 0;
    private static int box3 = 0;

    public static void main(String[] args) {


        String temp = "";
      //  Map<Integer, String> map1 = new LinkedHashMap<>();
      //  for (int i = 0; i < standard.length(); i++) {
      //      char index = standard.charAt(i);
      //      String t = standard.valueOf(index);
       //     map1.put(i, t);
     //   }
        String text = standard;//+upper;
        Map<Integer, String> map1 = putMap(text);
        int r = (int) (Math.random()*map1.size());
        temp = map1.get(((int)(Math.random()*map1.size())));
        System.out.println(temp);
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
}

