package com.aravena.actividadevaluadanicolasaravena.models;

public class Receta {
    private String nombre;
    private String ingP;
    private String base;
    private String[]  ing;
    private String [] alinos;
    private double precio;



    public Receta(String nombre, String ingP, String base, String [] ing, String [] alinos, double precio){
        this.nombre = nombre;
        this.ingP = ingP;
        this.base = base;
        this.ing = ing;
        this.alinos = alinos;
        this.precio = precio;

    }


    public String getNombre(){
        return nombre;
    }
    public String getIngP(){
        return ingP;
    }
    public String getBase()

    {
        return base;

    }
    public String[] getIng(){
        return ing;
    }
    public String[] getAlinos(){
        return alinos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIngP(String ingP) {
        this.ingP = ingP;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setIng(String[] ing) {
        this.ing = ing;
    }

    public void setAlinos(String[] alinos) {
        this.alinos = alinos;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
