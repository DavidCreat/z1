/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empres;

/**
 *
 * @author David
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InterfazGestionPersonas extends JFrame {

    private final GestorPersonas gestorPersonas;
    private final GestorProductos gestorProductos;

    private JTextArea resultadoTextArea;

    public InterfazGestionPersonas() {
        gestorPersonas = new GestorPersonas();
        gestorProductos = new GestorProductos();

        configurarInterfaz();
    }

    private void configurarInterfaz() {
        setTitle("Gestión de Personas y Productos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panelPersonas = crearPanelPersonas();
        JPanel panelProductos = crearPanelProductos();

        tabbedPane.addTab("Personas", panelPersonas);
        tabbedPane.addTab("Productos", panelProductos);

        resultadoTextArea = new JTextArea();
        resultadoTextArea.setEditable(false);

        add(tabbedPane, BorderLayout.CENTER);
        add(resultadoTextArea, BorderLayout.SOUTH);
    }

    private JPanel crearPanelPersonas() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton mostrarPersonasButton = new JButton("Mostrar Personas");
        mostrarPersonasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPersonas();
            }
        });

        JButton agregarPersonaButton = new JButton("Agregar Persona");
        agregarPersonaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPersona();
            }
        });

        panel.add(mostrarPersonasButton, BorderLayout.NORTH);
        panel.add(agregarPersonaButton, BorderLayout.SOUTH);

        return panel;
    }

    private void mostrarPersonas() {
        List<Persona> personas = gestorPersonas.obtenerPersonas();
        mostrarResultados("Lista de Personas:\n" + personas.toString());
    }

    private void agregarPersona() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección:");

        if (nombre != null && apellido != null && telefono != null && direccion != null) {
            Persona nuevaPersona = new Persona(0, nombre, apellido, telefono, direccion, false);
            gestorPersonas.agregarPersona(nuevaPersona);
            mostrarPersonas();
        }
    }

    private JPanel crearPanelProductos() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton mostrarProductosButton = new JButton("Mostrar Productos");
        mostrarProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarProductos();
            }
        });

        panel.add(mostrarProductosButton, BorderLayout.NORTH);

        return panel;
    }

    private void mostrarProductos() {
        List<Producto> productos = gestorProductos.obtenerProductos();
        mostrarResultados("Lista de Productos:\n" + productos.toString());
    }

    private void mostrarResultados(String resultados) {
        resultadoTextArea.setText(resultados);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazGestionPersonas().setVisible(true);
            }
        });
    }
}






