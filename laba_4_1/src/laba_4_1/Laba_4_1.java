/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laba_4_1;

import java.applet.Applet;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author User
 */
public class Laba_4_1 extends Applet {
static Socket s;
 static ServerSocket ss;
  static InputStreamReader isr;
 static BufferedReader br;
 static String message="";
 static String mes="";
  int a;
    /**
     * @param args the command line arguments
     */
    public void init ()
    {
     
        
    }
    
     public void paint(Graphics g)
    {
        try
        {
        ss=new ServerSocket(8080);
        while(true)
        {
        s=ss.accept();
        isr = new   InputStreamReader(s.getInputStream());
        br=new BufferedReader (isr);
     
        message=br.readLine();
         //System.out.println(message);
a=Integer.parseInt(message);
      System.out.println(a);
        
        for (int i=0;i<a;i++)
        {
    g.drawOval(i*70, 70, 50, 50);
        }
       
     System.out.println();
     repaint();
        }
        } 
        catch(IOException e)
        {
        e.printStackTrace();
        }
       
    }
    
}
