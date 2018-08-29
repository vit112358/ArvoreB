/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alunos
 */
public class Pagina {
    private static final int M = 4;
    
    private int m;                             // id da Página
    private Pessoa[] children = new Pessoa[M];   // vetor de filhos

        // create a node with k children
    public Pagina(int k) {
         m = k;
    }
    
}
