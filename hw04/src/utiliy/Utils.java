package utiliy;

import java.text.NumberFormat;
import java.util.Locale;

public class Utils {

    private static final String EMPTY = "";
    private static final String COMMA = ",";
    private static final String DOT = ".";

    private Utils() {
    }

    public static String sumAmounts(String... amounts) {

        if (amounts.length == 0) {
            throw new IllegalArgumentException("Нулевое количество сумм");
        }

        if (!areCurrenciesEqual(amounts)) {
            throw new IllegalArgumentException("Суммы в разной валюте");
        }

        double value = 0.0;

        for (String amount : amounts) {
            value = value + toDoubleValue(amount);
        }

        String currencySymbol = getCurrencySymbol(amounts[0]);

        return toStringValue(value, currencySymbol);
    }

    private static boolean areCurrenciesEqual(String... amounts) {

        String[] currencySymbols = new String[amounts.length];

        for (int index = 0; index < currencySymbols.length; index++) {
            currencySymbols[index] = getCurrencySymbol(amounts[index]);
        }

        for (int index = 1; index < currencySymbols.length; index++) {
            if (!currencySymbols[index].equals(currencySymbols[index - 1])) {
                return false;
            }
        }

        return true;
    }

    private static String getCurrencySymbol(String amount) {
        return amount.replaceAll("[^\\p{Sc}]", "");
    }

    private static double toDoubleValue(String value) {
        return Double.parseDouble(value
                .replaceAll("[^\\d,]", EMPTY)
                .replace(COMMA, DOT));
    }

    private static String toStringValue(double value, String currencySymbol) {
        return NumberFormat.getNumberInstance(Locale.FRANCE).format(value) + " " + currencySymbol;
    }
}
