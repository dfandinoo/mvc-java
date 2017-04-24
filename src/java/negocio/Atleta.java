package negocio;

import java.sql.ResultSet;

public class Atleta {
    
    private int id;
    private String nombre;
    private String genero;
    private int cedula;

    public Atleta() {
    }

    public Atleta(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }

    public Atleta(String nombre, String genero, int cedula) {
        this.nombre = nombre;
        this.genero = genero;
        this.cedula = cedula;
    }
    
    public Atleta(ResultSet rs){
        try{
            id = rs.getInt("id");
            nombre = rs.getString("nombre");
            genero = rs.getString("genero");
            cedula = rs.getInt("cedula");
        }catch(Exception e){          
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
    @Override
    public String toString() {
        return nombre; 
    }
}

