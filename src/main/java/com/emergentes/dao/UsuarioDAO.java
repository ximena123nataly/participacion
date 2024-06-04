
package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import java.util.List;


public interface UsuarioDAO {
     public void insert(Usuario usr) throws Exception; 
   public void update(Usuario usr) throws Exception; 
   public void delete(int id) throws Exception; 
   public Usuario getById(int id) throws Exception;
   public List<Usuario> getAll() throws Exception;
   
}
