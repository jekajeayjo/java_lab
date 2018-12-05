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
public class Laba_5_1_udp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        byte bKbdInput []=new byte[256];
        byte buf []=new byte[512];
        DatagramSocket s;
        DatagramPacket pinp;
        InetAddress SrcAdress;
        int SrcPort;
        try 
        {
        System.out.println("Datagramm Socket Server Aplication");
        }
        catch (Exception ioe)
        {
        System.out.println(ioe.toString());
        
        }
        try
        {
        s=new  DatagramSocket(9998);
        pinp=new   DatagramPacket(buf,512);
        while (true)
        {
        s.receive(pinp);
       SrcAdress=pinp.getAddress();
        SrcPort=pinp.getPort();
        String str=new String (buf,0);
        StringTokenizer st;
        st   = new StringTokenizer(str, "\r\n");
        str = new String((String)st.nextElement());
System.out.println(">  " + str + " < " +
          "port: " + SrcPort);
if(str.equals("quit"))
          break;

        }
        s.close();
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
        try
    {
      System.out.println(
        "Press <Enter> to terminate application...");

      System.in.read(bKbdInput);
    }
    catch(Exception ioe)
    {
      System.out.println(ioe.toString());
    }

    }
    
}
