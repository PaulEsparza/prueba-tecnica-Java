/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import BaseDeDatos.Conexion;
import Modelo.Notas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotasDAO {
    Conexion cnx = new Conexion();
    Notas n = new Notas();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        ArrayList<Notas> list = new ArrayList<>();
        String sql = "SELECT * FROM notas";
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Notas nota = new Notas();
                nota.setIdNota(rs.getInt("idNota"));
                nota.setIdUsuario(rs.getInt("idUsuario"));
                nota.setNota(rs.getString("nota"));
                nota.setFechaNota(rs.getString("fechaNota"));
                list.add(nota);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Notas list(int id){
        String sql = "SELECT * FROM notas WHERE idNota="+id;
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {               
                n.setIdNota(rs.getInt("idNota"));
                n.setIdUsuario(rs.getInt("idUsuario"));
                n.setNota(rs.getString("nota"));
                n.setFechaNota(rs.getString("fechaNota"));
            }
        } catch (Exception e) {
        }
        return n;
    }
    
    public boolean crear(Notas nota){
        String sql = "INSERT INTO notas(idUsuario,nota)"
                + " VALUES('"+nota.getIdUsuario()+"','"+nota.getNota()+"')";
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean editar(Notas nota){
        String sql = "UPDATE notas SET idUsuario='"+nota.getIdUsuario()+"',"
                + "nota='"+nota.getNota()+"' WHERE idNota="+nota.getIdNota();
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean eliminar(int id){
        String sql = "DELETE FROM notas WHERE idNota="+id;
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
}
