package tyshchenko.java.beginning.lesson2;

/**
 * author Alexander Tyshchenko.
 */
public class StringExample1 {
    public static void main(String[] args) {
        String s1 = "abCd";
        String s2 = "12345";
        String s3 = s1 + s2; // “abCd12345”
        String s4 = s1.substring(2); // “Cd”
        int x = s2.length(); // 5
        String s5 = s1.toUpperCase(); // “ABCD”
        char c = s1.charAt(0); // ‘a’
        int pos = s1.indexOf("bC"); // 1
        String s6 = "aaacccddd".replace("ccc", "qqq"); // “aaaqqqddd”

        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }
}
