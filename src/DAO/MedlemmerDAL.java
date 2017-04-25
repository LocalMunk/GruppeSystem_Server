/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DALException.DALException;
import Data.Aftale;
import Data.Bruger;
import connector.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author marti
 */
public class MedlemmerDAL {
    public void createMedlem(int id, int projektid, int studienummer) throws DALException{
        {
		Connector.doUpdate
		(
			"INSERT INTO medlemmer(id, projektid, brugid) VALUES (?,?,?)",
				id, projektid, studienummer
				);
	}
        
    }
    
    public void DeleteMedlem(int projektid, int studienummer) throws DALException{
        
        {
		Connector.doUpdate(
				"DELETE FROM medlemmer WHERE groupid = ? AND brugid = ?", 
                                projektid, studienummer
				
				);
	} 
    }
}
