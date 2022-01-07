package raul.target;

//Essa é a 5
public class StringReverser {

    public static void main(String[] args) {
        String a = "raul";
        System.out.println(inverterString(a));
    }

    private static String inverterString(String s) {
        var newString = "";

        for(int i = s.length() - 1; i >= 0; i--) {
            newString += s.charAt(i);
        }
        return newString;
    }

}
