/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppesystem_server;

import DALException.DALException;
import DAO.AftaleDAL;
import DAO.OpgaveDAL;
import DAO.ProjektDAL;
import Data.Aftale;
import Data.Opgave;
import Data.Projekt;
import java.sql.SQLException;
import connector.Connector;
import java.sql.Date;
import java.util.List;

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
        
        ProjektDAL p = new ProjektDAL();
        List<Projekt> a = p.getProjektList(133045);
        for(Projekt c: a){
            System.out.println(c.getNavn());
        }
    }
    
}
