package model;

/**
 *
 * @author guilh
 */
public class Usuario extends Funcionario {   
    public Usuario(int ra, String nome, String senha) {
        super(ra, nome, senha);
    }
    
    public Usuario(int ra, String nome, String senha, String ticket) {
        super(ra, nome, senha);
        setTicket(ticket);
    }
    
    @Override
    public String getCard() {
        return "cardUser";
    }
    
    public void setTicket(String t) {
        this.ticket = t;
    }
    
    public void setResposta(String r) {
        this.resposta = r;
    }
}
