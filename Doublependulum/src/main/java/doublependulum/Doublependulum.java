package doublependulum;

import doublependulum.ui.UI;
import javafx.application.Application;
/**
 * @author KevHann
 * Run a simulation of two balls connected by a rigid line. The starting positions,
 * masses and the gravity can be chosen by the user.
 */
public class Doublependulum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(UI.class);
    }
}
