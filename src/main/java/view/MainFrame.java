
package view;

import java.awt.event.ItemEvent;
import model.Currency;
import model.ExchangeRate;
import rest.RestExchangeRateLoader;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class MainFrame extends javax.swing.JFrame {


    private ExchangeRate exchangeRateEurToDollar;
    private ExchangeRate exchangeRateDollarToEur;
    
    public MainFrame(RestExchangeRateLoader exchangeLoader) {
        initComponents();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        loadExchangeRate(exchangeLoader);
        fromAmountTextField.setText("1");
        toAmountTextField.setText(String.valueOf(exchangeRateEurToDollar.getAmount()));
        initCurrencyComboBox();       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fromAmountTextField = new javax.swing.JTextField();
        toAmountTextField = new javax.swing.JTextField();
        currencyFromComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        currencyTojComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fromAmountTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fromAmountTextFieldKeyReleased(evt);
            }
        });

        toAmountTextField.setEditable(false);
        toAmountTextField.setBackground(new java.awt.Color(204, 204, 204));

        currencyFromComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                currencyFromComboBoxItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Money Exchanger");

        currencyTojComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                currencyTojComboBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(currencyTojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currencyFromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyFromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyTojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void currencyFromComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_currencyFromComboBoxItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED ){
            if (currencyFromComboBox.getSelectedItem().equals("EURO")) {
                toAmountTextField.setText(String.valueOf(calculate(exchangeRateEurToDollar)));
                currencyTojComboBox.setSelectedItem("DOLAR");
            }else{
                toAmountTextField.setText(String.valueOf(calculate(exchangeRateDollarToEur)));
                currencyTojComboBox.setSelectedItem("EURO");
            }
        }
    }//GEN-LAST:event_currencyFromComboBoxItemStateChanged

    private void currencyTojComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_currencyTojComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED ){
            if (currencyTojComboBox.getSelectedItem().equals("EURO")) {
                toAmountTextField.setText(String.valueOf(calculate(exchangeRateDollarToEur)));
                currencyFromComboBox.setSelectedItem("DOLAR");
            }else{
                toAmountTextField.setText(String.valueOf(calculate(exchangeRateEurToDollar)));
                currencyFromComboBox.setSelectedItem("EURO");
            }
        }
    }//GEN-LAST:event_currencyTojComboBoxItemStateChanged

    private void fromAmountTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromAmountTextFieldKeyReleased
        char caracter = evt.getKeyChar();
        if((caracter < '0' || caracter > '9') && caracter != 8)  {
           evt.consume();  // ignorar el evento de teclado
        } else {
            if (currencyFromComboBox.getSelectedItem().equals("EURO")) {
                toAmountTextField.setText(String.valueOf(calculate(exchangeRateEurToDollar)));
            }else{
                toAmountTextField.setText(String.valueOf(calculate(exchangeRateDollarToEur)));
            }
        }
    }//GEN-LAST:event_fromAmountTextFieldKeyReleased

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> currencyFromComboBox;
    private javax.swing.JComboBox<String> currencyTojComboBox;
    private javax.swing.JTextField fromAmountTextField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField toAmountTextField;
    // End of variables declaration//GEN-END:variables

    private void initCurrencyComboBox() {
        currencyFromComboBox.addItem("EURO");
        currencyFromComboBox.addItem("DOLAR");
        currencyTojComboBox.addItem("DOLAR");
        currencyTojComboBox.addItem("EURO");
    }

    private double calculate(ExchangeRate exchangeRate) {
        if(!fromAmountTextField.getText().isEmpty()){
            double from= Double.valueOf(fromAmountTextField.getText());      
            BigDecimal bd = new BigDecimal(from * exchangeRate.getAmount());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }else{
            return 0;
        }
    }
    
    private void loadExchangeRate (RestExchangeRateLoader exchangeLoader){
        exchangeRateEurToDollar = exchangeLoader.load(new Currency("EUR","Euro", "€"), new Currency("USD", "Dólar", "$"));
        exchangeRateDollarToEur = exchangeLoader.load(new Currency("USD", "Dólar", "$"), new Currency("EUR","Euro", "€"));
    }
}
