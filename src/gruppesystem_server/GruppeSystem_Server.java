/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppesystem_server;

import DAO.AftaleDAL;
import Data.Aftale;
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
    public static void main(String[] args) {
            try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
        
        AftaleDAL aftdal = new AftaleDAL();
        Aftale a = new Aftale(1234, "Hotdawgspisning", "WAAIAWOIAOW", new Date(1,1,1), "Hawtdawgstanden");
        try{aftdal.createAftale(a, 4);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
