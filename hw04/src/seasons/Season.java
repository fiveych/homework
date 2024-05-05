package seasons;

import java.time.Month;

enum Season {

    SPRING("Весна", Month.MARCH, Month.APRIL, Month.MAY),
    SUMMER("Лето", Month.JUNE, Month.JULY, Month.AUGUST),
    AUTUMN("Осень", Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER),
    WINTER("Зима", Month.DECEMBER, Month.JANUARY, Month.FEBRUARY);

    private final String name;
    private final Month[] months;

    Season(String name, Month... months) {
        this.name = name;
        this.months = months;
    }

    public String getName() {
        return name;
    }

    public Month[] getMonths() {
        return months;
    }

    public boolean containsMonth(int monthNumber) {

        for (Month month : months) {
            if (month.ordinal() + 1 == monthNumber) {
                return true;
            }
        }

        return false;
    }
}

