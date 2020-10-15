package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import model.Currency;
import model.ExchangeRate;

public class RestExchangeRateLoader {

    public ExchangeRate load(Currency from, Currency to) {
        try {
            return new ExchangeRate(from, to, read(from.getCode(), to.getCode()));
        } catch (IOException ex) {
            return null;
        }
    }

    private double read(String from, String to) throws IOException {
        URL url = new URL("http://api.currencylayer.com/live?access_key=b15d18f004bb805785647b73d8b60a22");
        URLConnection connection = url.openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            String line1 = line.substring(line.indexOf("USDEUR")+8, line.indexOf("USDEUR")+16);
            if (from.equals("USD")) {
                return Double.parseDouble(line1);
            }else{
                return 1/Double.parseDouble(line1);
            }
        }
    }

}