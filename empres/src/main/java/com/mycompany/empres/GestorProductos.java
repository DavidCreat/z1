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
import java.sql.SQLException;
import java.util.List;

public class GestorProductos {

    public void agregarProducto(Producto producto) {
        try (Connection conexion = ConexionBD.obtenerConexion()) {
            String consulta = "INSERT INTO productos (nombre, descripcion, precio, imagen_path) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = conexion.prepareStatement(consulta)) {
                pst.setString(1, producto.getNombre());
                pst.setString(2, producto.getDescripcion());
                pst.setDouble(3, producto.getPrecio());
                pst.setString(4, producto.getImagenPath());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProducto(Producto producto) {
        try (Connection conexion = ConexionBD.obtenerConexion()) {
            String consulta = "UPDATE productos SET nombre=?, descripcion=?, precio=?, imagen_path=? WHERE id=?";
            try (PreparedStatement pst = conexion.prepareStatement(consulta)) {
                pst.setString(1, producto.getNombre());
                pst.setString(2, producto.getDescripcion());
                pst.setDouble(3, producto.getPrecio());
                pst.setString(4, producto.getImagenPath());
                pst.setInt(5, producto.getId());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProducto(int idProducto) {
        try (Connection conexion = ConexionBD.obtenerConexion()) {
            String consulta = "DELETE FROM productos WHERE id=?";
            try (PreparedStatement pst = conexion.prepareStatement(consulta)) {
                pst.setInt(1, idProducto);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Producto> obtenerProductos() {
        return Producto.obtenerProductosDesdeBD();
    }
}
