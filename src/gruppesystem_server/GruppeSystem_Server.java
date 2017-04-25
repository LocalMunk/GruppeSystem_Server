/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppesystem_server;

import DALException.DALException;
import DAO.AftaleDAL;
import DAO.OpgaveDAL;
import Data.Aftale;
import Data.Opgave;
import java.sql.SQLException;
import connector.Connector;
import java.sql.Date;

/**
 *
 * @author elbosso
 */
public class GruppeSystem_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DALException {
        try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); } 
        
        AftaleDAL aftdal = new AftaleDAL();
        Aftale a = null;
        try{a = aftdal.getAftale(1234);
        }catch(Exception e){
            e.printStackTrace();
        }
        if(a != null)
            System.out.println(a.getNavn());
        else
            System.out.println("Der er gået nog½et galt");
    }
    
}
