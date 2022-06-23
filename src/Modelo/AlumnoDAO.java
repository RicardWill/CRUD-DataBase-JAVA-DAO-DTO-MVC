/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
public class AlumnoDAO {
    private Connection conn;

    void registraAlumno(AlumnoDTO objAlumno, Connection conn) throws SQLException {
        String QUERY = "INSERT INTO alumnos (nombre,matricula,carrera,edad) VALUES(?,?,?,?)";
        
        try{
            PreparedStatement insercion = conn.prepareStatement(QUERY);
            
            insercion.setString(1, objAlumno.getNombre());
            insercion.setString(2, objAlumno.getMatricula());
            insercion.setString(3, objAlumno.getCarrera());
            insercion.setInt(4, objAlumno.getEdad());
            insercion.executeUpdate();
            insercion.close();
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
    }

    ResultSet consultaAlumno(String mat, Connection conn) {
        String QUERY = "SELECT * FROM alumnos WHERE matricula=?";
        
        try {
            PreparedStatement consulta = conn.prepareStatement(QUERY);
            consulta.setString(1, mat);
            ResultSet resultSet = consulta.executeQuery();
            
            return resultSet;
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;  
    }

    ResultSet cargaAlumnos(Connection conn) {
        String QUERY = "SELECT * FROM alumnos";
        
        try {
            PreparedStatement consulta = conn.prepareStatement(QUERY);
            ResultSet resultSet = consulta.executeQuery();
            
            return resultSet;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        // execute the query, and get a java resultset
        return null;   
    }

    void modificaAlumno(AlumnoDTO objAlumno, Connection conn) {
        String QUERY = "UPDATE alumnos SET nombre=?, matricula=?, carrera=?, edad=? WHERE matricula=?";
        
        try{
            PreparedStatement insercion = conn.prepareStatement(QUERY);
            
            insercion.setString(5, objAlumno.getMatricula());
            
            insercion.setString(1, objAlumno.getNombre());
            insercion.setString(2, objAlumno.getMatricula());
            insercion.setString(3, objAlumno.getCarrera());
            insercion.setInt(4, objAlumno.getEdad());
            insercion.executeUpdate();
            insercion.close();
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }

    void eliminaAlumno(AlumnoDTO objAlumno, Connection conn) {
        String QUERY = "DELETE FROM alumnos WHERE matricula=?";
        
        try{
            PreparedStatement insercion = conn.prepareStatement(QUERY);
            
            insercion.setString(1, objAlumno.getMatricula());
            
            insercion.executeUpdate();
            insercion.close();
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
}
