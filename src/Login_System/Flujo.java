/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login_System;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Flujo extends Thread {

    Socket nsfd;
    DataInputStream FlujoLectura;
    DataOutputStream FlujoEscritura;
    String nombreUsuario;

    public Flujo(Socket sfd, String nombre) {
        nsfd = sfd;
        nombreUsuario = nombre;
        try {
            FlujoLectura = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
            FlujoEscritura = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));
        } catch (IOException ioe) {
            System.out.println("IOException(Flujo): " + ioe);
        }
    }

    public void run() {
        broadcast(nombreUsuario
                + "> se ha conectado");
        Servidor.usuarios.add((Object) this);
        while (true) {
            try {
                String linea = FlujoLectura.readUTF();
                if (!linea.equals("")) {
                    linea = nsfd.getInetAddress() + "> " + linea;
                    broadcast(linea);
                }
            } catch (IOException ex) {
                Logger.getLogger(Flujo.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                // Recibir nombre del archivo                
                String nombreArchivo = FlujoLectura.readUTF();
                System.out.println("Recibiendo archivo: " + nombreArchivo);
                // Recibir tamaño del archivo                
                long tamanoArchivo = FlujoLectura.readLong();
                System.out.println("Tamaño del archivo: " + tamanoArchivo);
                // Crear un buffer para almacenar los datos del archivo
                byte[] buffer = new byte[1024]; // Tamaño del buffer, puedes ajustarlo según tus necesidades                
                int bytesRead;
                long bytesRecibidos = 0;
                // Crear un FileOutputStream para escribir el archivo recibido
                FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo);
                // Leer los bytes del archivo y escribirlos en el FileOutputStream
                while ((bytesRead = FlujoLectura.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                    bytesRecibidos += bytesRead;
                    // Opcional: Mostrar progreso de recepción del archivo                    
                    System.out.println("Recibidos: " + bytesRecibidos + "/" + tamanoArchivo);
                    // Si se han recibido todos los bytes, salir del bucle
                    if (bytesRecibidos == tamanoArchivo) {
                        break;
                    }
                }
                // Cerrar el FileOutputStream
                fileOutputStream.close();
                System.out.println("Archivo recibido correctamente");
            } catch (IOException ioe) {
                Servidor.usuarios.remove(this);
                broadcast(nombreUsuario + "> se ha desconectado");
                System.out.println("Error al recibir el archivo: " + ioe.getMessage());
            } catch (Exception ioe) {
                Servidor.usuarios.removeElement(this);
                broadcast(nsfd.getInetAddress() + "> se ha desconectado");
                break;
            }
        }
    }

    public void broadcast(String mensaje) {
        String mensajeConUsuario = nombreUsuario + "> " + mensaje;
        synchronized (Servidor.usuarios) {
            Enumeration e = Servidor.usuarios.elements();
            while (e.hasMoreElements()) {
                Flujo f = (Flujo) e.nextElement();
                try {
                    synchronized (f.FlujoEscritura) {
                        f.FlujoEscritura.writeUTF(mensaje);
                        f.FlujoEscritura.flush();
                    }
                } catch (IOException ioe) {
                    System.out.println("Error: " + ioe);
                }
            }
        }
    }
}
