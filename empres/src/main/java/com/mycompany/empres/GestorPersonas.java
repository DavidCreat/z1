/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empres;

/**
 *
 * @author David
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestorPersonas {

    public void agregarPersona(Persona persona) {
        try (Connection conexion = ConexionBD.obtenerConexion()) {
            String consulta = "INSERT INTO personas (nombre, apellido, telefono, direccion, es_deudor) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pst = conexion.prepareStatement(consulta)) {
                pst.setString(1, persona.getNombre());
                pst.setString(2, persona.getApellido());
                pst.setString(3, persona.getTelefono());
                pst.setString(4, persona.getDireccion());
                pst.setBoolean(5, persona.esDeudor());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPersona(Persona persona) {
        try (Connection conexion = ConexionBD.obtenerConexion()) {
            String consulta = "UPDATE personas SET nombre=?, apellido=?, telefono=?, direccion=?, es_deudor=? WHERE id=?";
            try (PreparedStatement pst = conexion.prepareStatement(consulta)) {
                pst.setString(1, persona.getNombre());
                pst.setString(2, persona.getApellido());
                pst.setString(3, persona.getTelefono());
                pst.setString(4, persona.getDireccion());
                pst.setBoolean(5, persona.esDeudor());
                pst.setInt(6, persona.getId());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPersona(int idPersona) {
        try (Connection conexion = ConexionBD.obtenerConexion()) {
            String consulta = "DELETE FROM personas WHERE id=?";
            try (PreparedStatement pst = conexion.prepareStatement(consulta)) {
                pst.setInt(1, idPersona);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Persona> obtenerPersonas() {
        List<Persona> listaPersonas = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion()) {
            String consulta = "SELECT * FROM personas";
            try (PreparedStatement pst = conexion.prepareStatement(consulta)) {
                try (ResultSet rs = pst.executeQuery()) {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPersonas;
    }
}


