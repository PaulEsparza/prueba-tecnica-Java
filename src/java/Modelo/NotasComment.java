/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author paule
 */
public class NotasComment {
    int idComentario;
    int idNota;
    int idUsuario;
    String comentario;
    String fechaComentario;

    public NotasComment() {
    }

    public NotasComment(int idComentario, int idNota, int idUsuario, String comentario, String fechaComentario) {
        this.idComentario = idComentario;
        this.idNota = idNota;
        this.idUsuario = idUsuario;
        this.comentario = comentario;
        this.fechaComentario = fechaComentario;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(String fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
    
    
}
