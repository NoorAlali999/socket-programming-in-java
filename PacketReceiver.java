 import java.net.*;
 import java.io.*;
 import java.util.Scanner;

 public class PacketReceiver
 {
     static int x=0;
      static int counterInc() { 
                // System.out.println(x);
          return x++;
          }

          static int counterDec() { 
            // System.out.println(x);
      return x--;
      }
      public static void main(String argvs[]) throws IOException
     {   
            
         final int Port = 3034;
          ServerSocket  myServerSocket = new ServerSocket(Port);
          //  System.out.println("Server Side");
             System.out.println("Server is waiting for a client to connect ... ");

           while (true){  

            Socket mySocket = myServerSocket.accept(); 
             Thread t = new Thread() {
                public void run() {
         try
         { 
           // waiting for  a client to send connection request
           counterInc();
             System.out.println("New Client Connected... number of clients is " +x);
             // Receiving input messages from the client using socket
             PrintWriter out = new PrintWriter(mySocket.getOutputStream(), true);
           DataInputStream  stream = new DataInputStream( mySocket.getInputStream() );
       
           //initial value I made it two parts to be able to split in the while condition
             String packet = "test test";
            // I tried to make it != it's not working because it's comaring the adresses but equals() method only comparing the values
             while (!packet.split(" ")[1].equals("Close"))
             {  
                 try
                 {
                     // read from stream
                     packet = stream.readUTF();

                     // the packet is two parts client id and raduis so we need to split them ("id raduis") example packet = "1221 2"  
                     String[] ary = packet.split(" ");
                  
                      if (!ary[1].equals("Close")){
                        System.out.println( "Server recieved this raduis (" +ary[1] +") from Client " +ary[0] );
                        double radius = Double.valueOf(ary[1]);
                     double area = Math.PI* radius *radius ;
                     out.println(area);
                      }
                      else{
                        counterDec();
                        System.out.println("Client "+ ary[0] + " Closed the connection ... number of clients is " +x);
                        
                      }
                     
                 }
                //  handle errors
                 catch(IOException io)
                 {
                     
                 }
             }
             // closing the established connection
            //  mySocket.close();
            //  stream.close();
            //  System.out.println(" Connection Closed!");
         }


         // handling errors
         catch(IOException Exception)
         {
            //  System.out.println(Exception);
         }
            }
            
             };
             t.start();
     }
   
    
 } 
 }