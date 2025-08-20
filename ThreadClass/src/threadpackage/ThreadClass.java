/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadpackage;

/**
 *
 * @author Michy
 */
public class MultithreadMain {
    
    public static void main (String[] args){
          int n =10; //10 threads
          for (int i=0; i<n; i++) {
          ThreadClass runthread = new ThreadClass();//New
          runthread.start();//runnable
          }
    }
}

