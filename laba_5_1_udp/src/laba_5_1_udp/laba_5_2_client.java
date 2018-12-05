/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laba_5_1_udp;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author User
 */
public class laba_5_2_client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        byte bKbdInput []=new byte[256];
       int Length;
       String str;
       DatagramSocket s;
       DatagramPacket pout;
       try
       {
       System.out.println(
        "Datagram Socket Client Application" + 
        "\nEnter any string or 'quit' to exit...");

       }
       catch(Exception e)
       {
       System.out.println(e.toString());
       }
       try
       {
           InetAddress OutAddress=InetAddress.getLocalHost();
           s=new DatagramSocket();
           pout=new DatagramPacket(bKbdInput,bKbdInput.length,OutAddress,9998); 
           while (true)
           {
           Length=System.in.read(bKbdInput);
           if (Length!=1)
           {
           str=new String (bKbdInput,0);
           StringTokenizer st;
           st=new StringTokenizer(str,"\n");
           str=new String ((String)st.nextElement());
           System.out.println(">"+str);
           s.send(pout);
           if (str.equals("quit"))
               break;
           }
           }
           s.close();
       }
       catch(Exception e)
       {
       System.out.println(e);
       }
       try 
       {
       System.out.println(" Press <Enter> to terminate application ...");
       }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
}
