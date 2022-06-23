/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author William
 */
public class AlumnoDTO {
    private String Nombre;
    private String Matricula;
    private String Carrera;
    private int Edad;

    public AlumnoDTO(String Nombre, String Matricula, String Carrera, int Edad) {
        this.Nombre = Nombre;
        this.Matricula = Matricula;
        this.Carrera = Carrera;
        this.Edad = Edad;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }
    
    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }
    
    
}
