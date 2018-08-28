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
public class LoginController extends Dados{       
    public String login(JTextField raTextField, JTextField userTextField, JTextField passTextField,
        JLabel welcomeLabel) {

        /* Se os campos nao estiverem vazios, procura o usuario e faz login */       
        String sRa = raTextField.getText();
        String nome = userTextField.getText();
        String senha = passTextField.getText();
     
        if (!(sRa.isEmpty() ||
                nome.isEmpty() ||
                senha.isEmpty())) {
            
            int ra = Integer.parseInt(raTextField.getText());
            boolean sucesso = verifica_login(ra, nome, senha);
            if (sucesso) {
                welcomeLabel.setText("Bem vindo " + welcomeLabel());
                return getFunc(index).getCard();
            }
        }
        
        return "";
    }

    private int pesquisa(int ra) {
        for (int i=0; i < list.size(); i++) {
            if (list.get(i).getRa() == ra) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean compara(int k, int ra, String nome, String senha) {
        return list.get(k).getRa() == ra &&
                list.get(k).getNome().equals(nome) &&
                list.get(k).getSenha().equals(senha);
    }
        
    private boolean verifica_login(int ra, String nome, String senha) {
        int i = pesquisa(ra);
        if (i != -1 && compara(i, ra, nome, senha)) {
            // salva funcionario atual
            index = i;        
            return true;
        }
        return false;
    }
    
    private String welcomeLabel() {
        return list.get(index).getNome();
    }
}
