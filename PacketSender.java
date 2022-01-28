
 // import statements
 import java.net.*;
 import java.io.*;
 import java.util.Scanner;
 public class PacketSender
 {   
     public static void main(String argvs[])
     { 
        final double senderId=Math.random()*10000; 
        final int senderIdInteger = (int) senderId;
        // I tried to work without try{}catch(){}, but we can't create a socket without handeling the error
       try{
              // creating  socket object
              
             Socket mySocket = new Socket("localhost", 3034);
             
            //  System.out.println("Client Side");
             System.out.println("Client "+ senderIdInteger+ " can start Sending packets...");
            //  System.out.println("send \"Close\" to close the connection........");
             // Scanner object to take data from the user
             Scanner   scanner = new Scanner(System.in);
            
             DataOutputStream  dataOutput = new DataOutputStream(mySocket.getOutputStream());
             Scanner in = new Scanner(mySocket.getInputStream());
         
        
         // The reading continues until "Close" is input
         while (true)
         {   //scanner past the current line and returns the input
            System.out.println("Enter the raduis then press enter... or send \"Close\" to close the connection.... ");
            System.out.print("Raduis   ");
             String packet = scanner.nextLine(); 
             // writes primitive data write of this packet in modified UTF-8 format and send it to the stream
             dataOutput.writeUTF(senderIdInteger+" "+packet);   
             if (packet.equalsIgnoreCase("Close")) break;
             System.out.println("The server finished the calculations, the Area is " + in.nextLine());          
         }
         
         //close stream
         dataOutput.close();
         // close the connection
         mySocket.close(); 
        }
        catch(Exception e){System.out.println(e);}
     }
  
 } 