package seasons;

import java.time.Month;

public class Main {

    public static void main(String[] args) {

        System.out.println(Season.SPRING.getName());

        for (Month month : Season.SUMMER.getMonths()) {
            System.out.println(month);
        }

        System.out.println(Season.AUTUMN.hasMonth(5));
        System.out.println(Season.AUTUMN.hasMonth(9));
    }
}
