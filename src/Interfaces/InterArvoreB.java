/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author alunos
 * @param <T> tipo
 */
public interface InterArvoreB<T> {
    
    public boolean inserir(T valor);
    
    public T busca(Integer id);
    
    public boolean destroy();
}
