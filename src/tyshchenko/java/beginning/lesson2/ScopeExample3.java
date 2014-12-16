package tyshchenko.java.beginning.lesson2;

/**
 * author Alexander Tyshchenko.
 */
public class ScopeExample3 {

    private static String global = "Global 2";

    public static void main(String[] args) {
        System.out.println("Begin program");
        String global = "Global Var";
        {
            String local ="Local Var";
            {

                System.out.println("Local Scope :");
                System.out.println("global=" + global);
                System.out.println("local=" + local);
            }
        }
        System.out.println("__________________");
        System.out.println("Global Scope :");
        System.out.println("global=" + global);
        //System.out.println("local=" + local); //ScopeExample3.java: error: cannot find symbol
        System.out.println("End program");
        System.out.println(ScopeExample3.global);
        myMethod();
    }

    static void myMethod() {
        System.out.println(ScopeExample3.global);
    }
}


