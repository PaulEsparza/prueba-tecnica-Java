/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author paule
 */
public class NotasCommentResponse {
    int idComentarioRespuesta;
    int idComentario;
    int idUsuario;
    String comentarioRespuesta;
    String fechaComentarioRespuesta;

    public NotasCommentResponse() {
    }

    public NotasCommentResponse(int idComentarioRespuesta, int idComentario, int idUsuario, String comentarioRespuesta, String fechaComentarioRespuesta) {
        this.idComentarioRespuesta = idComentarioRespuesta;
        this.idComentario = idComentario;
        this.idUsuario = idUsuario;
        this.comentarioRespuesta = comentarioRespuesta;
        this.fechaComentarioRespuesta = fechaComentarioRespuesta;
    }

    public int getIdComentarioRespuesta() {
        return idComentarioRespuesta;
    }

    public void setIdComentarioRespuesta(int idComentarioRespuesta) {
        this.idComentarioRespuesta = idComentarioRespuesta;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getComentarioRespuesta() {
        return comentarioRespuesta;
    }

    public void setComentarioRespuesta(String comentarioRespuesta) {
        this.comentarioRespuesta = comentarioRespuesta;
    }

    public String getFechaComentarioRespuesta() {
        return fechaComentarioRespuesta;
    }

    public void setFechaComentarioRespuesta(String fechaComentarioRespuesta) {
        this.fechaComentarioRespuesta = fechaComentarioRespuesta;
    }
    
    
}
