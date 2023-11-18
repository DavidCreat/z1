/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empres;

/**
 *
 * @author David
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private boolean esDeudor;

    // Constructor
    public Persona() {
    }

    public Persona(int id, String nombre, String apellido, String telefono, String direccion, boolean esDeudor) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.esDeudor = esDeudor;
    }

    // Getters y setters
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean esDeudor() {
        return esDeudor;
    }

    public void setEsDeudor(boolean esDeudor) {
        this.esDeudor = esDeudor;
    }

    // Método para obtener una lista de personas desde la base de datos
    public static List<Persona> obtenerPersonasDesdeBD() {
        List<Persona> listaPersonas = new ArrayList<>();
        try (var conexion = ConexionBD.obtenerConexion()) {
            String consulta = "SELECT * FROM personas";
            try (var pst = conexion.prepareStatement(consulta);
                 var rs = pst.executeQuery()) {
                while (rs.next()) {
                    Persona persona = new Persona();
                    persona.setId(rs.getInt("id"));
                    persona.setNombre(rs.getString("nombre"));
                    persona.setApellido(rs.getString("apellido"));
                    persona.setTelefono(rs.getString("telefono"));
                    persona.setDireccion(rs.getString("direccion"));
                    persona.setEsDeudor(rs.getBoolean("es_deudor"));
                    listaPersonas.add(persona);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPersonas;
    }
}



