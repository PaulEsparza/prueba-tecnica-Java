/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import BaseDeDatos.Conexion;
import Modelo.NotasComment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotasCommentDAO {
    Conexion cnx = new Conexion();
    NotasComment nc = new NotasComment();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(int id){
        ArrayList<NotasComment> list = new ArrayList<>();
        String sql = "SELECT * FROM comentarios WHERE idNota="+id;
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                NotasComment nota = new NotasComment();
                nota.setIdComentario(rs.getInt("idComentario"));
                nota.setIdNota(rs.getInt("idNota"));
                nota.setIdUsuario(rs.getInt("idUsuario"));
                nota.setComentario(rs.getString("comentario"));
                nota.setFechaComentario(rs.getString("fechaComentario"));
                list.add(nota);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public NotasComment list(int id){
        String sql = "SELECT * FROM comentarios WHERE idComentario="+id;
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {               
                nc.setIdComentario(rs.getInt("idComentario"));
                nc.setIdNota(rs.getInt("idNota"));
                nc.setIdUsuario(rs.getInt("idUsuario"));
                nc.setComentario(rs.getString("comentario"));
                nc.setFechaComentario(rs.getString("fechaComentario"));
            }
        } catch (Exception e) {
        }
        return nc;
    }
    
    public boolean crear(NotasComment nota){
        String sql = "INSERT INTO comentarios(idNota,idUsuario,comentario)"
                + " VALUES('"+nota.getIdNota()+"','"+nota.getIdUsuario()+"','"+nota.getComentario()+"')";
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean editar(NotasComment nota){
        String sql = "UPDATE comentarios SET idUsuario='"+nota.getIdUsuario()+"',"
                + "comentario='"+nota.getComentario()+"' WHERE idComentario="+nota.getIdComentario();
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean eliminar(int id){
        String sql = "DELETE FROM comentarios WHERE idComentario="+id;
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
}
