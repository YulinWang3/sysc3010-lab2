import java.net.*;
import java.util.Scanner;

public class UDPSender {

	public static void main(String[] args) 
   {
	      // Check the arguments
	      if( args.length != 2 )
	      {
	         System.out.println( "usage: java UDPSender host port" ) ;
	         return ;
	      }
	      DatagramSocket socket = null ;
	      try
	      {  
                int n = 2000
                for (int i = 0 ; i < n ; i++ ){
                    // Convert the arguments first, to ensure that they are valid
                    InetAddress host = InetAddress.getByName( args[i] ) ;
                    int port         = Integer.parseInt( args[i+1] ) ;
                    socket = new DatagramSocket() ;
     
                    Scanner in;
                    in = new Scanner (System.in);
                    String message = null;
                    while (true)
                    {
	        		 System.out.println("Message" + i);
	        		 message = in.nextLine();
	        		 if (message.length()==0) break;
	        		 byte [] data = message.getBytes() ;
	        		 DatagramPacket packet = new DatagramPacket( data, data.length, host, port ) ;
	        		 socket.send( packet ) ;
                    } 
		    System.out.println("wait-to-receive a message");
                }
                System.out.println ("Closing down");
	      }
	      catch( Exception e )
	      {
	         System.out.println( e ) ;
	      }
	      finally
	      {
	         if( socket != null )
	            socket.close() ;
      }
   }
}

