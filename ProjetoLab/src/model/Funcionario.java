package model;

import java.io.Serializable;

/**
 *
 * @author guilh
 */
public abstract class Funcionario implements Serializable {
    protected int ra;
    protected String nome;
    protected String senha;
    protected String ticket;
    protected String resposta;
    
    public Funcionario(int ra, String n, String s) {
        this.ra = ra;
        this.nome = n;
        this.senha = s;
        this.ticket = "";
        this.resposta = "";
    }

    public int getRa() {
        return ra;
    }
    
    public String getNome() {
        return nome;
    } 
    
    public String getSenha() {
        return senha;
    }

    public String getTicket() {
        return ticket;
    } 
    
    public String getResposta() {
        return resposta;
    } 
    
    public abstract String getCard();
}
