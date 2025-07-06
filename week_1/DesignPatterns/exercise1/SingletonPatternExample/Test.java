package SingletonPatternExample;

public class Test {
    public static void main(String[] args) {
        Logger l1 = Logger.getLogger();
        Logger l2 = Logger.getLogger();

        l1.log("this is l1");
        l2.log("this is l2");

        if(l1 == l2){
            System.out.println("Same instance! Singleton achieved.");
        }
        else{
            System.out.println("Different instance");
        }
    }

}
