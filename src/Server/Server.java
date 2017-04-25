/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import static java.lang.System.in;
import java.rmi.Naming;
import java.rmi.Remote;
import java.util.Scanner;
import javax.xml.ws.Endpoint;
import brugerautorisation.transport.soap.BrugeradminImpl;
import brugerautorisation.server.Brugerdatabase;
import Server.ServerImpl;
import Server.ServerInterface;
import connector.Connector;
import java.sql.SQLException;


/**
 *
 * @author TheGeek
 */
public class Server {
    
   public static void main(String [] args)throws Exception{
       
       try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
       
       ServerInterface serv = new ServerImpl();
      

		
                //Til test (local)
                Endpoint.publish("http://[::]:8080/server", serv);
                
		//Endpoint.publish("http://ubuntu4.javabog.dk:54694/GruppeSystem", serv);
           
		System.out.println("Gruppesystjeneste publiceret min ven.");
          
       
       
   }
    
   
    
}