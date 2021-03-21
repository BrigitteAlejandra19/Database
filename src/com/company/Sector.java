package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sector {

    private static final String TABLA_EMPLEADO = "empleado";
    private String dbName = "jhs7JfWxPH";
    private String dbUser = "jhs7JfWxPH";
    private String dbPwd = "hMQz4SgE0t";

    public void buscarYMostrar(String sql){
        ConexionDB conexionDB = new ConexionDB(dbName,dbUser,dbPwd);
        ResultSet resultados = conexionDB.consultar(sql);
        try{
            mostrarResultados(resultados);
        }catch(SQLException e){
            System.out.println("No se encontraron resultados.");
        }finally {
            conexionDB.cerrar();
        }
    }

    private void mostrarResultados(ResultSet resultados) throws SQLException {
        if(resultados != null)
            while(resultados.next())
                System.out.println("Nombre: "+resultados.getString("nombre"));
    }

    public void mostrarEmpleadoPorLegajo(int legajo){
        buscarYMostrar("SELECT nombre, apellido FROM " + TABLA_EMPLEADO + " WHERE legajo = " +legajo);
    }
    public void listarEmpleados() {
        buscarYMostrar("SELECT nombre FROM " + TABLA_EMPLEADO );
    }

    public boolean agregarEmpleado(Empleado empleado) {
        ConexionDB conexionDB = new ConexionDB(dbName,dbUser,dbPwd);
        String nombre = empleado.getNombre();
        String apellido = empleado.getApellido();
        String sql = "INSERT INTO " + TABLA_EMPLEADO + " (nombre, apellido) VALUES ('" +
                nombre + "','"+apellido+"');";
        boolean respuesta = false;
        try {
            respuesta = conexionDB.insertar(sql);
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("No se pudo agregar al " + TABLA_EMPLEADO + ".");
        }finally {
            conexionDB.cerrar();
        }
        return respuesta;
    }
}
