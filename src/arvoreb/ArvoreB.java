/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvoreb;

import Controle.ImplArvoreB;
import Modelo.Pagina;
import Modelo.Pessoa;

/**
 *
 * @author alunos
 */
public class ArvoreB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pessoa p = new Pessoa("carlos", "Rua tal", "232323");
        Pessoa[] pessoas = new Pessoa[10];
        ImplArvoreB agenda = new ImplArvoreB( 2);
        for (int i = 0; i < 10; i++) {
            p.setId(i);
            pessoas[i]=p;
            System.out.println(pessoas[i].toString());
        }
        
        for (int i = 0; i < 10; i++) {
            agenda.inserir(pessoas[i]);
        }
        agenda.imprime();
    }
    
}
