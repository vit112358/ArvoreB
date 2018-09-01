/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Interfaces.InterArvoreB;
import Modelo.Pagina;
import Modelo.Pessoa;

/**
 *
 * @author alunos
 * @param <T>
 */
public class ImplArvoreB<T> implements InterArvoreB<T>{
    
    private Pagina raiz;
    private int m, mm;

    public ImplArvoreB(int m) {
        this.raiz = null;
        this.m = m;
        this.mm = 2*m;
    }
    
    @Override
    public boolean inserir(T valor) {
        Pessoa aux = (Pessoa) valor;
        Pessoa regRetorno[] = new Pessoa[1];
        boolean cresceu[] = new boolean[1];
        Pagina apRetorno = this.insere (aux, this.raiz, regRetorno, cresceu);
        if (cresceu[0]) {
          Pagina apTemp = new Pagina(this.mm);
          apTemp.r[0] = regRetorno[0];
          apTemp.p[0] = this.raiz;
          apTemp.p[1] = apRetorno;
          this.raiz = apTemp; this.raiz.n++;
        } else {
            this.raiz = apRetorno;
        }
        return true;
    }

    @Override
    public T busca(T reg) {
        return this.pesquisa (reg, this.raiz);
    }

    
    /*Métodos Privados*/
    private T pesquisa (T reg, Pagina ap) {
        
        Pessoa aux = (Pessoa) reg;
        if (ap == null) return null; // Registro @{\it n\~ao}@ econtrado
        else {
          int i = 0;
          while ((i < ap.n-1) && (aux.compara (ap.r[i]) > 0)) i++;
          if (aux.compara (ap.r[i]) == 0) 
            {
                T result =(T) ap.r[i];
                return result;
            }
          else if (aux.compara (ap.r[i]) < 0) return pesquisa (reg, ap.p[i]);
          else return pesquisa (reg, ap.p[i+1]);
        }
    }
    private void imprime (Pagina p, int nivel) {
        if (p != null) {
            System.out.print ("  Nivel " + nivel + ":");
            for (int i = 0; i < p.n; i++)
                System.out.print (" "+p.r[i].toString());
            System.out.println ();
            for (int i = 0; i <= p.n; i++) {
                if (p.p[i] != null)
                    if (i < p.n) System.out.println ("  Esq: "+ p.r[i].toString());
                    else System.out.println ("  Dir: "+ p.r[i-1].toString());
                imprime (p.p[i], nivel + 1);      
            }
        }
    }
    
    public void imprime () {
        System.out.println ("ARVORE:");
        this.imprime (this.raiz, 0);
    }
    
    private void insereNaPagina (Pagina ap, Pessoa reg, Pagina apDir) {
    int k = ap.n - 1;
    while ((k >= 0) && (reg.compara (ap.r[k]) < 0)) {
      ap.r[k+1] = ap.r[k]; ap.p[k+2] = ap.p[k+1]; k--; 
    }
    ap.r[k+1] = reg; ap.p[k+2] = apDir; ap.n++;     
  }
  
  private Pagina insere (Pessoa reg, Pagina ap, Pessoa[] regRetorno, 
                         boolean[] cresceu) {
    Pagina apRetorno = null;
    if (ap == null) { cresceu[0] = true; regRetorno[0] = reg; } 
    else {
      int i = 0;
      while ((i < ap.n-1) && (reg.compara (ap.r[i]) > 0)) i++;      
      if (reg.compara (ap.r[i]) == 0) {
        System.out.println ("Erro: Registro ja existente");
        cresceu[0] = false;
      } 
      else {
        if (reg.compara (ap.r[i]) > 0) i++;
        apRetorno = insere (reg, ap.p[i], regRetorno, cresceu);
        if (cresceu[0])          
          if (ap.n < this.mm) { // @{\it P\'agina tem espa\c{c}o}@
            this.insereNaPagina (ap, regRetorno[0], apRetorno);
            cresceu[0] = false; apRetorno = ap;
          } 
          else { // Overflow: @{\it P\'agina tem que ser dividida}@
            Pagina apTemp = new Pagina (this.mm); apTemp.p[0] = null;
            if (i <= this.m) {
              this.insereNaPagina (apTemp, ap.r[this.mm-1], ap.p[this.mm]);
              ap.n--;
              this.insereNaPagina (ap, regRetorno[0], apRetorno);
            } else this.insereNaPagina (apTemp, regRetorno[0], apRetorno);
            for (int j = this.m+1; j < this.mm; j++) {
              this.insereNaPagina (apTemp, ap.r[j], ap.p[j+1]);
              ap.p[j+1] = null; // @{\it transfere a posse da mem\'oria}@
            }
            ap.n = this.m; apTemp.p[0] = ap.p[this.m+1]; 
            regRetorno[0] = ap.r[this.m]; apRetorno = apTemp;
          }
      }        
    }
    return (cresceu[0] ? apRetorno : ap);
  }
}
