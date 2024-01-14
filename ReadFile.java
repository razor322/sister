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
public class ReadFile {
    public static void main(String[] args) throws IOException {
        System.out.println("Nama file : ");
        String filename;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        filename= br.readLine();
        System.out.println("Baca File "+ filename+ " ... ");
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(filename);
            
        }catch(FileNotFoundException ex){
            System.out.println("File Not Found");
            }
        try {
            char data;
            int temp;
            do {                
                temp = fis.read();
                data = (char) temp;
                if (temp != -1) {
                    System.out.print(data+"("+temp+")");
                }
            } while (temp != -1);
        } catch (IOException ex) {
            System.out.println("Problem in reading from the file");
        }
        
    }
}
