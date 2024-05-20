/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author ESTUDIANTE
 */
public class Communication {

    private final Socket socket;
    private final PrintWriter out;
    private final BufferedReader in;

    public Communication(Socket socket, PrintWriter out, BufferedReader in) {
        this.socket = socket;
        this.out = out;
        this.in = in;
    }

    public void clientMessage(String message) {
        out.println(message);
    }

    public String receiveMessage() throws IOException {
        return in.readLine();
    }
    
    public void close(){
        try{
            in.close();
            out.close();
            socket.close();
        }catch(IOException e){
            System.out.println("Error"+ e);
        }
    
}
    

}
