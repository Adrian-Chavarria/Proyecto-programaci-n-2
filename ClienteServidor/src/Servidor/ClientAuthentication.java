/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ESTUDIANTE
 */
public class ClientAuthentication {

    //constante que mantiene la ruta del archivo users.txt
    private static final String File = "users.txt";

    //Metodo de registrarse 
    
    public void checkInUsers(String userName, String password, String rol) {
        System.out.println(userName + " " + password);
        
        // se abre un try para mantener los errores, a la hora de acceder al txt
        try (FileWriter fw = new FileWriter("users.txt", true); // permite la escritura en el txt del nuevo usuario 
                 PrintWriter pw = new PrintWriter(fw)) {
            pw.println(userName + " " + password);
            System.out.println("Usuario registrado correctamente: " + userName + password );

        } catch (IOException e) {
            System.out.println("Se detectó un problema al guardar el usuario " + e.getMessage());

        }
    }

    
    public boolean authenticateUser(String userName, String password){
        return verifyPassword(userName,password).equals("True");
    }

 // Metodo para Verificar usuario y contraseña 
    public String verifyPassword(String userName, String Password) {
        System.out.println("hola");
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("hola 1" + line);
                String[] parts = line.split(" ");
                if (parts.length >= 2) {
                    System.out.println("Hola 333");
                    String savedUserName = parts[0];
                    String savedPassword = parts[1];
                    System.out.println("Comparando: "+ userName + " con " + savedUserName + " y " + Password + savedPassword);
//                    String rol = parts[2];

                    if (userName.equals(savedUserName) && Password.equals(savedPassword)) {
                        return "True";
                    }

                }else{
                    System.out.println("No separado ");
                }
          } 
        } catch(IOException e) {
                        System.err.println("Error al leer el usuario: " + e.getMessage());
                    }
        return "False";
    }

}


