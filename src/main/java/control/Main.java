
package control;

import rest.RestExchangeRateLoader;
import view.MainFrame;


public class Main {
    public static void main(String [] args){
        ///Todo
        MainFrame mainFrame = new MainFrame(new RestExchangeRateLoader());
    }
}