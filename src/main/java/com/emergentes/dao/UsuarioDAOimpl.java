
package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOimpl extends ConexionDB implements UsuarioDAO{

    @Override
    public void insert(Usuario usr) throws Exception {
     
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement("INSERT INTO usuarios (nombre,apellido,correo,password) values (?,?,?,md5(?))");
        ps.setString(1,usr.getNombres());
        ps.setString(2,usr.getApellidos());
        ps.setString(3,usr.getCorreo());
        ps.setString(4,usr.getPassword());
        ps.executeUpdate();
            
            this.desconectar();           
    }

    @Override
    public void update(Usuario usr) throws Exception {
    this.conectar();
        PreparedStatement ps = this.conn.prepareStatement("UPDATE suarios SET nombre=?apellidos=?,correo=?,password=md5(?) where id = ?");
        ps.setString(1,usr.getNombres());
        ps.setString(2,usr.getApellidos());
        ps.setString(3,usr.getCorreo());
        ps.setString(4,usr.getPassword());
        ps.setInt(4,usr.getId());
        ps.executeUpdate();
        this.desconectar(); 
    }

    @Override
    public void delete(int id) throws Exception {
     this.conectar();
        PreparedStatement ps = this.conn.prepareStatement("DELETE FROM usuarios where id = ?");
        
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar(); 
    }

    @Override
    public Usuario getById(int id) throws Exception {
   Usuario usr = new Usuario(); 
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios where id = ?");
       ps.setInt(1, id);
       ResultSet rs = ps.executeQuery();
       while(rs.next()){
           usr.setId(rs.getInt("id"));
           usr.setNombres(rs.getString("nombres"));
           usr.setApellidos(rs.getString("apellidos"));
           usr.setCorreo(rs.getString("correo"));
         }
       this.desconectar(); 
       return usr;
    }
    @Override
    public List<Usuario> getAll() throws Exception {
    List<Usuario> lista =null;
        this.conectar();
        
        PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios");
       
       ResultSet rs = ps.executeQuery();
       
       lista=new ArrayList <Usuario>();
       
       while(rs.next()){
             Usuario usu = new Usuario();
          usu.setId(rs.getInt("id"));
           usu.setNombres(rs.getString("nombres"));
           usu.setApellidos(rs.getString("apellidos"));
           usu.setCorreo(rs.getString("correo"));
           
           lista.add(usu);
    }
    this.desconectar(); 
       return lista;
    }
}
