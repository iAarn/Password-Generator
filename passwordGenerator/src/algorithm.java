public class algorithm {
    public static String gePass(int num){
        String temp ="";
        if(num>0){
            for(int i=0;i<num;i++){
                char index = letters.charAt((int) (Math.random() * letters.length()));
                temp = temp.concat(String.valueOf((char) index));
            }
        }
        return temp;

    }
    private static final String
    letters = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
}
