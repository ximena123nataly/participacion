
package com.emergentes.controlador;

import com.emergentes.dao.ClienteDAO;
import com.emergentes.dao.ClienteDAOimpl;
import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;

import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Producto;
import com.emergentes.modelo.Venta;
import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProductoControlador", urlPatterns = {"/ProductoControlador"})
public class ProductoControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         try {
           Producto dao=new Producto();            
            ProductoDAO daoProducto = new ProductoDAOimpl();
            ClienteDAO daoCliente = new ClienteDAOimpl();
            int id;
            List<Producto> lista_productos = null;
            List<Cliente> lista_clientes = null;
            
             Producto p=new Producto(); 
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_productos=daoProducto.getAll();
                    lista_clientes=daoCliente.getAll();
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_clientes", lista_clientes);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    p = dao.getById(id);                
                    lista_productos=daoProducto.getAll();
                    lista_clientes=daoCliente.getAll();
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_clientes", lista_clientes);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;
                case "delete":
                   id = Integer.parseInt(request.getParameter("id"));
                   dao.delete(id);
                   response.sendRedirect("ProductoConcrolador");
                    break;
                case "view":
                   
                    List<Venta> lista = dao.getAll();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Eror" + ex.getMessage());
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id"));
          
           String descripcion= request.getParameter("descripcion");
           int precio = Integer.parseInt(request.getParameter("precio"));
           
          Producto p=new Producto(); 
    p.setId(id);
    
    p.setDescripcion(descripcion);
    p.setPrecio(precio);
        if (id==0) {
            //nuevo
            ProductoDAO dao = new ProductoDAOimpl();
             try {
                 dao.insert(p);
                 response.sendRedirect("VentaConcrolador");
             } catch (Exception ex) {
                
             }
        }else{
            //editar
               ProductoDAO dao = new ProductoDAOimpl();
             try {
                 dao.update(p);
                 response.sendRedirect("VentaConcrolador");
             } catch (Exception ex) {
                
             }
        }
    }

}
 
   