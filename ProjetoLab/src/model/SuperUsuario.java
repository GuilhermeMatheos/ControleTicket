package model;

/**
 *
 * @author guilh
 */
public class SuperUsuario extends Funcionario {
    public SuperUsuario(int ra, String nome, String senha) {
        super(ra, nome, senha);
    }
    
    @Override
    public String getCard() {
        return "cardSuperMain";
    }
}
