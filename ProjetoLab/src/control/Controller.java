/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.*;

/**
 *
 * @author guilh
 */
public class Controller extends Dados {
    public void limpa(JTextField textField) {
        textField.setText("");
    }
    
    public void apenasNum(java.awt.event.KeyEvent evt) {
        // permite inserir apenas números no ra
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') ||
            (c == evt.VK_BACK_SPACE) ||
            (c == evt.VK_DELETE))) {
            evt.consume();
        }
    }
}
