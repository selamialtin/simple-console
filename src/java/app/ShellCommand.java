/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Selami
 */
public class ShellCommand extends Thread{

    private String command;
    
    public ShellCommand(String command) {
        this.command = command;
    }
    
    public void run() {
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            //Process p = new ProcessBuilder(command).start();
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                    output.append(line + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(ShellCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ShellCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ShellCommand.class.getName()).log(Level.SEVERE, null, ex);
	}
        
        System.out.println("app.ShellCommand.run() : "+ command + "\n" + output.toString());
    }
    

}
