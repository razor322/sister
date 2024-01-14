/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enkrip;

/**
 *
 * @author Gybran
 */
public class Enkripsi2 {
    public static void main (String []args){
        String text ="selamat datang";
        String temp ="";
        int key = 5;
            for(int i=0; i<text.length(); i++){
                int h = (int) (text.charAt(i)); 
                char k = (char)(h ^ key);
                temp += k; 
                System.out.print(h);
                System.out.println(k);

        }
        System.out.println("Sebelum :" +text);
        System.out.println("Hasil :" +temp);
    }
}
