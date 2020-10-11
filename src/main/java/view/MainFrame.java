
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
        this.exchangeRateEurToDollar = exchangeLoader.load(new Currency("EUR","Euro", "€"), new Currency("USD", "Dólar", "$"));
        this.exchangeRateDollarToEur = exchangeLoader.load(new Currency("USD", "Dólar", "$"), new Currency("EUR","Euro", "€"));
        exchangeRateTextField.setText(String.valueOf(exchangeRateEurToDollar.getAmount()));
        initCurrencyComboBox();
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calculateButton = new javax.swing.JButton();
        exchangeRateTextField = new javax.swing.JTextField();
        fromTextField = new javax.swing.JTextField();
        toTextField = new javax.swing.JTextField();
        currencyComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });

        currencyComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                currencyComboBoxItemStateChanged(evt);
            }
        });

        jLabel1.setText("From:");

        jLabel2.setText("To:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Money Exchanger");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(currencyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(exchangeRateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(fromTextField)
                            .addComponent(toTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(calculateButton)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exchangeRateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addComponent(calculateButton)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void currencyComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_currencyComboBoxItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED ){
            if (currencyComboBox.getSelectedItem().equals("EURO")) {
                exchangeRateTextField.setText(String.valueOf(exchangeRateEurToDollar.getAmount()));
            }else{
                exchangeRateTextField.setText(String.valueOf(exchangeRateDollarToEur.getAmount()));
            }
        }
    }//GEN-LAST:event_currencyComboBoxItemStateChanged

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        toTextField.setText(String.valueOf(calculate()));
        
    }//GEN-LAST:event_calculateButtonActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calculateButton;
    private javax.swing.JComboBox<String> currencyComboBox;
    private javax.swing.JTextField exchangeRateTextField;
    private javax.swing.JTextField fromTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField toTextField;
    // End of variables declaration//GEN-END:variables

    private void initCurrencyComboBox() {
        currencyComboBox.addItem("EURO");
        currencyComboBox.addItem("DOLLAR");
    }

    private double calculate() {
        double from= Double.valueOf(fromTextField.getText());
        double rate = Double.valueOf(exchangeRateTextField.getText());
       
        BigDecimal bd = new BigDecimal(rate*from);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
