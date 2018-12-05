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
public class Laba_4_2 extends Applet {
    static Socket s;
 static ServerSocket ss;
  static InputStreamReader isr;
 static BufferedReader br;
 static String message="";
 static String mes="";
  int a;
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
       
      this.a=Integer.parseInt(message);
        System.out.println(a);
        if (a==4)
        {
         for (int i=0;i<a;i++)
        {
    g.drawOval(70, 70, 50, 50);
        }
        }
        else  if (a==3)
        {
         for (int i=0;i<a;i++)
        {
      g.fillRect(70, 70, 50, 50);
        }
        }
         else  if (a==2)
        {
         for (int i=0;i<a;i++)
        {
       g.drawRect(50, 50, 60, 50);
        }
        }
       
        
         else  if (a==1)
        {
         for (int i=0;i<a;i++)
        {
          g.drawLine(0, 0, 100, 90);
        }
        }
     System.out.println();
 
        }
        } 
        catch(IOException e)
        {
        e.printStackTrace();
        }
       
    }
}
