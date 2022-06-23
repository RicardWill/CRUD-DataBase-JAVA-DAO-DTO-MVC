/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;

import Modelo.AlumnoDTO;
import Vista.Ventana_consulta;
import Vista.Ventana_consulta_general;
import Vista.Ventana_eliminar;
import Vista.Ventana_modificar;
import Vista.Ventana_principal;
import Vista.Ventana_registro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author William
 */

//La clase control debe contener métodos que permita establecer el control entre todos

public class Controladora {
    
    //Necesitamos agregar un conjunto de objetos que puedan recibir
    //a todas las demás
    
    private Ventana_principal objetoVentanaPrincipal;
    private Ventana_registro objetoVentanaRegistro;
    private Ventana_consulta objetoVentanaConsulta;
    private Ventana_consulta_general objetoVentanaConsultaGeneral;
    private Ventana_modificar objetoVentanaModificar;
    private Ventana_eliminar objetoVentanaEliminar;
    
    private Modelo ObjetoModelo;
    
    //creamos también un objeto de tipo modelo agregado como atributo
    private Controladora control;

    //Insertamos los setter para cuando necesite solicitar información, no creare uno nuevo sino un solo objeto
    public void setObjetoVentanaPrincipal(Ventana_principal objetoVentanaPrincipal) {
        this.objetoVentanaPrincipal = objetoVentanaPrincipal;
    }

    public void setObjetoVentanaRegistro(Ventana_registro objetoVentanaRegistro) {
        this.objetoVentanaRegistro = objetoVentanaRegistro;
    }

    public void setObjetoVentanaConsulta(Ventana_consulta objetoVentanaConsulta) {
        this.objetoVentanaConsulta = objetoVentanaConsulta;
    }
    
     public void setObjetoVentanaConsultaGeneral(Ventana_consulta_general objetoVentanaConsultaGeneral) {
        this.objetoVentanaConsultaGeneral = objetoVentanaConsultaGeneral;
    }

    public void setObjetoVentanaModificar(Ventana_modificar objetoVentanaModificar) {
        this.objetoVentanaModificar = objetoVentanaModificar;
    }

    public void setObjetoVentanaEliminar(Ventana_eliminar objetoVentanaEliminar) {
        this.objetoVentanaEliminar = objetoVentanaEliminar;
    }

    public void setObjetoModelo(Modelo ObjetoModelo) {
        this.ObjetoModelo = ObjetoModelo;
    }

    //Conexiones entre vistas
    public void MostrarVentanaRegistro_Principal() {
        objetoVentanaRegistro.setVisible(true);
        objetoVentanaPrincipal.setVisible(false);
    }
    
    public void MostrarVentanaConsulta_Principal() {
        objetoVentanaConsulta.setVisible(true);
        objetoVentanaPrincipal.setVisible(false);
    }
    
    public void MostrarVentanaConsultaGeneral_Principal() {
        objetoVentanaConsultaGeneral.setVisible(true);
        objetoVentanaPrincipal.setVisible(false);
    }
    
    public void MostrarVentanaModificar_Principal() {
        objetoVentanaModificar.setVisible(true);
        objetoVentanaPrincipal.setVisible(false);
    }

    public void MostrarVentanaEliminar_Principal() {
        objetoVentanaEliminar.setVisible(true);
        objetoVentanaPrincipal.setVisible(false);
    }
    
    public void MostrarVentanaPrincipal_Registro() {
        objetoVentanaPrincipal.setVisible(true);
        objetoVentanaRegistro.setVisible(false);
    }
    
    public void MostrarVentanaPrincipal_Consulta() {
        objetoVentanaPrincipal.setVisible(true);
        objetoVentanaConsulta.setVisible(false);
    }
    
    public void MostrarVentanaPrincipal_ConsultaGeneral() {
        objetoVentanaPrincipal.setVisible(true);
        objetoVentanaConsultaGeneral.setVisible(false);
    }
    
    public void MostrarVentanaPrincipal_Modificar() {
        objetoVentanaPrincipal.setVisible(true);
        objetoVentanaModificar.setVisible(false);
    }
    
    public void MostrarVentanaPrincipal_Eliminar() {
        objetoVentanaPrincipal.setVisible(true);
        objetoVentanaEliminar.setVisible(false);
    }

    //Acciones de las vistas
    
    public void RegistraInformacion(String nombre, String matricula, String carrera, String edad) throws Exception {
        
        //Otra vez saco la excepcion y se lo regreso a la vista
        ObjetoModelo.RegistraInformacion(nombre, matricula, carrera, edad);
        
        
    }

    public ResultSet BuscaAlumno(String matricula) throws SQLException {
        
        
        ResultSet Obj = ObjetoModelo.BuscaAlumno(matricula);
        //System.out.println("test");
        //System.out.println(Obj.getMatricula());
        if(Obj == null){
            System.out.println("Valor nulo");
            return null;
        }else{
            return Obj;
        }  
        
    }

    public ResultSet BuscaDatos() throws SQLException {
        ResultSet Obj = ObjetoModelo.getListaAlumnos();
        //System.out.println("test");
        //System.out.println(Obj.getMatricula());
        if(Obj == null){
            System.out.println("Valor nulo");
            return null;
        }else{
            return Obj;
        }  
        
        
        
    }

    public void ModificaAlumno(String matricula, String nombre, String carrera, String edad) throws Exception {
        ObjetoModelo.ModificaInformacion(matricula, nombre, carrera, edad);
    }

    public void EliminaAlumno(String matricula, String nombre, String carrera, String edad) {
        ObjetoModelo.EliminaInformacion(matricula, nombre, carrera, edad);
    }

    

    

   

    

    

   

    

    
   
    
}
