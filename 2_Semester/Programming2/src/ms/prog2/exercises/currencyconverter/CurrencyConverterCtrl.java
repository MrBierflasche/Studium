package ms.prog2.exercises.currencyconverter;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverterCtrl {

    @FXML private ComboBox<String> fromCurrency;
    @FXML private ComboBox<String> toCurrency;
    @FXML private TextField amountField;
    @FXML private TextField resultField;

    @FXML
    public void initialize() {
        fromCurrency.getItems().addAll("EUR", "USD", "GBP", "ISK", "JPY", "CHF");
        toCurrency.getItems().addAll("EUR", "USD", "GBP", "ISK", "JPY", "CHF");
        fromCurrency.setValue("EUR");
        toCurrency.setValue("ISK");
    }

    @FXML
    public void convert() {
        // Wechselkurse - Euro als Basis
        Map<String, Double> rates = new HashMap<>();
        rates.put("EUR", 1.0);
        rates.put("USD", 1.15);
        rates.put("GBP", 0.86);
        rates.put("ISK", 143.60);
        rates.put("JPY", 186.14);
        rates.put("CHF", 0.92);

        try {
            double amount = Double.parseDouble(amountField.getText());
            String from = fromCurrency.getValue();
            String to = toCurrency.getValue();

            double inEur = amount / rates.get(from); // Als gemeinsame Basis in Euro umwandeln
            double result = inEur * rates.get(to); // Dann von Euro in Zielbasis umrechnen

            resultField.setText(String.format("%.2f", result));
        } catch (NumberFormatException e) {
            resultField.setText("Ungültige Eingabe");
        }
    }
}
