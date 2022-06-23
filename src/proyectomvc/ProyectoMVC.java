/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomvc;

import Controlador.Controladora;
import Modelo.Modelo;
import Vista.Ventana_consulta;
import Vista.Ventana_consulta_general;
import Vista.Ventana_eliminar;
import Vista.Ventana_modificar;
import Vista.Ventana_principal;
import Vista.Ventana_registro;

/**
 *
 * @author William
 */

//Comenzamos gestionando en el modelo toda la información
//El control funciona como el administrador del sistema
//Las vistas son la parte visual

//Aca en la parte principal necesito crear todas las instancias necesarias para que sirva el sistema +y la controladora
public class ProyectoMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instancia de las interfaces o ventanas
        Ventana_principal ObjetoVentanaPrincipal = new Ventana_principal();
        Ventana_registro ObjetoVentanaRegistro = new Ventana_registro();
        Ventana_consulta ObjetoVentanaConsulta = new Ventana_consulta();
        Ventana_consulta_general ObjetoVentanaConsultaGeneral = new Ventana_consulta_general();
        Ventana_modificar ObjetoVentanaModificar = new Ventana_modificar();
        Ventana_eliminar ObjetoVentanaEliminar = new Ventana_eliminar();
        
        //Instancia a la clase controladora
        Controladora control = new Controladora();
        
        //Instancia a la clase modelo
        
        Modelo ObjetoModelo = new Modelo();
        //Ya tenemos instanciadas todas las ventanas principales, ahora tendre que otorgar acceso al resto de componentes
        
        //La ventana principal se comunica con la controladora por si quiere comunicar algo.
        
        //Le pasaremos todos los objetos al control y que todos estos reciban al control
        //Todos los reciben para guardar algunos métodos y poder hacer visibles ciertas ventanas
        ObjetoVentanaPrincipal.setObjetoControlador(control);
        ObjetoVentanaRegistro.setObjetoControlador(control);
        ObjetoVentanaConsulta.setObjetoControlador(control);
        ObjetoVentanaConsultaGeneral.setObjetoControlador(control);
        ObjetoVentanaModificar.setObjetoControlador(control);
        ObjetoVentanaEliminar.setObjetoControlador(control);
        
        
        //La ventana registro se comunica con ventana controladora
        //Todas las vistas o ventanas se comunican reciprocamente con la vista
        
        //Conexion : Controlador - Vistas
        control.setObjetoVentanaPrincipal(ObjetoVentanaPrincipal);
        control.setObjetoVentanaRegistro(ObjetoVentanaRegistro);
        control.setObjetoVentanaConsulta(ObjetoVentanaConsulta);
        control.setObjetoVentanaConsultaGeneral(ObjetoVentanaConsultaGeneral);
        control.setObjetoVentanaModificar(ObjetoVentanaModificar);
        control.setObjetoVentanaEliminar(ObjetoVentanaEliminar);
        
        //Conexion Modelo - Controlador : Controlador - Modelo
        ObjetoModelo.setObjetoControlador(control);
        control.setObjetoModelo(ObjetoModelo);
        
        ObjetoModelo.LlenarArrayList("Ricardo Gutierrez", "GARO190717", "ITI", 21);
        ObjetoModelo.LlenarArrayList("Fatima Plascencia", "PMFO190717", "IET", 21);
        ObjetoVentanaPrincipal.setVisible(true);
        
    }
    
}
