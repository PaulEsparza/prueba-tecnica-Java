/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import BaseDeDatos.Conexion;
import Modelo.NotasCommentResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotasCommentResponseDAO {
    Conexion cnx = new Conexion();
    NotasCommentResponse ncr = new NotasCommentResponse();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(int id){
        ArrayList<NotasCommentResponse> list = new ArrayList<>();
        String sql = "SELECT * FROM comentariorespuesta WHERE idComentario="+id;
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                NotasCommentResponse nota = new NotasCommentResponse();
                nota.setIdComentarioRespuesta(rs.getInt("idComentarioRespuesta"));
                nota.setIdComentario(rs.getInt("idComentario"));
                nota.setIdUsuario(rs.getInt("idUsuario"));
                nota.setComentarioRespuesta(rs.getString("comentarioRespuesta"));
                nota.setFechaComentarioRespuesta(rs.getString("fechaComentarioRespuesta"));
                list.add(nota);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public NotasCommentResponse list(int id){
        String sql = "SELECT * FROM comentariorespuesta WHERE idComentarioRespuesta="+id;
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {               
                ncr.setIdComentarioRespuesta(rs.getInt("idComentarioRespuesta"));
                ncr.setIdComentario(rs.getInt("idComentario"));
                ncr.setIdUsuario(rs.getInt("idUsuario"));
                ncr.setComentarioRespuesta(rs.getString("comentarioRespuesta"));
                ncr.setFechaComentarioRespuesta(rs.getString("fechaComentarioRespuesta"));
            }
        } catch (Exception e) {
        }
        return ncr;
    }
    
    public boolean crear(NotasCommentResponse nota){
        String sql = "INSERT INTO comentariorespuesta(idComentario,idUsuario,comentarioRespuesta)"
                + " VALUES('"+nota.getIdComentario()+"','"+nota.getIdUsuario()+"','"+nota.getComentarioRespuesta()+"')";
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean editar(NotasCommentResponse nota){
        String sql = "UPDATE comentariorespuesta SET idUsuario='"+nota.getIdUsuario()+"',"
                + "comentarioRespuesta='"+nota.getComentarioRespuesta()+"' WHERE idComentarioRespuesta="+nota.getIdComentarioRespuesta();
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean eliminar(int id){
        String sql = "DELETE FROM comentariorespuesta WHERE idComentarioRespuesta="+id;
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
}
