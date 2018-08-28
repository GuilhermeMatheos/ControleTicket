/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.*;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public class Dados {
    public void setDados() {
        index  = -1;
        
        Funcionario func;
        func = new Administrador(0, "Admin", "qwerty");
        list.add(func);
        
        func = new Usuario(111, "Guilherme", "1234", "Placa com defeito");
        list.add(func);
        func = new Usuario(222, "Pedro", "1234");
        list.add(func);
        func = new Usuario(333, "Walter", "1234", "Celular travando");
        list.add(func); 
        
        func = new SuperUsuario(444, "Lucas", "1234");
        list.add(func);
    }

    public Funcionario getFunc(int k) {
        return list.get(k);
    }
    
    public void save() throws FileNotFoundException, IOException {
        FileOutputStream fos;
        fos = new FileOutputStream("dados.sav");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
    }
    
    public void read(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fin= new FileInputStream (fileName);
        ObjectInputStream ois = new ObjectInputStream(fin);
        list = (ArrayList<Funcionario>)ois.readObject();
        fin.close();
    }
    
    // Funcionario atual
    protected static int index;
    protected static ArrayList<Funcionario> list = new ArrayList<>();
}
