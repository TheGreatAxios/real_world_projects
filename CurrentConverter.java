import java.util.Scanner;

public class CurrentConverter {
    
    enum Currencies {
        USD,
        JPY,
        GBP,
        AUD,
        EUR,
        CAD
    }

    public static double getCents(String money) {
        
        double smallestUnit = Double.parseDouble(money);
        return smallestUnit;
    }
    
    public static CurrentConverter.Currencies getCurrency(String userInput) {
        
        String currency = userInput.toUpperCase();
        if (currency.equals("USD")) {
            return Currencies.USD;
        } else if (currency.equals("GBP")) {
            return Currencies.GBP;
        } else if (currency.equals("AUD")) {
            return Currencies.AUD;
        } else if (currency.equals("JPY")) {
            return Currencies.JPY;
        } else if (currency.equals("EUR")) {
            return Currencies.EUR;
        } else if (currency.equals("CAD")) {
            return Currencies.CAD;
        } else {
            return null;
        }
    }

    public static void finalOutput(CurrentConverter.Currencies o, CurrentConverter.Currencies n, double value, String originalValue) {
        double convertedToUSD = 0;

        if (o == Currencies.GBP) {
            convertedToUSD = value * 1.37;
        } else if (o == Currencies.AUD) {
            convertedToUSD = value * 0.77;
        } else if (o == Currencies.JPY) {
            convertedToUSD = value * 0.0095;
        } else if (o == Currencies.EUR) {
            convertedToUSD = value * 1.20;
        } else if (o == Currencies.CAD) {
            convertedToUSD = value / 0.78;
        } else {
            convertedToUSD = (double) value;
        }
        convertedToUSD = ((int)(convertedToUSD * 100)) / 100.00;
        System.out.printf("Converted to USD: %.2f", convertedToUSD);
        double newCurrency;
        if (n == Currencies.GBP) {
            newCurrency = convertedToUSD / 1.37;
        } else if (n == Currencies.AUD) {
            newCurrency = convertedToUSD / 1.31;
        } else if (n == Currencies.JPY) {
            newCurrency = convertedToUSD * 0.0095;
        } else if (n == Currencies.EUR) {
            newCurrency = convertedToUSD / 1.20;
        } else if (n == Currencies.CAD) {
            newCurrency = convertedToUSD * 0.78;
        } else {
            newCurrency = (double) convertedToUSD;
        }
        System.out.printf("newCurrency %.2f", newCurrency);
        double newValue = ((int)(newCurrency * 100)) / 100.00;
        System.out.printf("new value %.2f", newValue);
        System.out.printf("$%s, %s is equal to $%.2f %s%n", originalValue, o.toString(), newValue, n.toString());
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("What currency do you have? (USD, JPY, GBP, AUD, EUR, CAD) ");

        String myCurrency = scanner.nextLine();
        Currencies originalCurrencyConverted = getCurrency(myCurrency);

        System.out.println(originalCurrencyConverted);
        if (originalCurrencyConverted == null) System.exit(1);

        System.out.print("How much money do you have? $");

        String totalMoney = scanner.nextLine();

        double moneyToDouble = getCents(totalMoney);

        System.out.print("What currency do you want to convert too? (USD, JPY, GBP, AUD, EUR, CAD) ");

        String newCurrency = scanner.nextLine();
        Currencies convertingToCurrency = getCurrency(newCurrency);
        if (convertingToCurrency == null) System.exit(1);

        finalOutput(originalCurrencyConverted, convertingToCurrency, moneyToDouble, totalMoney);

        scanner.close();
        System.out.println("Closing the Converter....");
        System.exit(1);
    }
}
