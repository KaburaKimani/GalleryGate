/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package runnableinterface;

/**
 *
 * @author Michy
 */
public class MultithreadRunnableMain {
    public static void main(String[] args) {
        int n = 10;//10 Threads
        for(int i = 0; i < n;i++) {
            
            RunnableInterface runnablethread= new RunnableInterface();
            Thread runthread = new Thread(runnablethread);//New
            runthread start();
        }
    }
    
}
