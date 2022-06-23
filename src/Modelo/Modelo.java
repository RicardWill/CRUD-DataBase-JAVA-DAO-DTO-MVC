/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controladora;
import Modelo.Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author William
 */
public class Modelo {
    //Atributos de la clase
    private Controladora control;
    private Connection conn;
    private AlumnoDAO CRUDAlumno;
    //Array list donde guardaremos los alumnos a registrar
    
    ArrayList<AlumnoDTO> ListaAlumnos = new ArrayList<AlumnoDTO>();
    
    
    public Modelo(){
        ConexionBD conex = new ConexionBD();
        conn = conex.getConexion();
        
        //Instancia alumno dao para no crear tantas instancias
        this.CRUDAlumno = new AlumnoDAO();
    }

    public void LlenarArrayList(String nombre, String matricula, String carrera, int edad){
        AlumnoDTO objAlumno = new AlumnoDTO(nombre, matricula, carrera, edad);
        ListaAlumnos.add(objAlumno);
        
    }
    
    /*
    public ArrayList<AlumnoDTO> getListaAlumnos() {
        return ListaAlumnos;
    }
    */

    public void setObjetoControlador(Controladora control) {
        this.control = control;
    }

    public void RegistraInformacion(String nombre, String matricula, String carrera, String edad) throws Exception {
        int intEdad = Integer.parseInt(edad);
        EvaluarEdad(intEdad);
        
        AlumnoDTO objAlumno = new AlumnoDTO(nombre, matricula, carrera, intEdad);
        CRUDAlumno.registraAlumno(objAlumno, conn);
        
    }

    public ResultSet BuscaAlumno(String matricula) throws SQLException {
        ResultSet obj = (ResultSet) CRUDAlumno.consultaAlumno(matricula, conn);
        
        while (obj.next()) {         
            if(obj.getString("matricula").equals(matricula)){
                int edad = obj.getInt(4);  
                System.out.println("edad equivale a "+ edad);
                    
                return obj;
            } 
        }
        return null;
    }
    
    public ResultSet getListaAlumnos() throws SQLException {
        
        ResultSet obj = (ResultSet) CRUDAlumno.cargaAlumnos(conn);
        
        return obj;
        
    }
    
    public void ModificaInformacion(String matricula, String nombre, String carrera, String edad) throws Exception {
        int intEdad = Integer.parseInt(edad);
        EvaluarEdad(intEdad);
        AlumnoDTO objAlumno = new AlumnoDTO(nombre, matricula, carrera, intEdad);
        CRUDAlumno.modificaAlumno(objAlumno, conn);   
    }
    
    public void EliminaInformacion(String matricula, String nombre, String carrera, String edad) {
        int intEdad = Integer.parseInt(edad);
        AlumnoDTO objAlumno = new AlumnoDTO(nombre, matricula, carrera, intEdad);
        CRUDAlumno.eliminaAlumno(objAlumno, conn);  
    }

    private void EvaluarMatricula(String matricula) throws Exception {
        Iterator<AlumnoDTO> itr = ListaAlumnos.iterator();
              
        while(itr.hasNext()){
            //System.out.println("Impresion 1: "+ (AlumnoDTO)itr.next());
            //System.out.println("Impresion 2: "+ itr);
            AlumnoDTO obj=(AlumnoDTO)itr.next();
            
            if(obj.getMatricula().equals(matricula)){
                throw new Exception("Alumno existente");
            }
            
        }
    }


    private void EvaluarEdad(int intEdad) throws Exception{
        if(intEdad < 1 || intEdad > 100){
            throw new ExceptionRango("Edad erronea");
        }else{
            
        }
        
    }

    
}
