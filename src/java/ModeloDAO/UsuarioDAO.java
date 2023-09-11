/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import BaseDeDatos.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    Conexion cnx = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuario list(String usuario, String password){
        Usuario u = null;
        String sql = "SELECT \n" +
        "tu.idTipoUsuario, tu.tipoUsuario,\n" +
        "u.idUsuario, u.usuario,\n" +
        "p.idPersonal, p.qpePaterno, p.apeMaterno, p.nombre, p.direccion, p.fechaIngreso\n" +
        "FROM tipousuario as tu\n" +
        "INNER JOIN usuarios as u on tu.idTipoUsuario = u.idTipoUsuario\n" +
        "INNER JOIN personal as p on u.idPersonal = p.idPersonal\n" +
        "WHERE u.usuario ='"+usuario+"' AND u.password ='"+password+"';";
        try {
            con = cnx.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) {      
                u = new Usuario();
                u.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                u.setTipoUsuario(rs.getString("tipoUsuario"));
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setUsuario(rs.getString("usuario"));
                u.setIdPersonal(rs.getInt("idPersonal"));
                u.setApePaterno(rs.getString("apePaterno"));
                u.setApeMaterno(rs.getString("apeMaterno"));
                u.setNombre(rs.getString("nombre"));
                u.setDireccion(rs.getString("direccion"));
                u.setFechaIngreso(rs.getString("fechaIngreso"));
                return u;
            }
        } catch (Exception e) {
        }
        return u;
    }
}
