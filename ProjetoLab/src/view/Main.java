package view;

/**
 *
 * @author guilh
 */
public class Main {  
    // Main
    public static void main(String args[]) {       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
}
