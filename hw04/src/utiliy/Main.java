package utiliy;

public class Main {

    public static void main(String[] args) {

        String amount1 = "1 111 111,11 $";
        String amount2 = "2 222,22 $";
        String amount3 = "3,33 $";

        System.out.println(Utils.sumAmounts(amount1, amount2, amount3));
    }
}
