/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author Xavier
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

public final class ServerInterface extends JFrame {
    private final JLabel lblTitle, lblMessages;
    private final JTextArea txtMessages;
    private final JButton btnLimpiar;
    private final JPanel panel;
    private final ClaseThread myThread;
    
    public ServerInterface (String title){
        
        lblTitle    = new JLabel("Chat (Servidor)");
        lblMessages = new JLabel ("Chat: ");
        txtMessages = new JTextArea (10, 25);
        btnLimpiar  = new JButton("Limpiar");
        panel       = new JPanel();
        myThread = new ClaseThread();                
        panel.add(lblTitle);
        panel.add(lblMessages);  
        panel.add(txtMessages);
        panel.add(btnLimpiar);
        
        this.setBounds(800, 350, 320, 410);
        this.add(panel);
        this.setVisible(true);
        this.setTitle(title);
        myThread.start();                        
    }

class ClaseThread extends Thread
{          
    @Override
    public void run() {                
        ServerSocket serverSocket;
        Socket server;
        try {
            serverSocket = new ServerSocket(5555);            
            while (true)
            {
                try{
                    server = serverSocket.accept();
                    System.out.println("Ya aceptó algo el servidor");
                    DataInputStream inputStream = new DataInputStream(server.getInputStream());
                    txtMessages.setText(txtMessages.getText() + "\n" + inputStream.readUTF());
                    server.close();
                }
                catch (IOException ex){
                    System.out.println (ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    } 
}
