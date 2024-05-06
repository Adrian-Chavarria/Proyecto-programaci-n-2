/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login_System;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFileChooser;

public class Cliente extends Frame implements ActionListener {

    static Socket sfd = null;
    static DataOutputStream SalidaSocket;
    static TextArea entrada;

    public Cliente() {
        setTitle("Chat");
        setSize(350, 200);
        entrada = new TextArea();
        entrada.setEditable(false);
        add("Center", entrada);
        Button btnCargarArchivo = new Button("Cargar Archivo");
        btnCargarArchivo.addActionListener(this);
        add("South", btnCargarArchivo);
        setVisible(true);
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        try {
            sfd = new Socket("10.235.63.216", 8000);
            SalidaSocket = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));
            SalidaSocket.writeUTF("Jeison");
            SalidaSocket.flush();
        } catch (UnknownHostException uhe) {
            System.out.println("No se puede acceder al servidor.");
            System.exit(1);
        } catch (IOException ioe) {
            System.out.println("Comunicación rechazada.");
            System.exit(1);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Cargar Archivo")) {
            try {
                cargarArchivo();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void cargarArchivo() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            enviarArchivo(file);
           
        }
    }

    private void enviarArchivo(File file) throws IOException {
// Crear un buffer para leer el archivo en bloques de bytes
        byte[] buffer = new byte[1024];
        int bytesRead;
        long fileSize = file.length();
        try ( FileInputStream fileInputStream = new FileInputStream(file)) {
// Enviar el nombre del archivo y su tamaño al servidor
            SalidaSocket.writeUTF(file.getName());
            SalidaSocket.flush();
            SalidaSocket.writeLong(fileSize);
            SalidaSocket.flush();
            // Leer y enviar el contenido del archivo al servidor en bloques
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                SalidaSocket.write(buffer, 0, bytesRead);
            }
            SalidaSocket.flush();
            entrada.append("Archivo enviado: " + file.getName() + "\n");
        } catch (IOException e) {
            System.out.println("Error al enviar el archivo: " + e.getMessage());
        }
    }

    public boolean handleEvent(Event e) {
        if ((e.target == this) && (e.id == Event.WINDOW_DESTROY)) {
            if (sfd != null) {
                try {
                    sfd.close();
                } catch (IOException ioe) {
                    System.out.println("Error: " + ioe);
                }
                this.dispose();
            }
        }
        return true;
    }
}
