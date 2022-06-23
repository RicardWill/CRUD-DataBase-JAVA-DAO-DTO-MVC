/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
//DAO Integra en una clase solo modelos en en DTO solo caracteristicas
//No mandar campos de la tabla por separados, mejor mandar todo junto en un DTO
//Objetos POJO, objetos se solo utilizan caracteristicas
//Casi siempre tendré un DTO VO y un DAO

//Establecer la cadena de conexión con la bd
//Nos conectamos
//Devolvemos el objeto conexion

public class ConexionBD {
    public Connection conex;
    
    public ConexionBD(){
        String bd = "prueba_9c";
        String login = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/"+bd+"?useUnicode=true+use"+"JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"+"serverTimezone=UTC";
        //127.0.0.1
        try {
            this.conex = DriverManager.getConnection(url,login,password);
            if(conex != null){
                System.out.println("Conexion exitosa");
            }else{
                System.out.println("Eror al establecer conexion");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    //public Connection conex;
    
    public Connection getConexion(){
        return conex;
    }
}
