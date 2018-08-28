/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.CardLayout;
import model.*;
import javax.swing.*;

/**
 *
 * @author guilh
 */
public class SuperUserController extends Dados{
    public void executar(JComboBox comboBox) {
        Object item = comboBox.getSelectedItem();
        String value = ((ComboItem)item).getValue();
        if (!"".equals(value)) {
            current_user = Integer.parseInt(value);
        }
    }
    
    public void usuariosComTicket(JComboBox comboBox) {
        // salva usuarios com ticket aberto na comboBox
        for (int i=0; i < list.size(); i++) {
            if (!"".equals(list.get(i).getTicket())) {
                comboBox.addItem(new ComboItem(list.get(i).getNome(), Integer.toString(i)));
            }
        }
    }
              
    public void ler(JLabel welcome, JTextArea ticket, JTextArea resposta, JButton enviar,
            JButton cancelar, JButton editar, JButton voltar) {
        welcome.setVisible(false);
        enviar.setVisible(false);
        cancelar.setVisible(false);
        // ticket
        ticket.setEditable(false); 
        ticket.setText(lerTick(current_user));
            
        // resposta
        resposta.setText(lerRes(current_user));
        
        String texto = resposta.getText();
        if ("".equals(texto)) {
            resposta.setEditable(true);
            enviar.setVisible(true);
            editar.setVisible(false);
        }
        else {
            editar.setVisible(true);
            resposta.setEditable(false);
        }
    }
    
    public void enviaResposta(JTextArea area, JPanel userJPanel, JDialog mensagem) {
        String resposta = area.getText();
        if (!"".equals(resposta)) {    
            // cadastra
            cadastra(current_user, resposta);
            // exibe mensagem
            JOptionPane.showMessageDialog(mensagem, "Resposta cadastrada com sucesso.");
            // limpa caixa texto
            area.setText("");
            // volta
            CardLayout layout = (CardLayout)userJPanel.getLayout();
            layout.show(userJPanel, "SuperUserCard"); 
        }
        else { 
            // exibe mensagem
            JOptionPane.showMessageDialog(mensagem, "ERRO - Resposta nula");
        }
    }
    
    public void editar(JTextArea area, JButton enviar, JButton cancelar, JButton editar,
            JButton voltar) {
        area.setEditable(true);
        enviar.setVisible(true);
        cancelar.setVisible(true);
        
        editar.setVisible(false);
        voltar.setVisible(false);
        
        current_resposta = area.getText();
    }
    
    public void cancela(JTextArea area, JButton enviar, JButton cancelar, JButton voltar,
            JButton editar) {
        area.setEditable(false);
        enviar.setVisible(false);
        cancelar.setVisible(false);
        
        voltar.setVisible(true);
        editar.setVisible(true);
        
        area.setText(current_resposta);
    }
    
    
    private void cadastra(int k, String resposta) {
        // cadastra resposta do usuario k
        ((Usuario)list.get(k)).setResposta(resposta);   // downcast para Usuario
    }
    
    private String lerTick(int k) {
        return list.get(k).getTicket();
    }
    
    private String lerRes(int k) {
        return list.get(k).getResposta();
    }
    
    private int current_user;
    private String current_resposta;
}
