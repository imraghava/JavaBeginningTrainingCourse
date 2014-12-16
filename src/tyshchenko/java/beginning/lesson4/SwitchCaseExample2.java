package tyshchenko.java.beginning.lesson4;

/**
 * author Alexander Tyshchenko.
 */
public class SwitchCaseExample2 {
    public static void main(String args[]) {
        visitIsland("Santorini");
        visitIsland("Crete");
        visitIsland("Paros");
    }

    public static void visitIsland(String island) {
        switch(island) {
            case "Corfu":
                System.out.println("User wants to visit Corfu");
                break;
            case "Crete":
                System.out.println("User wants to visit Crete");
                break;
            case "Santorini":
                System.out.println("User wants to visit Santorini");
                break;
            case "Mykonos":
                System.out.println("User wants to visit Mykonos");
                break;
            default:
                System.out.println("Unknown Island");
                break;
        }
    }

}


