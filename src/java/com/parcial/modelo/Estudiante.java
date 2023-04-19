package com.parcial.modelo;
public class Estudiante {
    private int id;
    private String nombre;
    private int primerparcial;
    private int segundoparcial;
    private int tercerparcial;
    private int nota;
    
    public Estudiante(int id, String nombre, int primerparcial, int segundoparcial, int tercerparcial, int nota) {
        this.id = id;
        this.nombre = nombre;
        this.primerparcial = primerparcial;
        this.segundoparcial = segundoparcial;
        this.tercerparcial = tercerparcial;
        this.nota = nota;
    }
    
    public Estudiante() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrimerparcial() {
        return primerparcial;
    }

    public void setPrimerparcial(int primerparcial) {
        this.primerparcial = primerparcial;
    }

    public int getSegundoparcial() {
        return segundoparcial;
    }

    public void setSegundoparcial(int segundoparcial) {
        this.segundoparcial = segundoparcial;
    }

    public int getTercerparcial() {
        return tercerparcial;
    }

    public void setTercerparcial(int tercerparcial) {
        this.tercerparcial = tercerparcial;
    }

    public int getNota() {
        return getPrimerparcial()+getSegundoparcial()+getTercerparcial();
    }
    
    
    
}
