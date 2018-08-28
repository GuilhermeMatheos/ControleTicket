/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.*;
import javax.swing.*;
import java.awt.CardLayout;

/**
 *
 * @author guilh
 */
public class UserController extends Dados{
    public String menu(JRadioButton botao1, JRadioButton botao2, JRadioButton botao3) {  
        if (botao1.isSelected()) {
            return "cardCriarTicket";           
        }
        else if (botao2.isSelected()) {
            return "cardLerTicket";
        }
        else if (botao3.isSelected()) {
            return "cardLerResposta";
        }
        
        return "";
    }
    
    public void lerTicket(JLabel welcome, JTextArea area, JButton enviar,
            JButton cancelar, JButton editar, JButton deletar, JButton voltar) {
        voltar.setVisible(true);
        welcome.setVisible(false);
        area.setEditable(false);
        area.setText(lerTick());
        String ticket = area.getText();
        
        enviar.setVisible(false);
        cancelar.setVisible(false);
        if ("".equals(ticket)) {
            editar.setVisible(false);
            deletar.setVisible(false);
        }
        else {
            editar.setVisible(true);
            deletar.setVisible(true);
        }
    }
    
    public void enviaTicket(JTextArea area, JPanel userJPanel, JDialog mensagem) {
        String ticket = area.getText();
        if (!"".equals(ticket)) {    
            // cadastra
            cadastra(ticket);
            // exibe mensagem
            JOptionPane.showMessageDialog(mensagem, "Ticket cadastrado com sucesso.");
            // limpa caixa texto
            area.setText("");
            // volta
            CardLayout layout = (CardLayout)userJPanel.getLayout();
            layout.show(userJPanel, "cardUserMain"); 
        }
        else { 
            // exibe mensagem
            JOptionPane.showMessageDialog(mensagem, "ERRO - Ticket nulo");
        }
    }
    
    public void editar(JTextArea area, JButton enviar, JButton cancelar, JButton editar,
            JButton voltar, JButton deletar) {
        area.setEditable(true);
        enviar.setVisible(true);
        cancelar.setVisible(true);
        
        editar.setVisible(false);
        voltar.setVisible(false);
        deletar.setVisible(false);
        
        current_resposta = area.getText();
    }
    
    public void cancela(JTextArea area, JButton enviar, JButton cancelar, JButton voltar,
            JButton editar, JButton deletar) {
        area.setEditable(false);
        enviar.setVisible(false);
        cancelar.setVisible(false);
        
        voltar.setVisible(true);
        editar.setVisible(true);
        deletar.setVisible(true);
        
        area.setText(current_resposta);
    }
    
    public void deletaTicket(JTextArea area, JDialog mensagem, JPanel userJPanel) {
        // deleta ticket do usuario
        String ticket = area.getText();
        if (!"".equals(ticket)) {          
            // limpa caixa texto
            area.setText("");
            // deleta ticket
            deleta();
            // exibe mensagem
            JOptionPane.showMessageDialog(mensagem, "Ticket deletado com sucesso.");
            // volta
            CardLayout layout = (CardLayout)userJPanel.getLayout();
            layout.show(userJPanel, "cardUserMain"); 
        }
    }
    
    public void lerResposta(JLabel welcome, JTextArea area) {
        welcome.setVisible(false);
        area.setEditable(false);
        area.setText(lerRes());
    }
    
    public void verifica(JTextArea area, JScrollPane scroll, JLabel info, JButton enviar) {
        area.setVisible(true);
        scroll.setVisible(true);
        enviar.setVisible(true);
        info.setText("Descreva o seu problema:");
        
        if (!"".equals(lerTick())) {
            area.setVisible(false);
            scroll.setVisible(false);
            enviar.setVisible(false);
            info.setText("Usuário já possui ticket aberto");
        }
    }
    
    private String lerTick() {
        return list.get(index).getTicket();
    }
    
    private String lerRes() {
        return list.get(index).getResposta();
    }
    
    private void deleta() {
        ((Usuario)list.get(index)).setTicket("");
        ((Usuario)list.get(index)).setResposta("");
    }
    
    private void cadastra(String ticket) {
        // cadastra ticket do usuario 
        ((Usuario)list.get(index)).setTicket(ticket);       // downcast para Usuario
    }
    
    private String current_resposta;
}
