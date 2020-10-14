package control;

import rest.RestExchangeRateLoader;
import view.MainFrame;


public class Main {
/**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame(new RestExchangeRateLoader()).setVisible(true);
            }
        });
    }
}