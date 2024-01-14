/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st_2111081006;

/**
 *
 * @author Gybran
 */
class PrintNameThread implements Runnable {
 Thread thread;
 PrintNameThread(String name) {
 thread = new Thread(this, name);
 thread.start();
 }
 public void run() {
 String name = thread.getName();
 for (int i = 0; i < 100; i++) {
 System.out.print(name);
 }
 }
}
class TestThread {
 public static void main(String args[]) {
 PrintNameThread pnt1 = new PrintNameThread("A");
 PrintNameThread pnt2 = new PrintNameThread("B");
 PrintNameThread pnt3 = new PrintNameThread("Z");
 PrintNameThread pnt4 = new PrintNameThread("D");
 System.out.println("Running threads...");
 try {
 pnt1.thread.join();
 pnt2.thread.join();
 pnt3.thread.join();
 pnt4.thread.join();
 } catch (InterruptedException ie) {
 }
 System.out.println("\nThreads killed."); //dicetak terakhir
 }
}