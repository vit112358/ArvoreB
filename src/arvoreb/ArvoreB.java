/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvoreb;

import Controle.ImplArvoreB;
import Modelo.Pagina;
import Modelo.Pessoa;
import com.sun.jmx.snmp.EnumRowStatus;

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
        Pessoa p ;
        Pessoa[] pessoas = new Pessoa[10];
        ImplArvoreB agenda = new ImplArvoreB(2);
        for (int i = 0; i < 10; i++) {
            p= new Pessoa(i,"carlos", "Rua tal", "232323");
            pessoas[i]=p;
            System.out.println(pessoas[i].toString());
        }
        
        System.out.println("");
        
        /**/
        
        for (int i = 1; i < 10; i++) {
            agenda.inserir(pessoas[i]);
        }
        
        System.out.println("Busca \n");
        
        Pessoa busca =(Pessoa) agenda.busca(pessoas[5]);
        
        System.out.println("Resultado Pessoa: \n");
        System.out.println("ID: "+busca.getId()+" \tNome: "+busca.getNome());
        
        agenda.imprime();
        
        destroy(agenda);
    }
    
    public static void destroy(ImplArvoreB arvore) {
        arvore = null;
        System.out.println("Em Java nnão tem como destruir explicitamente um \n"
                + "Objeto, mas setando ele como null o aumentamos a chance do \n"
                + "garbage collector destriur esse objeto");
    }
    
}
