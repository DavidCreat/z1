/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.empres;

/**
 *
 * @author David
 */
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Agregar una persona (ejemplo)
        GestorPersonas gestorPersonas = new GestorPersonas();
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Juan");
        nuevaPersona.setApellido("Pérez");
        nuevaPersona.setTelefono("123456789");
        nuevaPersona.setDireccion("Calle Principal");
        nuevaPersona.setEsDeudor(false);

        gestorPersonas.agregarPersona(nuevaPersona);

        // Obtener y mostrar todas las personas
        List<Persona> personas = gestorPersonas.obtenerPersonas();
        for (Persona persona : personas) {
            System.out.println("ID: " + persona.getId());
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Apellido: " + persona.getApellido());
            System.out.println("Teléfono: " + persona.getTelefono());
            System.out.println("Dirección: " + persona.getDireccion());
            System.out.println("Es Deudor: " + persona.esDeudor());
            System.out.println("----------");
        }
    }
}

