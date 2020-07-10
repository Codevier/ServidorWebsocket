/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverSocket;

import javax.swing.JFrame;
import views.ServerInterface;

/**
 *
 * @author gugle
 */
public class Server {
    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        ServerInterface interfaceServer = 
                new ServerInterface("Chat - SocketServer Java");
        interfaceServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/        
        ServerInterface interfaceServer = 
                new ServerInterface("Chat - SocketServer Java");
        interfaceServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
