package model;

/**
 *
 * @author guilh
 */
public class Administrador extends Funcionario {
    public Administrador(int ra, String nome, String senha) {
        super(ra, nome, senha);
    }
    
    @Override
    public String getCard() {
        return "cardAdmin";
    }
    
    public void setRa(int r) {
        this.ra = r;
    } 
    
    public void setNome(String n) {
        this.nome = n;
    }
    
    public void setSenha(String s) {
        this.senha = s;
    }
}
