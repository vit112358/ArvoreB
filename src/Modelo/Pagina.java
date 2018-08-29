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
    public int n; 
    public Pessoa r[];
    public Pagina p[]; 
    public Pagina (int mm) {
      this.n = 0; 
      this.r = new Pessoa[mm]; 
      this.p = new Pagina[mm+1];
    }
    
}
