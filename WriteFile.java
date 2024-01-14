/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st_2111081006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

/**
 *
 * @author Gybran
 */
public class WriteFile {
    public static void main(String[] args) throws IOException {
        System.out.println("Masukkan file yang ingin di tulis");
        String filename;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        filename = br.readLine();
        System.out.println("Enter data : "+ filename +" ... ");
        System.out.println("Type q$ to end.");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
                System.out.println("File tidak dapat di buka dan di tulis");
        }
        try {
            boolean done = false;
            int data;
            do {                
                data = br.read();
                if ((char)data == 'q') {
                    data = br.read();
                    if ((char)data =='$') {
                        done = true;
                        
                    }else{
                        fos.write('q');
                        fos.write(data);
                    }             
                }else{
                    fos.write(data);
                }
            } while (!done);
        } catch (IOException ex) {
            System.out.println("Masalah ketika membaca file");
        }
        
        
    }
    
}
