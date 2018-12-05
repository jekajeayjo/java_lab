/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laba_3_1;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author User
 */
public class Sender {
     String mes=null;
     String read ()
     {
         
           try(FileReader reader = new FileReader("notes3.txt"))
        {
           // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                // this.mes+=c;
                System.out.print((char)c);
            mes+=Character.toString((char) c);
            } 
            mes=(String)mes;
        }
        catch(IOException ex){
             
            //System.out.println(ex.getMessage());
        } 
         return this.mes;
     }
    void send ( String mes)
    {
        this.mes=mes;
 
       
         try
{
Socket s=     new Socket("127.0.0.1",8081);  
//Socket s=     new Socket("192.168.0.102",8081);   
PrintWriter pw=new PrintWriter(s.getOutputStream());

pw.write(mes);
pw.flush();
pw.close();
s.close();
  
  
}
catch(IOException e)
{
e.printStackTrace();
}
    }
            }
