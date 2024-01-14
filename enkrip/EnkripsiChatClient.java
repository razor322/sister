/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enkrip;
import ClientServer061023.ChatClient;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Gybran
 */
public class EnkripsiChatClient {
    private static final int server_port = 12345;
    private static final String server_address = "localhost";
    private static final int shift = 3; // Jumlah pergeseran karakter

    public static void main(String[] args) {
        BufferedReader in = null;
        try {
            Socket socket = new Socket(server_address, server_port);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Connect ke server, silahkan kirim pesan (exit untuk keluar)");
            new PesanServer(socket, in).start();
            String message;

            while (true) {
                message = scanner.nextLine();
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                
                String encryptedMessage = encrypt(message);
                out.println(encryptedMessage);
                out.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static class PesanServer extends Thread {
        Socket socket;
        BufferedReader in;
        String message;

        public PesanServer(Socket socket, BufferedReader in) {
            this.socket = socket;
            this.in = in;
        }

        @Override
        public void run() {
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Pesan Terenkripsi: " + message);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            char encryptedChar = (char) (c + shift);
            encryptedMessage.append(encryptedChar);
        }

        return encryptedMessage.toString();
    }

    public static String decrypt(String message) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            char decryptedChar = (char) (c - shift);
            decryptedMessage.append(decryptedChar);
        }

        return decryptedMessage.toString();
    }
}